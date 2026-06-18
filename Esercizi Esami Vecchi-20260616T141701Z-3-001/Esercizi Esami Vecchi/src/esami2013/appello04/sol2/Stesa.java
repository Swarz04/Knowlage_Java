package esami2013.appello04.sol2;

public class Stesa extends IngredientDecorator {
	
	public Stesa(Pizza p){
		super(p);
	}
	
	public int getCost(){
		return (int)(super.getCost() * 1.1);
	}
	
	public String getIngredients(){
		return "[STESA] "+super.getIngredients();
	}
	
}
