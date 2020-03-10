package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import javax.swing.JButton;

import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.ButtonGroup;

import questionDatabaseManagement.MultipleChoiceQuestion;
import questionDatabaseManagement.Question;

public class QuestionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	String correctAnswer;

	String correctAnswerMessage;

	String questionType;

	JTextPane txtpnQuestionText;

	LinkedList<JRadioButton> rdbtnsAnswers;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private String incorrectAnswerMessage;

	public QuestionPanel() {
		setLayout(null);

		txtpnQuestionText = new JTextPane();
		txtpnQuestionText.setBounds(0, 0, 200, 100);
		txtpnQuestionText.setText("Question Text");
		txtpnQuestionText.setEditable(false);
		add(txtpnQuestionText);

		rdbtnsAnswers = new LinkedList<JRadioButton>();

//		JRadioButton rdbtnAnswerOne = new JRadioButton("Answer 1");
//		buttonGroup.add(rdbtnAnswerOne);
//		rdbtnAnswerOne.setBounds(0, 100, 200, 50);
//		rdbtnAnswerOne.setVisible(false);
//		add(rdbtnAnswerOne);
//		JRadioButton rdbtnAnswerTwo = new JRadioButton("Answer 2");
//		buttonGroup.add(rdbtnAnswerTwo);
//		rdbtnAnswerTwo.setBounds(0, 150, 200, 50);
//		rdbtnAnswerTwo.setVisible(false);
//		add(rdbtnAnswerTwo);
//		JRadioButton rdbtnAnswerThree = new JRadioButton("Answer 3");
//		buttonGroup.add(rdbtnAnswerThree);
//		rdbtnAnswerThree.setBounds(0, 200, 200, 50);
//		rdbtnAnswerThree.setVisible(false);
//		add(rdbtnAnswerThree);
//		JRadioButton rdbtnAnswerFour = new JRadioButton("Answer 4");
//		buttonGroup.add(rdbtnAnswerFour);
//		rdbtnAnswerFour.setBounds(0, 250, 200, 50);
//		rdbtnAnswerFour.setVisible(false);
//		add(rdbtnAnswerFour);
//		JRadioButton rdbtnAnswerFive = new JRadioButton("Answer 5");
//		buttonGroup.add(rdbtnAnswerFive);
//		rdbtnAnswerFive.setBounds(0, 300, 200, 50);
//		rdbtnAnswerFive.setVisible(false);
//		add(rdbtnAnswerFive);
//
//		rdbtnsAnswers = new JRadioButton[] { rdbtnAnswerOne, rdbtnAnswerTwo, rdbtnAnswerThree, rdbtnAnswerFour,
//				rdbtnAnswerFive };

	}

	public void initializeQuestionData(Question q) {
		txtpnQuestionText.setText(q.getQuestion());
		correctAnswer = q.getCorrectAnswer();
		questionType = q.getType();

		correctAnswerMessage = q.getCommentRight();
		incorrectAnswerMessage = q.getCommentWrong();
		String[] answers = null;
		System.out.println(questionType);
		switch (questionType) {
		case ("TF"):
			answers = new String[] { "True", "False" };
			break;
		case ("MC"):
			answers = ((MultipleChoiceQuestion) q).getOptions();
			break;
		case ("SA"):
			break;
		}
		for (int i = 50; i <= answers.length * 50; i += 50) {
			JRadioButton rdbtnAnswer = new JRadioButton(answers[i / 50 - 1]);
			buttonGroup.add(rdbtnAnswer);
			rdbtnAnswer.setBounds(0, i + 50, 200, 50);
			rdbtnAnswer.setVisible(true);
			rdbtnsAnswers.add(rdbtnAnswer);
			add(rdbtnAnswer);
		}
	}

	public boolean isAnswerCorrect() {
		switch (questionType) {
		case ("TF"):
			return (getSelectedAnswer().equals("True") && correctAnswer.equals("T"))
					|| (getSelectedAnswer().equals("False") && correctAnswer.equals("F"));
		case ("MC"):
			return correctAnswer.equals(getSelectedAnswer());
		case ("SA"):
			return true;
		}
		return false;
	}

	private String getSelectedAnswer() {
		for (JRadioButton radio : rdbtnsAnswers) {
			if (radio.isSelected()) {
				return radio.getText();
			}
		}
		return null;
	}

	public String getCorrectAnswerMessage() {
		// TODO Auto-generated method stub
		return correctAnswerMessage;
	}

	public String getIncorrectAnswerMessage() {
		// TODO Auto-generated method stub
		return incorrectAnswerMessage;
	}

}
