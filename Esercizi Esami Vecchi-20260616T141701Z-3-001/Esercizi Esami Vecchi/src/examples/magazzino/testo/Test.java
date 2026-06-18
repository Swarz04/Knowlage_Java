package examples.magazzino.testo;

import static org.junit.Assert.*;

/*
 * Si consideri l'interfaccia Product, che modella un prodotto di magazzino.
 * Si considerino le corrispondeti implementazioni Beverage.Beer, Beverage.Coke, e Beverage.Water.
 * Si realizzi la classe StockImpl con costruttore di default che implementa l'interfaccia
 * Stock fornita e che modella un Magazzino, con operazioni per comprare e vendere prodotti,
 * e per verificare quanti prodotti di un certo tipo (o sopratipo) esistono.
 * Il tutto passi il test qui sotto (da "scommentare").
 */

public class Test {
	
	@org.junit.Test
	public void test1() throws Exception {
		
		Stock stock = new StockImpl();
		assertEquals(stock.getProductAmount(Beverage.class),0);
		assertEquals(stock.getProductAmount(Product.class),0);
		assertEquals(stock.getBalance(),0);
		
		stock.buy(new Beverage.Beer("Corona"),100);
		assertEquals(stock.getProductAmount(Beverage.Beer.class),100);
		assertEquals(stock.getProductAmount(Beverage.Coke.class),0);
		assertEquals(stock.getProductAmount(Beverage.class),100);
		assertEquals(stock.getBalance(),-200);
		
		stock.buy(new Beverage.Coke("Pepsi"),20);
		assertEquals(stock.getProductAmount(Beverage.Beer.class),100);
		assertEquals(stock.getProductAmount(Beverage.Coke.class),20);
		assertEquals(stock.getProductAmount(Beverage.class),120);
		assertEquals(stock.getProductAmount(Product.class),120);
		assertEquals(stock.getBalance(),-240);
		
		stock.sell(new Beverage.Beer("Corona"),50, 300);
		assertEquals(stock.getProductAmount(Beverage.Beer.class),50);
		assertEquals(stock.getProductAmount(Beverage.Coke.class),20);
		assertEquals(stock.getProductAmount(Beverage.class),70);
		assertEquals(stock.getProductAmount(Product.class),70);
		assertEquals(stock.getBalance(),60);
		
		java.util.Set<String> set = stock.getAvailableProducts(Product.class);
		System.out.println(set);
		assertTrue(set.contains("Coke: Pepsi"));
		assertTrue(set.contains("Beer: Corona"));
		assertEquals(set.size(),2);
		
		java.util.Set<String> set2 = stock.getAvailableProducts(Beverage.Beer.class);
		System.out.println(set2);
		assertTrue(set2.contains("Beer: Corona"));
		assertEquals(set2.size(),1);
		
		
		try{
			stock.sell(new Beverage.Beer("Corona"),60, 300);
		} catch (IllegalStateException e){}
		try{
			stock.sell(new Beverage.Beer("Corona"),-60, 300);
		} catch (IllegalArgumentException e){}
		try{
			stock.sell(new Beverage.Beer("Corona"),20, -300);
		} catch (IllegalArgumentException e){}
		try{
			stock.sell(null,20, 300);
		} catch (NullPointerException e){}

		try{
			stock.buy(new Beverage.Beer("Corona"),-60);
		} catch (IllegalArgumentException e){}
		try{
			stock.buy(null,20);
		} catch (NullPointerException e){}
		
		// Nessuna delle operazioni qui sopra fa nulla.. quindi:
		assertEquals(stock.getProductAmount(Beverage.Beer.class),50);
		assertEquals(stock.getProductAmount(Beverage.Coke.class),20);
		assertEquals(stock.getProductAmount(Beverage.class),70);
		assertEquals(stock.getProductAmount(Product.class),70);
		assertEquals(stock.getBalance(),60);
		
		
		
	}
	
}