package esami2013.appello03b.sol3;

public interface Occurrences {

	/*
	 * Reads a text file, and checks which lines of it have the string 'occurrences' in it.
	 * For each of them adds to the output binary file, two int: line count, and position (row) of the string. 
	 */
	long readAndStoreOccurrences(String inputTextFile, String outputDataFile, String occurrence) throws java.io.IOException;
	
	/*
	 * Reads back those pairs of int and write them on the console. 
	 */
	void printStoredOccurrences(String dataFile) throws java.io.IOException;
}
