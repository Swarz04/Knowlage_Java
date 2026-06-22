package aula.e3sol;

import java.util.*;

public class Test {
	
	/*
	 * Si consideri l'interfaccia Acceptor<X> fornita (se ne legga la documentazione).
	 * Si realizzino due specializzazioni ListAcceptor<X> e SequenceAcceptor<X>, in modo
	 * che passino i test sottostanti (da scommentare).
	 * La prima è un adapter per un oggetti List<X>, ed è usata per accettare via via
	 * gli elementi della lista (e solo quelli, in ordine).
	 * La seconda (un decoratore) prende in ingresso due Acceptor<X>, e di conseguenza
	 * accetta gli elementi accettati dal primo, e poi (quando completati) quelli del secondo
	 * (e quindi non accetta più niente.
	 */
	
	public static boolean test1(){
		// ListAcceptor accetta in ordine gli elementi della lista, poi più niente
		List<Integer> list = Arrays.asList(10,20,30);
		Acceptor<Integer> a = new ListAcceptor<>(list);
		return a.accept(10) &&	a.accept(20) && a.accept(30) && !a.accept(31);
	}
	
	public static boolean test2(){
		// ListAcceptor accetta in ordine gli elementi della lista, se si fa un errore, rifiuta non accetta più nulla
		List<Integer> list = Arrays.asList(10,20,30);
		Acceptor<Integer> a = new ListAcceptor<>(list);
		return a.accept(10) &&	!a.accept(21) && !a.accept(20);
	}
	
	public static boolean test3(){
		// SequenceAcceptor accetta in ordine gli elementi della primo acceptor e poi del secondo, poi più nulla
		Acceptor<Integer> a = new ListAcceptor<>(Arrays.asList(10,20,30));
		Acceptor<Integer> b = new ListAcceptor<>(Arrays.asList(40,50));
		Acceptor<Integer> c = new SequenceAcceptor<>(a,b);
		return c.accept(10) &&	c.accept(20) && c.accept(30) && c.accept(40) && c.accept(50) & !c.accept(51);
	}
	
	public static boolean test4(){
		// Facendo un errore a metà, rifiuta e non accetta più nulla
		Acceptor<Integer> a = new ListAcceptor<>(Arrays.asList(10,20,30));
		Acceptor<Integer> b = new ListAcceptor<>(Arrays.asList(40,50));
		Acceptor<Integer> c = new SequenceAcceptor<>(a,b);
		return c.accept(10) &&	c.accept(20) && c.accept(30) && !c.accept(10) && !c.accept(40) & !c.accept(50);
	}
	
	public static boolean test5(){
		// Non è possibile accorgersi se una sequenza è completamente ultimata, quinsi accetta anche 10,20,40,50
		Acceptor<Integer> a = new ListAcceptor<>(Arrays.asList(10,20,30));
		Acceptor<Integer> b = new ListAcceptor<>(Arrays.asList(40,50));
		Acceptor<Integer> c = new SequenceAcceptor<>(a,b);
		return c.accept(10) &&	c.accept(20) && !c.accept(10) && !c.accept(40) & !c.accept(50);
	}

	public static void main(String[] args) {
		System.out.println("test1: "+test1());
		System.out.println("test2: "+test2());
		System.out.println("test3: "+test3());
		System.out.println("test4: "+test4());
		System.out.println("test5: "+test5());
	}
}
