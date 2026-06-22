package a06.e1;

import java.util.List;
import java.util.stream.Stream;

public class CirclerFactoryImpl implements CirclerFactory{

	@Override
	public <T> Circler<T> leftToRight() {
		return new Circler<>(){
			private List<T> elements;
        	private int counter = 0;

			@Override
			public void setSource(List<T> elements) {
				this.elements = elements;
                this.counter = 0;
			}

			@Override
            public T produceOne() {
				T t = this.elements.get(counter % this.elements.size());
				//TRICK
				//counter % this.elements.size() serve per evitare l'eccezione di ArrayIndexOutOfBoundsException,
				// in quanto il counter può crescere indefinitamente, mentre la size della lista è limitata
				this.counter++;
				return t;
			}

			@Override
			public List<T> produceMany(int n) {
				 return Stream.generate(() ->  produceOne()).limit(n).toList();
			}

		};

    }

	@Override
	public <T> Circler<T> alternate() {
		throw new UnsupportedOperationException();
	};

	/**
	 * @param <T>
	 * @return a new circler that iterates the source from left to right, and then stays
	 * on last element, hence yielding:
	 * E1,E2,...,En,En,En,En,En,En,...
	 */
	public <T> Circler<T> stayToLast() {
		throw new UnsupportedOperationException();
	};

	/**
	 * @param <T>
	 * @return a new circler that behaves like the one created by leftToRight(), but skipping
	 * one element each time, that is, if the one created by leftToRight() would give
	 * A1,A2,A3,A4,A5,...., this one gives: A1,A3,A5,A7,...
	 */
	public <T> Circler<T> leftToRightSkipOne() {
		throw new UnsupportedOperationException();
	};

	/**
	 * @param <T>
	 * @return a new circler that behaves like the one created by alternate(), but skipping
	 * one element each time, that is, if the one created by alternate() would give
	 * A1,A2,A3,A4,A5,...., this one gives: A1,A3,A5,A7,...
	 * THIS IS OPTIONAL IN THIS EXAM!
	 */
	public <T> Circler<T> alternateSkipOne() {
		throw new UnsupportedOperationException();
	};

	/**
	 * @param <T>
	 * @return a new circler that behaves like the on create by stayToLast(), but skipping
	 * one element each time, that is, if the one created by stayToLast() would give
	 * A1,A2,A3,A4,A5,...., this one gives: A1,A3,A5,A7,...
	 * THIS IS OPTIONAL IN THIS EXAM!
	 */
	public <T> Circler<T> stayToLastSkipOne() {
		throw new UnsupportedOperationException();
	};
}
