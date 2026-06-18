package esami2013.appello03b.e2;

import java.util.*;

/*
 * Given Two iterables given in input, it allows to iterate over all ordered
 * couples of them, modelling cartesian product.
 * This class should be extended to implement method iterator()
 */

public abstract class CartesianIterable<X,Y> implements Iterable<Pair<X,Y>> {

	protected List<X> it1;
	protected List<Y> it2;
	
	public CartesianIterable(List<X> it1, List<Y> it2) {
		super();
		this.it1 = it1;
		this.it2 = it2;
	}

	abstract public Iterator<Pair<X, Y>> iterator();
}
