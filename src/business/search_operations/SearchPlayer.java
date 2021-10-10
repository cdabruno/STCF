package business.search_operations;
import java.util.ArrayList;
import java.util.List;

import database.Player;

public class SearchPlayer {
	public static List<Player> search(String searchString) {
		List<Player> returnList = new ArrayList<Player>();

		List<Player> allPlayers = new ArrayList<Player>();
		Player pimentex = new Player();
		Player lucineia = new Player();
		Player ingrid = new Player();
		Player ingrid2 = new Player();
		
		pimentex.name = "Pimentex";
		pimentex.teamName = "TCP";
		pimentex.currentValue = 1f;
		
		lucineia.name = "lucineia";
		lucineia.teamName = "ES";
		lucineia.currentValue = 10000f;
		
		ingrid.name = "ingrid";
		ingrid.teamName = "ES/TCP";
		ingrid.currentValue = 1000f;

		ingrid2.name = "ingrid2";
		ingrid2.teamName = "TCP/ES";
		ingrid2.currentValue = 500f;

		allPlayers.add(pimentex);
		allPlayers.add(lucineia);
		allPlayers.add(ingrid);
		allPlayers.add(ingrid2);

		// Depois as instancias tem que vir da database
		for (Player player : allPlayers) {
			if (player.name.toUpperCase().contains(searchString.toUpperCase()))
				returnList.add(player);
		}
		
		return returnList;
		
	}
}