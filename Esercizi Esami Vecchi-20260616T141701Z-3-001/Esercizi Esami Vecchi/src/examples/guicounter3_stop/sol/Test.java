package examples.guicounter3_stop.sol;

public class Test {
	
	/* Realizzare una classe CounterGUI con costruttore vuoto, tale che quando istanziata
	 * crei un JFrame con un pulsante stop e una JLabel. Alla creazione parta un contatore
	 * che si aggiorni ogni 10 millisecondi circa, mostrando sulla JLabel il proprio valore 
	 * di conteggio mano a mano. Alla pressione del pulsante stop, il conteggio venga fermato,
	 * senza chiudere la finestra.  
	 */

	public static void main(String[] args) {
		new CounterGUI();
		
	}
}
