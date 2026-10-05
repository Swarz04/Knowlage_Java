package aula.e1sol;

/* 
 * Rappresenta un archivio di persone, con metodi per aggiungere una nuova persona (codice + nome),
 * verificare se un codice è giù usato, ottenere il nome relativo ad un certo codice, ottenere
 * l'array di nomi, e impostare un valore massimo al numero di persone. 
 */

public interface PersonArchive {
	
	/**
	 * Aggiunge una persona
	 * 
	 * @param code, il codice della persona 
	 * @param name, il nome della persona
	 * @throws java.lang.IllegalArgumentException, se il codice è già presente, o il nome è null
	 * @throws java.lang.UnsupportedOperationException, se non è ossibile aggiungere un nuovo nome per effetto del metodo setLimit
	 */
	
	void addPerson(int code,String name) throws java.lang.IllegalArgumentException, 
												java.lang.UnsupportedOperationException;
	/**
	 * @param code, il codice da cercare
	 * @return se già registrato
	 */
	boolean hasCode(int code);
	
	/**
	 * @param code, il codice da cercare
	 * @return, il nome trovato, o null se non trovato
	 */
	String getNameByCode(int code);
	
	/**
	 * @return un array di nomi corrispondenti alle persone inserite: l'ordine non è rilevante
	 */
	String[] getNames();
	
	/**
	 * Imposta un limite massimo al numero di persone. Funziona solo se il numero corrente di persone non è già maggiore.
	 * 
	 * @param n, il numero max di persone
	 * @throws java.lang.IllegalArgumentException se n è negativo, o se n è minore del numero attuale di persone.
	 */
	void setLimit(int n) throws java.lang.IllegalArgumentException;
}
