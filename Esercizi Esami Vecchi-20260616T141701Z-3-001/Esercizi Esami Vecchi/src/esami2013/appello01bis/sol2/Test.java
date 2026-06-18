package esami2013.appello01bis.sol2;

public class Test {
	
	/*  
	 * Realizzare una class GUI che appena istanziata crea il frame con (circa) l'aspetto mostrato nel file gui.png fornito.
	 * A tal scopo:
	 * - si utilizzi il componente MyJList<E> fornito, che realizza un componento grafico  lista (con barra di scorrimento verticale) 
	 *   inizialmente vuota, ove è possibile aggiungere un elemento in fondo, e al quale si può chiedere tutta la lista 
	 *   degli elementi come java.util.List<E>
	 * - si ponga tale componente nella parte CENTER di un BorderLayout - si usi il metodo add(<comp>,BordeLayout.CENTER)
	 * - si pongano i due pulsanti ed il JTextField dentro un pannello con FlowLayout, da porre nella parte SOUTH del BorderLayout 
	 * Alla pressione del pulsante Add, il contenuto del JTextField (ottenuto dal metodo getText) venga aggiunto alla lista.
	 * Alla pressione del pulsante Print&Quit, si stampi su console, riga per riga, il contenuto dalla lista, e si esca.
	 * 
	 *  >> Si mostri al docente compilazione ed esecuzione da linea di comando
	 */
	
	public static void main(String[] args) {
		// TOGLIERE IL COMMENTO QUI!!
		new GUI();

	}

}
