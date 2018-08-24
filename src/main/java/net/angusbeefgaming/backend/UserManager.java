package net.angusbeefgaming.backend;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
	private static Map<String, Rank> accountStore = new HashMap<String, Rank>();
	
	public static void setupAccountStore() {
		accountStore.put("MrBeefSteak", Rank.ADMINISTRATOR);
		accountStore.put("NoobSight", Rank.ADMINISTRATOR);
		
		accountStore.put("JackSucksAtMC", Rank.YOUTUBER);
		accountStore.put("Smajor1995", Rank.YOUTUBER);
		accountStore.put("Seapeekay", Rank.YOUTUBER);
		accountStore.put("Sk1er", Rank.YOUTUBER);
	}
	
	public static Rank getRank(String username) {
		for (Map.Entry<String, Rank> entry : accountStore.entrySet()) {
		    String name = entry.getKey();
		    Rank rank = entry.getValue();
		    if(name.equalsIgnoreCase(username)) {
		    	return rank;
		    }
		}
		return Rank.DEFAULT;
	}
}
