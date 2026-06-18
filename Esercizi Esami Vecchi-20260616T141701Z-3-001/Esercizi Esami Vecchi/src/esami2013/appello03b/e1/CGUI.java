package esami2013.appello03b.e1;

import java.awt.FlowLayout;
import javax.swing.*;

public class CGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3842081547816694880L;

	private final JButton upButton = new JButton("Up");
	private final JButton downButton = new JButton("Down");
	private final JButton stopButton = new JButton("Stop");
	private final JLabel numLabel = new JLabel("0");
	
	public CGUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		final CounterAgent count = new CounterAgent();
		
		upButton.addActionListener(e->count.setDownCount(false));
		
		downButton.addActionListener(e->count.setDownCount(true));
		
		stopButton.addActionListener(e->{
			count.stopCounting();
			upButton.setEnabled(false);
			downButton.setEnabled(false);
			stopButton.setEnabled(false);
		});
		
		this.add(numLabel);
		this.add(upButton);
		this.add(downButton);
		this.add(stopButton);
		
		this.setSize(400,100);
		this.setVisible(true);
		count.start();
	}
	
	private class CounterAgent extends Thread{
		
		private static final int SLEEP_TIME = 100;
		
		private int counter;
		private volatile boolean stop;
		private volatile boolean downCount;
		
		@Override
		public void run(){
			while(!stop){
				
				if(this.downCount){
					this.counter--;
				}else{
					this.counter++;
				}
				
				try {
					SwingUtilities.invokeAndWait(()->numLabel.setText(Integer.toString(this.counter)));
					
					Thread.sleep(SLEEP_TIME);
					
				}catch(Exception e){
					System.out.println(e.toString());
				}
			}
		}
		
		public void setDownCount(final boolean downCount){
			this.downCount = downCount; 
		}
		
		public void stopCounting(){
			this.stop = true;
		}
	}
	
}
