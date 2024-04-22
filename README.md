# Cricket-Match-Analytics-Highest-Scores-and-300-Club
> Fetches recent cricket match data via API, computes highest single innings score and counts matches with total score exceeding 300 runs.
1. Return the highest score in one innings with the team name.
   * The program should analyze each match's data and determine the highest score achieved by any team in a single inning.
   * It should identify the team that achieved this highest score.
2. Return the number of matches with a total score of 300 or more from both teams.
   * The program should calculate the total score from both teams for each match.
   * It should count the number of matches where this total score is 300 or greater.

*API Description:*
> The provided API endpoint returns a list of recent cricket matches along with their data. Each match object contains the following fields:
  - id: Unique Match Id
  - dateTimeGMT: Date Time
  - matchType: Type of the match (e.g., T20, ODI, Test Match)
  - status: Match result (e.g., "Team A won by 10 runs")
  - ms: Match Status (Result, Fixture, Ongoing), where "Result" means the match result is obtained
  - t1: Team 1 name
  - t2: Team 2 name
  - t1s: Team 1 Score
  - t2s: Team 2 Score
  - t1img: Team 1 Image
  - t2img: Team 2 Image
    
*Tasks:*
1. Fetch cricket match data from the provided API endpoint using HTTP GET request.
2. Perform computations to:
   * Find the highest score in one innings with the team name.
   * Count the number of matches with a total score of 300 or more from both teams.
3. Print the computed results in the console.
4. Return a message from the main function containing the computed results.

*Key Points:*
* Use Java for implementation.
* Utilize the org.json library to parse the JSON response from the API.
* Ensure error handling for any exceptions that may occur during data fetching or processing.

> By completing these tasks, the program provides essential insights into the recent cricket matches, including the highest score achieved and the number of high-scoring matches.

*Code Explanation:)
1. The program uses Java to fetch data from the given API endpoint using HTTP GET requests.
2. It then parses the JSON response to extract match details such as team names, scores, match type, status, etc.
3. It calculates the highest score from each match and keeps track of the highest score across all matches.
4. It counts the number of matches where the total score from both teams is 300 or more.
5. Finally, it prints match details along with the highest score and the count of matches with a total score of 300 or more.

*Technologies Used:*
1. Java: The core programming language used for development.
2. HTTPURLConnection: Java built-in class for making HTTP requests to the API endpoint.
3. JSON: The response from the API is in JSON format, and the program uses the org.json library to parse it.

*Methods Used:*
1. 'fetchJsonData:' This method makes an HTTP GET request to the API endpoint and returns the JSON response as a string.
2. 'processJsonData:' This method processes the JSON data, calculates the highest score, counts the number of matches with a total score of 300 or more, and constructs the 
   output message.
3. 'main:' The entry point of the program. It triggers the data fetching and processing, prints the result, and handles exceptions.


>*This Java program utilizes an external API to retrieve cricket match data, analyzing it to determine the highest score in a single innings and count the matches with a combined score of 300 or more, as per the problem statement.*

