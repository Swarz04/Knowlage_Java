package esami2013.appello06.e3;

/**
 * This interface extends Stream<X> with two functions used to create new streams out of this.
 * This interface is meant to be implemented by the Decorator pattern, namely, as a wrapper for another stream,
 * passed in the constructor.
 */

public interface OpStream<X> extends Stream<X>{

	X getNextElement() throws java.util.NoSuchElementException;
	
	/**
	 * Returns a new stream over the same elements of this, but producing only those elements 
	 * which applied to reducefun give true
	 */
	
	Stream<X> reduce(final Function<X,Boolean> reducefun);
	
	/**
	 * Returns a new stream over the same elements of this, producing all the elements 
	 * until there's one which applied to reducefun gives false
	 */
	
	Stream<X> until(final Function<X,Boolean> reducefun);
	
}
