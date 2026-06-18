package esami2013.appello03.e2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairIterableImpl<X> extends PairIterable<X> {

	public PairIterableImpl(Iterable<X> it) {
		super(it);
	}

	@Override
	public Iterator<Pair<X, X>> iterator() {
		final Iterator<X> baseIterator = this.it.iterator();
		return new Iterator<Pair<X, X>>() {

			private X first;
			private X second;
			private boolean hasNextCalled;
			private boolean lastAnswer;

			@Override
			public boolean hasNext() {
				if (!hasNextCalled) {
					hasNextCalled = true;
					if (baseIterator.hasNext()) {
						second = baseIterator.next();
						lastAnswer = baseIterator.hasNext();
					} else {
						lastAnswer = false;
					}
				}
				return lastAnswer;
			}

			@Override
			public Pair<X, X> next() {
				if (this.hasNext()) {
					first = second;
					second = baseIterator.next();
					hasNextCalled = false;
					return new Pair<>(first, second);
				}else{
					throw new NoSuchElementException();
				}
			}

		};
	}

}
