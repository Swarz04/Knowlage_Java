package examples.magazzino.sol;

import java.util.*;

public class StockImpl implements Stock {
	
	private Map<Product,Integer> map = new HashMap<>();
	private int balance = 0;
	
	private void checkItem(Product p, int quantity){
		if (p==null){
			throw new NullPointerException("Product is null");
		}
		if (quantity < 0){
			throw new IllegalArgumentException("Quantity can't be negative");
		}
	}
	
	@Override
	public void buy(Product p, int quantity) {
		this.checkItem(p,quantity);
		this.balance -= p.price(quantity);
		int oldQ = this.map.get(p) == null ? 0 : this.map.get(p);
		map.put(p,oldQ + quantity);
		
	}
	
	@Override
	public void sell(Product p, int quantity, int amount) {
		this.checkItem(p,quantity);
		if (amount < 0){
			throw new IllegalArgumentException("Amount can't be negative");
		}
		int oldQ = this.map.get(p) == null ? 0 : this.map.get(p);
		if (oldQ < quantity){
			throw new IllegalStateException("There's not enough items to be sold");
		}
		map.put(p,oldQ - quantity);
		this.balance += amount;
		
	}
	
	@Override
	public int getBalance() {
		return this.balance;
	}
	
	@Override
	public int getProductAmount(Class<? extends Product> c) {
		int amount = 0;
		for (Product p: this.map.keySet()){
			if (c.isAssignableFrom(p.getClass())){
				amount += this.map.get(p);
			}
		}
		return amount;
	}

	@Override
	public Set<String> getAvailableProducts(Class<? extends Product> c) {
		Set<String> set = new HashSet<>();
		for (Product p: this.map.keySet()){
			if (c.isAssignableFrom(p.getClass())){
				set.add(p.getDescription());
			}
		}
		return set;
	}

}
