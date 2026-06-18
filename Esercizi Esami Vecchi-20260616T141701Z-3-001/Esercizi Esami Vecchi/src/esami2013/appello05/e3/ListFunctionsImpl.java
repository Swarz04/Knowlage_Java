package esami2013.appello05.e3;

import java.util.ArrayList;
import java.util.List;

public final class ListFunctionsImpl implements ListFunctions {

	private static final ListFunctionsImpl SINGLETON = new ListFunctionsImpl();
	
	private ListFunctionsImpl(){}
	
	public static ListFunctionsImpl getInstance(){
		return SINGLETON;
	}

	@Override
	public <X> boolean all(final List<X> l, final Function<X, Boolean> f) {
		for(final X x : l){
			if(!f.apply(x)){
				return false;
			}
		}
		return true;
	}

	@Override
	public <X, Y> List<Y> map(final List<X> l,final Function<X, Y> f) {
		final List<Y> result = new ArrayList<>();
		for(final X x : l){
			result.add(f.apply(x));
		}
		return result;
	}

	@Override
	public <X> List<X> reduce(final List<X> l, final Function<X, Boolean> f) {
		final List<X> result = new ArrayList<>();
		for(final X x : l){
			if(f.apply(x)){
				result.add(x);
			}
		}
		return result;
	}
	
}
