package triviamaze.ui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;

public class AdminSettingsPanel extends JPanel {

	public AdminSettingsPanel() {
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 450, 300);
		add(tabbedPane);
		
		JPanel newAdminPanel = new NewAdministratorPanel();
		tabbedPane.addTab("New Admin", null, newAdminPanel, null);
		
		JPanel newMultipleChoiceQuestionPanel = new AddMultipleChoiceQuestionPanel();
		tabbedPane.addTab("New Multiple Choice Question", null, newMultipleChoiceQuestionPanel, null);
		
		JPanel newTrueFalseQuestionPanel = new AddTrueFalseQuestionPanel();
		tabbedPane.addTab("New True/False Question", null, newTrueFalseQuestionPanel, null);

	}
}
