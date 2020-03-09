package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import questionDatabaseManagement.Question;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import maze.Location;
import maze.Maze;

public class GamePanel extends JPanel {
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	Maze maze;
	MazePanel panelMaze;
	QuestionPanel panelQuestion;
	
	MovementDirection currentDirection = null;
	
	Location TestLocation = new Location(0,0);
	
	JButton btnMoveUp;
	JButton btnMoveDown;
	JButton btnMoveLeft;
	JButton btnMoveRight;
	JButton btnSubmitAnswer;
	
	public GamePanel() {
		
		maze = new Maze(4,4,new Location(0,0), new Location(4,4));
		
		panelMaze = new MazePanel(maze);
		panelMaze.setBounds(59, 60, 180, 180);
		add(panelMaze);
		
		panelQuestion = new QuestionPanel();
		panelQuestion.setBounds(390, 10, 200, 350);
		panelQuestion.setVisible(false);
		
		btnMoveUp = new JButton("Up");
		btnMoveUp.setBounds(100, 365, 90, 25);
		btnMoveUp.addActionListener(moveUpButton);
		
		btnMoveDown = new JButton("Down");
		btnMoveDown.setBounds(100, 415, 90, 25);
		btnMoveDown.addActionListener(moveDownButton);
		
		btnMoveLeft = new JButton("Left");
		btnMoveLeft.setBounds(10, 390, 90, 25);
		btnMoveLeft.addActionListener(moveLeftButton);

		btnMoveRight = new JButton("Right");
		btnMoveRight.setBounds(190, 390, 90, 25);
		btnMoveRight.addActionListener(moveRightButton);
		
		btnSubmitAnswer = new JButton("Submit");
		btnSubmitAnswer.setBounds(435, 390, 100, 25);
		btnSubmitAnswer.addActionListener(submitButton);
		btnSubmitAnswer.setEnabled(false);
		
		setLayout(null);
		add(panelQuestion);
		add(btnSubmitAnswer);
		add(btnMoveLeft);
		add(btnMoveUp);
		add(btnMoveDown);
		add(btnMoveRight);
	}
	
	private void setEnabledMovementButtons(boolean shouldEnable) {
		btnMoveUp.setEnabled(shouldEnable);
		btnMoveDown.setEnabled(shouldEnable);
		btnMoveLeft.setEnabled(shouldEnable);
		btnMoveRight.setEnabled(shouldEnable);
	}
	
	private void showQuestion() {
		//panelQuestion.initializeQuestionData(new Question);
		panelQuestion.setVisible(true);
		
		btnSubmitAnswer.setEnabled(true);
		setEnabledMovementButtons(false);
	}
	
	ActionListener submitButton = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (panelQuestion.isAnswerCorrect()) {
				Location newLocation;
				switch (currentDirection) {
				case UP:
					break;
				case DOWN:
					break;
				case LEFT:
					break;
				case RIGHT:
					break;
				default: 
					newLocation = new Location(0,0);
				}
			}
			else {
				maze.hasValidPathToEnd();
			}
			
			panelQuestion.setVisible(false);
			btnSubmitAnswer.setEnabled(false);
			currentDirection = null;
			setEnabledMovementButtons(true);
		}
	};
	
	ActionListener moveUpButton = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			currentDirection = MovementDirection.UP;
			showQuestion();
		}
	};
	
	ActionListener moveRightButton = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			currentDirection = MovementDirection.RIGHT;
			showQuestion();
		}
	};
	
	ActionListener moveDownButton = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			currentDirection = MovementDirection.DOWN;
			showQuestion();
		}
	};
	
	ActionListener moveLeftButton = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			currentDirection = MovementDirection.LEFT;
			showQuestion();
		}
	};

	private enum MovementDirection{
		UP,
		DOWN,
		LEFT,
		RIGHT
	}
	
}
