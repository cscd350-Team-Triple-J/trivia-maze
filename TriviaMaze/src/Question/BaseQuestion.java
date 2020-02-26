package Question;


/**
 * Maybe have the question field in the Abstract, and then have correctAnswer and answerOptions in their individual Classes?
 * This is because True/False should be using booleans, but the way we have it now they will be using strings
 */
public abstract class BaseQuestion {
	
	private String correctAnswer;
	private String[] answerOptions;
	
	public BaseQuestion( String correctAnswer, String[] answerOptions ) {
		this.correctAnswer = correctAnswer;
		this.answerOptions = answerOptions;
	}
	
	public String getCorrectAnswer() {
		return this.correctAnswer;
	}
	
	public String[] getAnswerOptions() {
		return this.answerOptions;
	}

}
