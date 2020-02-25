package Maze;
import Question.*;

public class Room {

	private boolean isRoomLocked;
	private BaseQuestion question;
	
	public Room( BaseQuestion question ){
		this.question = question;
	}
	
	public BaseQuestion getQuestion() {
		return this.question;
	}
	
	public boolean getIsRoomLocked() {
		return this.isRoomLocked;
	}
	
	public void setIsRoomLocked( boolean isRoomLocked ) {
		this.isRoomLocked = isRoomLocked;
	}
	
}
