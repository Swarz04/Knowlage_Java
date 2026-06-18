package examples.guicounter3_stop.sol;

import javax.swing.*;

import java.awt.event.*;

public class CounterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1222191612877582282L;
	
	final Counter counter = new Counter(0);
	final JLabel display = new JLabel();
	final JButton button = new JButton("stop");
	final Agent agent = new Agent();

	public CounterGUI() {
		this.setTitle("Counter GUI");
		this.setSize(300, 100);

		JPanel panel = new JPanel();
		panel.add(display);
		panel.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agent.stopCounting();
			}
		});

		this.getContentPane().add(panel);
		this.setVisible(true);
		agent.start();
	}

	private class Agent extends Thread {

		private volatile boolean stop = false;

		public void run() {
			while (!stop) {
				counter.inc();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						display.setText("" + counter.getValue());
					}
				});
				try {
					Thread.sleep(10);
				} catch (Exception ex) {
				}
			}
		}

		public void stopCounting() {
			this.stop = true;
		}
	}

}
