package esami2013.appello05.e3;

import java.util.*;

/* 
 * Rendere questi metodi generici!
 * Esempio:
 * 
 * <X> void print(List<X> l);
 */

public interface ListFunctions {
	
	<X> boolean all(List<X> l, Function<X, Boolean> f); 
	<X,Y> List<Y> map(List<X> l,Function<X,Y> f);
	<X> List<X> reduce(List<X> l,Function<X, Boolean> f);

}
