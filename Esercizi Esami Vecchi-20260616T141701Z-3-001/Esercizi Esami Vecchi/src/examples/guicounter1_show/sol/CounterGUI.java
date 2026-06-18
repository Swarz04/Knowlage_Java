package examples.guicounter1_show.sol;

import javax.swing.*;

import java.awt.event.*;


@SuppressWarnings("serial")
public class CounterGUI extends JFrame {

	public CounterGUI(){
		this.setTitle("Counter GUI");
		this.setSize(300,100);
		
		final Counter counter = new Counter(0);
		final JLabel display = new JLabel("0");
		final JButton print = new JButton("print");
		
		JPanel panel = new JPanel();
		panel.add(display);
		panel.add(print);
		
		print.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				display.setText(""+counter.getValue());
				
			}
		});
		
		this.getContentPane().add(panel);
		this.setVisible(true);
		new Thread(new Runnable(){
			public void run(){
				while (true){
					counter.inc();
					try {
						Thread.sleep(10);
					} catch(Exception ex){
					}
				}
			}
		}).start();
	}
	
}
