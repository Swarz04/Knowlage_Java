package aula.e2;

public class ContoCorrenteImpl implements ContoCorrente {

	private double saldo = 0;
	private final CCStrategy condizioni;

	public ContoCorrenteImpl(final CCStrategy condizioni) {
		this.condizioni = condizioni;
	}

	@Override
	public double saldoAttuale() {
		return saldo;
	}

	@Override
	public boolean prelievo(final double d) {
		if (saldo < d){
			return false;
		} else {
			saldo = saldo - d - this.condizioni.getCostoOperazione(d);
			return true;
		}
	}

	@Override
	public void versamento(final double d) {
		saldo += d;
	}

	@Override
	public void cambioAnno() {
		saldo += this.condizioni.getInteressiAnnuali(this.saldo);
	}

}
