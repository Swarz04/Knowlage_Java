package examples.fibio.sol;

import java.util.*;
import java.io.*;

public class FibIOonFile implements FibIO{
	
	private String fileName;
	private List<Integer> list = new ArrayList<>();
	
	public FibIOonFile(String fileName){
		this.fileName = fileName;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadFib() throws IOException {
		FileInputStream stream = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(stream);
		try{
			this.list=(List<Integer>)ois.readObject();
		} catch (ClassNotFoundException e){
		}
		ois.close();
	}

	@Override
	public List<Integer> getFib() {
		return this.list;
	}

	@Override
	public void computeNewNumbers(int howMany) {
		for (int i=0;i<howMany;i++){
			this.computeOne();
		}
	}
	
	private void computeOne(){
		int size = this.list.size();
		if (size<2){
			this.list.add(1);
		} else{
			this.list.add(this.list.get(size-2)+this.list.get(size-1));
		}
	}

	@Override
	public void saveFib() throws IOException {
		FileOutputStream stream = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(stream);
		oos.writeObject(this.list);
		oos.close();
	}
}
