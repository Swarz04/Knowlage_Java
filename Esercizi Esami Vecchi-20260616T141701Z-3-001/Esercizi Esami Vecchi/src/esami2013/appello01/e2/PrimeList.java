package esami2013.appello01.e2;

/*
 * Starting from 2 (excluded), it computes prime numbers
 * It extends Iterable<Integer>, so it is also able to iterate over all prime numbers computed so far
 */

public interface PrimeList extends Iterable<Integer>{
	
	// computes and returns the next prime number
	int next();
	
	// iterate over all prime numbers computed so far
	java.util.Iterator<Integer> iterator();
	
}