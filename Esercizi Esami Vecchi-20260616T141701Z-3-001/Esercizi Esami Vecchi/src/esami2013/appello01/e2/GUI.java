package esami2013.appello01.e2;

import java.awt.FlowLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

public class GUI {
	
	private final PrimeList model = new PrimeListImpl();
	
	public GUI(){
		final JFrame main = new JFrame();
		main.setLayout(new FlowLayout());
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final String LABEL_TEXT = "Prime: ";
		final JLabel primeNumber = new JLabel(LABEL_TEXT+"2    ");
		
		final List<Integer> listOfPrimes = new LinkedList<>();
		listOfPrimes.add(2);
		final JButton nextButton = new JButton("Next");
		nextButton.addActionListener(e-> {
			final int nextPrime = model.next();
			listOfPrimes.add(nextPrime);
			primeNumber.setText(LABEL_TEXT+nextPrime);
		});
		
		final JButton showQuitButton = new JButton("Show & Quit");
		showQuitButton.addActionListener(e->{
			StringBuilder out = new StringBuilder();
			final String positionString = "Numero primo in posizione ";
			for(int i=0;i<listOfPrimes.size();i++){
				out.append(positionString).append(i+1).append(": ").append(listOfPrimes.get(i)).append('\n');
			}
			System.out.println(out.toString());
			System.exit(0);
		});
		
		main.add(nextButton);
		main.add(primeNumber);
		main.add(showQuitButton);
		
		main.setLocationByPlatform(true);
		main.pack();
		main.setVisible(true);
	}
}
