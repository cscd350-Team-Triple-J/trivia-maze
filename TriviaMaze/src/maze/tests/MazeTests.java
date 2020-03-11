package maze.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import maze.*;
import questionDatabaseManagement.Question;

class MazeTests {

	Maze t;
	Maze test;
	Maze test2;
	Maze test3;
	Room[][] maze;
	Location mazeStart = new Location(0, 0);
	Location mazeEnd = new Location(1, 1);

	@BeforeEach
	void setUp() throws Exception {
		test = new Maze(2, 2, mazeStart, mazeEnd);
		t = new Maze(3, 3, mazeStart, new Location(3, 3));
		test2 = new Maze(4, 4, mazeStart, new Location(4, 4));
		test3 = new Maze(5, 7, mazeStart, new Location(5, 7));
		maze = test.getMaze();
	}

	@Test
	void testMazeLocations() {
		assertTrue(new Location(0, 0).equals(test.getPlayerLocation()));
		assertTrue(new Location(0, 0).equals(mazeStart));
		assertTrue(new Location(1, 1).equals(mazeEnd));
	}

	@Test
	void testMoveRight() {
		test.move(MovementDirection.RIGHT);
		assertTrue(test.getPlayerLocation().equals(new Location(1, 0)));
		IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class,
				() -> test.move(MovementDirection.RIGHT), "Moved out of the maze");
	}

	@Test
	void testMoveLeft() {
		test.setPlayerLocation(new Location(1, 0));
		test.move(MovementDirection.LEFT);
		assertTrue(test.getPlayerLocation().equals(new Location(0, 0)));
		IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class,
				() -> test.move(MovementDirection.LEFT), "Moved out of the maze");
	}

	@Test
	void testMoveUp() {
		test.setPlayerLocation(new Location(0, 1));
		test.move(MovementDirection.UP);
		assertTrue(test.getPlayerLocation().equals(new Location(0, 0)));
		IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class,
				() -> test.move(MovementDirection.UP), "Moved out of the maze");
	}

	@Test
	void testMoveDown() {
		test.move(MovementDirection.DOWN);
		assertTrue(test.getPlayerLocation().equals(new Location(0, 1)));
		IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class,
				() -> test.move(MovementDirection.DOWN), "Moved out of the maze");
	}

	@Test
	void testCheckSurroundingRooms() {
		boolean[] arr = test.checkSurroundingRooms();
	}

	@Test
	void testRoomLock() {
		for (int i = 0; i < test.getMaze().length; i++) {
			for (int j = 0; j < test.getMaze()[i].length; j++) {
				assertTrue(test.isRoomLocked(i, j)); // check rooms are default locked, as they're supposed to be
				test.getMaze()[i][j].unlockRoom();
				assertFalse(test.isRoomLocked(i, j)); // unlock the rooms again
				test.getMaze()[i][j].lockRoom();
				assertTrue(test.isRoomLocked(i, j)); // check that lock functionality works
			}
		}
	}

	@Test
	void testRoomUnlock() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				assertTrue(test.isRoomLocked(i, j)); // check rooms are default locked, as they're supposed to be
				test.getMaze()[i][j].unlockRoom();
				assertFalse(test.isRoomLocked(i, j));
			}
		}
	}

	@Test
	void testRoomExists() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				assertTrue(test.roomExists(i, j));
			}
		}
		// test close bounds of 2x2
		assertFalse(test.roomExists(2, 0));
		assertFalse(test.roomExists(0, 2));
		assertFalse(test.roomExists(2, 2));
	}

	@Test
	void testCheckRoom() {
		boolean[] rooms = test.checkSurroundingRooms();
		assertFalse(rooms[0]);
		assertTrue(rooms[1]);
		assertFalse(rooms[2]);
		assertTrue(rooms[3]);

		test2.move(MovementDirection.RIGHT);
		test2.move(MovementDirection.DOWN);
		rooms = test2.checkSurroundingRooms();
		assertTrue(rooms[0]);
		assertTrue(rooms[1]);
		assertTrue(rooms[2]);
		assertTrue(rooms[3]);
	}

	@Test
	void testHasValidPath() {
		// test blank mazes
		assertTrue(test.hasValidPathToEnd());
		assertTrue(test2.hasValidPathToEnd());
		assertTrue(test3.hasValidPathToEnd());
		assertTrue(t.hasValidPathToEnd());

		// set up block @ start so that test has no valid path
		t.getMaze()[0][1].setRoomPermaLocked(true);
		t.getMaze()[1][0].setRoomPermaLocked(true);
		assertFalse(t.hasValidPathToEnd());

		// unblock one room to open path
		t.getMaze()[1][0].setRoomPermaLocked(false);
		assertTrue(t.hasValidPathToEnd());

		// unblock other room by start, and block off the end
		t.getMaze()[0][1].setRoomPermaLocked(false);
		t.getMaze()[1][2].setRoomPermaLocked(true);
		t.getMaze()[2][1].setRoomPermaLocked(true);
		assertFalse(t.hasValidPathToEnd());

		// testing with changed player location
		test3.setPlayerLocation(new Location(3, 4));
		assertTrue(test3.hasValidPathToEnd());
		test3.getMaze()[2][4].setRoomPermaLocked(true);
		test3.getMaze()[4][4].setRoomPermaLocked(true);
		test3.getMaze()[3][3].setRoomPermaLocked(true);
		test3.getMaze()[3][5].setRoomPermaLocked(true);
		assertFalse(test3.hasValidPathToEnd());
		test3.getMaze()[3][5].setRoomPermaLocked(false);
		assertTrue(test3.hasValidPathToEnd());

	}

}
