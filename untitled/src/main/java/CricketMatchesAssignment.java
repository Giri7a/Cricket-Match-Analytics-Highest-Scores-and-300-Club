import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CricketMatchesAssignment {
    private static final String API_URL = "https://api.cuvora.com/car/partner/cricket-data";
    private static final String API_KEY = "test-creds@2320";

    public static void main(String[] args) {
        try {
            String jsonData = fetchJsonData(API_URL, API_KEY);
            String highestScoreMessage = processJsonData(jsonData);
            System.out.println(highestScoreMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String processJsonData(String jsonData) {
        StringBuilder message = new StringBuilder();

        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray matchesArray = jsonObject.getJSONArray("data");

            int highestScore = Integer.MIN_VALUE;
            String highestScorer = "";
            int matches300Plus = 0;

            for (int i = 0; i < matchesArray.length(); i++) {
                JSONObject match = matchesArray.getJSONObject(i);
                int team1Score = match.optInt("t1s",0);
                int team2Score = match.optInt("t2s",0);

                // Calculate highest score
                if (team1Score > highestScore) {
                    highestScore = team1Score;
                    highestScorer = match.getString("t1");
                }
                if (team2Score > highestScore) {
                    highestScore = team2Score;
                    highestScorer = match.getString("t2");
                }

                // Check if total score is 300+
                if (team1Score + team2Score >= 300) {
                    matches300Plus++;
                }

                // Print match details
                System.out.println("Match ID: " + match.getString("id"));
                System.out.println("DateTime GMT: " + match.getString("dateTimeGMT"));
                System.out.println("Match Type: " + match.getString("matchType"));
                System.out.println("Match Status: " + match.getString("status"));
                System.out.println("Match Status Type: " + match.getString("ms"));
                System.out.println("Team 1: " + match.getString("t1") + ", Score: " + team1Score + ", Image: " + match.optString("t1img"));
                System.out.println("Team 2: " + match.getString("t2") + ", Score: " + team2Score + ", Image: " + match.optString("t2img"));
                System.out.println("--------------------------------------------");
            }

            // Construct message for highest score
            message.append("Highest Score: ").append(highestScore).append(", Team Name: ").append(highestScorer).append("\n");
            // Construct message for number of matches with total 300+ score
            message.append("Number of Matches with total 300 Plus Score: ").append(matches300Plus);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return message.toString();
    }

    private static String fetchJsonData(String apiUrl, String apiKey) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("apiKey", apiKey);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        } finally {
            connection.disconnect();
        }
    }
}
