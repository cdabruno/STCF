package business.search_operations;

import java.util.List;
import database.*;
import java.util.Map;
import java.util.HashMap;
import database.player.*;
import database.user.team.*;

public class SearchPlayer {
	
	public static void main(String [] args) {
		System.out.println(search("").values());
	}

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