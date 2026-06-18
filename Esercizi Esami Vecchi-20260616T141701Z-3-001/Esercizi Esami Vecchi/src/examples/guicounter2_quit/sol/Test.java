package examples.guicounter2_quit.sol;

public class Test {
	
	/* Realizzare una classe CounterGUI con costruttore vuoto, tale che quando istanziata
	 * crei un JFrame con un pulsante quit e una JLabel. Alla creazione parta un contatore
	 * che si aggiorna ogni 10 millisecondi circa, mostrando sulla JLabel il proprio valore 
	 * di conteggio mano a mano. Alla pressione del pulsante quit, l'applicazione venga terminata.
	 * Si mostri compilazione ed esecuzione da linea di comando. 
	 */

	public static void main(String[] args) {
		new CounterGUI();
		
	}
}
