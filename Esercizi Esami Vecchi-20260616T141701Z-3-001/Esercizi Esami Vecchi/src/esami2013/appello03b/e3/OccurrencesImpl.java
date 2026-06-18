package esami2013.appello03b.e3;

import java.io.*;

public class OccurrencesImpl implements Occurrences {

	@Override
	public long readAndStoreOccurrences(final String inputTextFile,
			final String outputDataFile, final String occurrence)
			throws IOException {

		final BufferedReader bReader = new BufferedReader(new FileReader(
				inputTextFile));

		final DataOutputStream out = new DataOutputStream(new FileOutputStream(
				outputDataFile));

		String currentLine;
		int rowCounter = 0;
		int found = 0;
		while (true) {
			currentLine = bReader.readLine();
			if (currentLine == null) {
				break;
			}
			final int temp = currentLine.indexOf(occurrence);
			if (temp != -1) {
				out.writeInt(rowCounter);
				out.writeInt(temp);
				found++;
			}

			rowCounter++;
		}
		out.writeInt(-1);
		bReader.close();
		out.close();
		return found;
	}

	@Override
	public void printStoredOccurrences(final String dataFile)
			throws IOException {
		final DataInputStream dataReader = new DataInputStream(
				new FileInputStream(dataFile));

		int row = dataReader.readInt();
		while (row != -1) {
			System.out.println("Row: " + row + " Column: "
					+ dataReader.readInt());
			
			row = dataReader.readInt();
		}
		dataReader.close();
	}

}
