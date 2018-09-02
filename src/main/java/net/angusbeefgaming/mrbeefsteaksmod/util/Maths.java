package net.angusbeefgaming.mrbeefsteaksmod.util;

public class Maths {
	public static double squareNum(double x) {
		return (x * x);
	}
	
	public static String genErrorId() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < 4; i++) {
			str.append(Math.round((Math.random() * 9) + 1));
		}
		return str.toString();
	}
}
