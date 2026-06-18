package esami2013.appello04.sol3;

import java.util.Arrays;

/*
 * A class of utilities to manage permutations, check how it works running the main
 */

public class PermUtilities {

	/*
	 * Swaps elements at index i and j in array a
	 */
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/*
	 * Given an array of integers, it changes it so as to create the next permutation
	 */
	public static boolean nextperm(int[] a) {
		int i, k;
		for (i = a.length - 2; i >= 0 && a[i] > a[i + 1]; i--);
		if (i < 0) {
			return false;
		}
		for (k = a.length - 1; a[i] > a[k]; k--);
		swap(a, i, k);
		k = 0;
		for (int j = i + 1; j < (a.length + i) / 2 + 1; j++) {
			swap(a, j, a.length - k - 1);
			k++;
		}
		return true;
	}
	
	/*
	 * This main generates and prints all permutations of list [0,1,2,3]
	 */
	public static void main(String[] args) {
		int n = 4;
		int[] perm = new int[n];
		for (int i = 0; i < perm.length; i++) {
			perm[i] = i;
		}
		do {
			System.out.println(Arrays.toString(perm));
		} while (nextperm(perm));
	}

}
