import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ActionPanel extends JPanel {
	public ActionPanel() {
		addButton("Add");
		addButton("Remove First");
		addButton("Remove Last");
		addButton("Remove All");
		addButton("Quit");
	}
	
	public void addButton(String name) {
		HelpAction help = new HelpAction(name);
		JButton button = new JButton(help);
		button.addActionListener( (ActionEvent event) -> {
			String cmd = event.getActionCommand();
			if(cmd == "Quit") System.exit(0);
			else JOptionPane.showMessageDialog(null, cmd);
		});
		add( button );
	}
	
	class HelpAction extends AbstractAction {
		public HelpAction(String name) {
			putValue(Action.NAME , name);
			putValue(Action.SHORT_DESCRIPTION, "Help for button "+ name);
		}
		
		public void actionPerformed(ActionEvent event) {
			//
		}
	}
}
