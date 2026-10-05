package aula.e1;

import java.util.HashMap;
import java.util.Map;

public class PersonArchiveImpl implements PersonArchive {

	private Integer limit = null;
	private final Map<Integer,String> persons = new HashMap<>();


	@Override
	public void addPerson(final int code, final String name)
		throws java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException {
			if(hasCode(code) || name == null) {
				throw new IllegalArgumentException();
			}
			if(limit != null && limit == this.persons.size()) {
				throw new java.lang.UnsupportedOperationException();
			}
			this.persons.put(code, name);
	}

	@Override
	public boolean hasCode( int code) {
		return this.persons.get(code) != null;
	}

	@Override
	public String getNameByCode(final int code) {
		return this.persons.get(code);
	}

	@Override
	public String[] getNames() {
		return this.persons.values().toArray(new String[persons.size()]);
	}

	@Override
	public void setLimit(final int n) throws IllegalArgumentException {
		if (n < persons.size() || n < 0) {
			throw new java.lang.IllegalArgumentException();
		}
		this.limit = n;
	}
}
