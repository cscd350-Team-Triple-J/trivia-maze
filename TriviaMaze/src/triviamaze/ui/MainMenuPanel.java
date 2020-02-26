package triviamaze.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainMenuPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MainMenuPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblThisIsThe = new JLabel("This is the Main Menu");
		contentPane.add(lblThisIsThe, BorderLayout.NORTH);
		
		JButton btnAddQuestion = new JButton("Admin Settings");
		contentPane.add(btnAddQuestion, BorderLayout.WEST);
		
		JButton btnPlayGame = new JButton("Play Game");
		contentPane.add(btnPlayGame, BorderLayout.EAST);
		
		btnPlayGame.addActionListener(new PlayGameButton(this));
		btnAddQuestion.addActionListener(new AdminSettingsButton(this));
	}
	
	private class PlayGameButton implements ActionListener{

		JFrame frame;
		public PlayGameButton(JFrame frame) {
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JButton button = (JButton) event.getSource();
			frame.setContentPane(new GamePanel());
			frame.invalidate();
			frame.validate();
		}
	}
	
	private class AdminSettingsButton implements ActionListener{

		JFrame frame;
		public AdminSettingsButton(JFrame frame) {
			this.frame = frame;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JButton button = (JButton) event.getSource();
			frame.setContentPane(new AdminSettingsPanel());
			frame.invalidate();
			frame.validate();
		
		}
	}
}




