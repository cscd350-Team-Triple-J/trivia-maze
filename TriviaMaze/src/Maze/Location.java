package Maze;

public class Location {
	
	private int xCoord;
	private int yCoord;
	
	public Location( int xCoord, int yCoord ) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public int getXCoord() {
		return this.xCoord;
	}
	
	public int getYCoord() {
		return this.yCoord;
	}
	
	public boolean isLocationSame( Location loc ) {
		boolean isSame = false;
		if( this.xCoord == loc.getXCoord() && this.yCoord == loc.getYCoord() ) {
			isSame = true;
		}
		return isSame;
	}

}
