package maze;

import questionDatabaseManagement.*;

/**
 * Class to represent a room in the Maze Holds a question, location, and several
 * boolean fields for utility
 * 
 * @author Jon
 *
 */
public class Room {

	private boolean isRoomLocked;
	private boolean isRoomPermaLocked;
	private boolean isExplored;
	private Location location;
	private Question question;
	
	/**
	 * Room constructor that holds a question and two boolean values. Room will be
	 * checked to see if it is locked or permalocked before moving the player
	 * forward
	 * 
	 * @param question Trivia question that player has to answer
	 */
	public Room(Location location) {
		this.location = location;
		isRoomLocked = false;
		isRoomPermaLocked = false;
		isExplored = false;
	}

	/**
	 * @return boolean that says if the room is locked or not
	 */
	public boolean isRoomLocked() {
		return this.isRoomLocked;
	}

	/**
	 * @return boolean that will say if the room has been permanently locked
	 */
	public boolean isRoomPermaLocked() {
		return this.isRoomPermaLocked;
	}

	/**
	 * @param isRoomPermaLocked boolean value that will set the room as permanently
	 *                          locked
	 */
	public void setRoomPermaLocked(boolean isRoomPermaLocked) {
		this.isRoomPermaLocked = isRoomPermaLocked;
	}

	/**
	 * sets boolean isRoomLocked to true, simulating locking the door
	 */
	public void lockRoom() {
		this.isRoomLocked = true;
	}

	/**
	 * sets boolean isRoomLocked to false, simulating unlocking the door
	 */
	public void unlockRoom() {
		this.isRoomLocked = false;
	}

	/**
	 * @return boolean value used in Backtracking to see if we have been in the room
	 *         yet
	 */
	public boolean isExplored() {
		return this.isExplored;
	}

	/**
	 * @param isExplored set if we have explored the room or not in backtracking
	 */
	public void setExplore(boolean isExplored) {
		this.isExplored = isExplored;
	}

}
