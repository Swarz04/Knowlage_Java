package esami2013.appello05.e2;

import java.awt.FlowLayout;

import javax.swing.*;

public class BinaryGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2649228250369560392L;

	private final transient Binary model = new BinaryImpl(); 
	private final JLabel bitLabel = new JLabel();
	private final JLabel intLabel = new JLabel();
	
	public BinaryGUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setSize(500,100);
		
		final JButton bt0 = new JButton("0");
		final JButton bt1 = new JButton("1");
		
		final JButton btReset = new JButton("Reset");
		final JButton btCompute = new JButton("Compute");
		
		this.setLayout(new FlowLayout());
		this.add(bitLabel);
		this.add(bt0);
		this.add(bt1);
		this.add(btReset);
		this.add(btCompute);
		this.add(intLabel);
		
		bt0.addActionListener(e->{
			model.addBit(0);
			bitLabel.setText(bitLabel.getText()+"0");
		});
		
		bt1.addActionListener(e->{
			model.addBit(1);
			bitLabel.setText(bitLabel.getText()+"1");
		});
		
		btReset.addActionListener(e->{
			model.reset();
			bitLabel.setText("");
			intLabel.setText("");
		});
		
		btCompute.addActionListener(e->{
			try{
				intLabel.setText(Integer.toString(model.getInt()));
			}catch(Exception ex){
				JOptionPane.showMessageDialog(this, ex.toString());
			}
			
		});
		
		this.setVisible(true);
	}
}
