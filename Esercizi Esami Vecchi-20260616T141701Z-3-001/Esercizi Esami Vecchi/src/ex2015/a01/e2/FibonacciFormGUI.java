package ex2015.a01.e2;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ex2015.a01.e1.FibonacciAcceptor;
import ex2015.a01.e1.FibonacciAcceptorImpl;

public class FibonacciFormGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7961050519648438609L;

	private final JTextField[] fields;

	public FibonacciFormGUI(final int size) {

		// Inizializzazione base
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		this.fields = new JTextField[size];

		// Pannello sud, ossia in basso
		final JPanel south = new JPanel(new FlowLayout());
		final JButton ok = new JButton("OK");
		south.add(ok);
		this.getContentPane().add(BorderLayout.SOUTH, south);

		// Pannello centrale, ossia una griglia a due colonne
		final JPanel center = new JPanel(new GridLayout(0, 2));

		for (int i = 0; i < size; i++) {
			center.add(wrapperPanel(new JLabel(Integer.toString(i)),
					FlowLayout.RIGHT));
			this.fields[i] = new JTextField(10);
			center.add(wrapperPanel(this.fields[i], FlowLayout.CENTER));
		}

		this.getContentPane().add(center);
		this.pack();
		this.setVisible(true);

		// Handler pulsante ok

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				final FibonacciAcceptor acc = new FibonacciAcceptorImpl();

				if (passControlFields(fields, acc)) {
					doActions(acc.getCurrentSequence());
				}

				JOptionPane.showMessageDialog(FibonacciFormGUI.this,
						"Wrong Numbers!!", "Incorrect data!",
						JOptionPane.ERROR_MESSAGE);

			}
		});

	}

	private boolean passControlFields(final JTextField[] txtf,
			final FibonacciAcceptor fib) {

		for (final JTextField t : txtf) {
			if (t.getText().isEmpty()) {
				return false;
			}
		}

		if (Integer.parseInt(fields[0].getText()) != 1
				|| Integer.parseInt(fields[1].getText()) != 1) {
			return false;
		}

		fib.reset("Standard");
		final List<Long> insertedList = new ArrayList<>();
		for (final JTextField f : fields) {
			final long actual = Long.parseLong(f.getText());
			fib.consumeNext(actual);
			insertedList.add(actual);
		}
		return insertedList.equals(fib.getCurrentSequence());
	}

	private <X> void doActions(final List<X> list) {
		System.out.println(list);
		System.exit(0);
	}

	/*
	 * Helper function statica per wrappare un componente in un pannellino con
	 * FlowLayout Serve a garantire che il componente sia piazzato secondo le
	 * sue dimentioni preferite
	 */
	private static JPanel wrapperPanel(final JComponent component,
			final int orientation) {
		final JPanel panel = new JPanel(new FlowLayout(orientation));
		panel.add(component);
		return panel;

	}
}
