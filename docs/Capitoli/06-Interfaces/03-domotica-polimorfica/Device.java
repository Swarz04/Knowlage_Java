/**
 * Sorgente: 06-Interfaces.pdf, pagina 25.
 *
 * Un'interfaccia descrive un contratto, non lo stato o il modo concreto
 * con cui le operazioni vengono realizzate.
 *
 * I metodi di un'interfaccia sono implicitamente public e abstract.
 */
public interface Device {

    void switchOn();

    void switchOff();

    boolean isSwitchedOn();
}
