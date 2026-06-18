package esami2013.appello03.e1;

public class Test {
	
	/* Realizzare una classe NGUI con costruttore che prende in ingresso un intero positivo 'n', tale che quando istanziata 
	 * crei un JFrame con l'aspetto mostrato nella figura allegata (e valore dell'ingresso pari a 7) -- ad esempio, si dispongano
	 * gli 'n' pulsanti con FlowLayout. 
	 * Il JFrame venga chiuso non appena le ultime N pressioni di pulsante siano relative agli N pulsanti,
	 * ordinatamente da sinistra a destra.
	 * Esempi di sequenze di pressione che devono portare alla chiusura della finestra sono quindi:
	 * 
	 * 0 1 2 3 4 5 6
	 * 0 1 2 0 5 0 1 2 3 4 5 6
	 * 6 6 6 3 3 2 1 0 1 2 3 4 5 6
	 * 
	 * Ci sono vari modi per intercettare eventi provenienti da sorgenti multiple, e allo studente è data facoltà di scegliere
	 * in autonomia. Uno di questi consiste nell'usare i metodi JButton.setActionCommand e ActionEvent.getActionCommand visti a lezione, 
	 * che sono utilizzabili per associare una stringa ad un pulsante, e quindi intercettarla dentro alla actionPerformed quando questo
	 * viene premuto.
	 * 
 	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando, effettuate da una stessa directory (ossia senza 
	 * doverla cambiare da un comando all'altro)
	 */

	public static void main(String[] args) throws java.io.IOException{
		new NGUI(7);
		
	}
}
