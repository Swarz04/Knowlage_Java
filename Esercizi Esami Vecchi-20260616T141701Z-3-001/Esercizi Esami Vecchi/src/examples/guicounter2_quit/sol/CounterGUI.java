package examples.guicounter2_quit.sol;

import javax.swing.*;

import java.awt.event.*;


public class CounterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2916056906882689497L;

	public CounterGUI(){
		this.setTitle("Counter GUI");
		this.setSize(300,100);
		
		final Counter counter = new Counter(0);
		final JLabel display = new JLabel();
		final JButton quit = new JButton("quit");
		
		JPanel panel = new JPanel();
		panel.add(display);
		panel.add(quit);
		
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		this.getContentPane().add(panel);
		this.setVisible(true);
		new Thread(new Runnable(){
			public void run(){
				while (true){
					counter.inc();
					SwingUtilities.invokeLater(new Runnable(){
						public void run() {
							display.setText(""+counter.getValue());
						}
					});
					try {
						Thread.sleep(10);
					} catch(Exception ex){
					}
				}
			}
		}).start();
		//new CounterAgent(counter).start();
	}
	
}
