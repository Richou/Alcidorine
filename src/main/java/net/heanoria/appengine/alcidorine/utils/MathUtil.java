package net.heanoria.appengine.alcidorine.utils;

import java.util.Random;

public class MathUtil {

	private MathUtil() {
		
	}
	
	public static Integer getRandomRange(int from, int to) {
		Random rand = new Random();
		return rand.nextInt((to - from) + 1) + from;
	}
}
