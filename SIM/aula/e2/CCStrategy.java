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
	double getCostoOperazione(final double importo);

	/**
	 *
	 * @return gli interessi anuuali maturati sul conto
	 */
	double getInteressiAnnuali(final double saldoCC);
}
