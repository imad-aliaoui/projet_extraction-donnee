package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.util.ArrayList;

public final class ItemsScrapper 
{
  ArrayList<Item> parseSource(String pageSource) 
  {
    ArrayList<Item> itemList = new ArrayList<>();
    int playerIndex = pageSource.indexOf("data-stat=\"ranker\">");

    while (true) 
    {
      Item item = new Item();
      
      String name = findPlayerName(pageSource, playerIndex);

      String nationality = findNationality(pageSource, playerIndex);
    
      String team = findTeam(pageSource, playerIndex);

      String league = findLeague(pageSource, playerIndex);
    
      Integer yearOfBirth = findYearOfBirth(pageSource, playerIndex);
    
      Integer minutesPlayed = findMinutesPlayed(pageSource, playerIndex);
    
      Integer goals = findGoals(pageSource, playerIndex);
    
      Integer assists = findAssists(pageSource, playerIndex);
    
      Double expectedGoals = findExpectedGoals(pageSource, playerIndex);
    
      Integer yellowCards = findYellowCards(pageSource, playerIndex);
  
      item.setName(name);
      item.setNationality(nationality);
      item.setTeam(team);
      item.setLeague(league);
      item.setYearOfBirth(yearOfBirth);
      item.setMinutesPlayed(minutesPlayed);
      item.setGoals(goals);
      item.setAssists(assists);
      item.setExpectedGoals(expectedGoals);
      item.setYellowCards(yellowCards);

      itemList.add(item);
     
      playerIndex = pageSource.indexOf("data-stat=\"ranker\">", playerIndex + 1);
      if(playerIndex == -1) 
      {
        // on a fini d'extraire les item
        break;
      }
    }

    return itemList;
  }


  private String findPlayerName(String pageSource, int index) 
  {
    String returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"player\"", index);

    if (statisticsIndex != -1) 
    {
        int nameStart = pageSource.indexOf("csk=\"", statisticsIndex);

        if (nameStart != -1) 
        {
          nameStart += "csk=\"".length(); 
            int nameEnd = pageSource.indexOf("\"", nameStart); 

            if (nameEnd != -1) 
            {
            returnedValue = pageSource.substring(nameStart, nameEnd).trim();
            }
        }
    }

    return returnedValue;
  }


  private String findNationality(String pageSource, int index) 
  {
    String returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"nationality\"", index);

    if (statisticsIndex != -1) 
    {
        int nationalityStart = pageSource.indexOf("</span>", statisticsIndex);

        if (nationalityStart != -1) 
        {
          nationalityStart += "</span>".length(); 
          int nationalityEnd = pageSource.indexOf("<", nationalityStart);

          if (nationalityEnd != -1) 
          {
            returnedValue = pageSource.substring(nationalityStart, nationalityEnd).trim();
          }
        }
    }

    return returnedValue;
  }


  private String findTeam(String pageSource, int index) 
  {
    String returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"team\"", index);   

    if (statisticsIndex != -1) 
    {
      int hrefStart = pageSource.indexOf("<a", statisticsIndex);
      int hrefEnd = pageSource.indexOf("</a>", hrefStart); 
      String hrefTeam = pageSource.substring(hrefStart, hrefEnd).trim();
      String [] separation = hrefTeam.split(">");
      returnedValue = separation[1];
    }

    return returnedValue;
  }


  private String findLeague(String pageSource, int index) 
  {
    String returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"comp_level\"", index);

    if (statisticsIndex != -1) 
    {
      int hrefStart = pageSource.indexOf("<a", statisticsIndex);
      int hrefEnd = pageSource.indexOf("</a>", hrefStart); 
      String hrefLeague = pageSource.substring(hrefStart, hrefEnd).trim();
      String [] separation = hrefLeague.split(">");
      returnedValue = separation[1];
    }

    return returnedValue;
  }


  private Integer findYearOfBirth(String pageSource, int index) 
  {
    Integer returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"birth_year\">", index);

    if (statisticsIndex != -1) 
    {
      int yearStart = statisticsIndex + "data-stat=\"birth_year\">".length();
      int yearEnd = pageSource.indexOf("</td>", yearStart);
      String yearOfBirthString = pageSource.substring(yearStart, yearEnd).trim();
      returnedValue = Integer.parseInt(yearOfBirthString);
    }

    return returnedValue;
  }


  private Integer findMinutesPlayed(String pageSource, int index) 
  {
    Integer returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"minutes\"", index);

    if (statisticsIndex != -1) 
    {
        int minutesStart = pageSource.indexOf("csk=\"", statisticsIndex);

        if (minutesStart != -1) 
        {
          minutesStart += "csk=\"".length(); 
          int minutesEnd = pageSource.indexOf("\"", minutesStart); 

          if (minutesEnd != -1) 
          {
            String minutesPlayedString = pageSource.substring(minutesStart, minutesEnd).trim();
            returnedValue = Integer.parseInt(minutesPlayedString);
          }
        }
    }

    return returnedValue;
  }


  private Integer findGoals(String pageSource, int index) 
  {
    Integer returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"goals\"", index);

    if (statisticsIndex != -1) 
    {
      int goalStart = statisticsIndex + "data-stat=\"goals\">".length();
      int goalEnd = pageSource.indexOf("</td>", goalStart);
      String goalString = pageSource.substring(goalStart, goalEnd).trim();
      returnedValue = Integer.parseInt(goalString);
    }

    return returnedValue;
  }


  private Integer findAssists(String pageSource, int index) 
  {
    Integer returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"assists\"", index);

    if (statisticsIndex != -1) 
    {
      int assistStart = statisticsIndex + "data-stat=\"assists\">".length();
      int assistEnd = pageSource.indexOf("</td>", assistStart);
      String assistString = pageSource.substring(assistStart, assistEnd).trim();
      returnedValue = Integer.parseInt(assistString);
    }

    return returnedValue;
  }


  private Double findExpectedGoals(String pageSource, int index) 
  {
    Double returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"xg\"", index);

    if (statisticsIndex != -1) 
    {
      int xgStart = statisticsIndex + "data-stat=\"xg\">".length();
      int xgEnd = pageSource.indexOf("</td>", xgStart);
      String xgString = pageSource.substring(xgStart, xgEnd).trim();
      returnedValue = Double.parseDouble(xgString);
    }

    return returnedValue;
  }


  private Integer findYellowCards(String pageSource, int index) 
  {
    Integer returnedValue = null;
    int statisticsIndex = pageSource.indexOf("data-stat=\"cards_yellow\"", index);

    if (statisticsIndex != -1) 
    {
      int yellowCardStart = statisticsIndex + "data-stat=\"cards_yellow\">".length();
      int yellowCardEnd = pageSource.indexOf("</td>", yellowCardStart);
      String yellowCardString = pageSource.substring(yellowCardStart, yellowCardEnd).trim();
      returnedValue = Integer.parseInt(yellowCardString);
    }

    return returnedValue;
  }
}
