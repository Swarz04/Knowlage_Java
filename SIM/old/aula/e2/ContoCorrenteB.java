package aula.e2;

public class ContoCorrenteB implements ContoCorrente {

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
			saldo = saldo - d - d*0.01; // 1% di costo dell'operazione sul prelievo
			return true;
		}
	}

	@Override
	public void versamento(double d) {
		saldo += d;
	}

	@Override
	public void cambioAnno() {
		saldo = saldo * 1.05; // 5% di interessi annuali
	}
}
