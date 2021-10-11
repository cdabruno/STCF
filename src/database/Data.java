package database;
import java.util.*;



public class Data {
    private Map<Integer, Player> players;
    private Map<Integer, Team> teams;
    
    public Data(){
        players = new HashMap<Integer, Player>();
        teams = new HashMap<Integer, Team>(); 

        players.put(01, new Player("Junior Baiano", 01, 01, 1000.00f, false));
        players.put(02, new Player("Leandrao", 02, 02, 2000.00f, false));
        players.put(03, new Player("Jucilei", 03, 03, 3000.00f, false));
        players.put(04, new Player("Jobson", 04, 04, 4000.00f, false));
        players.put(05, new Player("Gladstone", 05, 05, 5000.00f, true));

        teams.put(01, new Team("Central", 01));
        teams.put(02, new Team("Boavista", 02));
        teams.put(02, new Team("Boavista", 02));
        teams.put(03, new Team("Sport", 03));
        teams.put(04, new Team("Betim", 04));

    }

    public List<Player> getPlayers() {
        return new ArrayList<Player>(players.values());
    }

    public void setPlayers(Map<Integer, Player> players) {
        this.players = players;
    }

    public List<Team> getTeams() {
        return new ArrayList<Team>(teams.values());
    }

    public void setTeams(Map<Integer, Team> teams) {
        this.teams = teams;
    }

    public Team getTeamById(int id){
        return teams.get(id);
    }

    public Player getPlayerById(int id){
        return players.get(id);
    }

    

    
}
