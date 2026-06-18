package esami2013.appello06.e3;

import java.util.NoSuchElementException;

public class OpStreamImpl<X> implements OpStream<X> {

	private final Stream<X> decorated;

	public OpStreamImpl(final Stream<X> s) {
		this.decorated = s;
	}

	@Override
	public X getNextElement() throws NoSuchElementException {
		return this.decorated.getNextElement();
	}

	@Override
	public Stream<X> reduce(final Function<X, Boolean> reducefun) {
		return new Stream<X>() {

			@Override
			public X getNextElement() throws NoSuchElementException {
				final X x = decorated.getNextElement();
				return reducefun.apply(x) ? x : this.getNextElement();
			}

		};
	}

	@Override
	public Stream<X> until(final Function<X, Boolean> reducefun) {
		return new Stream<X>(){

			@Override
			public X getNextElement() throws NoSuchElementException {
				final X x = decorated.getNextElement();
				if(reducefun.apply(x)){
					return x;
				}else{
					throw new NoSuchElementException("Out Of Range");
				}
			}
			
		};
	}
}
