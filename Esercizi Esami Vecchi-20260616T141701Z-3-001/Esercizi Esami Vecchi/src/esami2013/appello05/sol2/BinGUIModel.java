package esami2013.appello05.sol2;

import java.util.*;

public class BinGUIModel implements IBinGUIModel{
	
	private List<Boolean> list = new ArrayList<>();
	
	public BinGUIModel(){}

	@Override
	public void one() {
		list.add(true);
	}

	@Override
	public void zero() {
		list.add(false);
		
	}

	@Override
	public void reset() {
		list.clear();
		
	}

	@Override
	public int compute() {
		int val=0;
		int bit=1;
		for (boolean b: list){
			if (b) {
				val = val + bit;
			}
			bit = bit * 2;
		}
		return val;
	}

	@Override
	public String getString() {
		String s = "";
		if (list.isEmpty()){
			return "-";
		}
		for (boolean b: list){
			s = (b?"1":"0")+s; 
		}
		return s;
	}
	
}
