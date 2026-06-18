package esami2013.appello02b.sol1;

import javax.swing.*;

import java.io.*;
import java.math.BigInteger;
import java.awt.event.*;

public class FibGUI extends JFrame {

	private static final long serialVersionUID = -6218820567019985015L;
	private final JLabel display = new JLabel("                                                                 ");
	private final JButton stop = new JButton("stop");
	
	public FibGUI(String fileName) throws IOException{
		this.setTitle("Fib GUI");
		this.setSize(400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		final Agent agent = new Agent(fileName);
		
		JPanel panel = new JPanel();
		panel.add(display);
		panel.add(stop);

		stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agent.stopComputing();
				stop.setEnabled(false);
			}
		});

		this.getContentPane().add(panel);
		this.setVisible(true);
		agent.start();
	}

	private class Agent extends Thread {

		private volatile boolean stop = false;
		private final BigFibonacci fib = new BigFibonacci();
		private PrintStream out;
		
		public Agent(String fileName) throws IOException{
			this.out = new PrintStream(fileName);
		}
		
		public void run() {
			while (!stop) {
				final BigInteger b = fib.next();
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						display.setText("" + b);
					}
				});
				out.println(""+b);
				try {
					Thread.sleep(100);
				} catch (Exception ex) {
				}
			}
			out.close();
		}

		public void stopComputing() {
			this.stop = true;
		}
	}
}
