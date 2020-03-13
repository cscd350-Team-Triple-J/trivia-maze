package questionDatabaseManagement;

import java.util.Arrays;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
	private String[] options;

	public MultipleChoiceQuestion(String type, String question, String correctAnswer, String commentWrong,
			String commentRight, String options) {
		super(type, question, correctAnswer, commentWrong, commentRight);
		this.options = super.convertStringToArray(options);
	}

	public String[] getOptions() {
		return options;
	}

	@Override
	public String toString() {
		return super.toString() + " MultipleChoiceQuestion [options=" + Arrays.toString(options) + "]";
	}
}
