package esami2013.appello06.e2;

import java.util.List;

public interface PasswordCheck<X> {
	
	void scrivi(X x);
	boolean check(List<X> list);
	void clear();
	
}
