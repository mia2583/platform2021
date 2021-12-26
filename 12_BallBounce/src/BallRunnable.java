import javax.swing.JPanel;

class BallRunnable implements Runnable {
	public BallRunnable(Ball aBall, JPanel ballPanel, int delay) { 
		ball = aBall; this.ballPanel = ballPanel; this.DELAY= delay;
	}
	
	public void run() {
		try {
			for (int i = 1; i <= STEPS; i++) {
				ball.move(ballPanel.getBounds()); // update the location of the ball
				ballPanel.paint(ballPanel.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) { }
	}
	
	private Ball ball;
	private JPanel ballPanel;
	public static final int STEPS = 1000;
	public int DELAY;
}
