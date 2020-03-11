package maze;

public class Location {
	
	private int xCoord;
	private int yCoord;
	
	/**
	 * Location constructor 
	 * @param xCoord The x-coordinate of the location in the maze
	 * @param yCoord The y-coordinate of the location in the maze
	 */
	public Location( int xCoord, int yCoord ) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	/**
	 * Location constructor for utility
	 * @param loc Location to set this new location to
	 */
	public Location( Location loc ) {
		this.xCoord = loc.getXCoord();
		this.yCoord = loc.getYCoord();
	}
	
	public int getXCoord() {
		return this.xCoord;
	}
	
	public int getYCoord() {
		return this.yCoord;
	}
	
	public Location getCurrentLocation() {
		return new Location( this.xCoord, this.yCoord );
	}
	
	@Override
	public boolean equals( Object o ) {
		boolean isSame = false;
		if( this.xCoord == ((Location) o).getXCoord() && this.yCoord == ((Location) o).getYCoord() ) {
			isSame = true;
		}
		return isSame;
	}

}
