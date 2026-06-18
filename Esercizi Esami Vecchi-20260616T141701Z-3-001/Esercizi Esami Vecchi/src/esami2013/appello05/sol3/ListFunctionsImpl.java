package esami2013.appello05.sol3;

import java.util.*;

public class ListFunctionsImpl implements ListFunctions {
	
	static private ListFunctions one = new ListFunctionsImpl();
	
	private ListFunctionsImpl(){}
	
	static public ListFunctions getListFunctions(){
		return one;
	}

	@Override
	public <X> boolean all(List<? extends X> l, Function<? super X, Boolean> f) {
		for (X x:l){
			if (!f.apply(x)){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public <X, Y> List<Y> map(List<? extends X> l, Function<? super X, ? extends Y> f) {
		ArrayList<Y> lout = new ArrayList<>();
		for (X x:l){
			lout.add(f.apply(x));
		}		
		return lout;
	}

	@Override
	public <X> List<X> reduce(List<? extends X> l, Function<? super X, Boolean> f) {
		ArrayList<X> lout = new ArrayList<>();
		for (X x:l){
			if (f.apply(x)){
				lout.add(x);
			}
		}		
		return lout;
	}
	

}
