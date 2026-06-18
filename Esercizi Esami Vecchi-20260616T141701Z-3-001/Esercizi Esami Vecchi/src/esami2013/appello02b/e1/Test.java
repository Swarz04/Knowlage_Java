package esami2013.appello02b.e1;

public class Test {
	
	/* Realizzare una classe FibGUI con costruttore che accetta il nome di un file, tale che quando istanziata
	 * crei un JFrame con un pulsante stop e una JLabel (ampia almeno 40 caratteri circa) -- si veda l'immagine allegata.
	 * Sfruttando la classe BigFibonacci fornita, alla creazione della GUI parta anche un thread dentro il quale
	 * ogni 100 millisecondi circa si calcoli un nuovo valore della serie di Fibonacci, lo si mostri nella JLabel, 
	 * e lo si scriva sul file, da trattare come file di testo (si consiglia l'uso di java.io.PrintStream,
	 * la stessa classe di System.out). 
	 * Alla pressione del pulsante stop, il computo dei numeri della serie venga fermato, il pulsante disabilitato, 
	 * e il file chiuso.
	 * Per far partire l'applicazioni si tolga il commento nel main qui sotto.
	 * 
	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando
	 */

	public static void main(String[] args) throws java.io.IOException{
		new FibGUI("prova.txt");
		
	}
}
