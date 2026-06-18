package esami2013.appello03.e1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NGUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6140557571836569743L;

	private final Set<JButton> btList = new HashSet<>();
	private final List<String> pressed = new ArrayList<>();
	private final List<String> exitList = new ArrayList<>();

	public NGUI(final int numTasti) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		for (int i = 0; i < numTasti; i++) {
			final String index = Integer.toString(i);
			final JButton bt = new JButton(index);
			btList.add(bt);
			bt.addActionListener(this);
			bt.setActionCommand(index);
			exitList.add(index);
			this.add(bt);
		}

		pack();
		setLocationByPlatform(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		boolean byeBye = true;

		pressed.add(e.getActionCommand());

		if (pressed.size() > exitList.size()) {
			pressed.remove(0);
		}

		if (pressed.size() == exitList.size()) {
			for (int i = 0; i < exitList.size(); i++) {
				if (!exitList.get(i).equals(pressed.get(i))) {
					byeBye = false;
				}
			}
			if (byeBye) {
				System.exit(0);
			}
		}
	}

}
