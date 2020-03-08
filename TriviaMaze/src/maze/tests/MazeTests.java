package maze.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import maze.*;
import questionDatabaseManagement.Question;

class MazeTests {

	Maze test;
	Room[][] maze;
	Location mazeStart = new Location(0,0);
	Location mazeEnd = new Location(1,1);
	
	
	@BeforeEach
	void setUp() throws Exception {
		test = new Maze( 2,2, mazeStart, mazeEnd );
		maze = test.getMaze();
	}

	@Test
	void testMazeLocations() {
		assertTrue( new Location(0,0).equals(test.getPlayerLocation()));
		assertTrue( new Location(0,0).equals(mazeStart));
		assertTrue( new Location(1,1).equals(mazeEnd));
	}
	
	@Test
	void testMoveRight() {
		//test.moveRight();
		test.move(MovementDirection.RIGHT);
		assertTrue( test.getPlayerLocation().equals( new Location(1,0)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.move(MovementDirection.RIGHT),
														"Moved out of the maze" );
	}
	
	@Test
	void testMoveLeft() {
		test.setPlayerLocation( new Location(1,0) );
		//test.moveLeft();
		test.move(MovementDirection.LEFT);
		assertTrue( test.getPlayerLocation().equals( new Location(0,0)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.move(MovementDirection.LEFT),
														"Moved out of the maze" );
	}
	
	@Test
	void testMoveUp() {
		test.setPlayerLocation( new Location(0,1) );
		//test.moveUp();
		test.move(MovementDirection.UP);
		assertTrue( test.getPlayerLocation().equals( new Location(0,0)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.move(MovementDirection.UP),
														"Moved out of the maze" );
	}
	
	@Test
	void testMoveDown() {
		test.move(MovementDirection.DOWN);
		assertTrue( test.getPlayerLocation().equals( new Location(0,1)) );
		IndexOutOfBoundsException thrown = assertThrows( IndexOutOfBoundsException.class,
														() -> test.move(MovementDirection.DOWN),
														"Moved out of the maze" );
	}
	
	@Test
	void testRoomLock() {
		for( int i = 0; i < test.getMaze().length; i++ ) {
			for( int j = 0; j < test.getMaze()[i].length; j++ ) {
				assertTrue( test.isRoomLocked(i,j) ); // check rooms are default locked, as they're supposed to be
				test.getMaze()[i][j].unlockRoom();
				assertFalse( test.isRoomLocked(i,j) ); // unlock the rooms again
				test.getMaze()[i][j].lockRoom();
				assertTrue( test.isRoomLocked(i,j) ); // check that lock functionality works
			}
		}
	}
	
	
	@Test
	void testRoomUnlock() {
		for( int i = 0; i < maze.length; i++ ) {
			for( int j = 0; j < maze[i].length; j++ ) {
				assertTrue( test.isRoomLocked(i,j) ); // check rooms are default locked, as they're supposed to be
				test.getMaze()[i][j].unlockRoom();
				assertFalse( test.isRoomLocked(i,j) );
			}
		}
	}
	
	@Test
	void testRoomExists() {
		for( int i = 0; i < maze.length; i++ ) {
			for( int j = 0; j < maze[i].length; j++ ) {
				assertTrue( test.roomExists(i,j) );
			}
		}
		//test close bounds of 2x2
		assertFalse( test.roomExists(2,0) );
		assertFalse( test.roomExists(0,2) );
		assertFalse( test.roomExists(2,2) );
	}
	
	@Test
	void testGetRoomQuestion() {
		Room rm = maze[0][0];
		Room rm1 = maze[1][0];
		Room rm2 = maze[0][1];
		Room rm3 = maze[1][1];
		assertTrue( rm.getQuestion().equals(test.getRoomQuestion(0, 0)) );
		assertTrue( rm1.getQuestion().equals(test.getRoomQuestion(1, 0)) );
		assertTrue( rm2.getQuestion().equals(test.getRoomQuestion(0, 1)) );
		assertTrue( rm3.getQuestion().equals(test.getRoomQuestion(1, 1)) );
		assertTrue( rm.getQuestion().equals( test.getRoomQuestion(rm)) );
		assertTrue( rm1.getQuestion().equals(test.getRoomQuestion(rm1)) );
		assertTrue( rm2.getQuestion().equals(test.getRoomQuestion(rm2)) );
		assertTrue( rm3.getQuestion().equals(test.getRoomQuestion(rm3)) );
	}

}
