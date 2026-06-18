package examples.fib_strategy.testo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LastTwoBasedGenerator implements Generator {

	private final GenerationStrategy strategy;
	private int last1;
	private int last2;
	private int numOut;
	
	public LastTwoBasedGenerator(final int first, final int second, final GenerationStrategy s){
		this.last1 = first;
		this.last2 = second;
		this.strategy = s;
	}
	
	@Override
	public int getNext() {
		if(numOut==0){
			numOut++;
			return last1;
		}else if(numOut==1){
			numOut++;
			return last2;
		}else{
			final int result = strategy.getNextFromThose(last1, last2);
			last1 = last2;
			last2 = result;
			return result;
		}
	}

	@Override
	public void skip(int n) {
		if(n<0){
			throw new IllegalArgumentException();
		}
		
		while(n>0){
			this.getNext();
			n--;
		}
	}

	@Override
	public int[] getNextArray(final int[] array) {
		Objects.requireNonNull(array);
		for(int i=0;i<array.length;i++){
			array[i] = this.getNext();
		}
		return array;
	}

	@Override
	public List<Integer> getNextList(int size) {
		if(size<0){
			throw new IllegalArgumentException();
		}
		final List<Integer> result = new ArrayList<>(size);
		while(size>0){
			result.add(this.getNext());
			size--;
		}
		return result;
	}

}
