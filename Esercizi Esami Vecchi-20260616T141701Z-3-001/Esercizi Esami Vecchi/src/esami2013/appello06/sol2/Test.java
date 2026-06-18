package esami2013.appello06.sol2;

public class Test {
	
	/* Realizzare una classe PwdGUI con costruttore che accetta una java.util.List di Integer (compresi fra 0 e 9), 
	 * tale che quando istanziata crei un JFrame con l'aspetto mostrato nella figura allegata.
	 * I pulsanti servono per inserire una password, che dovrà corrispondere alla lista in ingresso.
	 * Il pulsante check verifica la conformità della password, chiudendo finestra e applicazione se corretta,
	 * o altrimenti offrendo all'utente la possibilità di reintrodurla.
	 * Circa un terzo del valore dell'esercizio verrà attribuito se la parte di "modello" di questa applicazione 
	 * (in un'ottica MVC) viene opportunamente disaccoppiata dal resto (e quindi utilizzata mediante una interfaccia). 
	 * Non sarà invece necessario disaccoppiare le parti di vista e controllo.
	 * Per far partire l'applicazioni si tolga il commento nel main qui sotto.
	 * 
 	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando, effettuate da una stessa directory (ossia senza 
	 * doverla cambiare da un comando all'altro)
*/

	public static void main(String[] args) throws java.io.IOException{
		new PwdGUI(java.util.Arrays.asList(1,3,5,7));
	}
}
