package triviamaze.ui;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class AddMultipleChoiceQuestionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTextField txtQuestion;
	private JTextField txtAnswerOne;
	private JTextField txtAnswerTwo;
	private JTextField txtAnswerThree;

	public AddMultipleChoiceQuestionPanel() {
		setLayout(null);
		
		JButton btnSaveQuestion = new JButton("Save Question");
		btnSaveQuestion.setBounds(160, 187, 119, 23);
		add(btnSaveQuestion);
		btnSaveQuestion.addActionListener(new AddMultipleChoiceQuestionButton());
		
		txtAnswerOne = new JTextField();
		txtAnswerOne.setText("Answer 1");
		txtAnswerOne.setColumns(10);
		txtAnswerOne.setBounds(180, 92, 86, 20);
		add(txtAnswerOne);
		
		txtAnswerTwo = new JTextField();
		txtAnswerTwo.setText("Answer 2");
		txtAnswerTwo.setColumns(10);
		txtAnswerTwo.setBounds(180, 125, 86, 20);
		add(txtAnswerTwo);
		
		txtAnswerThree = new JTextField();
		txtAnswerThree.setText("Answer 3");
		txtAnswerThree.setBounds(180, 156, 86, 20);
		add(txtAnswerThree);
		txtAnswerThree.setColumns(10);
		
		JRadioButton rdbtnCorrectAnswerOne = new JRadioButton("");
		buttonGroup.add(rdbtnCorrectAnswerOne);
		rdbtnCorrectAnswerOne.setSelected(true);
		rdbtnCorrectAnswerOne.setBounds(92, 92, 26, 23);
		add(rdbtnCorrectAnswerOne);
		
		JRadioButton rdbtnCorrectAnswerTwo = new JRadioButton("");
		buttonGroup.add(rdbtnCorrectAnswerTwo);
		rdbtnCorrectAnswerTwo.setBounds(92, 122, 26, 23);
		add(rdbtnCorrectAnswerTwo);
		
		JRadioButton rdbtnCorrectAnswerThree = new JRadioButton("");
		buttonGroup.add(rdbtnCorrectAnswerThree);
		rdbtnCorrectAnswerThree.setBounds(92, 156, 26, 23);
		add(rdbtnCorrectAnswerThree);

		txtQuestion = new JTextField();
		txtQuestion.setText("Question");
		txtQuestion.setBounds(123, 40, 194, 20);
		add(txtQuestion);
		txtQuestion.setColumns(10);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(64, 71, 202, 14);
		add(lblCorrectAnswer);
	}
	
	private class AddMultipleChoiceQuestionButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

		}
	}
}
