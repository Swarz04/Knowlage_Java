package esami2013.appello03.sol2;

import java.util.Iterator;

/*
 * Given Two iterables given in input, it allows to iterate over all ordered
 * pairs of them, modelling cartesian product.
 * This class should be extended to implement the correct generation of a
 * java.util.Iterator.
 */

public abstract class PairIterable<X> implements Iterable<Pair<X,X>> {

	protected Iterable<X> it;
	
	public PairIterable(Iterable<X> it) {
		super();
		this.it = it;
	}

	abstract public Iterator<Pair<X, X>> iterator();
}
