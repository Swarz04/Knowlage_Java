package esami2013.appello06.sol3;

import static org.junit.Assert.*;

import java.util.*;

/*
 * Si consideri l'interfaccia Stream (che modella un produttore di elementi) e
 * la sua implementazione ListStream (che wrappa una lista e ne genera gli elementi).
 * Il loro funzionamento è descritto nei commenti alle classi e dal metodo test() 
 * qui sotto riportato.
 * 
 * Si consideri ora l'interfaccia OpStream che aggiunge le due funzionalità di reduce e until. 
 * Tale interfaccia va implementata con una classe OpStreamImpl che funga da decoratore per uno stream.
 * 
 * Si consideri la funzione test2() qui sotto (da "scommentare") come riferimento.
 */

public class Test {
	
	@org.junit.Test
	public void test(){
		
		List<Integer> list = Arrays.asList(10,20,30,40,50,60,70,80,90,100);
		Stream<Integer> stream = new ListStream<>(list);
		
		// Lo stream produce gli elementi della lista uno ad uno, fino all'eccezione
		
		assertTrue(stream.getNextElement().equals(10));
		assertTrue(stream.getNextElement().equals(20));
		assertTrue(stream.getNextElement().equals(30));
		assertTrue(stream.getNextElement().equals(40));
		assertTrue(stream.getNextElement().equals(50));
		assertTrue(stream.getNextElement().equals(60));
		assertTrue(stream.getNextElement().equals(70));
		assertTrue(stream.getNextElement().equals(80));
		assertTrue(stream.getNextElement().equals(90));
		assertTrue(stream.getNextElement().equals(100));
		try{
			stream.getNextElement();
			fail("stream is over!");
		} catch (java.util.NoSuchElementException e){}
	}
	
	@org.junit.Test
	public void test2(){
	
		List<Integer> list = Arrays.asList(10,20,30,40,50,60,70,80,90,100);
		
		Stream<Integer> stream2 = new OpStreamImpl<>(new ListStream<>(list));
		
		// Un OpStream è un semplice wrapper, infatti non altera il funzionamento della ListStream

		assertTrue(stream2.getNextElement().equals(10));
		assertTrue(stream2.getNextElement().equals(20));
		assertTrue(stream2.getNextElement().equals(30));
		assertTrue(stream2.getNextElement().equals(40));
		assertTrue(stream2.getNextElement().equals(50));
		assertTrue(stream2.getNextElement().equals(60));
		assertTrue(stream2.getNextElement().equals(70));
		assertTrue(stream2.getNextElement().equals(80));
		assertTrue(stream2.getNextElement().equals(90));
		assertTrue(stream2.getNextElement().equals(100));
		try{
			stream2.getNextElement();
			fail("stream is over!");
		} catch (java.util.NoSuchElementException e){}
		
		// Lo stream3 applica una riduzione allo stream della lista, fa passare solo gli elementi multipli di 20
		
		Stream<Integer> stream3 = new OpStreamImpl<>(new ListStream<>(list)).reduce(new Function<Integer,Boolean>(){
	    	 public Boolean apply(Integer i){
	    		 return i % 20 == 0;
	    	 }
	    }); 
		
		assertTrue(stream3.getNextElement().equals(20));
		assertTrue(stream3.getNextElement().equals(40));
		assertTrue(stream3.getNextElement().equals(60));
		assertTrue(stream3.getNextElement().equals(80));
		assertTrue(stream3.getNextElement().equals(100));
		try{
			stream3.getNextElement();
			fail("stream is over!");
		} catch (java.util.NoSuchElementException e){}
		
		// Lo stream4 applica una mappa allo stream3(bis), fa passare solo finchè i<=40, poi più niente
		
		Stream<Integer> stream3bis = new OpStreamImpl<>(new ListStream<>(list)).reduce(new Function<Integer,Boolean>(){
	    	 public Boolean apply(Integer i){
	    		 return i % 20 == 0;
	    	 }
	    }); 
		Stream<Integer> stream4 = new OpStreamImpl<>(stream3bis).until(new Function<Integer,Boolean>(){
	    	 public Boolean apply(Integer i){
	    		 return i<=40;
	    	 }
	    });


		assertTrue(stream4.getNextElement().equals(20));
		assertTrue(stream4.getNextElement().equals(40));
		try{
			stream4.getNextElement();
			fail("stream is over!");
		} catch (java.util.NoSuchElementException e){}


	}
}
