package esami2013.appello04.e3;

import java.io.*;

public class PermutationsStoreImpl implements PermutationsStore {

	private final File storeFile;

	public PermutationsStoreImpl(final String fileName) {
		this.storeFile = new File(fileName);
	}

	@Override
	public int storePermutations(final int n) {
		final int[] vett = new int[n];
		for (int i = 0; i < vett.length; i++) {
			vett[i] = i;
		}

		int permCount = 0;

		try {
			final DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(
							this.storeFile)));
			out.writeInt(n);

			do {
				for (int i = 0; i < n; i++) {
					out.writeInt(vett[i]);
				}
				permCount++;
			} while (PermUtilities.nextperm(vett));

			out.close();
		} catch (IOException e) {
			System.err.println(e.toString());
			return -1;
		}
		return permCount;
	}

	@Override
	public int[] getPermutation(final int index) {
		int[] result = null;
		try {
			final RandomAccessFile raf = new RandomAccessFile(this.storeFile,"r");
			
			final int dim = raf.readInt();

			result = new int[dim];

			raf.seek((long) dim * index * Integer.BYTES + raf.getFilePointer());

			try{
				for (int i = 0; i < dim; i++) {
					result[i] = raf.readInt();
				}
			}catch(IOException e){
				raf.close();
				throw new IndexOutOfBoundsException();
			}
			
			raf.close();
		} catch (IOException e) {
			System.err.println(e.toString());
		}
		return result;
	}

}
