package esami2013.appello01.sol2;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	
	private PrimeListImpl primes = new PrimeListImpl();
	private JButton bnext = new JButton("Next");
	private JLabel label = new JLabel("Prime: 2");
	private JButton bquit = new JButton("Show & Quit");
	
	public GUI(){
		this.setSize(400,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(bnext);
		bnext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				label.setText("Prime: "+primes.next());
			}
		});
		this.getContentPane().add(label);
		this.getContentPane().add(bquit);
		bquit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int ct = 1;
				for (Integer i: primes){
					System.out.println("Numero primo in posizione "+(ct++)+": "+i);
				}
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}
