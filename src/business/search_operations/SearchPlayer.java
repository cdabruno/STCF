package business.search_operations;
import java.util.ArrayList;
import java.util.List;

import database.Player;


public class SearchPlayer {
	public static List<Player> search(String searchString) {
		List<Player> returnList = new ArrayList<Player>();
		Player pimentex = new Player();
		Player lucineia = new Player();
		Player ingrid = new Player();
		
		pimentex.name = "Pimentex";
		pimentex.teamName = "TCP";
		pimentex.currentValue = 1f;
		
		lucineia.name = "lucineia";
		lucineia.teamName = "ES";
		lucineia.currentValue = 10000f;
		
		ingrid.name = "ingrid";
		ingrid.teamName = "ES/TCP";
		ingrid.currentValue = 1000f;
		
		returnList.add(lucineia);
		returnList.add(pimentex);
		returnList.add(ingrid);
		
		return returnList;
		
	}
}