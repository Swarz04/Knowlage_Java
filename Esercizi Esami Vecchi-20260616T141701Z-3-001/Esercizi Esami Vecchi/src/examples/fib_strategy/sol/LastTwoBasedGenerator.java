package examples.fib_strategy.sol;

import java.util.*;

public class LastTwoBasedGenerator implements Generator{
	
	private int last;
	private int prev;
	private int index;
	private BinFunction<Integer> bfun;
	
	public LastTwoBasedGenerator(int n1, int n2, BinFunction<Integer> bfun){
		this.index = 0;
		this.last = n2;
		this.prev = n1;
		this.bfun = bfun;
	}
	
	protected int getLast(){
		return this.last;
	}
	
	protected int getPrev(){
		return this.prev;
	}
	
	public int getNext(){
		if (this.index == 0){
			this.index++;
			return prev;
		} else if (this.index == 1){
			this.index++;
			return last;
		} 
		int out = this.bfun.apply(this.last, this.prev);
		prev = last;
		last = out;
		return last;
	}
	
	public void skip(int n){
		for (int i=0; i< n; i++){
			getNext();
		}	
	}
	
	public int[] getNextArray(int[] array){
		for (int i=0; i< array.length; i++){
			array[i] = this.getNext();
		}
		return array;
	}
	
	public List<Integer> getNextList(int size){
		List<Integer> list = new ArrayList<>(size);
		for (int i=0; i< size; i++){
			list.add(this.getNext());
		}
		return list;
	}

}
