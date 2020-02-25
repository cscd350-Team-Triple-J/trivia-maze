package Maze;
import Question.*;

public class Maze {

	private Room[][] rooms;
	private Location playerLocation;
	private Location startLocation;
	private Location endLocation;
	
	public Maze( Room[][] rooms, Location playerLocation, Location startLocation, Location endLocation ) {
		this.rooms = rooms;
		this.playerLocation = playerLocation;
		this.startLocation = startLocation;
		this.endLocation = endLocation;
	}
	
	public void moveLeft() {
		
	}
	
	public void moveRight() {
		
	}
	
	public void moveUp() {
		
	}
	
	public void moveDown() {
		
	}
	
	public void lockRoom( int x, int y ) {
		
	}
	
	public BaseQuestion getRoomQuestion() {
		
		return null;
	}
	
	public boolean hasValidPathToEnd() {
		
		return true;
	}
	
	public boolean roomExists( int x, int y ) {
		
		return true;
	}
	
	public boolean isRoomLocked( int x, int y ) {
		
		return true;
	}
	
	public Location getPlayerLocation() {
		return this.playerLocation;
	}
	
	
}
