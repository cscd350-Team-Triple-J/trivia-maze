package triviamaze.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;

public class MainMenuPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textFieldUsername;
	JTextPane textPaneLoginDetails;
	private JPasswordField passwordFieldAdminPassword;
	
	private boolean loggedIn;
	
	public MainMenuPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddQuestion = new JButton("Admin Settings");
		btnAddQuestion.setBounds(392, 300, 168, 50);
		contentPane.add(btnAddQuestion);
		
		JButton btnPlayGame = new JButton("New Game");
		btnPlayGame.setBounds(10, 50, 120, 150);
		contentPane.add(btnPlayGame);
		
		JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setBounds(10, 200, 120, 150);
		contentPane.add(btnLoadGame);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(339,  10, 62, 20);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setBounds(339, 141, 62, 20);
		contentPane.add(lblPassword);
		
		JLabel lblGameTitle = new JLabel("Trivia Maze");
		lblGameTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblGameTitle.setBounds(187, 10, 225, 40);
		contentPane.add(lblGameTitle);
		
		JLabel lblLoginAsAdmin = new JLabel("Log in as Administrator");
		lblLoginAsAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAsAdmin.setBounds(390, 90, 170, 20);
		contentPane.add(lblLoginAsAdmin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(437, 162, 90, 20);
		contentPane.add(btnLogin);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(411, 110, 149, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordFieldAdminPassword = new JPasswordField();
		passwordFieldAdminPassword.setBounds(411, 135, 149, 20);
		contentPane.add(passwordFieldAdminPassword);
		
		textPaneLoginDetails = new JTextPane();
		textPaneLoginDetails.setBackground(new Color(211, 211, 211));
		textPaneLoginDetails.setEditable(false);
		textPaneLoginDetails.setText("Currently not logged in.");
		textPaneLoginDetails.setBounds(392, 218, 168, 71);
		contentPane.add(textPaneLoginDetails);
			
		btnPlayGame.addActionListener(PlayGameButton);
		btnLoadGame.addActionListener(LoadGameButton);
		btnAddQuestion.addActionListener(AdminSettingsButton);
		btnLogin.addActionListener(AdminLoginButton);
	}
	
	ActionListener PlayGameButton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			setContentPane(new GamePanel());
		}
	};
	
	ActionListener LoadGameButton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			setContentPane(new GamePanel());
		}
	};
	
	ActionListener AdminSettingsButton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if (loggedIn) {
				setContentPane(new AdminSettingsPanel());
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Login as administrator to access settings.");
			
			}
		}
	};
	
	ActionListener AdminLoginButton = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (loginCredentialsAreValid()) {
				loggedIn = true;
				textPaneLoginDetails.setText("Currently logged in as " + textFieldUsername.getText());
				textFieldUsername.setEnabled(false);
				passwordFieldAdminPassword.setEnabled(false);
			}
			else {
				JOptionPane.showMessageDialog(contentPane, "Invalid Username/Password.");
			}
		}
	};
	
	private boolean loginCredentialsAreValid() {
		return true;
	}
}




