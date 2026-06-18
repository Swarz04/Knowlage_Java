package esami2013.appello02.sol1;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class FiboGUI extends JFrame {

	private static final long serialVersionUID = -7483358546926910323L;
	public static final String START = "Start";
	public static final String NEXT = "Next";
	public static final int COLUMNS = 10;

	private final JTextField tnum = new JTextField(COLUMNS);
	private final JButton start = new JButton(START);
	private final JButton next = new JButton(NEXT);
	private final String file;
	
	public static void main(String[] args) {
		new FiboGUI("data.bin");
	}

	public FiboGUI(String f) {
		file = f;
		final JPanel main = new JPanel();
		setSize(400,100);
		getContentPane().add(main);
		main.add(tnum);
		main.add(start);
		start.addActionListener(new StartListener());
		main.add(next);
		next.setEnabled(false);
		next.addActionListener(new NextListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class StartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				int num = Integer.parseInt(tnum.getText());
				if (num > 0) {
					tnum.setEditable(false);
					start.setEnabled(false);
					try {
						DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
						java.util.Iterator<Long> it = new Fibonacci(num);
						while (it.hasNext()) {
							dos.writeLong(it.next());
						}
						dos.writeLong(-1); // terminatore
						dos.close();
						next.setEnabled(true);
					} catch (IOException e) {
						e.printStackTrace();
						System.exit(0);
					}
				}
			} catch (NumberFormatException e) {
			}
		}
	}

	private class NextListener implements ActionListener {
		
		private boolean first = true;
		private long element;
		private DataInputStream dis;
		@Override
		public void actionPerformed(ActionEvent ev) {
				try {
					if (first){
						dis = new DataInputStream(new FileInputStream(file));
						element = dis.readLong();
						first = false;
					}
					next.setText(NEXT+" ("+element+")");
					element = dis.readLong();
					if (element == -1){
						next.setEnabled(false);
						dis.close();
					} 
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
		}
	}	
}
