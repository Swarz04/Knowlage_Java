package aula.e2;

/**
 * Interfaccia che modella il concetto di conto corrente
 */
public interface ContoCorrente {
	
	// Quanto c'è nel conto (0 inizialmente)
	double saldoAttuale();
	
	// Prelievo quantitià d, torna falso se non ho la disponibilità, nel qual caso non si preleva nulla
	boolean prelievo(double d);
	
	// verso quantità d
	void versamento(double d);
	
	// fine anno, forse mi spettano gli interessi, che si aggiungono al saldo
	void cambioAnno();
}
