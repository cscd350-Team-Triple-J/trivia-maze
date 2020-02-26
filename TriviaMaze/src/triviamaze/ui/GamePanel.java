package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

public class GamePanel extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private JLabel[][] roomImages = new JLabel[4][4];

	public GamePanel() {
		setLayout(null);
		
		JButton btnMoveUp = new JButton("Up");
		btnMoveUp.setBounds(99, 214, 89, 23);
		add(btnMoveUp);
		btnMoveUp.addActionListener(new MoveUpButton());
		
		JButton btnMoveDown = new JButton("Down");
		btnMoveDown.setBounds(99, 248, 89, 23);
		add(btnMoveDown);
		btnMoveDown.addActionListener(new MoveDownButton());
		
		JButton btnMoveLeft = new JButton("Left");
		btnMoveLeft.setBounds(10, 234, 89, 23);
		add(btnMoveLeft);
		btnMoveLeft.addActionListener(new MoveLeftButton());

		JButton btnMoveRight = new JButton("Right");
		btnMoveRight.setBounds(189, 234, 89, 23);
		add(btnMoveRight);
		btnMoveRight.addActionListener(new MoveRightButton());
		
		JTextPane txtpnQuestionText = new JTextPane();
		txtpnQuestionText.setEditable(false);
		txtpnQuestionText.setText("Question Text");
		txtpnQuestionText.setBounds(321, 20, 105, 93);
		add(txtpnQuestionText);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Answer 1");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(321, 139, 109, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnAnswer = new JRadioButton("Answer 2");
		buttonGroup.add(rdbtnAnswer);
		rdbtnAnswer.setBounds(321, 165, 109, 23);
		add(rdbtnAnswer);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Answer 3");
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(321, 191, 109, 23);
		add(rdbtnNewRadioButton_1_1);
		
		JButton btnSubmitAnswer = new JButton("Submit");
		btnSubmitAnswer.setBounds(328, 234, 89, 23);
		add(btnSubmitAnswer);
		btnSubmitAnswer.addActionListener(new SubmitAnswerButton());
		
		
		JLabel lblRoomRowOneColumnOne = new JLabel("");
		lblRoomRowOneColumnOne.setIcon(new ImageIcon(GamePanel.class.getResource("/images/CurrentRoom.png")));
		lblRoomRowOneColumnOne.setBounds(10, 10, 30, 30);
		add(lblRoomRowOneColumnOne);
		
		
		JLabel lblRoomRowOneColumnTwo = new JLabel("");
		lblRoomRowOneColumnTwo.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnTwo.setBounds(60, 10, 30, 30);
		add(lblRoomRowOneColumnTwo);

		
		JLabel lblRoomRowOneColumnThree = new JLabel("");
		lblRoomRowOneColumnThree.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnThree.setBounds(110, 10, 30, 30);
		add(lblRoomRowOneColumnThree);

		
		JLabel lblRoomRowOneColumnFour = new JLabel("");
		lblRoomRowOneColumnFour.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnFour.setBounds(160, 10, 30, 30);
		add(lblRoomRowOneColumnFour);

		
		JLabel lblRoomRowTwoColumnOne = new JLabel("");
		lblRoomRowTwoColumnOne.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnOne.setBounds(10, 60, 30, 30);
		add(lblRoomRowTwoColumnOne);
		
		JLabel lblRoomRowTwoColumnTwo = new JLabel("");
		lblRoomRowTwoColumnTwo.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnTwo.setBounds(60, 60, 30, 30);
		add(lblRoomRowTwoColumnTwo);
		
		JLabel lblRoomRowTwoColumnThree = new JLabel("");
		lblRoomRowTwoColumnThree.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnThree.setBounds(110, 60, 30, 30);
		add(lblRoomRowTwoColumnThree);
		
		JLabel lblRoomRowTwoColumnFour = new JLabel("");
		lblRoomRowTwoColumnFour.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnFour.setBounds(160, 60, 30, 30);
		add(lblRoomRowTwoColumnFour);
		
		JLabel lblRoomRowThreeColumnOne = new JLabel("");
		lblRoomRowThreeColumnOne.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnOne.setBounds(10, 110, 30, 30);
		add(lblRoomRowThreeColumnOne);
		
		JLabel lblRoomRowThreeColumnTwo = new JLabel("");
		lblRoomRowThreeColumnTwo.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnTwo.setBounds(60, 110, 30, 30);
		add(lblRoomRowThreeColumnTwo);
		
		JLabel lblRoomRowThreeColumnThree = new JLabel("");
		lblRoomRowThreeColumnThree.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnThree.setBounds(110, 110, 30, 30);
		add(lblRoomRowThreeColumnThree);
		
		JLabel lblRoomRowThreeColumnFour = new JLabel("");
		lblRoomRowThreeColumnFour.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnFour.setBounds(160, 110, 30, 30);
		add(lblRoomRowThreeColumnFour);
		
		JLabel lblRoomRowFourColumnOne = new JLabel("");
		lblRoomRowFourColumnOne.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnOne.setBounds(10, 160, 30, 30);
		add(lblRoomRowFourColumnOne);
		
		JLabel lblRoomRowFourColumnTwo = new JLabel("");
		lblRoomRowFourColumnTwo.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnTwo.setBounds(60, 160, 30, 30);
		add(lblRoomRowFourColumnTwo);
		
		JLabel lblRoomRowFourColumnThree = new JLabel("");
		lblRoomRowFourColumnThree.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnThree.setBounds(110, 160, 30, 30);
		add(lblRoomRowFourColumnThree);
		
		JLabel lblRoomRowFourColumnFour = new JLabel("");
		lblRoomRowFourColumnFour.setIcon(new ImageIcon(GamePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnFour.setBounds(160, 160, 30, 30);
		add(lblRoomRowFourColumnFour);
		
		roomImages[0][0] = lblRoomRowOneColumnOne;
		roomImages[0][1] = lblRoomRowOneColumnTwo;
		roomImages[0][2] = lblRoomRowOneColumnThree;
		roomImages[0][3] = lblRoomRowOneColumnFour;
		roomImages[1][0] = lblRoomRowTwoColumnOne;
		roomImages[1][1] = lblRoomRowTwoColumnTwo;
		roomImages[1][2] = lblRoomRowTwoColumnThree;
		roomImages[1][3] = lblRoomRowTwoColumnFour;
		roomImages[2][0] = lblRoomRowThreeColumnOne;
		roomImages[2][1] = lblRoomRowThreeColumnTwo;
		roomImages[2][2] = lblRoomRowThreeColumnThree;
		roomImages[2][3] = lblRoomRowThreeColumnFour;
		roomImages[3][0] = lblRoomRowFourColumnOne;
		roomImages[3][1] = lblRoomRowFourColumnTwo;
		roomImages[3][2] = lblRoomRowFourColumnThree;
		roomImages[3][3] = lblRoomRowFourColumnFour;
		
		
		JLabel lblHorizontalDoor = new JLabel("");
		lblHorizontalDoor.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor.setBounds(40, 20, 20, 10);
		add(lblHorizontalDoor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel.setBounds(20, 40, 10, 20);
		add(lblNewLabel);
		
		JLabel lblHorizontalDoor_1 = new JLabel("");
		lblHorizontalDoor_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1.setBounds(90, 20, 20, 10);
		add(lblHorizontalDoor_1);
		
		JLabel lblHorizontalDoor_1_1 = new JLabel("");
		lblHorizontalDoor_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1.setBounds(140, 20, 20, 10);
		add(lblHorizontalDoor_1_1);
		
		JLabel lblHorizontalDoor_2 = new JLabel("");
		lblHorizontalDoor_2.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_2.setBounds(40, 70, 20, 10);
		add(lblHorizontalDoor_2);
		
		JLabel lblHorizontalDoor_1_2 = new JLabel("");
		lblHorizontalDoor_1_2.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_2.setBounds(90, 70, 20, 10);
		add(lblHorizontalDoor_1_2);
		
		JLabel lblHorizontalDoor_1_1_1 = new JLabel("");
		lblHorizontalDoor_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1_1.setBounds(140, 70, 20, 10);
		add(lblHorizontalDoor_1_1_1);
		
		JLabel lblHorizontalDoor_2_1 = new JLabel("");
		lblHorizontalDoor_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_2_1.setBounds(40, 120, 20, 10);
		add(lblHorizontalDoor_2_1);
		
		JLabel lblHorizontalDoor_1_2_1 = new JLabel("");
		lblHorizontalDoor_1_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_2_1.setBounds(90, 120, 20, 10);
		add(lblHorizontalDoor_1_2_1);
		
		JLabel lblHorizontalDoor_1_1_1_1 = new JLabel("");
		lblHorizontalDoor_1_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1_1_1.setBounds(140, 120, 20, 10);
		add(lblHorizontalDoor_1_1_1_1);
		
		JLabel lblHorizontalDoor_2_1_1 = new JLabel("");
		lblHorizontalDoor_2_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_2_1_1.setBounds(40, 170, 20, 10);
		add(lblHorizontalDoor_2_1_1);
		
		JLabel lblHorizontalDoor_1_2_1_1 = new JLabel("");
		lblHorizontalDoor_1_2_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_2_1_1.setBounds(90, 170, 20, 10);
		add(lblHorizontalDoor_1_2_1_1);
		
		JLabel lblHorizontalDoor_1_1_1_1_1 = new JLabel("");
		lblHorizontalDoor_1_1_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1_1_1_1.setBounds(140, 170, 20, 10);
		add(lblHorizontalDoor_1_1_1_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1.setBounds(70, 40, 10, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_1.setBounds(170, 40, 10, 20);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_2.setBounds(120, 40, 10, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_1_1.setBounds(170, 90, 10, 20);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_2_1.setBounds(120, 90, 10, 20);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_2.setBounds(70, 90, 10, 20);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_3.setBounds(20, 90, 10, 20);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_1_1_1.setBounds(170, 140, 10, 20);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_2_1_1.setBounds(120, 140, 10, 20);
		add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_2_1.setBounds(70, 140, 10, 20);
		add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(GamePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_3_1.setBounds(20, 140, 10, 20);
		add(lblNewLabel_3_1);
	}
	
	private class SubmitAnswerButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
		}
	}
	
	private class MoveUpButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
		}
	}
	
	private class MoveDownButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
		}
	}
	
	private class MoveLeftButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
		}
	}
	
	private class MoveRightButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
		
		}
	}
	
}
