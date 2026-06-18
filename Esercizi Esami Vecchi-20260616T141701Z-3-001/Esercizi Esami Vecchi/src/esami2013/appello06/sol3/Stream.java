package esami2013.appello06.sol3;

/*
 * A stream is a producer of elements of type X.
 * Each invocation of getNextElement produces a new value.
 * When the stream is over, an exception is raised: from then on,
 * the stream can't (and won't) be used, its behaviour is unpredictable
 */

public interface Stream<X> {

	X getNextElement() throws java.util.NoSuchElementException;
}
