package questionDatabaseManagement;

public class MultipleChoiceQuestion extends Question {
	private String option1;
	private String option2;
	private String option3;

	public MultipleChoiceQuestion(String type, String question, String correctAnswer, String commentWrong,
			String commentRight, String option1, String option2, String option3) {
		super(type, question, correctAnswer, commentWrong, commentRight);
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
	}
}
