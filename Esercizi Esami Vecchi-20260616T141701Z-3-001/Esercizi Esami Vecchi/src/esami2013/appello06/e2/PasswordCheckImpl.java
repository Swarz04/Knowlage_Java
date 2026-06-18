package esami2013.appello06.e2;

import java.util.ArrayList;
import java.util.List;

public class PasswordCheckImpl<X> implements PasswordCheck<X> {

	private final List<X> list = new ArrayList<>();
	
	@Override
	public void scrivi(final X x) {
		list.add(x);
	}

	@Override
	public boolean check(final List<X> list) {
		return this.list.equals(list);
	}

	@Override
	public void clear() {
		this.list.clear();
	}

}
