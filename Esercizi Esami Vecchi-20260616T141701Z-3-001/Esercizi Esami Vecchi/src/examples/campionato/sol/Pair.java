package examples.campionato.sol;
public class Pair<X,Y>{
    
    public X first;
    public Y second;
    
    public Pair(X first, Y second){
    	this.first = first;
    	this.second = second;
    }
    
    public X getFirst(){
    	return this.first;
    }
    
    public Y getSecond(){
    	return this.second;
    }
    
    public void setFirst(X first) {
		this.first = first;
	}

	public void setSecond(Y second) {
		this.second = second;
	}

	public String toString(){
    	return "<"+this.first+","+this.second+">";
    }
} 
