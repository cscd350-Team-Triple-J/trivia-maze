package Question;

public class MultipleChoiceQuestion extends BaseQuestion {
	
	private String question;
	
	public MultipleChoiceQuestion( String question, String correctAnswer, String[] answerOptions ) {
		super(correctAnswer, answerOptions);
		this.question = question;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	

}
