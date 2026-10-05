package aula.e2;

public class ContoCorrenteA implements ContoCorrente {

	private double saldo = 0;

	@Override
	public double saldoAttuale() {
		return saldo;
	}

	@Override
	public boolean prelievo(double d) {
		if (saldo < d){ 
			return false;
		} else {
			saldo = saldo - d - 1.0; // costo fisso di un euro
			return true;
		}
	}

	@Override
	public void versamento(double d) {
		saldo += d;
	}

	@Override
	public void cambioAnno() {
	}

}
