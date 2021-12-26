import javax.swing.JFrame;

public class SwingMain {
	public static void main(String args[]) {
		ActionFrame frame = new ActionFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class ActionFrame extends JFrame{
	public ActionFrame() {
		setTitle("Swing");
		setSize(500, 300);
		
		ActionPanel panel = new ActionPanel();
		add(panel);
		
	}
}
