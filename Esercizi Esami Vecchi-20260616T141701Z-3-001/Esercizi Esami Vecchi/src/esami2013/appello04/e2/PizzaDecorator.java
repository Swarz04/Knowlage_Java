package esami2013.appello04.e2;

public abstract class PizzaDecorator extends Margherita{

	protected final Pizza decorated;
	
	public PizzaDecorator(final Pizza decorated){
		this.decorated = decorated;
	}
	
	@Override
	public int getCost() {
		return this.decorated.getCost();
	}
	
	@Override
	public String getIngredients() {
		return this.decorated.getIngredients();
	}
}
