package examples.guicounter1_show.testo;

import java.awt.FlowLayout;

import javax.swing.*;

public class CounterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2952825815791835987L;

	public CounterGUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 100);
		this.setLocationByPlatform(true);
		this.setLayout(new FlowLayout());
		
		final CounterAgent count = new CounterAgent();
		
		final JLabel numLabel = new JLabel(" ");
		
		final JButton btPrint = new JButton("Print");
		btPrint.addActionListener(e->numLabel.setText(Integer.toString(count.getCurrentNum())));
		
		this.add(btPrint);
		this.add(numLabel);
		
		this.setVisible(true);
		count.start();
	}
	
	private static class CounterAgent extends Thread{
		
		private volatile boolean stop;
		private int counter;
		
		@Override
		public void run(){
			while(!stop){
				counter++;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}
		
		public int getCurrentNum(){
			return this.counter;
		}
		
	}
	
}
