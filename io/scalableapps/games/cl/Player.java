package io.scalableapps.games.cl;

public class Player {
	private int currentPostion;
	private String name;

	public Player(String name) {
		super();
		this.name = name;
		this.currentPostion = 0;
	}

	public void adjustChuteOrLadder(int destination) {
		this.currentPostion = destination;
	}

	public Square move(Board board, int lastRoll) {
		if (this.currentPostion + lastRoll > board.getWinnigSquareIndex()) {
			System.out.println("Your Roll is too big. Keep trying");
			return null;
		}
		int nextPosition = this.currentPostion + lastRoll;
		Square square = board.getSquare(nextPosition);
		this.currentPostion = nextPosition;
		return square;

	}

	public int getCurrentPostion() {
		return currentPostion;
	}

	public void setCurrentPostion(int postion) {
		this.currentPostion = postion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [ name=" + name + ", currentPostion=" + (currentPostion + 1) + "]";
	}

}
