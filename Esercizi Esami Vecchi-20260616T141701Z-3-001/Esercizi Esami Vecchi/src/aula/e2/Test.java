package aula.e2;

import static org.junit.Assert.*;

/*
 * Si fornisce l'interfaccia per un conto corrente e due sue diverse implementazioni a titolo di esempio.
 * che differiscono per le condizioni (ossia solo per i costi/interessi che applicano).
 * All'insorgere di una terza tipologia di condizioni, si rende necessaria una rifattorizzano che consenta di 
 * gestire il conto corrente con una unica classe, e comunque evitando il più possibile le duplicazioni di codice.
 * Quindi, si sostituiscano ContoCorrenteA e ContoCorrenteB con una unica implementazione riusabile ContoCorrenteImpl 
 * dell'interfaccia ContoCorrente. Tale implementazione sia utilizzabile per svolgere le stesse funzioni di 
 * ContoCorrenteA e ContoCorrenteB (si vedano testA e testB), ma anche per realizzare il nuovo funzionamento
 * richiesto da testC -- si veda sotto.
 * Per indicare quali condizioni vanno applicate al conto, si consiglia di usare il pattern Strategy, passando al 
 * costruttore di ContoCorrenteImpl un oggetto (magari creato attraverso una classe anonima), che specifichi i costi/interessi 
 * da applicare in modo sufficientemente flessibile da supportare tutti i test qui sotto.
 */

public class Test {

	@org.junit.Test
	public void testA() {
		/*
		 * Nella linea sottostante si assegni cc ad un oggetto di
		 * ContoCorrenteImpl opportunamente configurato per aver costo fisso per
		 * prelievo 1 euro, e interessi dello 0% all'anno. Ossia il
		 * funzionamento della classe ContoCorrenteA.
		 */
		final ContoCorrente cc = new ContoCorrenteImpl(new CCStrategy() {

			@Override
			public double costoPerPrelievo(final double importo) {
				return 1;
			}

			@Override
			public double interessiAnnuali(final double saldoCC) {
				return 0;
			}

		});
		cc.versamento(100);
		cc.prelievo(10);
		assertEquals(cc.saldoAttuale(), 89.0, 0.001); // Approssimazione di
														// 0.001 tollerata
		cc.prelievo(8);
		assertEquals(cc.saldoAttuale(), 80, 0.001);
		cc.cambioAnno();
		assertEquals(cc.saldoAttuale(), 80, 0.001);
	}

	@org.junit.Test
	public void testB() {
		/*
		 * Nella linea sottostante si assegni cc ad un oggetto di
		 * ContoCorrenteImpl opportunamente configurato per aver costo per
		 * prelievo pari al 1% dell'importo, e interessi del 5% annuali. Ossia
		 * il funzionamento della classe ContoCorrenteBs.
		 */
		final ContoCorrente cc = new ContoCorrenteImpl(new CCStrategy() {

			@Override
			public double costoPerPrelievo(final double importo) {
				return importo * 0.01;
			}

			@Override
			public double interessiAnnuali(final double saldoCC) {
				return saldoCC * 0.05;
			}

		});
		cc.versamento(100);
		cc.prelievo(10);
		assertEquals(cc.saldoAttuale(), 89.9, 0.001);
		cc.prelievo(40);
		assertEquals(cc.saldoAttuale(), 49.5, 0.001);
		cc.cambioAnno();
		assertEquals(cc.saldoAttuale(), 51.975, 0.001);
	}

	@org.junit.Test
	public void testC() {
		/*
		 * Nella linea sottostante si assegni cc ad un oggetto di
		 * ContoCorrenteImpl opportunamente configurato per aver costo fisso per
		 * prelievo 1 euro per importi inferiori a 10 euro, e del 10%
		 * dell'importo se maggiore di 10 euro. Non vi siano interessi annuali.
		 */
		final ContoCorrente cc = new ContoCorrenteImpl(new CCStrategy(){

			@Override
			public double costoPerPrelievo(final double importo) {
				if(importo <= 10){
					return 1;
				}else{
					return importo * 0.1;
				}
			}

			@Override
			public double interessiAnnuali(final double saldoCC) {
				return 0;
			}
			
		});
		cc.versamento(100);
		cc.prelievo(9);
		assertEquals(cc.saldoAttuale(), 90, 0.001);
		cc.prelievo(30);
		assertEquals(cc.saldoAttuale(), 57, 0.001);
		cc.cambioAnno();
		assertEquals(cc.saldoAttuale(), 57, 0.001);
	}
}
