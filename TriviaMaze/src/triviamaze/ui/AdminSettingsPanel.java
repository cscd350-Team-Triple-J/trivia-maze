package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;

public class AdminSettingsPanel extends JPanel {

	public AdminSettingsPanel() {
		setLayout(null);
		
		JTabbedPane adminSettingsCard = new JTabbedPane(JTabbedPane.TOP);
		adminSettingsCard.setBounds(0, 0, 450, 300);
		add(adminSettingsCard);
		
		JPanel newAdminPanel = new NewAdministratorPanel();
		adminSettingsCard.addTab("New Admin", null, newAdminPanel, null);
		
		JPanel newMultipleChoiceQuestionPanel = new AddMultipleChoiceQuestionPanel();
		adminSettingsCard.addTab("New Multiple Choice Question", null, newMultipleChoiceQuestionPanel, null);
		
		JPanel newTrueFalseQuestionPanel = new AddTrueFalseQuestionPanel();
		adminSettingsCard.addTab("New True/False Question", null, newTrueFalseQuestionPanel, null);
		
		
	}
}
