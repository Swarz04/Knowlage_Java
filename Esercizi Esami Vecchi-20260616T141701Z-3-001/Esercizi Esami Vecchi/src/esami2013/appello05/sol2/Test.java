package esami2013.appello05.sol2;

public class Test {
	
	/* Realizzare una classe BinaryGUI con costruttore vuoto, tale che quando istanziata crei un JFrame con l'aspetto
	 * mostrato nella figura allegata (i due valori numerici mostrati sono inizialmente assenti).
	 * I pulsanti zero e uno servono per digitare una sequenza binaria (dal bit meno significativo al più significativo)
	 * che dovrà comparire sulla sinistra mano a mano che viene digitata.
	 * Il pulsante reset la deve azzerare (ossia deve rendere la sequenza di bit vuota), in modo che la si possa 
	 * riscrivere daccapo.
	 * Il pulsante compute calcola il valore decimale della sequenza binaria e lo riporta sulla destra, come indicato
	 * in figura (infatti, il 13 corrisponde al numero binario 1101).
	 * Circa un terzo del valore dell'esercizio verrà attribuito se la parte di "modello" di questa applicazione 
	 * (in un'ottiva MVC) viene opportunamente disaccoppiata dal resto, e utilizzata mediante una interfaccia. 
	 * Non sarà invece necessario disaccoppiare le parti di vista e controllo.
	 * Per far partire l'applicazioni si tolga il commento nel main qui sotto.
	 * 
 	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando, effettuate da una stessa directory (ossia senza 
	 * doverla cambiare da un comando all'altro)
*/

	public static void main(String[] args) throws java.io.IOException{
		new BinaryGUI();
	}
}
