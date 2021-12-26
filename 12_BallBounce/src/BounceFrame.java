import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class BounceFrame extends JFrame {
	public BounceFrame() {
		setTitle("BounceThread");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		ballPanel = new BallPanel(); add(ballPanel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Add 1", new ActionListener() { 
			public void actionPerformed(ActionEvent event) { addBall(); }
		});
		addButton(buttonPanel, "Add 2", new ActionListener() {
			public void actionPerformed(ActionEvent event) { addBall(); 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			addBall(); }
		});
		addButton(buttonPanel, "Close", new ActionListener() { 
			public void actionPerformed(ActionEvent event) { System.exit(0); }
		});
		add(buttonPanel, BorderLayout.SOUTH);
		
		JMenu speedMenu = new JMenu("Speed");
		JMenuItem faster = speedMenu.add("Faster");
		faster.addActionListener((ActionEvent e) -> setDelayFast() );
		JMenuItem slower = speedMenu.add("Slower");
		slower.addActionListener((ActionEvent e) -> setDelaySlow());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(speedMenu);
		
	}
	private void addButton(Container container, String title, ActionListener listener) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}

	public void addBall() {
		Ball b = new Ball();
		ballPanel.add(b);
		Runnable r = new BallRunnable(b, ballPanel, DELAY);
		Thread t = new Thread(r);
		t.start();
	}
	
	public void setDelayFast() {
		int fastDelay = (int)this.DELAY/2;
		if (fastDelay < 1) {
			fastDelay = 1;
		}
		this.DELAY =  fastDelay;
	}
	
	public void setDelaySlow() {
		this.DELAY =  this.DELAY*2;
	}
	
	private BallPanel ballPanel;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350; 
	public static int DELAY = 3;
	
}
