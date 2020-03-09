package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Question.BaseQuestion;

import javax.swing.JButton;
import javax.swing.ButtonGroup;

public class QuestionPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	String correctAnswer;
	
	JTextPane txtpnQuestionText;
	
	JRadioButton[] rdbtnsAnswers;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	public QuestionPanel() {
		setLayout(null);
			
		txtpnQuestionText = new JTextPane();
		txtpnQuestionText.setBounds(0, 0, 200, 100);
		txtpnQuestionText.setText("Question Text");
		txtpnQuestionText.setEditable(false);
		add(txtpnQuestionText);
	
		JRadioButton rdbtnAnswerOne = new JRadioButton("Answer 1");
		buttonGroup.add(rdbtnAnswerOne);
		rdbtnAnswerOne.setBounds(0, 100, 200, 50);
		rdbtnAnswerOne.setVisible(false);
		add(rdbtnAnswerOne);
		JRadioButton rdbtnAnswerTwo = new JRadioButton("Answer 2");
		buttonGroup.add(rdbtnAnswerTwo);
		rdbtnAnswerTwo.setBounds(0, 150, 200, 50);
		rdbtnAnswerTwo.setVisible(false);
		add(rdbtnAnswerTwo);
		JRadioButton rdbtnAnswerThree = new JRadioButton("Answer 3");
		buttonGroup.add(rdbtnAnswerThree);
		rdbtnAnswerThree.setBounds(0, 200, 200, 50);
		rdbtnAnswerThree.setVisible(false);
		add(rdbtnAnswerThree);
		JRadioButton rdbtnAnswerFour = new JRadioButton("Answer 4");
		buttonGroup.add(rdbtnAnswerFour);
		rdbtnAnswerFour.setBounds(0, 250, 200, 50);
		rdbtnAnswerFour.setVisible(false);
		add(rdbtnAnswerFour);
		JRadioButton rdbtnAnswerFive = new JRadioButton("Answer 5");
		buttonGroup.add(rdbtnAnswerFive);
		rdbtnAnswerFive.setBounds(0, 300, 200, 50);
		rdbtnAnswerFive.setVisible(false);
		add(rdbtnAnswerFive);
		
		rdbtnsAnswers = new JRadioButton[] {
				rdbtnAnswerOne,
				rdbtnAnswerTwo,
				rdbtnAnswerThree,
				rdbtnAnswerFour,
				rdbtnAnswerFive
		};
		
	}
	
	public void initializeQuestionData(BaseQuestion q) {
		rdbtnsAnswers[0].setSelected(true);
		txtpnQuestionText.setText(q.getQuestion());
		correctAnswer = q.getCorrectAnswer();
		
		String[] answerOptions = q.getAnswerOptions();
		for (int i = 0; i < answerOptions.length; i++) {
			rdbtnsAnswers[i].setText(answerOptions[i]);
			rdbtnsAnswers[i].setVisible(true);
		}
	}
	
	public boolean IsAnswerCorrect() {
		return correctAnswer == getSelectedAnswer();
	}
	
	private String getSelectedAnswer() {
		for (JRadioButton radio : rdbtnsAnswers){
			if (radio.isSelected()) {
				return radio.getText();
			}
		}
		return null;
	}

}
