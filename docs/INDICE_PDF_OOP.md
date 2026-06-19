# Indice delle dispense di Programmazione ad Oggetti

> L'indice comprende i 21 PDF didattici principali. `00-Intro.pdf` è escluso perché contiene soprattutto informazioni organizzative sul corso. Nella numerazione non è presente il capitolo 15, mentre il capitolo 19 è diviso in due parti.

1. **01-OO-Abstraction.pdf — Ingegneria e astrazione object-oriented**
   - Sistemi software e fasi dello sviluppo: analisi, progettazione, implementazione e manutenzione.
   - Problem space, solution space e livelli di astrazione.
   - Principi e vantaggi della programmazione a oggetti.
   - Introduzione alla piattaforma Java, JVM, compilazione e portabilità.

2. **02-Objects.pdf — Oggetti e classi**
   - Tipi primitivi, variabili, riferimenti, oggetti e valore `null`.
   - Organizzazione della memoria: stack, heap e garbage collector.
   - Definizione di classi, campi e metodi; uso di `this`.
   - Package, librerie, stampa a video e struttura di un primo programma Java.

3. **03-Structured.pdf — Programmazione strutturata in Java**
   - Tipi primitivi, operatori, conversioni e casting.
   - Array monodimensionali e multidimensionali.
   - Istruzioni condizionali, cicli, `switch`, `break`, `continue` e `foreach`.
   - Metodi e classi di utilità; primi principi di qualità del software.

4. **04-Lifecycle.pdf — Ciclo di vita di oggetti e classi**
   - Campi e metodi statici.
   - Costruttori, inizializzazione degli oggetti e overloading.
   - Package, import e modificatori di accesso.
   - Garbage collection, distruzione degli oggetti e gestione delle risorse.

5. **05-Encapsulation.pdf — Incapsulamento**
   - Convenzioni di formattazione, denominazione e organizzazione del codice.
   - Decomposizione del sistema in classi.
   - Incapsulamento, information hiding e riduzione delle dipendenze.
   - Getter, setter, immutabilità e metodologia di progettazione delle classi.

6. **06-Interfaces.pdf — Composizione, riuso e interfacce**
   - Associazione, aggregazione, composizione e delegazione.
   - Rappresentazione delle relazioni tramite UML.
   - Definizione e implementazione delle interfacce Java.
   - Sottotipi, principio di sostituibilità e polimorfismo.
   - Metodi `default`, metodi statici e altri meccanismi delle interfacce.

7. **07-Inheritance.pdf — Ereditarietà**
   - Riuso tramite composizione ed ereditarietà.
   - Estensione delle classi con `extends`.
   - Accesso `protected`, overriding e uso di `super`.
   - Costruzione degli oggetti nelle gerarchie.
   - Classi e metodi `final`; progettazione di gerarchie `is-a`.

8. **08-Polymorphism.pdf — Polimorfismo inclusivo**
   - Polimorfismo basato su ereditarietà, interfacce e sostituibilità.
   - Binding dinamico e selezione dei metodi a runtime.
   - Tipi statici e dinamici, casting e operatore `instanceof`.
   - Classi e metodi astratti.
   - Wrapper, autoboxing/unboxing e argomenti variabili.

9. **09-Generics.pdf — Generici e polimorfismo parametrico**
   - Limiti delle collezioni basate sul solo polimorfismo inclusivo.
   - Classi, interfacce e metodi generici.
   - Parametri di tipo e sicurezza statica.
   - Wildcard generiche e relazioni di sottotipo.

10. **10-Collections.pdf — Java Collections Framework**
    - Struttura generale del Java Collections Framework.
    - Interfacce `Collection`, `List`, `Set`, `Iterator` e `Comparable`.
    - Iteratori e ciclo `foreach`.
    - Implementazioni come `ArrayList`, `LinkedList`, `HashSet` e `TreeSet`.
    - Ordinamento, uguaglianza, hashing e scelta della collezione adatta.

11. **11-GenColl2.pdf — Generici e collezioni avanzate**
    - Type erasure e conseguenze dei generici Java.
    - Tipi generici vincolati.
    - Wildcard, sostituibilità e principio PECS.
    - Implementazioni e caratteristiche delle liste.
    - Classi di utilità `Arrays` e `Collections`.
    - Mappe: `Map`, `HashMap` e relative operazioni.

12. **12-Exceptions.pdf — Errori di esecuzione ed eccezioni**
    - Differenza tra errori di compilazione ed errori a runtime.
    - Gerarchia di `Throwable`, `Error`, eccezioni checked e unchecked.
    - Lancio di eccezioni con `throw`.
    - Gestione con `try`, `catch` e `finally`.
    - Dichiarazione `throws`, creazione e rilancio di eccezioni personalizzate.
    - Linee guida per l'uso corretto delle eccezioni.

13. **13-AdvancedMechanisms.pdf — Meccanismi avanzati**
    - Classi innestate statiche.
    - Approfondimento sulle mappe del Collection Framework.
    - Inner class e relazione con l'oggetto esterno.
    - Classi locali e classi anonime.
    - Enumerazioni Java e loro funzionalità.

14. **14-Reflection.pdf — Reflection, annotazioni e testing**
    - File `.class`, caricamento delle classi e JVM.
    - Informazioni sui tipi a runtime e oggetti `Class`.
    - Reflection API per ispezionare e utilizzare classi, campi, metodi e costruttori.
    - Annotazioni standard e personalizzate.
    - Introduzione al testing automatico con JUnit.

15. **16-InputOutput.pdf — Input/Output**
    - File e proprietà del file system.
    - Stream binari: `InputStream` e `OutputStream`.
    - Composizione degli stream e pattern Decorator.
    - Serializzazione e deserializzazione degli oggetti.
    - File ad accesso casuale.
    - File di testo, `Reader`, `Writer` e buffering.

16. **17-Lambda.pdf — Espressioni lambda**
    - Introduzione allo stile di programmazione funzionale in Java.
    - Espressioni lambda e cattura delle variabili.
    - Interfacce funzionali e annotazione `@FunctionalInterface`.
    - Interfacce standard come `Predicate`, `Function`, `Consumer` e `Supplier`.
    - Method reference e uso delle lambda nelle API Java.
    - Cenni a record e switch expression.

17. **18-Streams.pdf — Stream funzionali**
    - Differenza tra stream, collezioni e iteratori.
    - Pipeline composte da sorgente, operazioni intermedie e operazione terminale.
    - Operazioni come `filter`, `map`, `flatMap`, `reduce`, `collect` e ordinamento.
    - Valutazione lazy e assenza di collezioni temporanee.
    - Stream sequenziali e paralleli; cenni all'implementazione concorrente.

18. **19a-Concurrency1.pdf — Programmazione multithread, parte I**
    - Concorrenza, parallelismo e richiami sui thread dei sistemi operativi.
    - Programmazione concorrente e approccio task-oriented.
    - Creazione e gestione dei thread con `Thread` e `Runnable`.
    - Ciclo di vita, avvio, terminazione e interruzione dei thread.
    - Parallelismo su sistemi multicore.
    - Prime applicazioni del multithreading alle interfacce grafiche reattive.

19. **19b-Concurrency2.pdf — Programmazione multithread, parte II**
    - Interazione, comunicazione e coordinamento tra thread.
    - Race condition, sezioni critiche e mutua esclusione.
    - Blocchi e metodi `synchronized`; progettazione di classi thread-safe.
    - Coordinamento tramite `wait`, `notify` e `notifyAll`.
    - Concorrenza nelle interfacce grafiche.
    - Task, executor, virtual thread e cenni ad altri modelli concorrenti.

20. **20-Patterns.pdf — Progettazione object-oriented e design pattern**
    - Ciclo di vita del software e modelli di sviluppo.
    - Analisi, progettazione architetturale e progettazione di dettaglio.
    - Definizione, struttura e classificazione dei design pattern GoF.
    - Pattern comportamentali e strutturali.
    - Pattern creazionali e loro applicazione.
    - Uso dei pattern per ottenere sistemi flessibili, estendibili e riusabili.

21. **21-EffectiveProgramming.pdf — Programmazione object-oriented efficace**
    - Problemi tipici del software mal progettato.
    - Principi DRY, KISS e convenzioni di buona programmazione.
    - Principi SOLID.
    - Riduzione di visibilità, mutabilità, accoppiamento e complessità.
    - Linee guida per classi, metodi, tipi, eccezioni e collezioni.
    - Indicazioni tratte da *Effective Java* per codice leggibile e manutenibile.
