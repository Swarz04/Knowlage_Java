package examples.magazzino.sol;

public abstract class Beverage implements Product {
	
	protected String name;
	
	@Override
	public String getDescription() {
		return this.getClass().getSimpleName()+": "+this.name;
	}
	
	protected Beverage(String name){
		this.name = name;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beverage other = (Beverage) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public static class Beer extends Beverage {
		
		public Beer(String name) {
			super(name);
		}

		@Override
		public int price(int quantity) {
			return quantity >= 10 ? 2*quantity : 3*quantity;
		}
	}
	
	public static class Water extends Beverage {

		public Water(String name) {
			super(name);
		}
		
		@Override
		public int price(int quantity) {
			return quantity;
		}
	}
	
	public static class Coke extends Beverage {

		public Coke(String name) {
			super(name);
		}
		
		@Override
		public int price(int quantity) {
			return quantity*2;
		}
	}
}
