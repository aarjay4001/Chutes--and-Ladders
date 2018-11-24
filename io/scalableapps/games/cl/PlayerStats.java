package io.scalableapps.games.cl;

public class PlayerStats {
   int counter=0;
   boolean ladder;
   boolean chute;
   int adjustedCurrentPositionWithLadderAndChute;
   String playerName;
   int previousPosition;
   int currentPosition;
public int getCounter() {
	return counter;
}
public void setCounter(int counter) {
	this.counter = counter;
}
public boolean isLadder() {
	return ladder;
}
public void setLadder(boolean ladder) {
	this.ladder = ladder;
}
public boolean isChute() {
	return chute;
}
public void setChute(boolean chute) {
	this.chute = chute;
}
public int getAdjustedCurrentPositionWithLadderAndChute() {
	return adjustedCurrentPositionWithLadderAndChute;
}
public void setAdjustedCurrentPositionWithLadderAndChute(int adjustedCurrentPositionWithLadderAndChute) {
	this.adjustedCurrentPositionWithLadderAndChute = adjustedCurrentPositionWithLadderAndChute;
}
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public int getPreviousPosition() {
	return previousPosition;
}
public void setPreviousPosition(int previousPosition) {
	this.previousPosition = previousPosition;
}
public int getCurrentPosition() {
	return currentPosition;
}
public void setCurrentPosition(int currentPosition) {
	this.currentPosition = currentPosition;
}
@Override
public String toString() {
	
	String str= counter+": "+playerName+": "+(previousPosition + 1) +" --> "+ (currentPosition +1);
    String adjusted="";

	if(isLadder() || isChute()) {
		adjusted=" --"+( isLadder()? " LADDER " : " CHUTE ")+" --> "+adjustedCurrentPositionWithLadderAndChute;
    }
	str+=adjusted;
	return str;
}


   
}
