package esami2013.appello03b.e1;

public class Test {
	
	/* Realizzare una classe CGUI con costruttore vuoto, tale che quando istanziata crei un JFrame con l'aspetto
	 * mostrato nella figura allegata (e contatore inizialmente posto a zero).
	 * Il contatore venga aggiornato incrementandolo ogni 100 millisecondi circa, e il suo nuovo valore venga mostrato
	 * ogni volta (l'interfaccia sia quindi reattiva).
	 * Alla pressione del pulsante "down", il conteggio venga da lì in poi aggiornato decrementandolo;
	 * alla pressione del pulsante "up", il conteggio venga da lì in poi aggiornato incrementandolo; e così via, in modo alternato.
	 * Alla pressione del pulsante "stop", il conteggio si blocchi, e i tre pulsanti vengano disabilitati.
	 * Per far partire l'applicazioni si tolga il commento nel main qui sotto.
	 * 
	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando, effettuate da una stessa directory (ossia senza 
	 * doverla cambiare da un comando all'altro)
	 */

	public static void main(String[] args) throws java.io.IOException{
		new CGUI();
		
	}
}
