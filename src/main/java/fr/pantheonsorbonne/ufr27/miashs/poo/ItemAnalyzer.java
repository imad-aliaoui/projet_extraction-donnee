package fr.pantheonsorbonne.ufr27.miashs.poo;

import java.util.ArrayList;

public final class ItemAnalyzer {
  private ArrayList<Item> items = new ArrayList<>();

  public ItemAnalyzer(ArrayList<Item> items) {
    this.items=items;
  }

  public String getYoungestPlayer() 
  {
    Integer minimumAge = 0;
    String namePlayer = null;

    for(Item item : items)
    {
      if(item.getYearOfBirth() >= minimumAge)
      {
        minimumAge = item.getYearOfBirth();
        namePlayer = item.getName();
      } 
    }

    return namePlayer;
  }


  public Double getAverageAge() 
  {
    Integer sumAge = 0;
    Integer numberOfPlayers = 0;
    Double averageAgeDouble = 0.0;
    String averageAgeString = null;

    for(Item item : items)
    {
      Integer age = 2024 - item.getYearOfBirth();
      sumAge += age;
      numberOfPlayers++;
    }

    averageAgeDouble = (double)sumAge / numberOfPlayers;
    averageAgeString = String.format("%.2f", averageAgeDouble);
    averageAgeDouble = Double.parseDouble(averageAgeString);

    return averageAgeDouble;
  }


  public String getNationalityLeastRepresented() 
  {
    ArrayList<String> listOfNationalities = new ArrayList<>();
    ArrayList<Integer> numberOfNationalities = new ArrayList<>();
    String nationality = null;
    Integer minimumNationality = 100;

    for(Item item : items)
    {
      if(listOfNationalities.contains(item.getNationality()))
      {
        int indexOfTheNationality = listOfNationalities.indexOf(item.getNationality());
        numberOfNationalities.set(indexOfTheNationality, numberOfNationalities.get(indexOfTheNationality) + 1);
      }
      else
      {
        listOfNationalities.add(item.getNationality());
        numberOfNationalities.add(1);
      }
    }

    for(int i = 0; i < listOfNationalities.size(); i++)
    {
      if(numberOfNationalities.get(i) <= minimumNationality)
      {
        minimumNationality = numberOfNationalities.get(i);
        nationality = listOfNationalities.get(i);
      }
    }

    return nationality;
  }

  
  public ArrayList<String> getTopScorerOfEachLeague() 
  {
    ArrayList<String> listOfLeagues = new ArrayList<>();
    ArrayList<Integer> numberOfGoals = new ArrayList<>();
    ArrayList<String> topScorer = new ArrayList<>();
    ArrayList<String> topScorerList = new ArrayList<>();

    for(Item item : items)
    {
        if(listOfLeagues.contains(item.getLeague()))
        {
          int indexOfTheLeague = listOfLeagues.indexOf(item.getLeague());
          
          if(item.getGoals() >= numberOfGoals.get(indexOfTheLeague))
          {          
            numberOfGoals.set(indexOfTheLeague, item.getGoals());
            topScorer.set(indexOfTheLeague, item.getName());
          }
        }
        else
        {
          listOfLeagues.add(item.getLeague());
          numberOfGoals.add(item.getGoals());
          topScorer.add(item.getName());
        }
    }

    for(int i = 0; i < listOfLeagues.size(); i++)
    {
      topScorerList.add(listOfLeagues.get(i));
      topScorerList.add(topScorer.get(i));
    }

    return topScorerList;
  }


  public String getPlayerWithTheMostYellowCards() 
  {
    Integer maximumYellowCards = 0;
    String nameJoueur = null;

    for(Item item : items)
    {
      if(item.getYellowCards() >= maximumYellowCards)
      {
        maximumYellowCards = item.getYellowCards();
        nameJoueur = item.getName();
      } 
    }
    
    return nameJoueur;
  }


  public ArrayList<Double> getBiggestGapBetweenXgAndGoalsScored() 
  {
    ArrayList<Double> goalsVsExpectedGoals = new ArrayList<>();
    Double maximumChancesMissed = 0.0;
    
    for(Item item: items)
    {
      Double chancesMissed = item.getExpectedGoals() - item.getGoals();

      if(chancesMissed >= maximumChancesMissed)
      {
        goalsVsExpectedGoals.clear();
        goalsVsExpectedGoals.add(item.getExpectedGoals());
        goalsVsExpectedGoals.add((double)item.getGoals());
        maximumChancesMissed = chancesMissed;
      }
    }

    return goalsVsExpectedGoals;
  }


  public String getTeamWithTheMostFrench() 
  {
    ArrayList<String> listOfTeams = new ArrayList<>();
    ArrayList<Integer> numberOfFrench = new ArrayList<>();
    String team = null;
    Integer maximumFrench = 0;

    for(Item item : items)
    {
      if(item.getNationality().equals("FRA"))
      {
        if(listOfTeams.contains(item.getTeam()))
        {
          int indexOfTheTeam = listOfTeams.indexOf(item.getTeam());
          numberOfFrench.set(indexOfTheTeam, numberOfFrench.get(indexOfTheTeam) + 1);
        }
        else
        {
          listOfTeams.add(item.getTeam());
          numberOfFrench.add(1);
        }
      }
    }

    for(int i = 0; i < listOfTeams.size(); i++)
    {
      if(numberOfFrench.get(i) >= maximumFrench)
      {
        maximumFrench = numberOfFrench.get(i);
        team = listOfTeams.get(i);
      }
    }

    return team;
  }


  public String getLeagueWithTheMostTeenagers() 
  {
    ArrayList<String> listOfLeagues = new ArrayList<>(); 
    ArrayList<Integer> numberOfTeenagers = new ArrayList<>();
    String league = null;
    Integer maximumTeenagers = 0;

    for(Item item : items)
    {
      if(item.getYearOfBirth() >= 2004)
      {
        if(listOfLeagues.contains(item.getLeague()))
        {
          int indexOfTheLeague = listOfLeagues.indexOf(item.getLeague());
          numberOfTeenagers.set(indexOfTheLeague, numberOfTeenagers.get(indexOfTheLeague) + 1);
        }
        else
        {
          listOfLeagues.add(item.getLeague());
          numberOfTeenagers.add(1);
        }
      }
    }

    for(int i = 0; i < listOfLeagues.size(); i++)
    {
      if(numberOfTeenagers.get(i) >= maximumTeenagers)
      {
        maximumTeenagers = numberOfTeenagers.get(i);
        league = listOfLeagues.get(i);
      }
    }

    return league;
  }
}
