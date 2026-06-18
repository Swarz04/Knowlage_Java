package esami2013.appello03.sol1;

import javax.swing.*;
import java.awt.event.*;

public class CGUI extends JFrame {

	private static final long serialVersionUID = -6218820567019985015L;
	private final JLabel display = new JLabel();
	private final JButton stop = new JButton("stop");
	private final JButton up = new JButton("up");
	private final JButton down = new JButton("down");
	
	public CGUI(){
		this.setSize(400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		final Agent agent = new Agent();
		
		JPanel panel = new JPanel();
		panel.add(display);
		panel.add(up);
		panel.add(down);
		panel.add(stop);

		up.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agent.upCounting();
			}
		});
		
		down.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agent.downCounting();
			}
		});
		
		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agent.stopCounting();
				stop.setEnabled(false);
				up.setEnabled(false);
				down.setEnabled(false);
			}
		});

		this.getContentPane().add(panel);
		this.setVisible(true);
		agent.start();
	}

	private class Agent extends Thread {

		private volatile boolean stop = false;
		private volatile boolean up = true;
		private int counter = 0;
		
		public void run() {
			while (!stop) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						display.setText("" + counter);
						counter += up ? 1 : -1;
					}
				});
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
				}
			}
		}

		public void stopCounting() {
			this.stop = true;
		}
		
		public void upCounting() {
			this.up = true;
		}
		
		public void downCounting() {
			this.up = false;
		}
	}
}
