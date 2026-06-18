package esami2013.appello05.sol2;

import javax.swing.*;
import java.awt.event.*;

public class BinaryGUI extends JFrame {

	private static final long serialVersionUID = -6218820567019985015L;
	private final IBinGUIModel model = new BinGUIModel();
	private final JLabel display = new JLabel(model.getString());
	private final JButton zero = new JButton("0");
	private final JButton one = new JButton("1");
	private final JButton reset = new JButton("Reset");
	private final JButton compute = new JButton("Compute");
	private final JLabel out = new JLabel("");
	
	public BinaryGUI(){
		this.setSize(500, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.add(display);
		panel.add(zero);
		panel.add(one);
		panel.add(reset);
		panel.add(compute);
		panel.add(out);

		zero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.zero();
				display.setText(model.getString());
			}
		});
		
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.one();
				display.setText(model.getString());
			}
		});
		
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.reset();
				display.setText(model.getString());
			}
		});
		
		compute.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				out.setText(""+model.compute());
			}
		});
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
