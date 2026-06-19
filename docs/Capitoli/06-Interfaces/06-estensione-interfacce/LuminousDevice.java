/**
 * Sorgente: 06-Interfaces.pdf, pagine 49-50.
 *
 * Un'interfaccia può estendere più interfacce. LuminousDevice non aggiunge
 * metodi, ma unisce i contratti Device e Luminous in un unico tipo.
 */
public interface LuminousDevice extends Device, Luminous {
    // Nessun metodo ulteriore nella slide.
}
