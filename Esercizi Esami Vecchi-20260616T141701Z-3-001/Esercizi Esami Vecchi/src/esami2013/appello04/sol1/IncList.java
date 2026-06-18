package esami2013.appello04.sol1;

import java.util.*;

/*
 * A list of elements of type X, each of which is given an incremental numerical index value (0,1,2,3,..)
 * This list is initially empty, and later can contain many copies of the same element
 * The parameter X is such that you can freely use any java.util.Collection<X> 
 */

public interface IncList<X> {
	
	/*
	 * adds a non-null element to the list
	 * assigns to it a index, which is the next incrementally available one (0 initially)
	 */
	int addNew(X x);
	
	/*
	 * returns the element at index, or null if it does not exist
	 * when one element is removed, its index will NOT be used for elements later added
	 * THIS METHOD IS TO BE EXECUTED IN THE FASTEST WAY POSSIBLE! 
	 */
	X getElement(int index);
	
	/*
	 * returns the index of one occurrence of X, or -1 if none is there
	 */
	int getPosition(X x);
	
	/*
	 * removes the element at index
	 * throws IllegalArgumentException if no such element exists
	 */
	void remove(int index);
	
	/*
	 * returns how many elements are currently in the list
	 */
	int size();
	
	/*
	 * returns an iterator over all indexes of elements x
	 */
	Iterator<Integer> allOccurrences(X x);
}
