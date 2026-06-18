package esami2013.appello04.e2;

public class Salsiccia extends PizzaIngredient implements Pizza {

	public Salsiccia(Pizza decorated) {
		super(decorated);
	}

	@Override
	protected int getSupplementCost() {
		return 150;
	}

	@Override
	protected String getSupplementName() {
		return "Salsiccia";
	}
	
}
