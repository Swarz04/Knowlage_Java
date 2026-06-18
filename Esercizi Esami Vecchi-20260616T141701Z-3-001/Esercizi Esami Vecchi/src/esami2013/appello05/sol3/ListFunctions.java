package esami2013.appello05.sol3;

import java.util.*;

/* Nota: le signature di queste funzioni contengono wildcard per ottenere
 * massima riusabilità, ma ciò non era necessario ai fini del conseguimento
 * del massimo punteggio per questo esercizio.
 */

public interface ListFunctions {
	
	/*
	
	boolean all(List l, Function f); 
	List map(List l,Function f);
	List reduce(List l,Function f);
	  
	*/
	
	<X> boolean all(List<? extends X> l, Function<? super X,Boolean> f);
	
	<X,Y> List<Y> map(List<? extends X> l, Function<? super X,? extends Y> f);
	
	<X> List<X> reduce(List<? extends X> l, Function<? super X,Boolean> f);

}
