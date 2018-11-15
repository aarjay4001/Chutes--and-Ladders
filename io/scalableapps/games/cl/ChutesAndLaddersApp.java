package io.scalableapps.games.cl;

import java.util.ArrayList;

import java.util.List;

public class ChutesAndLaddersApp {
	private static final int MAX_SQUARES = 100;

	public static void main(String []args) {

		String [] arr= {"Ram", "Rahim", "sita","Gita"};
		List<Player> players = new ArrayList<Player>();
		for(String player:arr) {
			players.add(new Player(player));
		}
		Dice dice = Dice.getInstance();
		Board board = Board.getInstance();
		board.init(MAX_SQUARES);
		boolean winner=false;
		while(!winner) {
		
			for(Player player:players) {
				System.out.println(player.toString()+ "turn");
				int roll= dice.roll();
				System.out.println("Roll  "+roll);
				player.move(board,roll);
				System.out.println("moved to new position "+player.toString());
				if(player.getCurrentPostion()>=board.getWinnigSquareIndex()) {
					winner=true;
					System.out.println("Winner is "+player.getName()+ " "+(player.getCurrentPostion()+1));
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}

}