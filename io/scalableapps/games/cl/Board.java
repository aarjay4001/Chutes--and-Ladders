package io.scalableapps.games.cl;

import java.util.HashMap;
import java.util.Map;

public class Board {
	private static final int MAX_INDEX = 99;
	private static Board  instance = new Board();
	private Board() {}
	public static Board getInstance() {
		return instance;
	}
	private Map<Integer,Square> board = new HashMap<Integer,Square>();
	
	
	public Square getSquare(int index) {
		return board.get(index);
	}

	public void init(int maxSquare) {
		for (int i=0;i<maxSquare-1;i++) {
			board.put(i, new Square(i));
		}
		//addLadders();
		//addSnakes();
	}
	public void addChutes(int start, int end) {
		addPath(start, end);
	}
	private void addPath(int start, int end) {
		board.get(start).addChute(end);
	}
    public void addLadders(int start, int end) {
    	addPath(start, end);
	}

	
	private void addSnakes() {
		board.get(15).addChute(5);;
		board.get(48).addChute(10);;
		board.get(46).addChute(25);;
		board.get(55).addChute(52);;
		board.get(63).addChute(59);;
		board.get(86).addChute(23);;
		board.get(92).addChute(72);;
		board.get(94).addChute(74);;
		board.get(98).addChute(77);;
		
	}
	private void addLadders() {
		board.get(0).addLadder(37);;
		board.get(3).addLadder(13);;
		board.get(8).addLadder(30);;
		board.get(20).addLadder(41);;
		board.get(27).addLadder(83);;
		board.get(35).addLadder(43);;
		board.get(50).addLadder(66);;
		board.get(70).addLadder(90);;
		board.get(79).addLadder(99);;
		
	}
	
	public int getWinnigSquareIndex() {
		return MAX_INDEX;
	}

}
