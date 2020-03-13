package questionDatabaseManagement;

import java.util.Arrays;
import java.util.Scanner;

public class Question {
	private String type;
	private String question;
	private String[] correctAnswers;
	private String commentWrong;
	private String commentRight;

	public Question(String type, String question, String correctAnswers, String commentWrong, String commentRight) {
		this.type = type;
		this.question = question;
		if (type.equals("SA")) {
			correctAnswers = correctAnswers.toLowerCase();
			correctAnswers = correctAnswers.replaceAll(" ", "");
		}
		this.correctAnswers = convertStringToArray(correctAnswers);
		this.commentWrong = commentWrong;
		this.commentRight = commentRight;
	}

	public String[] convertStringToArray(String string) {
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		int count = scanner.nextInt();
		String[] array = new String[count];
		for (int i = 0; i < count; i++) {
			array[i] = scanner.next();
		}
		return array;
	}

	public String getType() {
		return type;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getCorrectAnswers() {
		return correctAnswers;
	}

	public String getCommentWrong() {
		return commentWrong;
	}

	public String getCommentRight() {
		return commentRight;
	}

	@Override
	public String toString() {
		return "Question [type=" + type + ", question=" + question + ", correctAnswer="
				+ Arrays.toString(correctAnswers) + ", commentWrong=" + commentWrong + ", commentRight=" + commentRight
				+ "]";
	}
}