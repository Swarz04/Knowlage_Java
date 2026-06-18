package lab.e3sol;

public class ConcatenatingStream extends AbstractIterativeStream<String> {
	
	private String toConcatenate; 
	
	public ConcatenatingStream(String initial, String toConcatenate) {
		super(initial);
		this.toConcatenate = toConcatenate;
	}
		
	protected String iterate(){
		return this.current + this.toConcatenate;
	}
}
