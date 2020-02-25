package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Maze.Room;
import Question.MultipleChoiceQuestion;

class RoomTest {

	Room test;
	@BeforeEach
	void setUp() throws Exception {
		String question = "Who is the main villain in FF7";
		String[] answers = {"Cloud","Ultima","Sephiroth","Aerith"};
		String correct = "Sephiroth";
		test = new Room( new MultipleChoiceQuestion( question, correct, answers) );
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
