package examples.fib_strategy.sol;

public class Sum implements BinFunction<Integer>{

	@Override
	public Integer apply(Integer x, Integer y) {
		return x+y;
	}
	

}
