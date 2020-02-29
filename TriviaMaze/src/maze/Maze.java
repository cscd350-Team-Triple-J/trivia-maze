package maze;
import questionDatabaseManagement.*;

public class Maze {

	private Room[][] maze;
	private Location playerLocation;
	private Location startLocation;
	private Location endLocation;
	
	// this is probably going to be in the triviamaze.ui and taken as param, but for now we will use one here.
	private QuestionGetter qg;
	
	/**
	 * Constructor that will hold a maze, start, and end location
	 * @param x how many columns that will be in the maze
	 * @param y how many rows that will be in the maze
	 * @param startLocation Location that the player will start at
	 * @param endLocation Location that the player will attempt to reach
	 */
	public Maze( int x, int y, Location startLocation, Location endLocation ) {
		qg = new QuestionGetter("jdbc:sqlite:Trivia Questions.db");
		this.maze = generateMaze(2,2);
		this.playerLocation = startLocation;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
		
	}
	
	/**
	 * Will move the player from their current location in whichever direction is selected
	 * @param dir the direction in which the player will attempt to travel
	 * @throws IndexOutOfBoundsException if player goes out of bounds of the maze
	 */
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
	
	/**
	 * Will lock a room using specific coordinates
	 * @param x x-coordinate of the room to lock
	 * @param y y-coordinate of the room to lock
	 */
	public void lockRoom( int x, int y ) {
		maze[x][y].lockRoom();
	}
	
	/**
	 * Will lock a room using specified Location
	 * @param loc Location of the room to be locked
	 */
	public void lockRoom( Location loc ) {
		maze[loc.getXCoord()][loc.getYCoord()].lockRoom();
	}
	
	/**
	 * Will unlock a room using specific coordinates
	 * @param x x-coordinate of the room to unlock
	 * @param y y-coordinate of the room to unlock
	 */
	public void unlockRoom( int x, int y ) {
		maze[x][y].unlockRoom();
	}
	
	/**
	 * Will unlock a room using specified Location
	 * @param loc Location of the room to be unlocked
	 */
	public void unlockRoom( Location loc ) {
		maze[loc.getXCoord()][loc.getYCoord()].unlockRoom();
	}
	
	/**
	 * Gets the room at specified location
	 * @param loc Location of room to get
	 * @return room from the maze
	 */
	public Room getRoom( Location loc ) {
		return this.maze[loc.getXCoord()][loc.getYCoord()];
	}
	
	/**
	 * Gets the maze from the Maze object
	 * @return Room[][] maze that holds all rooms
	 */
	public Room[][] getMaze(){
		return this.maze;
	}
	
	/**
	 * Gets the question in specified room
	 * @param room room with the question we want
	 * @return Question from the specified room
	 */
	public Question getRoomQuestion( Room room ) {
		return room.getQuestion();
	}
	
	/**
	 * Gets the question from specified coordinates
	 * @param x x-coordinate of question we want
	 * @param y y-coordinate of question we want
	 * @return The specified question from the room
	 */
	public Question getRoomQuestion( int x, int y ) {
		return this.maze[x][y].getQuestion();
	}
	
	public boolean hasValidPathToEnd() {
		
		return true;
	}
	
	/**
	 * Checks if a room exists at specified coordinates
	 * @param x x-coordinate of room to check
	 * @param y y-coordinate of room to check
	 * @return boolean value that specifies if room exists
	 */
	public boolean roomExists( int x, int y ) {
		try {
			Room check = maze[x][y];
		}
		catch( IndexOutOfBoundsException e ){
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if a room exists at specified Location
	 * @param loc Location of the room we want to check
	 * @return boolean value that specifies if room exists
	 */
	public boolean roomExists( Location loc ) {
		try {
			Room check = maze[loc.getXCoord()][loc.getYCoord()];
		}
		catch( IndexOutOfBoundsException e ){
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if a room is locked at specified coordinates
	 * @param x x-coordinate of room to check
	 * @param y y-coordinate of room to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomLocked( int x, int y ) {
		return maze[x][y].isRoomLocked();
	}
	
	/**
	 * Checks if a room is locked at specified Location
	 * @param loc Location of the room we want to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomLocked( Location loc ) {
		return maze[loc.getXCoord()][loc.getYCoord()].isRoomLocked();
	}
	
	/**
	 * Sets the player location to a specified location
	 * @param loc Location at which to set player location
	 */
	public void setPlayerLocation( Location loc ) {
		this.playerLocation = loc;
	}

	/**
	 * Gets the current player location
	 * @return current player location
	 */
	public Location getPlayerLocation() {
		return this.playerLocation;
	}
	
	/**
	 * Generates a Room[][] that will represent the maze, and will add a question into the room as they're created
	 * @param x how many columns that will be in the maze
	 * @param y how many rows that will be in the maze
	 * @return a Room[][] representing a maze
	 */
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
