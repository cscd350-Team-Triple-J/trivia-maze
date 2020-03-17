package maze;

/**
 * A class that will represent the location in the maze. It will hold two integers
 * that will represent the x and y coordinates in the maze
 * 
 * @author Jonathyn Komorita
 */
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
	
	/**
	 * Getter for the x coordinate field
	 * @return int representing x coordinate
	 */
	public int getXCoord() {
		return this.xCoord;
	}
	
	/**
	 * Getter for the y coordinate field
	 * @return int representing y coordinate
	 */
	public int getYCoord() {
		return this.yCoord;
	}
	
	/**
	 * Will check if locations are the same based on their x and y coordinates 
	 */
	@Override
	public boolean equals( Object o ) {
		boolean isSame = false;
		if( this.xCoord == ((Location) o).getXCoord() && this.yCoord == ((Location) o).getYCoord() ) {
			isSame = true;
		}
		return isSame;
	}

}
