package examples.magazzino.testo;

public interface Stock {

	/** Compra il prodotto p, pagandolo quanto indicato in Product.price
	   throws IllegalArgumentException se quantity è negativa
	   throws NullPointerException se p è null*/
	void buy(Product p, int quantity);
	
	/** Vende il prodotto p alla cifra amount
	 throws IllegalArgumentException se quantity o amount sono negative
	 throws IllegalStateException se la quantità da vendere non è disponibile
	 throws NullPointerException se p è null*/
	void sell(Product p, int quantity, int amount);
	
	/** Torna il saldo del magazzino, possibilmente negativo*/
	int getBalance();
	
	/** Torna il quantitativo di prodotti del tipo c (o anche sottotipi)
	 .. si usi il metodo Class.isAssignableFrom..*/
	int getProductAmount(Class<? extends Product> c);
	
	/** Torna una lista di descrizioni di prodotti disponibili*/ 
	java.util.Set<String> getAvailableProducts(Class<? extends Product> c);

}
