package esami2013.appello04.sol2;

public class BasicIngredient extends IngredientDecorator {
	
	private final String name;
	private final int cost;
	
	public BasicIngredient(String name, int cost,Pizza p){
		super(p);
		this.name = name;
		this.cost = cost;
	}
	
	public int getCost(){
		return super.getCost() + this.cost;
	}
	
	public String getIngredients(){
		return super.getIngredients() + ", " + this.name;
	}
	
}
