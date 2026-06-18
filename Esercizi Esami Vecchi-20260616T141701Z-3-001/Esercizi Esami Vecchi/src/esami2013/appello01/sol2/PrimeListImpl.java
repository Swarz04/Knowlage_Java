package esami2013.appello01.sol2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeListImpl implements PrimeList{
	private List<Integer> list = new ArrayList<>();
	
	public PrimeListImpl(){
		this.list.add(2);
	}
	
	private int getLast(){
		return this.list.get(this.list.size()-1);
	}
	
	private boolean isPrime(int n){
		for (int i=2;i<=n/2;i++){
			if (n%i == 0){
				return false;
			}
		}
		return true;
	}
	
	private int nextPrime(int current){
		current++;
		while (!isPrime(current)){
			current++;
		}
		return current;
	}
	
	public int next(){
		int n = nextPrime(getLast());
		this.list.add(n);
		return n;
	}
	
	public Iterator<Integer> iterator(){
		return this.list.iterator();
	}
	
}
