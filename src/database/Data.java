package database;

import java.util.*;
import database.player.*;
import database.user.team.*;
import database.user.*;

public class Data {
    private static Map<Integer, Player> players;
    private static Map<Integer, Team> teams;
    private static Map<Integer, User> users;

    static {
        players = new HashMap<Integer, Player>();
        teams = new HashMap<Integer, Team>();

        players.put(01, new Player("Junior Baiano", 01, 01, 1000.00f, false));
        players.put(02, new Player("Leandrao", 02, 02, 2000.00f, true));
        players.put(03, new Player("Jucilei", 03, 03, 3000.00f, false));
        players.put(04, new Player("Jobson", 04, 04, 4000.00f, true));
        players.put(05, new Player("Gladstone", 05, 05, 5000.00f, true));

        teams.put(01, new Team("Central", 01, "12345678A@"));
        teams.put(02, new Team("Boavista", 02, "12345678B@"));
        teams.put(03, new Team("Sport", 03, "12345678C@"));
        teams.put(04, new Team("Betim", 04, "12345678D@"));
        teams.put(05, new Team("Gremio", 05, "12345678E@"));

    }

    public static List<Player> getPlayers() {
        return new ArrayList<Player>(players.values());
    }

    public static void setPlayers(Map<Integer, Player> newPlayers) {
        players = newPlayers;
    }

    public static List<Team> getTeams() {
        return new ArrayList<Team>(teams.values());
    }

    public static void setTeams(Map<Integer, Team> newTeams) {
        teams = newTeams;
    }

    public static Team getTeamById(int id) {
        return teams.get(id);
    }

    public static Player getPlayerById(int id) {
        return players.get(id);
    }

    public static List<User> getUsers(){
        return new ArrayList<User>(users.values());
    }

    public static void setUsers(Map<Integer, User> users) {
        Data.users = users;
    }
    
    public static Map<Integer, User> getHashUsers() {
        return users;
    }

    public static void setHashUsers(Map<Integer, User> users) {
        Data.users = users;
    }

}
