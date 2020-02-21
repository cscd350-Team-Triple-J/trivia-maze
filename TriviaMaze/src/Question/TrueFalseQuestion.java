package Question;

public class TrueFalseQuestion extends BaseQuestion {
	
private String question;
	
	public TrueFalseQuestion( String question, String correctAnswer, String[] answerOptions ) {
		super(correctAnswer, answerOptions);
		this.question = question;
	}
	
	public String getQuestion() {
		return this.question;
	}

}
