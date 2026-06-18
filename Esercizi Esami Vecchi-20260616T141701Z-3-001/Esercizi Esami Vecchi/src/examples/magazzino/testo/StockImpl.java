package examples.magazzino.testo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StockImpl implements Stock {

	private int balance;
	private final Map<Product, Integer> stock = new HashMap<>();

	@Override
	public void buy(final Product p, final int quantity) {
		Objects.requireNonNull(p);
		if (quantity < 0) {
			throw new IllegalArgumentException();
		}
		stock.compute(p, (k, v) -> v == null ? quantity : (v += quantity));
		balance -= p.price(quantity);
	}

	@Override
	public void sell(final Product p, final int quantity, final int amount) {
		Objects.requireNonNull(p);
		if (quantity < 0 || amount < 0 || !stock.containsKey(p)) {
			throw new IllegalArgumentException();
		}
		if (stock.get(p) < quantity) {
			throw new IllegalStateException();
		}
		stock.put(p, stock.get(p) - quantity);
		balance += amount;
	}

	@Override
	public int getBalance() {
		return this.balance;
	}

	@Override
	public int getProductAmount(final Class<? extends Product> c) {
		Objects.requireNonNull(c);
		return stock.entrySet().stream()
				.filter((e) -> (c.isAssignableFrom(e.getKey().getClass())))
				.mapToInt((e) -> e.getValue()).sum();
	}

	@Override
	public Set<String> getAvailableProducts(final Class<? extends Product> c) {
		Objects.requireNonNull(c);
		return stock.keySet().stream()
				.filter((k) -> c.isAssignableFrom(k.getClass()))
				.map((k) -> k.getDescription()).collect(Collectors.toSet());
	}

}
