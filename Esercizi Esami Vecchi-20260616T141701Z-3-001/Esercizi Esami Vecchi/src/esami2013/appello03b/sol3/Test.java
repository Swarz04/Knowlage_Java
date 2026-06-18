package esami2013.appello03b.sol3;

public class Test {
	
	/*
	 * Implementare l'interfaccia Occurrences con la classe OccurrencesImpl con costruttore vuoto.
	 * Si suggerisce di leggere il file di testo col decoratore BufferedReader applicato al FileReader.
	 * Si suggerisce di scrivere i dati (interi) col decoratore DataOutputStream applicato al FileOutputStream,
	 * usando un -1 come terminatore. Per identificare la posizione della stringa all'interno della linea
	 * si ricerchi il metodo più opportuno nella classe java.lang.String.
	 * 
	 * >> Si mostri al docente compilazione ed esecuzione da linea di comando, effettuate da una stessa directory (ossia senza 
	 * doverla cambiare da un comando all'altro)
	 * 
	 * Considerando il file "prova.txt" allegato (da visualizzare con Eclipse), l'esecuzione del test qui sotto deve generare il seguente output:
	 */
	/*
Found 3
Row: 0 Pos: 0
Row: 1 Pos: 3
Row: 3 Pos: 11
	 */

	
	

	public static void main(String[] s) throws java.io.IOException{
		Occurrences oc = new OccurrencesImpl();
		long read = oc.readAndStoreOccurrences("src/esami2013/appello03b/sol3/prova.txt", "data.bin", "casa");
		System.out.println("Found "+read);
		oc.printStoredOccurrences("data.bin");
	}	
}