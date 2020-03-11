package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import questionDatabaseManagement.MultipleChoiceQuestion;
import questionDatabaseManagement.Question;
import questionDatabaseManagement.QuestionSaver;

import javax.swing.JLabel;
import javax.swing.JButton;

public class AddQuestionPanel extends JPanel {

	private final ButtonGroup multipleChoiceButtonGroup = new ButtonGroup();
	private final ButtonGroup trueFalseButtonGroup = new ButtonGroup();

	JComboBox comboBox;

	QuestionSaver saver;

	private JTextField txtCommentRight;
	private JTextField txtCommentWrong;

	private JTextField txtShortAnswer;
	private JTextField txtQuestion;

	private JTextField[] multipleChoiceAnswers;
	private JRadioButton[] correctMultipleChoiceAnswer;

	private JRadioButton[] correctTrueFalseAnswer;
	private JLabel lblCorrectAnswer;

	public AddQuestionPanel() {
		setLayout(null);

		saver = new QuestionSaver("jdbc:sqlite:Trivia Questions.db");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Multiple Choice", "True/False", "Short Answer" }));
		comboBox.setBounds(218, 11, 121, 20);
		add(comboBox);
		comboBox.addActionListener(QuestionTypeComboBox);

		txtCommentRight = new JTextField();
		txtCommentRight.setText("Comment Right");
		txtCommentRight.setBounds(218, 265, 121, 20);
		add(txtCommentRight);
		txtCommentRight.setColumns(10);

		txtCommentWrong = new JTextField();
		txtCommentWrong.setText("Comment Wrong");
		txtCommentWrong.setColumns(10);
		txtCommentWrong.setBounds(218, 296, 121, 20);
		add(txtCommentWrong);

		JButton btnNewButton = new JButton("Save Question");
		btnNewButton.setBounds(218, 327, 121, 23);
		add(btnNewButton);

		initializeMultipleChoiceInputs();
		initializeTrueFalseInputs();
		initializeShortAnswerInputs();

	}

	private void initializeMultipleChoiceInputs() {

		multipleChoiceAnswers = new JTextField[5];
		correctMultipleChoiceAnswer = new JRadioButton[5];

		JTextField txtAnswerOne = new JTextField();
		txtAnswerOne.setText("Answer One");
		txtAnswerOne.setBounds(253, 84, 86, 20);
		add(txtAnswerOne);
		txtAnswerOne.setColumns(10);
		multipleChoiceAnswers[0] = txtAnswerOne;

		JTextField txtAnswerTwo = new JTextField();
		txtAnswerTwo.setText("Answer Two");
		txtAnswerTwo.setColumns(10);
		txtAnswerTwo.setBounds(253, 115, 86, 20);
		add(txtAnswerTwo);
		multipleChoiceAnswers[1] = txtAnswerTwo;

		JTextField txtAnswerThree = new JTextField();
		txtAnswerThree.setText("Answer Three");
		txtAnswerThree.setColumns(10);
		txtAnswerThree.setBounds(253, 146, 86, 20);
		add(txtAnswerThree);
		multipleChoiceAnswers[2] = txtAnswerThree;

		JTextField txtAnswerFour = new JTextField();
		txtAnswerFour.setText("Answer Four");
		txtAnswerFour.setColumns(10);
		txtAnswerFour.setBounds(253, 177, 86, 20);
		add(txtAnswerFour);
		multipleChoiceAnswers[3] = txtAnswerFour;

		JTextField txtAnswerFive = new JTextField();
		txtAnswerFive.setText("Answer Five");
		txtAnswerFive.setColumns(10);
		txtAnswerFive.setBounds(253, 208, 86, 20);
		add(txtAnswerFive);
		multipleChoiceAnswers[4] = txtAnswerFive;

		JRadioButton rdbtnCorrectAnswerOne = new JRadioButton("");
		rdbtnCorrectAnswerOne.setBounds(218, 84, 21, 23);
		add(rdbtnCorrectAnswerOne);
		correctMultipleChoiceAnswer[0] = rdbtnCorrectAnswerOne;
		multipleChoiceButtonGroup.add(rdbtnCorrectAnswerOne);

		JRadioButton rdbtnCorrectAnswerTwo = new JRadioButton("");
		rdbtnCorrectAnswerTwo.setBounds(218, 114, 21, 23);
		add(rdbtnCorrectAnswerTwo);
		correctMultipleChoiceAnswer[1] = rdbtnCorrectAnswerTwo;
		multipleChoiceButtonGroup.add(rdbtnCorrectAnswerTwo);

		JRadioButton rdbtnCorrectAnswerThree = new JRadioButton("");
		rdbtnCorrectAnswerThree.setBounds(218, 174, 21, 23);
		add(rdbtnCorrectAnswerThree);
		correctMultipleChoiceAnswer[2] = rdbtnCorrectAnswerThree;
		multipleChoiceButtonGroup.add(rdbtnCorrectAnswerThree);

		JRadioButton rdbtnCorrectAnswerFour = new JRadioButton("");
		rdbtnCorrectAnswerFour.setBounds(218, 144, 21, 23);
		add(rdbtnCorrectAnswerFour);
		correctMultipleChoiceAnswer[3] = rdbtnCorrectAnswerFour;
		multipleChoiceButtonGroup.add(rdbtnCorrectAnswerFour);

		JRadioButton rdbtnCorrectAnswerFive = new JRadioButton("");
		rdbtnCorrectAnswerFive.setBounds(218, 207, 21, 23);
		add(rdbtnCorrectAnswerFive);
		correctMultipleChoiceAnswer[4] = rdbtnCorrectAnswerFive;
		multipleChoiceButtonGroup.add(rdbtnCorrectAnswerFive);

		lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(160, 68, 110, 14);
		add(lblCorrectAnswer);
	}

	private void initializeTrueFalseInputs() {
		correctTrueFalseAnswer = new JRadioButton[2];

		JRadioButton rdbtnTrue = new JRadioButton("True");
		rdbtnTrue.setBounds(218, 83, 110, 23);
		add(rdbtnTrue);
		correctTrueFalseAnswer[0] = rdbtnTrue;
		trueFalseButtonGroup.add(rdbtnTrue);

		JRadioButton rdbtnFalse = new JRadioButton("False");
		rdbtnFalse.setBounds(218, 114, 110, 23);
		add(rdbtnFalse);
		correctTrueFalseAnswer[1] = rdbtnFalse;
		trueFalseButtonGroup.add(rdbtnFalse);

		txtQuestion = new JTextField();
		txtQuestion.setText("Question");
		txtQuestion.setBounds(218, 42, 121, 20);
		add(txtQuestion);
		txtQuestion.setColumns(10);

		hideTrueFalseInput();
	}

	private void initializeShortAnswerInputs() {
		txtShortAnswer = new JTextField();
		txtShortAnswer.setText("AAAA");
		txtShortAnswer.setBounds(218, 83, 121, 23);
		add(txtShortAnswer);
		txtShortAnswer.setColumns(10);

		hideShortAnswerInput();
	}

	private void updateQuestionInput(String questionType) {
		hideMultipleChoiceInput();
		hideTrueFalseInput();
		hideShortAnswerInput();

		switch (questionType) {
		case "Multiple Choice":
			showMultipleChoiceInput();
			break;
		case "True/False":
			showTrueFalseInput();
			break;
		case "Short Answer":
			showShortAnswerInput();
			break;
		}

	}

	private Question getQuestionFromInput() {
		String type = "";
		String question = txtQuestion.getText();
		String correctAnswer = "";
		String commentWrong = txtCommentWrong.getText();
		String commentRight = txtCommentRight.getText();

		switch ((String) comboBox.getSelectedItem()) {
		case "Multiple Choice":
			type = "MC";
			correctAnswer = getMultipleChoiceCorrectAnswer();
			String options = getMultipleChoiceAnswers();
			return new MultipleChoiceQuestion(type, question, correctAnswer, commentWrong, commentRight, options);
		case "True/False":
			type = "TF";
			correctAnswer = getTrueFalseCorrectAnswer();
			break;
		case "Short Answer":
			type = "SA";
			correctAnswer = getShortAnswerCorrectAnswer();
			break;
		default:
		}

		return new Question(type, question, correctAnswer, commentWrong, commentRight);

	}

	private void showMultipleChoiceInput() {
		for (JTextField field : multipleChoiceAnswers) {
			field.setVisible(true);
		}
		for (JRadioButton btn : correctMultipleChoiceAnswer) {
			btn.setVisible(true);
		}
		correctMultipleChoiceAnswer[0].setSelected(true);
		lblCorrectAnswer.setVisible(true);
	}

	private void hideMultipleChoiceInput() {
		for (JTextField field : multipleChoiceAnswers) {
			field.setText("");
			field.setVisible(false);
		}
		for (JRadioButton btn : correctMultipleChoiceAnswer) {
			btn.setSelected(false);
			btn.setVisible(false);
		}
		lblCorrectAnswer.setVisible(false);
	}

	private String getMultipleChoiceCorrectAnswer() {

		int correctAnswerIndex = 0;
		for (int i = 0; i < correctMultipleChoiceAnswer.length; i++) {
			if (correctMultipleChoiceAnswer[i].isSelected()) {
				correctAnswerIndex = i;
				break;
			}

		}
		return multipleChoiceAnswers[correctAnswerIndex].toString();
	}

	private String getMultipleChoiceAnswers() {
		StringBuilder sb = new StringBuilder();
		String temp = "";

		for (JTextField field : multipleChoiceAnswers) {
			if (!field.getText().isEmpty())
				sb.append(field.getText() + ",");
		}

		if (!sb.toString().isEmpty()) {
			temp = sb.substring(0, sb.length() - 2);
		}

		return temp;
	}

	private void showTrueFalseInput() {
		for (JRadioButton btn : correctTrueFalseAnswer) {
			btn.setVisible(true);
		}
		correctMultipleChoiceAnswer[0].setSelected(true);
	}

	private void hideTrueFalseInput() {
		for (JRadioButton btn : correctTrueFalseAnswer) {
			btn.setSelected(false);
			btn.setVisible(false);
		}
	}

	private String getTrueFalseCorrectAnswer() {
		if (correctTrueFalseAnswer[0].isSelected())
			return "T";
		return "F";
	}

	private void showShortAnswerInput() {
		txtShortAnswer.setVisible(true);
	}

	private void hideShortAnswerInput() {
		txtShortAnswer.setVisible(false);
		txtShortAnswer.setText("");
	}

	private String getShortAnswerCorrectAnswer() {
		return txtShortAnswer.getText();
	}

	ActionListener SaveQuestionButton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			saver.saveToDatabase(getQuestionFromInput());
		}

	};

	ActionListener QuestionTypeComboBox = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox) e.getSource();
			String questionType = (String) cb.getSelectedItem();
			updateQuestionInput(questionType);
		}
	};
}
