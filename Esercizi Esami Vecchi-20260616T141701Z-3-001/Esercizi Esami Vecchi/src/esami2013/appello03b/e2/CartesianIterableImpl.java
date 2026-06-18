package esami2013.appello03b.e2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class CartesianIterableImpl<X, Y> extends CartesianIterable<X, Y> {

	public CartesianIterableImpl(final List<X> it1, final List<Y> it2) {
		super(it1, it2);
	}

	@Override
	public Iterator<Pair<X, Y>> iterator() {
		return new Iterator<Pair<X, Y>>() {

			final Iterator<X> itX = it1.iterator();
			Iterator<Y> itY = it2.iterator();
			Optional<X> currentXValue = itX.hasNext() ? Optional.of(itX.next())
					: Optional.empty();

			@Override
			public boolean hasNext() {
				return itY.hasNext() || itX.hasNext();
			}

			@Override
			public Pair<X, Y> next() {
				if (this.hasNext()) {
					if (!itY.hasNext()) {
						itY = it2.iterator();
						currentXValue = Optional.of(itX.next());
					}
					return new Pair<X, Y>(currentXValue.get(), itY.next());
				} else {
					throw new NoSuchElementException();
				}
			}

		};
	}

}
