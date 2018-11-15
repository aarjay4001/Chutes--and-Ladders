package io.scalableapps.games.cl;

public class Square {
	private int position;
	private Path ladder;
	private Path snake;
	public Square(int position){
		this.position=position;
	}
	public void addLadder(int ladderDestination) {
		this.ladder= new Ladder(position,ladderDestination);
	}
	public void addChute(int snakeDestinaition) {
		this.snake=new Chute(position, snakeDestinaition);
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Path getLadder() {
		return ladder;
	}
	
	public Path getSnake() {
		return snake;
	}
	boolean hasLadder() {
		return ladder!=null ? true :false;
	}
	
	boolean hasSnake() {
		return snake!=null ? true :false;
	}
	boolean hasSnakeOrLadder() {
		return hasSnake() || hasLadder();
	}
}
