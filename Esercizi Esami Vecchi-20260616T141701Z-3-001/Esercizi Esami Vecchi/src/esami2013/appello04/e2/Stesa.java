package esami2013.appello04.e2;

public class Stesa extends PizzaDecorator {

	public Stesa(Pizza decorated) {
		super(decorated);
	}

	@Override
	public int getCost(){
		return (int)(this.decorated.getCost()*1.1);
	}
	
	@Override
	public String getIngredients() {
		return "[STESA] "+this.decorated.getIngredients();
	}
}
