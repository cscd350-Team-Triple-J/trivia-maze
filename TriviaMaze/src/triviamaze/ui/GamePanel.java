package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import maze.MovementDirection;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	boolean easyQuestionCheatEnabled = true;

	Maze maze;
	MazePanel panelMaze;
	QuestionPanel panelQuestion;

	MovementDirection currentDirection = null;

	Location TestLocation = new Location(0, 0);

	JButton btnMoveUp;
	JButton btnMoveDown;
	JButton btnMoveLeft;
	JButton btnMoveRight;
	JButton btnSubmitAnswer;

	public GamePanel() {

		maze = new Maze(4, 4, new Location(0, 0), new Location(3, 3));

		panelMaze = new MazePanel(maze);
		panelMaze.setBounds(59, 60, 180, 180);
		add(panelMaze);

		panelQuestion = new QuestionPanel();
		panelQuestion.setBounds(390, 10, 200, 350);

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

		initializeGame();

		setLayout(null);
		add(panelQuestion);
		add(btnSubmitAnswer);
		add(btnMoveLeft);
		add(btnMoveUp);
		add(btnMoveDown);
		add(btnMoveRight);
	}

	private void initializeGame() {
		maze = new Maze(4, 4, new Location(0, 0), new Location(3, 3));

		panelMaze.setStartRoom(maze.getPlayerLocation());
		panelMaze.setEndRoom(maze.getEndLocation());

		panelQuestion.setVisible(false);
		disableMovementButtons();
		btnSubmitAnswer.setEnabled(false);
		enableMovementButtons();
	}

	private void endGameOptions(int selectedOption) {
		if (selectedOption == 0) // yes
			initializeGame();
		else if (selectedOption == 1)// no
			// return to main menu
			return;
		else
			return;

	}

	private void disableMovementButtons() {
		btnMoveUp.setEnabled(false);
		btnMoveDown.setEnabled(false);
		btnMoveLeft.setEnabled(false);
		btnMoveRight.setEnabled(false);
	}

	private void enableMovementButtons() {
		boolean[] checkRooms = maze.checkSurroundingRooms(maze.getMaze());
		if (checkRooms[0])
			btnMoveUp.setEnabled(true);
		if (checkRooms[1])
			btnMoveDown.setEnabled(true);
		if (checkRooms[2])
			btnMoveLeft.setEnabled(true);
		if (checkRooms[3])
			btnMoveRight.setEnabled(true);
	}

	private void showQuestion() {
		if (Cheats.easyQuestionsEnabled)
			panelQuestion.initializeQuestionData(Cheats.getEasyQuestion());
		else
			panelQuestion.initializeQuestionData(maze.getQuestion());
		panelQuestion.setVisible(true);

		btnSubmitAnswer.setEnabled(true);
		disableMovementButtons();
	}

	ActionListener submitButton = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {

			if (panelQuestion.isAnswerCorrect()) {
				Location oldLocation = maze.getPlayerLocation();
				maze.move(currentDirection);
				panelMaze.setCurrentRoom(oldLocation, maze.getPlayerLocation());

				JOptionPane.showMessageDialog(panelQuestion, "Correct!\n" + panelQuestion.getCorrectAnswerMessage());
				if (maze.isPlayerAtExit()) {
					endGameOptions(JOptionPane.showConfirmDialog(panelMaze, "You win! Do you want to play again?"));
				}

			} else {
				JOptionPane.showMessageDialog(panelQuestion,
						"Incorrect!\n" + panelQuestion.getIncorrectAnswerMessage());
				if (maze.hasValidPathToEnd()) {
					maze.permaLockRoom(maze.getAdjacentRoomLocation(currentDirection));
					panelMaze.setLockedRoom(maze.getAdjacentRoomLocation(currentDirection));
				} else {
					endGameOptions(JOptionPane.showConfirmDialog(panelMaze,
							"You have a vision that there is no way to the exit. You accept your demise. Do you want to play again?"));
				}
			}

			panelQuestion.setVisible(false);
			btnSubmitAnswer.setEnabled(false);
			currentDirection = null;
			enableMovementButtons();
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

}
