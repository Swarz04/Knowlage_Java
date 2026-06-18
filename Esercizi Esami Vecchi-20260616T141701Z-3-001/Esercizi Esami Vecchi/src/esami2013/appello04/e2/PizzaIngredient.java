package esami2013.appello04.e2;

public abstract class PizzaIngredient extends PizzaDecorator {

	public PizzaIngredient(final Pizza decorated) {
		super(decorated);
	}

	@Override
	public int getCost() {
		return this.decorated.getCost()+this.getSupplementCost();
	}
	
	@Override
	public String getIngredients() {
		return this.decorated.getIngredients()+", "+this.getSupplementName();
	}
	
	protected abstract int getSupplementCost();

	protected abstract String getSupplementName();
	
}
