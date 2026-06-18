package aula.e2;

/**
 * 
 * @author Enrico
 *
 */
public interface CCStrategy {

	/**
	 * 
	 * @return il costo per aver prelevato
	 */
	double costoPerPrelievo(final double importo);
	
	/**
	 * 
	 * @return gli interessi anuuali maturati sul conto
	 */
	double interessiAnnuali(final double saldoCC);
}
