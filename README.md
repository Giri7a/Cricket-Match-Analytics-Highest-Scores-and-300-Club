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
  
