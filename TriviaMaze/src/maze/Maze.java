package maze;

import questionDatabaseManagement.*;

/**
 * Maze class that will hold a Room[][] that will represent a maze Will be used
 * in the GUI to provide functionality to the maze portion of the game
 * 
 * @author Jon
 *
 */
public class Maze {

	private Room[][] maze;
	private Location playerLocation;
	private Location startLocation;
	private Location endLocation;
	private QuestionGetter qg;

	/**
	 * Constructor that will hold a maze, start, and end location
	 * 
	 * @param x             how many columns that will be in the maze
	 * @param y             how many rows that will be in the maze
	 * @param startLocation Location that the player will start at
	 * @param endLocation   Location that the player will attempt to reach
	 */
	public Maze(int x, int y, Location startLocation, Location endLocation) {
		qg = new QuestionGetter("jdbc:sqlite:Trivia Questions.db");
		this.maze = generateMaze(x, y);
		this.playerLocation = startLocation;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}

	public Question getQuestion() {
		return qg.getQuestion();
	}

	/**
	 * Will move the player from their current location in whichever direction is
	 * selected
	 * 
	 * @param dir the direction in which the player will attempt to travel
	 * @throws IndexOutOfBoundsException if player goes out of bounds of the maze
	 */
	public void move(MovementDirection dir) throws IndexOutOfBoundsException {
		Location currLocation = this.playerLocation;
		Room movedTo = null;
		Location goTo = null;
		switch (dir) {
		case UP:
			goTo = new Location(currLocation.getXCoord(), currLocation.getYCoord() - 1);
			movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord() - 1];
			break;
		case DOWN:
			goTo = new Location(currLocation.getXCoord(), currLocation.getYCoord() + 1);
			movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord() + 1];
			break;
		case LEFT:
			goTo = new Location(currLocation.getXCoord() - 1, currLocation.getYCoord());
			movedTo = this.maze[currLocation.getXCoord() - 1][currLocation.getYCoord()];
			break;

		case RIGHT:
			goTo = new Location(currLocation.getXCoord() + 1, currLocation.getYCoord());
			movedTo = this.maze[currLocation.getXCoord() + 1][currLocation.getYCoord()];
			break;
		}
		// move the player to the location
		this.playerLocation = goTo;
	}

	/**
	 * Will check all surrounding directly reachable rooms and will check if which
	 * ones are in bounds of the maze, and which are out of bounds of the array
	 * 
	 * @param loc location of the room we are checking around
	 * @return boolean array telling us if directions up, down, left, right are
	 *         viable or not
	 */
	public boolean[] checkSurroundingRooms( Room[][] maze ) {
		// 					 up   down  left  right
		boolean[] rooms = { true, true, true, true };

		// check rooms around player location
		rooms[0] = checkRoom(MovementDirection.UP, maze);
		rooms[1] = checkRoom(MovementDirection.DOWN, maze);
		rooms[2] = checkRoom(MovementDirection.LEFT, maze);
		rooms[3] = checkRoom(MovementDirection.RIGHT, maze);

		return rooms;
	}

	/**
	 * Will lock a room using specific coordinates
	 * 
	 * @param x x-coordinate of the room to lock
	 * @param y y-coordinate of the room to lock
	 */
	public void lockRoom(int x, int y) {
		maze[x][y].lockRoom();
	}

	/**
	 * Will lock a room using specified Location
	 * 
	 * @param loc Location of the room to be locked
	 */
	public void lockRoom(Location loc) {
		maze[loc.getXCoord()][loc.getYCoord()].lockRoom();
	}

	/**
	 * Will unlock a room using specific coordinates
	 * 
	 * @param x x-coordinate of the room to unlock
	 * @param y y-coordinate of the room to unlock
	 */
	public void unlockRoom(int x, int y) {
		maze[x][y].unlockRoom();
	}

	/**
	 * Will unlock a room using specified Location
	 * 
	 * @param loc Location of the room to be unlocked
	 */
	public void unlockRoom(Location loc) {
		maze[loc.getXCoord()][loc.getYCoord()].unlockRoom();
	}

	/**
	 * Gets the room at specified location
	 * 
	 * @param loc Location of room to get
	 * @return room from the maze
	 */
	public Room getRoom(Location loc) {
		return this.maze[loc.getXCoord()][loc.getYCoord()];
	}

	/**
	 * Gets the maze from the Maze object
	 * 
	 * @return Room[][] maze that holds all rooms
	 */
	public Room[][] getMaze() {
		return this.maze;
	}

	/**
	 * Gets the question in specified room
	 * 
	 * @param room room with the question we want
	 * @return Question from the specified room
	 */
	public Question getQuestion(Room room) {
		return qg.getQuestion();
	}

	public boolean hasValidPathToEnd() {
		boolean goodPath = false;
		if (traverseMaze(this.playerLocation.getXCoord(), this.playerLocation.getYCoord())) {
			goodPath = true;
		}
		resetExplored();
		return goodPath;
	}

	/**
	 * Checks if a room exists at specified coordinates
	 * 
	 * @param x x-coordinate of room to check
	 * @param y y-coordinate of room to check
	 * @return boolean value that specifies if room exists
	 */
	public boolean roomExists(int x, int y) {
		try {
			Room check = maze[x][y];
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if a room exists at specified Location
	 * 
	 * @param loc Location of the room we want to check
	 * @return boolean value that specifies if room exists
	 */
	public boolean roomExists(Location loc) {
		try {
			Room check = maze[loc.getXCoord()][loc.getYCoord()];
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if a room is permanently locked at specified coordinates
	 * 
	 * @param x x-coordinate of room to check
	 * @param y y-coordinate of room to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomPermaLocked(int x, int y) {
		return maze[x][y].isRoomPermaLocked();
	}
	
	
	public Location getEndLocation() {
		return this.endLocation;
	}
	
	public boolean isPlayerAtExit() {
		return this.playerLocation.equals(this.endLocation);
	}

	public Location getAdjacentRoomLocation( MovementDirection dir ) {
		
		Room movedTo = null;
		Location goTo = null;
		Location currLocation = this.playerLocation;
		try {
			switch (dir) {
			case UP:
				goTo = new Location(currLocation.getXCoord(), currLocation.getYCoord() - 1);
				movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord() - 1];
				break;
			case DOWN:
				goTo = new Location(currLocation.getXCoord(), currLocation.getYCoord() + 1);
				movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord() + 1];
				break;
			case LEFT:
				goTo = new Location(currLocation.getXCoord()-1, currLocation.getYCoord());
				movedTo = this.maze[currLocation.getXCoord() - 1][currLocation.getYCoord()];
				break;

			case RIGHT:
				goTo = new Location(currLocation.getXCoord() + 1, currLocation.getYCoord());
				movedTo = this.maze[currLocation.getXCoord() + 1][currLocation.getYCoord()];
				break;
			}
		} catch (Exception e) {
			
		}
		return goTo;
	}
	/**
	 * Checks if a room is permanently locked at specified Location
	 * 
	 * @param loc Location of the room we want to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomPermaLocked(Location loc) {
		return maze[loc.getXCoord()][loc.getYCoord()].isRoomPermaLocked();
	}

	/**
	 * Checks if a room is locked at specified coordinates
	 * 
	 * @param x x-coordinate of room to check
	 * @param y y-coordinate of room to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomLocked(int x, int y) {
		return maze[x][y].isRoomLocked();
	}
	
	public void permaLockRoom( Location loc ) {
		
	}

	/**
	 * Checks if a room is locked at specified Location
	 * 
	 * @param loc Location of the room we want to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomLocked(Location loc) {
		return maze[loc.getXCoord()][loc.getYCoord()].isRoomLocked();
	}

	/**
	 * Sets the player location to a specified location
	 * 
	 * @param loc Location at which to set player location
	 */
	public void setPlayerLocation(Location loc) {
		this.playerLocation = loc;
	}

	/**
	 * Gets the current player location
	 * 
	 * @return current player location
	 */
	public Location getPlayerLocation() {
		return this.playerLocation;
	}

	/**
	 * Generates a Room[][] that will represent the maze, and will add a question
	 * into the room as they're created
	 * 
	 * @param x how many columns that will be in the maze
	 * @param y how many rows that will be in the maze
	 * @return a Room[][] representing a maze
	 */
	private Room[][] generateMaze(int x, int y) {
		Room[][] maze = new Room[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				maze[i][j] = new Room(new Location(i, j));
			}
		}
		return maze;
	}

	/**
	 * Will check a certain direction from the room to see if it could be a valid
	 * move
	 * 
	 * @param dir Direction in which the player will move
	 * @return boolean stating if it is a valid move
	 */
	private boolean checkRoom(MovementDirection dir, Room[][] maze) {

		Room movedTo = null;
		Location currLocation = this.playerLocation;
		boolean notOutOfBounds = true;

		try {
			switch (dir) {
			case UP:
				movedTo = maze[currLocation.getXCoord()][currLocation.getYCoord() - 1];
				break;
			case DOWN:
				movedTo = maze[currLocation.getXCoord()][currLocation.getYCoord() + 1];
				break;
			case LEFT:
				movedTo = maze[currLocation.getXCoord() - 1][currLocation.getYCoord()];
				break;

			case RIGHT:
				movedTo = maze[currLocation.getXCoord() + 1][currLocation.getYCoord()];
				break;
			}
		} catch (Exception e) {
			notOutOfBounds = false;
		}

		return notOutOfBounds;
	}

	/**
	 * Backtracking algorithm to check if there is a path to the end of the maze,
	 * checking for perma-locked rooms
	 * 
	 * @param x x-coordinate to start search at
	 * @param y y-coordinate to start search at
	 * @return if there is a path or not
	 */
	private boolean traverseMaze(int xCoord, int yCoord) {

		int maxX = this.maze.length;
		int maxY = this.maze[0].length;

		int endX = this.endLocation.getXCoord();
		int endY = this.endLocation.getYCoord();

		if ((xCoord == endX - 1) && (yCoord == endY - 1)) {
			this.maze[xCoord][yCoord].setExplore(true);
			return true;
		}

		// how should I format this
		if (xCoord >= 0 && yCoord >= 0 && xCoord < maxX && yCoord < maxY && !this.maze[xCoord][yCoord].isExplored()
				&& !this.maze[xCoord][yCoord].isRoomPermaLocked()) {

			this.maze[xCoord][yCoord].setExplore(true);
			if (traverseMaze(xCoord, yCoord - 1)) {
				return true;
			}
			if (traverseMaze(xCoord, yCoord + 1)) {
				return true;
			}
			if (traverseMaze(xCoord - 1, yCoord)) {
				return true;
			}
			if (traverseMaze(xCoord + 1, yCoord)) {
				return true;
			}
			this.maze[xCoord][yCoord].setExplore(false);
			return false;
		}
		return false;
	}

	/**
	 * Will reset the explored field in both the trace and the maze
	 */
	private void resetExplored() {
		for (int i = 0; i < this.maze.length; i++) {
			for (int j = 0; j < this.maze[0].length; j++) {
				this.maze[i][j].setExplore(false);
			}
		}
	}

}
