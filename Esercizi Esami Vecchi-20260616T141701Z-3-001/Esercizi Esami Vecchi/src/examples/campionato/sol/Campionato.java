package examples.campionato.sol;

import java.util.*;

public interface Campionato {
	
	/*
	 * Aggiunge una squadra al campionato:
	 * - shortName deve essere una stringa di 3 caratteri, pena lancio IllegalArgumentException
	 * - se il campionato è già iniziato lancia la UnsupportedOperationException
	 */
	void addSquadra(String shortName, String longName) throws IllegalArgumentException, UnsupportedOperationException;

	/* 
	 * Fa iniziare il campionato, da questo momento non si aggiungono più squadre, ma si aggiungono risultati
	 */
	void iniziaCampionato();

	/*
	 * Aggiunge un nuovo risultato:
	 * - i nomi delle squadre sono i loro shortname, se non trovati si lancia IllegalArgumentException
	 * - il risultato è "1", "X", o "2", con corrispondente attribuzione di 3 punti a squadra1, 1 punto a entrambe, o 3 punti a squadra2
	 * - se il campionato non è già iniziato lancia la UnsupportedOperationException
	 */
	void addRisultato(String squadra1, String squadra2, String risultato) throws IllegalArgumentException, UnsupportedOperationException;
	
	/*
	 * Torna la classifica, come lista di coppie squadra (nome lungo) e punteggio.
	 * E' ordinata in senso decrescente sul punteggio
	 */
	List<Pair<String,Integer>> getClassifica();

}
