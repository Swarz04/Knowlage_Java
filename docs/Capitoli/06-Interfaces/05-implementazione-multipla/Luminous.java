/**
 * Sorgente: 06-Interfaces.pdf, pagina 48.
 *
 * Contratto indipendente da Device: non ogni entità luminosa deve essere
 * necessariamente un dispositivo accendibile.
 */
public interface Luminous {

    void dim();

    void bright();
}
