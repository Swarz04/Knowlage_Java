package esami2013.appello06.sol2;

import java.util.List;

public interface IPwdGUIModel {
	
	void setPWD(List<Integer> pwd);
	
	void press(int val);
	
	void reset();
	
	boolean check();
	
}
