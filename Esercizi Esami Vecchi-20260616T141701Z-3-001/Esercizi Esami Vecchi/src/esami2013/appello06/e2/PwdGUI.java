package esami2013.appello06.e2;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.*;

public class PwdGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8812041687921122325L;

	private final transient PasswordCheck<Integer> model = new PasswordCheckImpl<>();
	
	public PwdGUI(final List<Integer> list) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setSize(600, 100);
		this.setLayout(new FlowLayout());

		final JButton[] zeroNineButtons = new JButton[10];
		
		for (int i = 0; i < zeroNineButtons.length; i++) {
			final int actualIndex = i;
			zeroNineButtons[i] = new JButton(Integer.toString(i));
			zeroNineButtons[i].addActionListener(e->model.scrivi(actualIndex));
		}

		final JButton btCheck = new JButton("Check");
		btCheck.addActionListener(e->{
			if(model.check(list)){
				System.exit(0);
			}else{
				model.clear();
				JOptionPane.showMessageDialog(this, "Hai inserito una password sbagliata. Riporvare...");
			}
		});
		
		for(final JButton b : zeroNineButtons){
			this.add(b);
		}
		
		this.add(btCheck);
		
		this.setVisible(true);
	}
}
