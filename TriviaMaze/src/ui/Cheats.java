package ui;

import questionDatabaseManagement.MultipleChoiceQuestion;
import questionDatabaseManagement.Question;

public class Cheats {
	public static boolean easyQuestionsEnabled = false;

	public static Question getEasyQuestion() {
		String type = "MC";
		String question = "The Answer to this Question is \"Answer\"";
		String correctAnswer = "Answer";
		String commentWrong = "How did you get this wrong?";
		String commentRight = "Answer?";
		String options = "Answer,Not Answer, Yes, No";
		return new MultipleChoiceQuestion(type, question, correctAnswer, commentWrong, commentRight, options);
	}

}
