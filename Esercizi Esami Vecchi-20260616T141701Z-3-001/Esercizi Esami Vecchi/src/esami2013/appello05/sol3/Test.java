package esami2013.appello05.sol3;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Si consideri l'interfaccia generica Function<X,Y> fornita, che include un metodo
 * apply che modella una funzione da elementi di tipo X a elementi di tipo Y.
 * 
 * Il test di cui sotto assume l'esistenza di una interfaccia ListFunctions, che è
 * fornita in modalità "raw", ossia senza l'uso di generici, con tre metodi denominati 
 * all(l,f), map(l,f) e reduce(l,f). 
 * Il primo verifica se tutti gli elementi della lista l soddisfano il predicato f 
 * (realizzato con una Function che prende un elemento della lista e torna un booleano). 
 * Il secondo prende ogni elemento di l, gli applica la Function f, e usa il risultato 
 * per costruire un elemento della lista in uscita.
 * Il terzo torna una lista costituita dai soli elementi di l che soddisfano un predicato f 
 * (realizzato con una Function che prende un elemento della lista e torna un booleano).
 * 
 * Si costruisca (modificandola) l'interfaccia ListFunctions in modo che sia più riusabile possibile
 * (quindi possibilmente, i suoi metodi siano generici). La si implementi con una classe
 * ListFunctionsImpl che realizza un singleton -- si noti infatti che ogni suo metodo 
 * realizza una funzionalità che non dipende dallo stato dell'oggetto, e quindi questo
 * pattern ben si presta.
 * 
 * Si consideri il test qui sotto (da "scommentare") come riferimento.
 */

public class Test {
	
	@org.junit.Test
	public void test(){
		ListFunctions listFunctions = ListFunctionsImpl.getListFunctions();
		List<Integer> list1 = Arrays.asList(10,20,30,40,50,60,70,80,90,100);
	
		// E' vero che ogni elemento di l1 è maggiore di 5? Si.
		boolean b = listFunctions.all(list1,new Function<Integer,Boolean>(){
			public Boolean apply(Integer i){
				return i>5;
			}
		});
		assertTrue(b);		
		
		// E' vero che ogni elemento di l1 è minore di 100? No.
		boolean b2 =listFunctions.all(list1,new Function<Integer,Boolean>(){
			public Boolean apply(Integer i){
				return i<100;
			}
		}); 
		assertFalse(b2);
		
		// Applicando ad ogni elemento i di l1 la funzione ""+(i+100)
		// si ha in uscita la lista ("110","120","130",...)
		List<String> l2 = listFunctions.map(list1,new Function<Integer,String>(){
	    	 public String apply(Integer i){
	    		 return ""+(i+100);
	    	 }
	    }); 
		assertEquals(l2,Arrays.asList("110","120","130","140","150","160","170","180","190","200"));	

		// Gli elementi di l1 che sono minori di 60 sono (10,20,30,40,50)
		List<Integer> l3 = listFunctions.reduce(list1,new Function<Integer,Boolean>(){
	    	 public Boolean apply(Integer i){
					return i<60;
				}
		}); 
		assertEquals(l3,Arrays.asList(10,20,30,40,50));
	}
}
