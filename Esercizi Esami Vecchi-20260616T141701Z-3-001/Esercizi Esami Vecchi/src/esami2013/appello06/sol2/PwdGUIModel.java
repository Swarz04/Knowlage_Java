package esami2013.appello06.sol2;

import java.util.*;

public class PwdGUIModel implements IPwdGUIModel{
	
	private List<Integer> pwd = null;
	private List<Integer> current = new ArrayList<>();
	
	public PwdGUIModel(){}

	@Override
	public void setPWD(List<Integer> pwd) {
		this.pwd = new ArrayList<>(pwd); // defensive copy
	}

	@Override
	public void press(int val) {
		current.add(val);
		
	}

	@Override
	public void reset() {
		current.clear();
	}

	@Override
	public boolean check() {
		return current.equals(pwd);
	}
	
}
