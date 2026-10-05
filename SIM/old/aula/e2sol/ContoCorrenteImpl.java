package aula.e2sol;

public class ContoCorrenteImpl implements ContoCorrente {

	private double saldo = 0;
	private Condizioni condizioni;
	
	public ContoCorrenteImpl(Condizioni condizioni){
		this.condizioni = condizioni;
	}

	@Override
	public double saldoAttuale() {
		return saldo;
	}

	@Override
	public boolean prelievo(double d) {
		if (saldo < d){ 
			return false;
		} else {
			saldo = saldo - d - this.condizioni.getCostoOperazione(d);
			return true;
		}
	}

	@Override
	public void versamento(double d) {
		saldo += d;
	}

	@Override
	public void cambioAnno() {
		saldo += this.condizioni.getInteressiAnnuali(this.saldo);
	}

}
