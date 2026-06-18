package esami2013.appello01.e1.sol1;

import java.util.*;

/*
 * It models a binary relation (possibly non symmetrical), with elements of type X and of type Y
 * Operations taking a non-null element raise a NullPointerException if a null is passed
 */
public interface Relation<X,Y>{

	// sets a relation between x and y (both non-null)
	// it has no effect if x and y are already in relation
	void set(X x, Y y);

	// unsets relation between x and y (both non-null)
	// it has no effect if x and y are not in relation
	void unset(X x, Y y);

	// checks if x and y (both non-null) are in relation
	boolean holds(X x, Y y);

	// returns how many pairs x,y are in relation
	int size();

	// Given x, it returns the set of elements in Y which are in relation with x
	// Returns the empty set if there is no element in relation with x
	Set<Y> relatedTo(X x);
}
