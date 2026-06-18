package esami2013.appello06.sol3;

import java.util.NoSuchElementException;

public class OpStreamImpl<X> implements OpStream<X>{
	
	private Stream<X> stream;
	
	public OpStreamImpl(Stream<X> stream) {
		super();
		this.stream = stream;
	}

	@Override
	public X getNextElement() throws java.util.NoSuchElementException{
		return stream.getNextElement();
	}

	@Override
	public Stream<X> reduce(final Function<X, Boolean> reducefun) {
		return new Stream<X>(){

			public X getNextElement() throws NoSuchElementException {
				X x = stream.getNextElement();
				return reducefun.apply(x) ? x : this.getNextElement();
			}
		};
	}

	@Override
	public Stream<X> until(final Function<X, Boolean> reducefun) {
		return new Stream<X>(){

			public X getNextElement() throws NoSuchElementException {
				X x = stream.getNextElement();
				if (!reducefun.apply(x)){
					throw new NoSuchElementException("out of range");
				}
				return x;
			}
		};
	}
	
	
	
}
