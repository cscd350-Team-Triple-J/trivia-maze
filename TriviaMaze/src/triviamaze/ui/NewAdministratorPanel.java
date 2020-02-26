package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NewAdministratorPanel extends JPanel {
	
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	public NewAdministratorPanel() {
		setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(169, 67, 110, 20);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(169, 98, 110, 20);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setText("Confirm Password");
		txtConfirmPassword.setBounds(169, 129, 110, 20);
		add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);
		
		JButton btnNewButton = new JButton("Create Admin Account");
		btnNewButton.setBounds(137, 194, 162, 23);
		add(btnNewButton);
	}
	
	private class CreateAdminAccountButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			JButton button = (JButton) event.getSource();
		}
	}
}
