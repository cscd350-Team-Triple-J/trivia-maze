package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class AddTrueFalseQuestionPanel extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JTextField textFieldQuestion;

	public AddTrueFalseQuestionPanel() {
		setLayout(null);
		
		JRadioButton rdbtnTrue = new JRadioButton("True");
		buttonGroup.add(rdbtnTrue);
		rdbtnTrue.setSelected(true);
		rdbtnTrue.setBounds(181, 103, 72, 23);
		add(rdbtnTrue);
		
		JRadioButton rdbtnFalse = new JRadioButton("False");
		buttonGroup.add(rdbtnFalse);
		rdbtnFalse.setBounds(181, 133, 72, 23);
		add(rdbtnFalse);
		
		JButton btnSaveQuestion = new JButton("Save Question");
		btnSaveQuestion.setBounds(178, 171, 119, 23);
		add(btnSaveQuestion);
		btnSaveQuestion.addActionListener(new AddTrueFalseQuestionButton());
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(153, 82, 220, 14);
		add(lblCorrectAnswer);
		
		textFieldQuestion = new JTextField();
		textFieldQuestion.setText("Question");
		textFieldQuestion.setColumns(10);
		textFieldQuestion.setBounds(143, 55, 194, 20);
		add(textFieldQuestion);
	}
	
	private class AddTrueFalseQuestionButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {

		}
	}
}
