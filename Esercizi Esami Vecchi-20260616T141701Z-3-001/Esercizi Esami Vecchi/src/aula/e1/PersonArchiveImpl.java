package aula.e1;

import java.util.HashMap;
import java.util.Map;

public class PersonArchiveImpl implements PersonArchive {

	private Integer limit = null;
	private final Map<Integer,String> persons = new HashMap<>();
	
	
	@Override
	public void addPerson(final int code, final String name)
			throws IllegalArgumentException, UnsupportedOperationException {
		
		if(this.hasCode(code) || name == null){
			throw new IllegalArgumentException();
			
		}else if(this.limit != null && this.persons.size() == this.limit){
			throw new UnsupportedOperationException();
			
		}else{
			persons.put(code, name);
		}
	}

	@Override
	public boolean hasCode(final int code) {
		return persons.containsKey(code);
	}

	@Override
	public String getNameByCode(final int code) {
		return persons.get(code);
	}

	@Override
	public String[] getNames() {
		return persons.values().toArray(new String[this.persons.size()]);
	}

	@Override
	public void setLimit(final int n) throws IllegalArgumentException {
		if(n < this.persons.size()){
			throw new IllegalArgumentException();
		}else{
			this.limit = n;
		}
	}

}
