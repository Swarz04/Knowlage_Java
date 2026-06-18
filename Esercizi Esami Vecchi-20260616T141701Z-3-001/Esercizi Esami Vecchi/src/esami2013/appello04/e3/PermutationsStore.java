package esami2013.appello04.e3;

/**
 * An interface to generate permutations of a list [0,..,n-1], store them somewhere,
 * and then access the i-th permutation.
 */

public interface PermutationsStore {
	
	/**
	 * Creates and stores all permutations of list [0,..,n-1]
	 * It returns the number of permutations, or -1 if some error occurred 
	 */
	int storePermutations(int n);
	
	/**
	 * When the store is created, it returns the index-th permutation
	 * It returns null if some problem occurred in reading the store 
	 * It may throw an IndexOutOfBoundsException 
	 */
	int[] getPermutation(int index);
}
