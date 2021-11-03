package database.user.team;
import database.player.*;
import database.user.*;
import java.util.*;

public class Team extends User{

  HashMap<Integer, Player> players;


  public Team(String name, int idUser, String password, HashMap<Integer, Player> players) {
    super(name, idUser, password);
    this.players = players;
  }

  public HashMap<Integer, Player> getPlayers() {
    return players;
  }

  public void setPlayers(HashMap<Integer, Player> players) {
    this.players = players;
  }

  public void addPlayer(Player player) {
    this.players.put(player.getId(), player);
  }

  public void removePlayer(Player player) {
    this.players.remove(player.getId());
  }

  
}