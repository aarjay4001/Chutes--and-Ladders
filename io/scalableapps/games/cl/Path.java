package io.scalableapps.games.cl;

abstract class  Path {
	int source;
	int destination;
	 public Path(int source, int destination) {
		this.source=source;
		this.destination=destination;
	}
	public int getDestination() {
		return destination;
	}
	@Override
	public String toString() {
		return "Path [source=" + source + ", destination=" + destination + "]";
	}
	
	
}
