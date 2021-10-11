package business.search_operations;

import java.util.List;
import database.*;
import java.util.Map;
import java.util.HashMap;

import database.Player;

public class SearchPlayer {

    public static Map<Player, Team> search(String searchString) {
        List<Player> allPlayers = Data.getPlayers();

        Map<Player, Team> returnMap = new HashMap<Player, Team>();

        for (Player player : allPlayers) {
            if (player.getName().toUpperCase().contains(searchString.toUpperCase()) && player.getOnSale())
                returnMap.put(player, Data.getTeamById(player.getIdTeam()));
        }

        return returnMap;

    }
}