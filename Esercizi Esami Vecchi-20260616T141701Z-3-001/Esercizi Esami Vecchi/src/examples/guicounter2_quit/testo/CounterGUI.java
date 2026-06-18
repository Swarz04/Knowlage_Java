package examples.guicounter2_quit.testo;

import java.awt.FlowLayout;

import javax.swing.*;

public class CounterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2027341173089351053L;

	private final JLabel numLabel = new JLabel();

	public CounterGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationByPlatform(true);
		this.setSize(400, 100);

		final CounterAgent count = new CounterAgent(); 
		final JButton btQuit = new JButton("Quit");
		btQuit.addActionListener(e->{
			count.stopCounting();
			System.exit(0);
		});

		this.add(numLabel);
		this.add(btQuit);
		
		this.setVisible(true);
		count.start();
	}

	private class CounterAgent extends Thread {

		private volatile boolean stop;
		private int counter;

		@Override
		public void run() {
			while (!stop) {
				counter++;
				try {
					SwingUtilities.invokeAndWait(() -> numLabel.setText(Integer.toString(counter)));

					Thread.sleep(10);
				} catch (Exception e) {}
			}
		}

		public void stopCounting() {
			this.stop = true;
		}
	}

}
