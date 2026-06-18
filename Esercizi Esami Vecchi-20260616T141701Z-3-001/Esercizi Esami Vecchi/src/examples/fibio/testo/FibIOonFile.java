package examples.fibio.testo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FibIOonFile implements FibIO {

	private final File file;
	private List<Integer> fibList = new ArrayList<>();

	public FibIOonFile(final String fileName) {
		this.file = new File(fileName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadFib() throws IOException {
		final ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.file));
		try {
			this.fibList = (List<Integer>) in.readObject();
		} catch (ClassNotFoundException e) {
			System.err.println(e.toString());
		}
		in.close();
	}

	@Override
	public List<Integer> getFib() {
		return new ArrayList<>(this.fibList);
	}

	@Override
	public void computeNewNumbers(final int howMany) {
		if (howMany < 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < howMany; i++) {
			computeNextFibNumber();
		}
	}

	private void computeNextFibNumber() {
		final int size = this.fibList.size();
		if(size<2){
			this.fibList.add(1);
		}else{
			this.fibList.add(this.fibList.get(size-2)+this.fibList.get(size-1));
		}
	}

	@Override
	public void saveFib() throws IOException {
		final ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(this.file));
		out.writeObject(fibList);
		out.close();
	}

}
