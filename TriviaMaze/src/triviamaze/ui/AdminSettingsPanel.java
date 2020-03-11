package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;

public class AdminSettingsPanel extends JPanel {

	public AdminSettingsPanel() {
		setLayout(null);
		
		JTabbedPane adminSettingsCard = new JTabbedPane(JTabbedPane.TOP);
		adminSettingsCard.setBounds(0, 0, 600, 450);
		add(adminSettingsCard);
		
		JPanel newAdminPanel = new NewAdministratorPanel();
		adminSettingsCard.addTab("New Admin", null, newAdminPanel, null);
		
		JPanel newQuestionPanel = new AddQuestionPanel();
		adminSettingsCard.addTab("New Question", null, newQuestionPanel, null);
	}
}
