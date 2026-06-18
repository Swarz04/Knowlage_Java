package esami2013.appello06.sol2;

import javax.swing.*;

import java.awt.event.*;
import java.util.List;

public class PwdGUI extends JFrame {

	private static final long serialVersionUID = -6218820567019985015L;
	private final IPwdGUIModel model =  new PwdGUIModel();
	private final JButton[] press = new JButton[10];
	private final JButton check = new JButton("Check");
	
	public PwdGUI(List<Integer> pwd){
		this.setSize(500, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		model.setPWD(pwd);
		ActionListener listener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				model.press(Integer.parseInt(e.getActionCommand()));
			}
		};
		
		JPanel panel = new JPanel();
		for (int i=0; i<10; i++){
			press[i]=new JButton(""+i);
			press[i].setActionCommand(""+i);
			press[i].addActionListener(listener);
			panel.add(press[i]);
		}
		panel.add(check);
		
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (model.check()){
					PwdGUI.this.setVisible(false);
					System.exit(0);
				} else {
					model.reset();
				}
			}
		});
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
}
