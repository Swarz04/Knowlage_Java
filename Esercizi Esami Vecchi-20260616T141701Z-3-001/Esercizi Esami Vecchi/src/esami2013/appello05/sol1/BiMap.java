package esami2013.appello05.sol1;

import java.util.*;

/*
 * A bijective map from elements of type X to elements of type Y.
 * Namely, one element of type X can be associated to just one element of type Y
 * and viceversa. 
 */

public interface BiMap<X,Y> {
	
	/*
	 * adds an association between x and y
	 * x and y should not be null and not be already associated to other elements 
	 */
	void put(X x,Y y);
	
	/*
	 * returns the element associated to y, or null if there is no such 
	 */
	X getX(Y y);
	
	/*
	 * returns the element associated to x, or null if there is no such
	 */
	Y getY(X x);

	/*
	 * returns true if there is an association between x and y
	 */
	boolean hasXY(X x, Y y);
	
	/*
	 * removes the association between x and y
	 * x and y should be already associated
	 */
	void remove(X x, Y y);
	
	/*
	 * returns how many associations are currently present
	 */
	int size();
	
	/*
	 * returns all elements x
	 */
	Set<X> allX();
	
	/*
	 * returns all elements y
	 */
	Set<Y> allY();
}
