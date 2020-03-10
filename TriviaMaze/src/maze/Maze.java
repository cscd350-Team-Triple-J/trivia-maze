package maze;

import questionDatabaseManagement.*;
import triviamaze.ui.Cheats;

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
		this.maze = generateMaze(4, 4);
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
		switch (dir) {
		case UP:
			this.playerLocation = new Location(currLocation.getXCoord(), currLocation.getYCoord() - 1);
			movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord() - 1];
			break;
		case DOWN:
			this.playerLocation = new Location(currLocation.getXCoord(), currLocation.getYCoord() + 1);
			movedTo = this.maze[currLocation.getXCoord()][currLocation.getYCoord() + 1];
			break;
		case LEFT:
			this.playerLocation = new Location(currLocation.getXCoord() - 1, currLocation.getYCoord());
			movedTo = this.maze[currLocation.getXCoord() - 1][currLocation.getYCoord()];
			break;

		case RIGHT:
			this.playerLocation = new Location(currLocation.getXCoord() + 1, currLocation.getYCoord());
			movedTo = this.maze[currLocation.getXCoord() + 1][currLocation.getYCoord()];
			break;
		}

	}

	/**
	 * Will check all surrounding directly reachable rooms and will check if which
	 * ones are in bounds of the maze, and which are out of bounds of the array
	 * 
	 * @param loc location of the room we are checking around
	 * @return boolean array telling us if directions up, down, left, right are
	 *         viable or not
	 */
	public boolean[] checkSurroundingRooms(Location loc) {
		// up down left right
		boolean[] doors = { false, false, false, false };
		Room currRoom = getRoom(loc);
		Location goTo = null;
		Room movedTo = null;
		/*
		 * switch( dir ) { case UP: goTo = new
		 * Location(currLocation.getXCoord(),currLocation.getYCoord()-1); movedTo =
		 * this.maze[currLocation.getXCoord()][currLocation.getYCoord()-1]; break; case
		 * DOWN: goTo = new
		 * Location(currLocation.getXCoord(),currLocation.getYCoord()+1); movedTo =
		 * this.maze[currLocation.getXCoord()][currLocation.getYCoord()+1]; break; case
		 * LEFT: goTo = new
		 * Location(currLocation.getXCoord()-1,currLocation.getYCoord()); movedTo =
		 * this.maze[currLocation.getXCoord()-1][currLocation.getYCoord()]; break;
		 * 
		 * case RIGHT: goTo = new
		 * Location(currLocation.getXCoord()+1,currLocation.getYCoord()); movedTo =
		 * this.maze[currLocation.getXCoord()+1][currLocation.getYCoord()]; break; }
		 */
		playerLocation = goTo;
		return doors;
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
	 * Gets the question from specified coordinates
	 * 
	 * @param x x-coordinate of question we want
	 * @param y y-coordinate of question we want
	 * @return The specified question from the room
	 */

	public boolean hasValidPathToEnd() {

		return true;
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
	 * Checks if a room is locked at specified coordinates
	 * 
	 * @param x x-coordinate of room to check
	 * @param y y-coordinate of room to check
	 * @return boolean value that specifies if the room is locked
	 */
	public boolean isRoomLocked(int x, int y) {
		return maze[x][y].isRoomLocked();
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

	public Location getEndLocation() {
		return this.endLocation;
	}

	public boolean isPlayerAtExit() {
		return this.playerLocation.getXCoord() == this.endLocation.getXCoord()
				&& this.playerLocation.getYCoord() == this.endLocation.getYCoord();
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
		Room[][] m = new Room[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				m[i][j] = new Room(new Location(i, j));
			}
		}
		return m;
	}

	public Location getAdjacentRoomLocation(MovementDirection dir) {
		switch (dir) {
		case UP:
			return new Location(playerLocation.getXCoord(), playerLocation.getYCoord() - 1);
		case DOWN:
			return new Location(playerLocation.getXCoord(), playerLocation.getYCoord() + 1);
		case LEFT:
			return new Location(playerLocation.getXCoord() - 1, playerLocation.getYCoord());
		case RIGHT:
			return new Location(playerLocation.getXCoord() + 1, playerLocation.getYCoord());
		}

		return new Location(0, 0);
	}

}
