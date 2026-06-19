# Protocollo per estrarre il codice Java dalle dispense PDF

Questo documento stabilisce il comportamento da mantenere quando l'utente indica una dispensa PDF presente in `docs`.

Il contenuto e l'ordine delle dispense sono descritti in [INDICE_PDF_OOP.md](./INDICE_PDF_OOP.md).

## Obiettivo

Quando l'utente indica **un PDF**, analizzare accuratamente quel PDF ed estrarre tutto il codice Java utile in una cartella che abbia lo stesso nome del documento, senza l'estensione `.pdf`.

Esempio:

```text
PDF richiesto: docs/12-Exceptions.pdf
Cartella creata: docs/12-Exceptions/
```

Si lavora normalmente su **un solo PDF per richiesta**. La lunghezza del documento non giustifica un'analisi parziale: è preferibile completare bene una dispensa alla volta.

## Interpretazione della richiesta

- Se l'utente scrive il nome esatto di un PDF, elaborare soltanto quel file.
- Se scrive un numero o un titolo riconoscibile, risolverlo usando `INDICE_PDF_OOP.md`.
- Non avviare automaticamente l'estrazione degli altri PDF.
- Se il PDF indicato non esiste o il riferimento corrisponde a più file, chiedere una precisazione.
- Se la cartella di destinazione esiste già, ispezionarla e preservare il lavoro valido presente: integrare o correggere senza cancellazioni indiscriminate.

## Struttura dell'output

La cartella di destinazione va creata accanto al PDF:

```text
docs/
├── 12-Exceptions.pdf
└── 12-Exceptions/
    ├── README.md
    ├── EsempioEccezione.java
    ├── GestioneRisorsa.java
    └── ...
```

Usare questa organizzazione:

- un file `.java` per ogni classe, interfaccia, enum, record o esempio autonomo;
- sottocartelle coerenti con i `package` mostrati nella dispensa, quando presenti;
- `README.md` come inventario e guida al materiale estratto;
- nomi descrittivi e stabili per i frammenti che nel PDF non hanno un nome esplicito.

Non creare un unico file enorme contenente esempi non collegati.

## Procedura obbligatoria

### 1. Analisi completa

1. Verificare nome, percorso e numero di pagine del PDF.
2. Estrarre il testo mantenendo, quando possibile, la disposizione originale.
3. Esaminare il documento dall'inizio alla fine, pagina per pagina.
4. Individuare:
   - blocchi di codice completi;
   - frammenti Java inseriti nel testo o nei diagrammi;
   - versioni successive dello stesso esempio;
   - codice distribuito su più pagine;
   - output, errori o pseudocodice che non devono essere confusi con sorgenti Java.
5. Se l'estrazione testuale perde parti visive, ispezionare direttamente le pagine interessate.

### 2. Ricostruzione fedele

- Conservare il significato didattico e l'ordine logico degli esempi.
- Unire soltanto i frammenti che nel PDF appartengono chiaramente allo stesso sorgente.
- Aggiungere `import`, classe contenitore o metodo `main` solo quando sono necessari per rendere eseguibile un esempio e la ricostruzione è non ambigua.
- Contrassegnare nel codice le aggiunte tecniche con un commento breve, per esempio:

```java
// Aggiunto per rendere autonomo l'esempio.
```

- Non inventare implementazioni mancanti e non completare liberamente codice intenzionalmente parziale.
- Non trasformare pseudocodice, UML o semplici firme in implementazioni arbitrarie.
- Se una slide mostra codice errato per spiegare un errore, conservarlo separatamente e identificarlo chiaramente come esempio non compilabile.

### 3. Gestione dei duplicati e delle varianti

- Non duplicare lo stesso blocco se viene ripetuto senza modifiche.
- Conservare varianti significative quando mostrano l'evoluzione di un concetto.
- Dare alle varianti nomi ordinati, per esempio:

```text
ContatoreV1.java
ContatoreV2Sincronizzato.java
```

- Nel `README.md`, indicare le pagine di provenienza e la relazione tra le varianti.

### 4. Verifica

Al termine:

1. controllare che ogni pagina sia stata considerata;
2. confrontare i sorgenti con il PDF per evitare righe saltate o simboli alterati;
3. verificare parentesi, generici, lambda, annotazioni e caratteri che l'estrazione PDF può corrompere;
4. compilare con `javac` tutti gli esempi che dovrebbero essere completi;
5. distinguere nel resoconto:
   - file compilati correttamente;
   - frammenti didattici volutamente incompleti;
   - esempi volutamente errati;
   - dipendenze esterne o versioni Java richieste.

Il superamento della compilazione non sostituisce il confronto con il PDF: un sorgente può compilare pur essendo stato ricostruito in modo infedele.

## Contenuto minimo del README

Ogni cartella estratta deve contenere un `README.md` con:

- nome del PDF sorgente;
- numero totale di pagine analizzate;
- versione Java richiesta, se ricavabile;
- elenco dei file prodotti;
- pagine di provenienza di ogni esempio;
- indicazione dei file autonomi, parziali o volutamente non compilabili;
- modifiche minime introdotte rispetto alle slide;
- esito della verifica e della compilazione.

Tabella consigliata:

```markdown
| File | Pagine | Stato | Note |
|---|---:|---|---|
| Esempio.java | 12-13 | Compilabile | Ricomposto da due slide |
| Errore.java | 18 | Errore intenzionale | Mostra un caso non valido |
```

## Criteri di completamento

Il lavoro su un PDF è concluso soltanto quando:

- l'intero documento è stato analizzato;
- tutto il codice Java rilevante è stato censito;
- ogni sorgente è riconducibile alle pagine di origine;
- frammenti, aggiunte e incertezze sono dichiarati;
- gli esempi completi sono stati verificati con `javac`, quando l'ambiente lo consente;
- il `README.md` permette di capire e utilizzare la cartella senza riaprire subito il PDF.

## Resoconto da dare all'utente

La risposta finale deve essere breve ma verificabile. Deve indicare:

- PDF elaborato e numero di pagine;
- cartella creata o aggiornata;
- quantità e tipologia dei file estratti;
- risultato della compilazione;
- eventuali esempi incompleti, volutamente errati o dubbi residui.

Non dichiarare che l'estrazione è completa se alcune pagine o alcuni blocchi non sono stati controllati.
