package esami2013.appello02.sol1;

public class Test {
	
	/* Data la classe Fibonaccifornita, realizzare una classe FiboGUI con costruttore che accetta il nome di un file, 
	 * tale che quando istanziata crei un JFrame (non reattivo, ossia senza gestione di thread) che abbia 
	 * ordinatamentecon un JTExtField, un pulsante Start, e un pulsante Next inizialmente disattivato (vedi figura allegata).
	 * Inserito un numero intero positivo N nel JTextField e premuto Start, si salvino sul file i primi N numeri della 
	 * serie di Fibonacci, con un -1 finale. (Si usi sempre il metodo writeLong di DataOutputStream).
	 * Fatto ciò, si deve disattivare il pulsante Start e attivare il pulsante Next.
	 * A questo punto, ad ogni pressione di Next si recuperi dal file il prossimo numero della serie di Fibonacci e 
	 * lo si mostri nel testo del pulsante Next (metodo setText), ad esempio avendo "Next (13)" per indicare che 
	 * il numero letto è il 13.
	 * Quando non vi sono più numeri da leggere (lo si scopre trovando il -1) si disattivi il pulsante Next e si chiuda 
	 * il file.
	 * Per far partire l'applicazioni si tolga il commento nel main qui sotto.
	 * 
	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando
	 */

	public static void main(String[] args) throws java.io.IOException{
		new FiboGUI("data.bin");
		
	}
}
