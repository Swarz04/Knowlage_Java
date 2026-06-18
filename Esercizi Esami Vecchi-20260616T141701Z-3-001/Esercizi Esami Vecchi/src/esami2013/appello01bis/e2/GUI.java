package esami2013.appello01bis.e2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3500686285291761545L;

	private final MyJList<String> list = new MyJList<>();
	
	public GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());

		this.getContentPane().add(list,BorderLayout.CENTER);
		
		final JTextField textField = new JTextField(10);
		
		final JButton add = new JButton("Add");
		add.addActionListener(e->{
			list.addElement(textField.getText());
			textField.setText(null);
		});
		
		final JButton printQuit = new JButton("Print & Quit");
		printQuit.addActionListener(e->{
			list.getAll().forEach(System.out::println);
			System.exit(0);
		});
		
		final JPanel southPanel = new JPanel(new FlowLayout());
		
		southPanel.add(add);
		southPanel.add(textField);
		southPanel.add(printQuit);
		
		this.getContentPane().add(southPanel,BorderLayout.SOUTH);
		
		pack();
		setLocationByPlatform(true);
		setVisible(true);
	}
}
