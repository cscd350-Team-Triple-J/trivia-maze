package Maze;
import Question.*;

public class Maze {

	private Room[][] maze;
	private Location playerLocation;
	private Location startLocation;
	private Location endLocation;
	
	// add int x, int y as params later to represent dimensions of the maze
	public Maze( Location startLocation, Location endLocation ) {
		this.maze = generateMaze();
		this.playerLocation = startLocation;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	
	//currently moving without regard to if room is locked or not
	// First, get our current location. Then iterate the row by +1 to simulate moving one space to the right
	// playerLocation is also moved at the same time
	// throws exception instead of catching so that error can be handled in Driver
	// maybe combine all move methods into one, taking in 0-left, 1-right, 2-up, 3-down to reduce duplicate code
	public void moveLeft() throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Location goTo = new Location(currLocation.getXCoord()-1,currLocation.getYCoord());
		Room movingTo = this.maze[currLocation.getXCoord()-1][currLocation.getYCoord()];
		playerLocation = goTo;
	}
	
	//currently moving without regard to if room is locked or not
	public void moveRight() throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Location goTo = new Location(currLocation.getXCoord()+1,currLocation.getYCoord());
		Room movedTo = this.maze[currLocation.getXCoord()+1][currLocation.getYCoord()];
		playerLocation = goTo;
	}
	
	//currently moving without regard to if room is locked or not
	public void moveUp() throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Location goTo = new Location(currLocation.getXCoord(),currLocation.getYCoord()-1);
		Room movedTo = this.maze[currLocation.getXCoord()+1][currLocation.getYCoord()-1];
		playerLocation = goTo;
	}
	
	//currently moving without regard to if room is locked or not
	public void moveDown() throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Location goTo = new Location(currLocation.getXCoord(),currLocation.getYCoord()+1);
		Room movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord()+1];
		playerLocation = goTo;
	}
	
	
	public void lockRoom( int x, int y ) {
		
	}
	
	public Room getRoom( Location loc ) {
		return this.maze[loc.getXCoord()][loc.getYCoord()];
	}
	
	public BaseQuestion getRoomQuestion() {
		
		return null;
	}
	
	public boolean hasValidPathToEnd() {
		
		return true;
	}
	
	public boolean roomExists( int x, int y ) {
		try {
			Room check = maze[x][y];
		}
		catch( IndexOutOfBoundsException e ){
			return false;
		}
		return true;
	}
	
	public boolean roomExists( Location loc ) {
		
		return true;
	}
	
	public boolean isRoomLocked( int x, int y ) {
		
		return true;
	}
	
	public boolean isRoomLocked( Location loc ) {
		
		return true;
	}
	
	public void setPlayerLocation( Location loc ) {
		this.playerLocation = loc;
	}

	public Location getPlayerLocation() {
		return this.playerLocation;
	}
	
	
	private Room[][] generateMaze(){ // will edit later to have int x, int y as dimension params
		BaseQuestion q1 = new MultipleChoiceQuestion("Who was the main villain in FF7?", 
													 "Sephiroth",
													 new String[]{"Sephiroth", "Cloud", "Aerith", "Ultima"} );
		BaseQuestion q2 = new MultipleChoiceQuestion("Who was the Hero in FF7?", 
													 "Cloud",
													 new String[]{"Sephiroth", "Cloud", "Aerith", "Ultima"} );
		BaseQuestion q3 = new MultipleChoiceQuestion("Who did the main villain in FF7 kill?", 
													 "Aerith",
													 new String[]{"Sephiroth", "Cloud", "Aerith", "Ultima"} );
		BaseQuestion q4 = new MultipleChoiceQuestion("What is a magic spell in FF7?", 
													 "Ultima",
													 new String[]{"Sephiroth", "Cloud", "Aerith", "Ultima"} );
		return new Room[][] { {new Room(q1), new Room(q2)}, {new Room(q3), new Room(q3)} };
	}
	
	
}
