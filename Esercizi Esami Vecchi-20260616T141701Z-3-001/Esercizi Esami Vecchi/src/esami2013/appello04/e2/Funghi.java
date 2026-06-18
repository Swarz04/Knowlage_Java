package esami2013.appello04.e2;

public class Funghi extends PizzaIngredient {
	
	public Funghi(Pizza decorated) {
		super(decorated);
	}

	@Override
	protected int getSupplementCost() {
		return 100;
	}

	@Override
	protected String getSupplementName() {
		return "Funghi";
	}
	
}
