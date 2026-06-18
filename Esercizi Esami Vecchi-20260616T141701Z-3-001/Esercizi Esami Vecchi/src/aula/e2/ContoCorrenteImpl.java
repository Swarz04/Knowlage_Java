package aula.e2;

public class ContoCorrenteImpl implements ContoCorrente {

	private double saldo;
	private CCStrategy strategiaCC;
	
	public ContoCorrenteImpl(final CCStrategy s){
		this.strategiaCC = s;
	}
	
	@Override
	public double saldoAttuale() {
		return this.saldo;
	}

	@Override
	public boolean prelievo(final double d) {
		if(saldo < d){
			return false;
		}else{
			this.saldo -= d + strategiaCC.costoPerPrelievo(d);
			return true;
		}
	}

	public void versamento(final double d) {
		this.saldo += d;
	}

	@Override
	public void cambioAnno() {
		this.saldo += strategiaCC.interessiAnnuali(this.saldo);
	}

}
