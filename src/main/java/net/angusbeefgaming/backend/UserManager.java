package net.angusbeefgaming.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.angusbeefgaming.backend.http.Backend;

public class UserManager {
	private static Map<String, Rank> accountStore = new HashMap<String, Rank>();
	
	public static List<String> devRanked = new ArrayList<String>();
	public static List<String> youtubeRanked = new ArrayList<String>();
	public static List<String> defaultRanked = new ArrayList<String>();
	
	public static Rank getRank(String username) {
		if(contains(username, devRanked)) {
			//System.out.println("Client Manager> Already have " + username + " in memory. Returning Developer Rank");
			return Rank.ADMINISTRATOR;
		}
		if(contains(username, youtubeRanked)) {
			//System.out.println("Client Manager> Already have " + username + " in memory. Returning YouTuber Rank");
			return Rank.YOUTUBER;
		}
		if(contains(username, defaultRanked)) {
			//System.out.println("Client Manager> Already have " + username + " in memory. Returning No Rank");
			return Rank.DEFAULT;
		}
		
		
		String playerRank = Backend.getData("getRank/" + username);
		if(playerRank.equals("ADMINISTRATOR")) {
			devRanked.add(username);
			//System.out.println("Client Manager> Got " + username + "'s Data for the first time. Returning Developer Rank.");
			return Rank.ADMINISTRATOR;
		}
		if(playerRank.equals("YOUTUBER")) {
			//System.out.println("Client Manager> Got " + username + "'s Data for the first time. Returning YouTuber Rank.");
			youtubeRanked.add(username);
			return Rank.YOUTUBER;
		}
		defaultRanked.add(username);
		//System.out.println("Client Manager> Got " + username + "'s Data for the first time. Returning No Rank.");
		return Rank.DEFAULT;
	}
	
	public static boolean contains(String username, List<String> list) {
		for(String str : list) {
			if(str.equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}
}
