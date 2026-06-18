package examples.guicounter3_stop.testo;

import java.awt.FlowLayout;

import javax.swing.*;

public class CounterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8935670481582147951L;

	private final JLabel numLabel = new JLabel();
	
	public CounterGUI(){
		this.setLocationByPlatform(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(400, 100);
		
		final CounterAgent count = new CounterAgent();
		final JButton btStop = new JButton("Stop");
		btStop.addActionListener(e->count.stopCounting());
		
		this.add(numLabel);
		this.add(btStop);
		
		this.setVisible(true);
		count.start();
	}
	
	private class CounterAgent extends Thread{
		
		private volatile boolean stop;
		private int counter;

		@Override
		public void run(){
			while(!stop){
				counter++;
				try{
					SwingUtilities.invokeAndWait(()->numLabel.setText(Integer.toString(counter)));
					Thread.sleep(10);
				}catch(Exception e){
				}
			}
		}
		
		public void stopCounting(){
			this.stop = true;
		}
	}
}
