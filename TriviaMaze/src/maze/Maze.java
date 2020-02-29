package maze;
import Question.*;
import questionDatabaseManagement.*;

public class Maze {

	private Room[][] maze;
	private Location playerLocation;
	private Location startLocation;
	private Location endLocation;
	
	// this is probably going to be in the triviamaze.ui and taken as param, but for now we will use one here.
	private QuestionGetter qg;
	
	// add int x, int y as params later to represent dimensions of the maze
	public Maze( int x, int y, Location startLocation, Location endLocation ) {
		qg = new QuestionGetter("jdbc:sqlite:Trivia Questions.db");
		this.maze = generateMaze(2,2);
		this.playerLocation = startLocation;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		
	}
	
	//currently moving without regard to if room is locked or not
	// First, get our current location. Then iterate the row by +1 to simulate moving one space to the right
	// playerLocation is also moved at the same time
	// throws exception instead of catching so that error can be handled in Driver
	// maybe combine all move methods into one, taking in 0-left, 1-right, 2-up, 3-down to reduce duplicate code
	public void move( String dir ) throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Location goTo = null;
		Room movedTo = null;
		switch( dir ) {
			case "up":
				goTo = new Location(currLocation.getXCoord(),currLocation.getYCoord()-1);
				movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord()-1];
				break;
			case "down":
				goTo = new Location(currLocation.getXCoord(),currLocation.getYCoord()+1);
				movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord()+1];
				break;
			case "left":
				goTo = new Location(currLocation.getXCoord()-1,currLocation.getYCoord());
				movedTo = this.maze[currLocation.getXCoord()-1][currLocation.getYCoord()];
				break;
				
			case "right":
				goTo = new Location(currLocation.getXCoord()+1,currLocation.getYCoord());
				movedTo = this.maze[currLocation.getXCoord()+1][currLocation.getYCoord()];
				break;
		}
		playerLocation = goTo;
	}
	
	/*public void moveLeft() throws IndexOutOfBoundsException {
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
		Room movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord()-1];
		playerLocation = goTo;
	}
	
	//currently moving without regard to if room is locked or not
	public void moveDown() throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Location goTo = new Location(currLocation.getXCoord(),currLocation.getYCoord()+1);
		Room movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord()+1];
		playerLocation = goTo;
	}
	*/
	
	public void lockRoom( int x, int y ) {
		maze[x][y].lockRoom();
	}
	
	public void lockRoom( Location loc ) {
		maze[loc.getXCoord()][loc.getYCoord()].lockRoom();
	}
	
	public void unlockRoom( int x, int y ) {
		maze[x][y].unlockRoom();
	}
	
	public void unlockRoom( Location loc ) {
		maze[loc.getXCoord()][loc.getYCoord()].unlockRoom();
	}
	
	public Room getRoom( Location loc ) {
		return this.maze[loc.getXCoord()][loc.getYCoord()];
	}
	
	public Room[][] getMaze(){
		return this.maze;
	}
	
	public Question getRoomQuestion( Room room ) {
		return room.getQuestion();
	}
	
	public Question getRoomQuestion( int x, int y ) {
		return this.maze[x][y].getQuestion();
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
		try {
			Room check = maze[loc.getXCoord()][loc.getYCoord()];
		}
		catch( IndexOutOfBoundsException e ){
			return false;
		}
		return true;
	}
	
	public boolean isRoomLocked( int x, int y ) {
		return maze[x][y].isRoomLocked();
	}
	
	public boolean isRoomLocked( Location loc ) {
		return maze[loc.getXCoord()][loc.getYCoord()].isRoomLocked();
	}
	
	public void setPlayerLocation( Location loc ) {
		this.playerLocation = loc;
	}

	public Location getPlayerLocation() {
		return this.playerLocation;
	}
	
	
	private Room[][] generateMaze(int x, int y){
		Room[][] m = new Room[x][y];
		for( int i = 0; i < x; i++ ) {
			for(int j = 0; j < y; j++ ) {
				m[i][j] = new Room( qg.getQuestion() );
			}
		}
		return m;
	}
	
	
}
