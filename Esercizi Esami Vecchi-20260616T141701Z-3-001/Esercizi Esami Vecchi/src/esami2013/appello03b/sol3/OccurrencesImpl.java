package esami2013.appello03b.sol3;

import java.io.*;

public class OccurrencesImpl implements Occurrences{

	@Override
	public long readAndStoreOccurrences(String inputTextFile,
			String outputDataFile, String occurrence) throws IOException {
		
		int l = 0;
		BufferedReader br = new BufferedReader(new FileReader(inputTextFile));
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputDataFile));
		String s = null;
		for (int row = 0; (s=br.readLine())!=null; row++){
			int pos = s.indexOf(occurrence);
			if (pos!=-1){
				l++;
				dos.writeInt(row);
				dos.writeInt(pos);
			}
		}
		dos.writeInt(-1);
		dos.close();
		br.close();
		return l;
	}

	@Override
	public void printStoredOccurrences(String dataFile) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(dataFile));
		int row = dis.readInt();
		while (row != -1){
			System.out.println("Row: "+row+ " Pos: "+dis.readInt());
			row = dis.readInt();
		}
		dis.close();
	}
	
}
