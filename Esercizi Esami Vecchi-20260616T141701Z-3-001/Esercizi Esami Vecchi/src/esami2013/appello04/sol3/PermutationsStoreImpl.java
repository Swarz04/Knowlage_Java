package esami2013.appello04.sol3;

import java.io.*;

public class PermutationsStoreImpl implements PermutationsStore {

	private final File file;

	public PermutationsStoreImpl(String fileName) {
		this.file = new File(fileName);
	}

	public int storePermutations(int n) {
		int count = 0;
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					this.file));
			int[] perm = new int[n];
			for (int i = 0; i < perm.length; i++) {
				perm[i] = i;
			}
			dos.writeInt(n);
			do {
				for (int elem : perm) {
					dos.writeInt(elem);
				}
				count++;
			} while (PermUtilities.nextperm(perm));
			dos.close();
		} catch (IOException e) {
			return -1;
		}
		return count;
	}

	public int[] getPermutation(int index){
		int[] out = null;
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(this.file));
			int n = dis.readInt();
			out = new int[n];
			try {
				for (int i = 0; i < index * n; i++) {
					dis.readInt();
				}
				for (int i = 0; i < n; i++) {
					out[i] = dis.readInt();
				}
			} catch (EOFException e) {
				throw new IndexOutOfBoundsException();
			}
			dis.close();
		} catch (IOException e) {
			return null;
		}
		return out;
	}
}
