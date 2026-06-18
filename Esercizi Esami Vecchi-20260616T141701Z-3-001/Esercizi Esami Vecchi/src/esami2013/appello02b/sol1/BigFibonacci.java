package esami2013.appello02b.sol1;

import java.math.BigInteger;
import java.util.Iterator;

public class BigFibonacci implements Iterator<BigInteger>{

	private BigInteger one = null;
	private BigInteger two = null;
	
	@Override
	public boolean hasNext() {
		return true;
	}
	@Override
	public BigInteger next() {
		if (one == null){
			return one = BigInteger.valueOf(1);
		} else if (two == null){
			return two = BigInteger.valueOf(1);
		} else{
			BigInteger three = one.add(two);
			one = two;
			two = three;
			return two;
		}
	}
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
	
	
	
}
