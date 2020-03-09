package triviamaze.ui;

import javax.swing.JPanel;

import maze.Location;
import maze.Maze;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MazePanel extends JPanel {

	/**
	 * Create the panel.
	 */

	ImageIcon iconEmptyRoom = new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png"));
	ImageIcon iconCurrentRoom = new ImageIcon(MazePanel.class.getResource("/images/CurrentRoom.png"));
	ImageIcon iconExitRoom = new ImageIcon(MazePanel.class.getResource("/images/ExitRoom.png"));
	
	private JLabel[][] roomImages;

	public MazePanel(Maze maze) {
		setLayout(null);

		JLabel lblHorizontalDoor_1_2_1_1 = new JLabel("");
		lblHorizontalDoor_1_2_1_1
				.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_2_1_1.setBounds(80, 160, 20, 10);
		add(lblHorizontalDoor_1_2_1_1);

		JLabel lblHorizontalDoor_1_1_1_1_1 = new JLabel("");
		lblHorizontalDoor_1_1_1_1_1
				.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1_1_1_1.setBounds(130, 160, 20, 10);
		add(lblHorizontalDoor_1_1_1_1_1);

		JLabel lblHorizontalDoor_2_1_1 = new JLabel("");
		lblHorizontalDoor_2_1_1
				.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_2_1_1.setBounds(30, 160, 20, 10);
		add(lblHorizontalDoor_2_1_1);

		JLabel lblHorizontalDoor_1_2_1 = new JLabel("");
		lblHorizontalDoor_1_2_1
				.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_2_1.setBounds(80, 110, 20, 10);
		add(lblHorizontalDoor_1_2_1);

		JLabel lblHorizontalDoor_2_1 = new JLabel("");
		lblHorizontalDoor_2_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_2_1.setBounds(30, 110, 20, 10);
		add(lblHorizontalDoor_2_1);

		JLabel lblHorizontalDoor_1_1_1_1 = new JLabel("");
		lblHorizontalDoor_1_1_1_1
				.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1_1_1.setBounds(130, 110, 20, 10);
		add(lblHorizontalDoor_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_1_1_1.setBounds(160, 130, 10, 20);
		add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_3_1.setBounds(10, 130, 10, 20);
		add(lblNewLabel_3_1);

		JLabel lblRoomRowFourColumnThree = new JLabel("");
		lblRoomRowFourColumnThree.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnThree.setBounds(100, 150, 30, 30);
		add(lblRoomRowFourColumnThree);

		JLabel lblRoomRowFourColumnTwo = new JLabel("");
		lblRoomRowFourColumnTwo.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnTwo.setBounds(50, 150, 30, 30);
		add(lblRoomRowFourColumnTwo);

		JLabel lblRoomRowFourColumnOne = new JLabel("");
		lblRoomRowFourColumnOne.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnOne.setBounds(0, 150, 30, 30);
		add(lblRoomRowFourColumnOne);

		JLabel lblRoomRowFourColumnFour = new JLabel("");
		lblRoomRowFourColumnFour.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowFourColumnFour.setBounds(150, 150, 30, 30);
		add(lblRoomRowFourColumnFour);

		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_2_1_1.setBounds(110, 130, 10, 20);
		add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_1_1.setBounds(160, 80, 10, 20);
		add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_2.setBounds(60, 80, 10, 20);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_3.setBounds(10, 80, 10, 20);
		add(lblNewLabel_3);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_2_1.setBounds(110, 80, 10, 20);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_2_1.setBounds(60, 130, 10, 20);
		add(lblNewLabel_1_2_1);

		JLabel lblRoomRowTwoColumnThree = new JLabel("");
		lblRoomRowTwoColumnThree.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnThree.setBounds(100, 50, 30, 30);
		add(lblRoomRowTwoColumnThree);

		JLabel lblRoomRowTwoColumnOne = new JLabel("");
		lblRoomRowTwoColumnOne.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnOne.setBounds(0, 50, 30, 30);
		add(lblRoomRowTwoColumnOne);

		JLabel lblRoomRowTwoColumnFour = new JLabel("");
		lblRoomRowTwoColumnFour.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnFour.setBounds(150, 50, 30, 30);
		add(lblRoomRowTwoColumnFour);

		JLabel lblRoomRowTwoColumnTwo = new JLabel("");
		lblRoomRowTwoColumnTwo.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowTwoColumnTwo.setBounds(50, 50, 30, 30);
		add(lblRoomRowTwoColumnTwo);

		JLabel lblHorizontalDoor_1_1 = new JLabel("");
		lblHorizontalDoor_1_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1.setBounds(130, 10, 20, 10);
		add(lblHorizontalDoor_1_1);

		JLabel lblRoomRowThreeColumnFour = new JLabel("");
		lblRoomRowThreeColumnFour.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnFour.setBounds(150, 100, 30, 30);
		add(lblRoomRowThreeColumnFour);

		JLabel lblRoomRowThreeColumnOne = new JLabel("");
		lblRoomRowThreeColumnOne.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnOne.setBounds(0, 100, 30, 30);
		add(lblRoomRowThreeColumnOne);

		JLabel lblRoomRowThreeColumnTwo = new JLabel("");
		lblRoomRowThreeColumnTwo.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnTwo.setBounds(50, 100, 30, 30);
		add(lblRoomRowThreeColumnTwo);

		JLabel lblRoomRowThreeColumnThree = new JLabel("");
		lblRoomRowThreeColumnThree.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowThreeColumnThree.setBounds(100, 100, 30, 30);
		add(lblRoomRowThreeColumnThree);

		JLabel lblHorizontalDoor = new JLabel("");
		lblHorizontalDoor.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor.setBounds(30, 10, 20, 10);
		add(lblHorizontalDoor);

		JLabel lblRoomRowOneColumnOne = new JLabel("");
		lblRoomRowOneColumnOne.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnOne.setBounds(0, 0, 30, 30);
		add(lblRoomRowOneColumnOne);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_2.setBounds(110, 30, 10, 20);
		add(lblNewLabel_2);

		JLabel lblRoomRowOneColumnThree = new JLabel("");
		lblRoomRowOneColumnThree.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnThree.setBounds(100, 0, 30, 30);
		add(lblRoomRowOneColumnThree);

		JLabel lblHorizontalDoor_1 = new JLabel("");
		lblHorizontalDoor_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1.setBounds(80, 10, 20, 10);
		add(lblHorizontalDoor_1);

		JLabel lblHorizontalDoor_1_1_1 = new JLabel("");
		lblHorizontalDoor_1_1_1
				.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_1_1.setBounds(130, 60, 20, 10);
		add(lblHorizontalDoor_1_1_1);

		JLabel lblRoomRowOneColumnFour = new JLabel("");
		lblRoomRowOneColumnFour.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnFour.setBounds(150, 0, 30, 30);
		add(lblRoomRowOneColumnFour);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1_1.setBounds(160, 30, 10, 20);
		add(lblNewLabel_1_1);

		JLabel lblHorizontalDoor_2 = new JLabel("");
		lblHorizontalDoor_2.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_2.setBounds(30, 60, 20, 10);
		add(lblHorizontalDoor_2);

		JLabel lblRoomRowOneColumnTwo = new JLabel("");
		lblRoomRowOneColumnTwo.setIcon(new ImageIcon(MazePanel.class.getResource("/images/EmptyRoom.png")));
		lblRoomRowOneColumnTwo.setBounds(50, 0, 30, 30);
		add(lblRoomRowOneColumnTwo);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel_1.setBounds(60, 30, 10, 20);
		add(lblNewLabel_1);

		JLabel lblHorizontalDoor_1_2 = new JLabel("");
		lblHorizontalDoor_1_2.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorHorizontal.png")));
		lblHorizontalDoor_1_2.setBounds(80, 60, 20, 10);
		add(lblHorizontalDoor_1_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MazePanel.class.getResource("/images/UnlockedDoorVertical.png")));
		lblNewLabel.setBounds(10, 30, 10, 20);
		add(lblNewLabel);

		roomImages = new JLabel[][] {
				{ lblRoomRowOneColumnOne, lblRoomRowTwoColumnOne, lblRoomRowThreeColumnOne, lblRoomRowFourColumnOne },
				{ lblRoomRowOneColumnTwo, lblRoomRowTwoColumnTwo, lblRoomRowThreeColumnTwo, lblRoomRowFourColumnTwo },
				{ lblRoomRowOneColumnThree, lblRoomRowTwoColumnThree, lblRoomRowThreeColumnThree, lblRoomRowFourColumnThree },
				{ lblRoomRowOneColumnFour, lblRoomRowTwoColumnFour, lblRoomRowThreeColumnFour, lblRoomRowFourColumnFour },};
						
		setRoomIcon(new Location(0,0), iconCurrentRoom);
		setRoomIcon(new Location(3,3), iconExitRoom);
	}

	
	private void setRoomIcon(Location roomToSet, ImageIcon icon) {
		roomImages[roomToSet.getXCoord()][roomToSet.getYCoord()].setIcon(icon);
	}
	
	public void movePlayer(int x, int y) {

	}


	public void setCurrentRoom(Location oldLocation, Location newLocation) {
		setRoomIcon(oldLocation, iconEmptyRoom);
		setRoomIcon(newLocation, iconCurrentRoom);
		
	}
}
