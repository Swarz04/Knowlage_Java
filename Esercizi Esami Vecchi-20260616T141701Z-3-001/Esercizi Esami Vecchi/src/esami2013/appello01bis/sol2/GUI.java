package esami2013.appello01bis.sol2;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	final private JButton badd = new JButton("Add");
	final private JTextField text = new JTextField(10);
	final private JButton bquit = new JButton("Print & Quit");
	final private MyJList<String> ijlist = new MyJList<>();

	public GUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 200);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(ijlist, BorderLayout.CENTER);
		JPanel panel = new JPanel(new FlowLayout());
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.add(badd);
		panel.add(text);
		panel.add(bquit);
		badd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ijlist.addElement(text.getText());
			}
		});
		bquit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String s : ijlist.getAll()) {
					System.out.println(s);
				}
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
}
