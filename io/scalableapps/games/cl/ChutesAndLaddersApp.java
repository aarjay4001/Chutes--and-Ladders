package io.scalableapps.games.cl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChutesAndLaddersApp {
	private static final int MAX_SQUARES = 100;

	public static void main(String []args) {
		System.out.println("Plese enter players name seprated by , eg Peter, Sam, Joseph ");	
		Scanner scanner = new Scanner(System.in);
		String [] arr =scanner.nextLine().split(",");
		List<Player> players = new ArrayList<Player>();
		for(String player:arr) {
			players.add(new Player(player));
		}
		Dice dice = Dice.getInstance();
		Board board = Board.getInstance();
		board.init(MAX_SQUARES);
		boolean winner=false;
		int counter=0;
		System.out.println("Start : Player status");
		for(Player player:players) {
			System.out.println(player.getName()+" : "+(player.getCurrentPostion()));
	    }
		List<PlayerStats> playersStats= new ArrayList<>();
		while(!winner) {
			
			for(Player player:players) {
				//System.out.println(player.toString()+ "turn");
				int roll= dice.roll();
				//System.out.println(player.getName()+ " Roll  "+roll);
				int currentPosition=player.getCurrentPostion();
				Square square=player.move(board,roll);
				
				if(square==null) {
					continue;
				}
				//System.out.println("square.hasSnakeOrLadder() "+square.hasSnakeOrLadder());
				StringBuilder sb = new  StringBuilder();
				
				PlayerStats st = new PlayerStats();
				st.setCounter(++counter);
				st.setPlayerName(player.getName());
				st.setPreviousPosition(currentPosition);
				st.setCurrentPosition(player.getCurrentPostion());
				
				
				processPrintReport(counter, player, currentPosition,sb);	
				if(square.hasSnakeOrLadder()) {
					Path path= square.hasLadder() ? square.getLadder(): square.getSnake();
					st.setLadder(square.hasLadder());
					st.setLadder(square.hasSnake());
					st.setAdjustedCurrentPositionWithLadderAndChute(path.getDestination());
					sb.append(" --").append(square.hasLadder()? " LADDER " : " CHUTE ").append(" --> ").append(path.getDestination());
				}
				playersStats.add(st);
				System.out.println(sb.toString());
				if(player.getCurrentPostion()==board.getWinnigSquareIndex()) {
					winner=true;
					st.setWinner(true);
					System.out.println("Winner is "+player.getName()+ " ");
					break;
				}
				
			}
			
			
		}
		System.out.println("\n\n Print Report \n\n");
		playersStats.forEach(playerStat -> {
		    System.out.println(playerStat.toString());
		    if(playerStat.isWinner()) {
		    	 System.out.println(playerStat.getPlayerName()+" is winner");
		    }
		});
		
		
	}

	private static void processPrintReport(int counter, Player player, int currentPosition, StringBuilder sb) {
		sb.append(counter+": "+player.getName()+": "+(currentPosition) +" --> "+ (player.getCurrentPostion()));
	}

}
