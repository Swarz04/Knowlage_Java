package esami2013.appello03b.sol2;

import java.util.*;

// Versione più efficiente, in quanto non usa la lista di coppie di appoggio

public class EfficientCartesianIterableImpl<X,Y> extends CartesianIterable<X,Y> {

	public EfficientCartesianIterableImpl(List<X> it1, List<Y> it2) {
		super(it1,it2);
	}

	@Override
	public Iterator<Pair<X, Y>> iterator() {
		return new CartesianIterator();
	}
	
	private class CartesianIterator implements Iterator<Pair<X,Y>>{

		private final Iterator<X> i1 = it1.iterator();
		private X lastx = i1.next();
		private Iterator<Y> i2 = it2.iterator();
		
		@Override
		public boolean hasNext() {
			return i1.hasNext() || i2.hasNext();
		}

		@Override
		public Pair<X, Y> next() {
			if (!i2.hasNext()){
				i2 = it2.iterator();
				lastx = i1.next();
			}
			return new Pair<>(lastx,i2.next());
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
	}
}
