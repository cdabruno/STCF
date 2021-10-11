package database;
import java.util.*;

public class Team {
  private int idTeam;
  private String name;
  //private List<Player> players;

  public Team(String name, int idTeam) {
    this.idTeam = idTeam;
    this.name = name;
  }

  public int getIdTeam() {
    return idTeam;
  }
  public void setIdTeam(int idTeam) {
    this.idTeam = idTeam;
  }
  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  // public List<Player> getPlayers() {
  //   return players;
  // }
  // public void setPlayers(List<Player> players) {
  //   this.players = players;
  // }
  
}