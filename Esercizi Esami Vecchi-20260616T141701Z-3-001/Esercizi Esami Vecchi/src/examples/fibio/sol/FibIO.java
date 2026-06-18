package examples.fibio.sol;

/*
 * Gestisce una serie di numeri di Fibonacci, con possibilità
 * di aggiungerne elementi, caricare e salvare.
 * Da dove caricare e salvare dipende dall'implementazione.
 */
public interface FibIO {
	
	// Carica una serie
	void loadFib() throws java.io.IOException;
	
	// Restituisce la serie come lista
	java.util.List<Integer> getFib();
	
	// Aggiunge hoMany numeri alla serie
	void computeNewNumbers(int howMany);
	
	// Salva la serie corrente
	void saveFib() throws java.io.IOException;

}
