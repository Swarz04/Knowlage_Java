package esami2013.appello01.sol2;

public class Test {
	
	/*  
	 * Realizzare una class GUI che appena istanziata crea il frame con (circa) l'aspetto mostrato nel file gui.png fornito.
	 * Ad esempio, si usi un FlowLayout e si aggiuga un JButton, una JLabel, e poi un JButton.  
	 * Ad ogni pressione del pulsante Next, la GUI mostri il prossimo numero primo (metodo setText sulla JLabel).
	 * A tal scopo, si usi la class PrimeListImpl fornita che implementa l'interfaccia PrimeList.
	 * Alla pressione del pulsante Show&Quit, si dovrà stampare su standard output (console) la lista dei numeri primi 
	 * trovati fino ad ora, e quindi uscire, esattamente come indicato qui di seguito (caso in cui si preme 
	 * il pulsante fino a raggiungere il 31).
	 * 
	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando
	 */
	/*
Numero primo in posizione 1: 2
Numero primo in posizione 2: 3
Numero primo in posizione 3: 5
Numero primo in posizione 4: 7
Numero primo in posizione 5: 11
Numero primo in posizione 6: 13
Numero primo in posizione 7: 17
Numero primo in posizione 8: 19
Numero primo in posizione 9: 23
Numero primo in posizione 10: 29
Numero primo in posizione 11: 31
	 */

	public static void main(String[] args) {
		new GUI();
	}

}
