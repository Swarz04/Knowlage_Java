package esami2013.appello03.sol2;

import java.util.Iterator;

public class PairIterableImpl<X> extends PairIterable<X> {

	public PairIterableImpl(Iterable<X> it) {
		super(it);
	}

	@Override
	public Iterator<Pair<X, X>> iterator() {
		return new PairIterator();
	}
	
	private class PairIterator implements Iterator<Pair<X,X>>{

		private final Iterator<X> i = it.iterator();
		private X last;
		
		public PairIterator(){
			if (i.hasNext()){
				this.last = i.next();
			}
		}
		
		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public Pair<X, X> next() {
			Pair<X,X> p = new Pair<>(last,i.next());
			last = i.hasNext() ? i.next() : null;
			return p;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
	}
}
