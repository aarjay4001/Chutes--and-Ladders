package io.scalableapps.games.cl;

import java.util.Random;

public class Dice {
	private static Dice dice = new Dice();
	private  Random random = new Random();
	private Dice() {}
	public static Dice getInstance() {
		return dice;
	}

	public int roll() {
		return random.nextInt(6) + 1;
	}
}
