package questionDatabaseManagement;

public class Question {
	private String type;
	private String question;
	private String correctAnswer;
	private String commentWrong;
	private String commentRight;

	public Question(String type, String question, String correctAnswer, String commentWrong, String commentRight) {
		this.type = type;
		this.question = question;
		this.correctAnswer = correctAnswer;
		this.commentWrong = commentWrong;
		this.commentRight = commentRight;
	}
}
