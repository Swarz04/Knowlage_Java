package aula.e2sol;

public interface Condizioni {
	
	// Dato l'importo del prelievo, me ne calcola i costi
	double getCostoOperazione(double importo);

	// Dato l'importo del saldo, me ne calcola gli interessi
	double getInteressiAnnuali(double saldo);
}
