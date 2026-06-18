package esami2013.appello03b.sol1;

import javax.swing.*;

import java.awt.event.*;

public class NGUI extends JFrame {

	private static final long serialVersionUID = -6218820567019985015L;
	private JButton[] row;
	private Listener listener = new Listener();
	
	public NGUI(int n){
		this.row = new JButton[n];
		
		this.setSize(400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		for (int i=0; i<n; i++){
			this.row[i] = new JButton(""+i);
			this.row[i].addActionListener(listener);
			this.row[i].setActionCommand(""+i);
			panel.add(this.row[i]);
		}
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	
	private class Listener implements ActionListener{
		
		private int last = -1; 

		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getActionCommand().equals("0")){
				last = 0;
			} else if (arg0.getActionCommand().equals(""+(last+1))){
				last++;
			} else {
				last = -1;
			}
			System.out.println(last);
			if (last == row.length-1){
				setVisible(false);
			}
		}
		
	}
}
