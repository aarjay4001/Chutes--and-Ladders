package io.scalableapps.games.cl;

public class Player {
	private int currentPostion;
	private String name;
	public Player(String name) {
		super();
		this.name = name;
		this.currentPostion=0;
	}
	public void move(Board board,int lastRoll) {
		if(this.currentPostion + lastRoll >= board.getWinnigSquareIndex()) {
			this.currentPostion=this.currentPostion + lastRoll;
			return;
		}
		Square square=board.getSquare(this.currentPostion+lastRoll);
		Path path= square.hasLadder() ? square.getLadder(): square.getSnake();
		this.currentPostion=square.hasSnakeOrLadder()? path.getDestination():square.getPosition();
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
		return "Player [ name=" + name + ", currentPostion=" + (currentPostion+1)+"]" ;
	}
	
	

}
