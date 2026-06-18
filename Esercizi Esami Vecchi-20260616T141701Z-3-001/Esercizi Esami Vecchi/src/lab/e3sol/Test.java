package lab.e3sol;

public class Test {
	
	/*
	 * Si considerino l'interfaccia Stream e la sua implementazione DoublingStream fornite,
	 * che passano il metodo di test testDoublingStream qui sotto.
	 * Realizzare una classe ConcatenatingStream che implementi Stream ma passi il test
	 * testConcatenatingStream (da scommentare).
	 * Visto che le due classi DoublingStream e ConcatenatingStream sono molto simili,
	 * si richiede altresì allo studente di rifattorizzarle in un'unica classe astratta
	 * AbstractIterativeStream (che implementa Stream) dalla quale entrambe DoublingStream 
	 * e ConcatenatingStream ereditano. Al solito, si cerchi di mettere quante più cose comuni in   
	 * AbstractIterativeStream e solo le poche differenze in DoublingStream e ConcatenatingStream.
	 * Si suggerisce a tal scopo di usare il pattern Template Method.
	 * 
	 * Risolto l'esercizio, si preapari a mostrare al docente anche compilazione ed esecuzione da Console.
	 */
	
	static boolean testDoublingStream(){
		Stream<Integer> stream = new DoublingStream(10);
		return stream.next()==10 && 
				stream.next()==20 && 
				stream.next()==40 &&
				stream.next()==80 &&
				stream.next()==160;
	}

    static boolean testConcatenatingStream(){
		Stream<String> stream = new ConcatenatingStream("init","0");
		return stream.next().equals("init") && 
				stream.next().equals("init0") &&
				stream.next().equals("init00") &&
				stream.next().equals("init000") &&
				stream.next().equals("init0000");
	}
	
	public static void main(String[] args) {
		System.out.println(testDoublingStream());
		System.out.println(testConcatenatingStream());
	}
	
	/*
	 * per la compilazione da linea di comando:
	 * - posizionarsi nella cartella src/ dentro al progetto
	 * - javac lab/e3sol/*.java
	 * - java lab.e3sol.test
	 */

}
