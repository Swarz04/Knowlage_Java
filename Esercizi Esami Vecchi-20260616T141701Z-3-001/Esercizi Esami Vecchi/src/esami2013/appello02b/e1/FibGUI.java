package esami2013.appello02b.e1;

import java.awt.FlowLayout;
import java.io.*;

import javax.swing.*;

public class FibGUI extends JFrame {

	private final JLabel numLabel;

	private static final long serialVersionUID = -4188975054879542409L;

	public FibGUI(final String fileName) throws FileNotFoundException {
		
		this.setTitle("Fib GUI");
		this.setSize(500, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		numLabel = new JLabel();

		final MyThread aggiornaLabel = new MyThread(fileName);

		final JButton stop = new JButton("Stop");
		stop.addActionListener(e -> {
			aggiornaLabel.stopSerie();
			stop.setEnabled(false);
		});

		this.add(numLabel);
		this.add(stop);
		
		setLocationByPlatform(true);
		setVisible(true);
		
		aggiornaLabel.start();
	}

	private class MyThread extends Thread {

		private volatile boolean stop;
		private final PrintStream outStream;
		private final BigFibonacci sequence = new BigFibonacci();
		
		public MyThread(final String outFile) throws FileNotFoundException{
			this.outStream = new PrintStream(outFile);
		}
		
		@Override
		public void run() {
			try {
				while (!stop) {
					Thread.sleep(100);

					final String fibNum = sequence.next().toString();
					
					SwingUtilities.invokeAndWait(() -> numLabel.setText(fibNum));

					outStream.println(fibNum);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}finally{
				outStream.close();
			}
		}

		public void stopSerie() {
			this.stop = true;
		}
	}

}
