package esami2013.appello01bis.sol1;

import java.util.*;

/*
 * It models a multiset of elements of type X, namely, a set with possibly more occurrences of the same element.
 */
public interface Multiset<X>{

	// adds element x
	void add(X x);
	
	// removes element x
	// throws IllegalArgumentException if no such element is present
	void remove(X x);
	
	// returns how many copies of x exist in the multiset
	// it returns 0 if there is no such element
	int countElements(X x);
	
	// how many elements are present in the multiset
	int size();
	
	// returns the set of elements, that is, without showing duplicates
	Set<X> set();
	
	// does this multiset contain all the elements of m?
	boolean contains(Multiset<X> m);
}
