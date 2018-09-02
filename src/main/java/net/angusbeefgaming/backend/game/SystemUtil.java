package net.angusbeefgaming.backend.game;

import java.net.InetAddress;
import java.net.UnknownHostException;

import net.angusbeefgaming.backend.http.Backend;

public class SystemUtil {
	public static String getAddress() {
		return Backend.getData("getAddress");
	}
}
