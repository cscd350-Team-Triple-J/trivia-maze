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
import javax.swing.JTextField;

public class QuestionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	String[] correctAnswers;

	String correctAnswerMessage;

	String questionType;

	JTextPane txtpnQuestionText;

	LinkedList<JRadioButton> rdbtnsAnswers;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private String incorrectAnswerMessage;
	private JTextField txtShortAnswerInput;

	public QuestionPanel() {
		setLayout(null);

		txtpnQuestionText = new JTextPane();
		txtpnQuestionText.setBounds(0, 0, 200, 100);
		txtpnQuestionText.setText("Question Text");
		txtpnQuestionText.setEditable(false);
		add(txtpnQuestionText);

		rdbtnsAnswers = new LinkedList<JRadioButton>();
	}

	public void initializeQuestionData(Question q) {

		cleanUpMultipleChoiceInputs();
		if (txtShortAnswerInput != null)
			cleanUpShortAnswerTextbox();

		txtpnQuestionText.setText(q.getQuestion());
		correctAnswers = q.getCorrectAnswers();
		questionType = q.getType();

		correctAnswerMessage = q.getCommentRight();
		incorrectAnswerMessage = q.getCommentWrong();
		String[] answers = null;
		System.out.println(questionType);

		int size = rdbtnsAnswers.size();
		for (int i = 0; i < size; i++) {
			rdbtnsAnswers.pop().hide();
		}
		rdbtnsAnswers.clear();

		switch (questionType) {
		case ("TF"):
			initializeAnswerRadios(new String[] { "True", "False" });
			break;
		case ("MC"):
			initializeAnswerRadios(((MultipleChoiceQuestion) q).getOptions());
			break;
		case ("SA"):
			initializeShortAnswerTextbox();
			break;
		}
	}

	private void initializeAnswerRadios(String[] answers) {

		rdbtnsAnswers.clear();
		for (int i = 50; i <= answers.length * 50; i += 50) {
			JRadioButton rdbtnAnswer = new JRadioButton();
			rdbtnAnswer.setText(answers[(i / 50) - 1]);
			buttonGroup.add(rdbtnAnswer);
			rdbtnAnswer.setBounds(0, i + 50, 200, 50);
			rdbtnAnswer.setVisible(true);
			rdbtnAnswer.setSelected(false);
			rdbtnsAnswers.add(rdbtnAnswer);
			add(rdbtnAnswer);
		}
	}

	private void initializeShortAnswerTextbox() {
		txtShortAnswerInput = new JTextField();
		txtShortAnswerInput.setText("Type Answer Here");
		txtShortAnswerInput.setBounds(10, 111, 180, 20);
		add(txtShortAnswerInput);
		txtShortAnswerInput.setColumns(10);
	}

	public boolean isAnswerCorrect() {
		switch (questionType) {
		case ("TF"):
			return (getSelectedAnswer().equals("True") && Arrays.asList(correctAnswers).contains("T"))
					|| (getSelectedAnswer().equals("False") && Arrays.asList(correctAnswers).contains("F"));
		case ("MC"):
			return Arrays.asList(correctAnswers).contains(getSelectedAnswer());
		case ("SA"):
			return Arrays.asList(correctAnswers).contains(txtShortAnswerInput.getText().toLowerCase().trim());
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

	private void cleanUpMultipleChoiceInputs() {
		int size = rdbtnsAnswers.size();
		for (int i = 0; i < size; i++) {
			rdbtnsAnswers.pop().hide();
		}
	}

	private void cleanUpShortAnswerTextbox() {
		txtShortAnswerInput.hide();
	}

	public String getCorrectAnswerMessage() {
		return correctAnswerMessage;
	}

	public String getIncorrectAnswerMessage() {
		return incorrectAnswerMessage;
	}
}
