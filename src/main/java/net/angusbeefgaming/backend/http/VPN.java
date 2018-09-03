package net.angusbeefgaming.backend.http;

import org.json.JSONObject;

import net.angusbeefgaming.backend.game.SystemUtil;

public class VPN {
	
	public static int overflow = 0;
	
	public static String checkerResult = "NONE";
	
	public static final boolean PAID_API = false;
	public static final String API_KEY = "";
	
	public static boolean vpnCheck() {
		if(checkerResult.equals("NONE")) {
			System.out.println("VPN Checker was unable to parse the data!");
			return false;
		}
		
		boolean isVpn = getBoolValue("host-ip");
		
		return isVpn;
	}
	
	public static boolean getBoolValue(String value) {
		if(overflow >= 10) {
			System.out.println("Unable to lookup. Overflow Maxed!");
			return false;
		}
		JSONObject object = null;
		
		try {
			object = new JSONObject(checkerResult);
		}
		catch(Exception e) {
			overflow++;
			getBoolValue(value);
		}
		
		return object.getBoolean(value);
	}
	
	public static void getResultInfo() {
		String checkerResultAA = "";
		try {
			if(PAID_API) {
				checkerResultAA = Backend.get("http://api.vpnblocker.net/v2/json/" + SystemUtil.getAddress() + API_KEY);
			}
			else {
				checkerResultAA = Backend.get("http://api.vpnblocker.net/v2/json/" + SystemUtil.getAddress());
			}
		} catch (Exception e) {
			// TODO: Try again
		}
		if(!checkerResultAA.equals("")) {
			checkerResult = checkerResultAA;
		}
		else {
			getResultInfo();
		}
	}
}
