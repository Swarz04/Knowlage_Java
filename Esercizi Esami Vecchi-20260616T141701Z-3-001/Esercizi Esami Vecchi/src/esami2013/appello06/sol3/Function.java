package esami2013.appello06.sol3;

/*
 * A simple interface to model a function from domain I to range O
 */

public interface Function<I,O> {
	O apply(I i);
}
