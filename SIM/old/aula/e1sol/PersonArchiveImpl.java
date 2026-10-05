package aula.e1sol;

import java.util.*;

public class PersonArchiveImpl implements PersonArchive {
	
	private Map<Integer,String> map = new HashMap<>();
	private Integer limit = null;
	
	public PersonArchiveImpl(){	}

	@Override
	public void addPerson(int code, String name)
			throws IllegalArgumentException, UnsupportedOperationException {
		if (hasCode(code) || name == null){
			throw new IllegalArgumentException();
		}
		if (limit != null && limit == this.map.size()){
			throw new UnsupportedOperationException();
		}
		this.map.put(code, name);
	}

	@Override
	public boolean hasCode(int code) {
		return this.map.get(code) != null;
	}

	@Override
	public String getNameByCode(int code) {
		return this.map.get(code);
	}

	@Override
	public String[] getNames() {
		return this.map.values().toArray(new String[map.size()]);
	}

	@Override
	public void setLimit(int n) throws IllegalArgumentException {
		if (n < this.map.size()){
			throw new IllegalArgumentException();
		}
		this.limit = n;
	}
	
}
