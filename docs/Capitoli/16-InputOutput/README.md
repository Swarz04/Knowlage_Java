# 16 — Input-Output

Materiale ricostruito da `16-InputOutput.pdf`.

- Pagine del PDF: **70**
- Pagine analizzate: **1-70**
- Anno accademico delle slide: **2025/2026**
- Java usato per la verifica: **OpenJDK 21**
- Dipendenze esterne: **nessuna**

## Organizzazione

| Cartella | Pagine | Contenuto |
|---|---:|---|
| `00-mappe-uml` | 4, 17, 28, 29, 36, 41, 59, 66 | Otto diagrammi estratti dal PDF |
| `01-file-e-path` | 7-12 | `java.io.File`, path e reflection |
| `02-stream-binari` | 15-25 | Stream di byte, EOF, try-with-resources e file binari |
| `03-data-e-buffered-stream` | 26-38 | Decorator, dati primitivi e buffering |
| `04-serializzazione` | 39-56 | Oggetti, `Serializable`, `transient` e metodi ad hoc |
| `05-random-access` | 57-60 | Lettura e scrittura in posizioni arbitrarie |
| `06-file-di-testo` | 61-69 | Reader, Writer, encoding, `System.in` e `System.out` |
| `07-frammenti-api` | 9-10, 16, 22, 30-31, 54-55 | API e sorgenti parziali mostrati con `...` |

## Come eseguire

Ogni cartella di sorgenti è autonoma. Aprire un file con `main`, premere `F5`
e scegliere **Java: avvia il file aperto**.

I file generati dagli esempi vengono salvati in:

```text
${java.io.tmpdir}/oop16-input-output/
```

Questa è una modifica tecnica rispetto ai path Unix delle slide: rende gli
esempi portabili e impedisce che i dati prodotti finiscano fra i sorgenti.

## Inventario dei sorgenti

| File | Pagine | Stato | Note |
|---|---:|---|---|
| `01-file-e-path/UseFile.java` | 11-12 | Compilabile | Interroga `File` tramite reflection |
| `02-stream-binari/UseByteArrayStream.java` | 18 | Compilabile | Lettura di byte ed EOF `-1` |
| `02-stream-binari/UseTryWithResources.java` | 19 | Compilabile | Chiusura automatica |
| `02-stream-binari/StreamDumper.java` | 20 | Compilabile | Utility polimorfica |
| `02-stream-binari/UseStreamDumper.java` | 21 | Compilabile | Tre implementazioni di `InputStream` |
| `02-stream-binari/UseOutputStream.java` | 23 | Compilabile | Scrittura binaria |
| `02-stream-binari/UseOutputStream2.java` | 24 | Compilabile | Variante con `File` e `catch` |
| `02-stream-binari/ListOnFile.java` | 25 | Compilabile | Codifica manuale di `List<Byte>` |
| `03-data-e-buffered-stream/UseDataStream.java` | 32 | Compilabile | Tipi primitivi e ordine di lettura |
| `03-data-e-buffered-stream/UseBufferedDataStream.java` | 34 | Compilabile | Decoratori espliciti |
| `03-data-e-buffered-stream/UseBufferedDataStream2.java` | 35 | Compilabile | Constructor chaining |
| `04-serializzazione/Person.java` | 42 | Compilabile | Interfaccia marker e `serialVersionUID` |
| `04-serializzazione/UseObjectStream.java` | 43 | Compilabile | Stream di oggetti |
| `04-serializzazione/CPerson.java` | 48-49 | Compilabile | Cache `transient` |
| `04-serializzazione/UseTransient.java` | 50 | Compilabile | Cache dopo deserializzazione |
| `04-serializzazione/APerson.java` | 52 | Compilabile | `readObject`/`writeObject` personalizzati |
| `04-serializzazione/UseAdHocSerialization.java` | 53 | Compilabile | Uso di `APerson` |
| `05-random-access/UseRandomAccessFile.java` | 60 | Compilabile | `seek`, `setLength`, posizioni in byte |
| `06-file-di-testo/UseReadersWriters.java` | 67 | Compilabile | Codifica predefinita |
| `06-file-di-testo/UseStreamReadersWriters.java` | 68 | Compilabile | Codifica UTF-16 esplicita |
| `06-file-di-testo/SystemInOut.java` | 69 | Compilabile | Console e `PrintStream` |

I file `*ExampleFiles.java` sono supporti tecnici portabili aggiunti per
centralizzare i path temporanei.

## Concetti fondamentali

### `File` e contenuto

`java.io.File` rappresenta un path, non apre né legge il contenuto. Le
operazioni sul contenuto avvengono tramite stream, reader o
`RandomAccessFile`.

### Stream binari

- `InputStream.read()` restituisce `0..255`; `-1` indica la fine del flusso.
- `OutputStream.write(int)` usa gli otto bit meno significativi.
- try-with-resources chiude le risorse anche in caso di eccezione.
- La funzione che riceve uno stream non dovrebbe chiuderlo se non ne possiede
  il ciclo di vita.

### Decorator

Gli stream possono essere composti:

```text
DataInputStream
    -> BufferedInputStream
        -> FileInputStream
            -> file
```

Ogni strato aggiunge una responsabilità:

- `FileInputStream`: sorgente fisica;
- `BufferedInputStream`: prestazioni;
- `DataInputStream`: decodifica dei tipi primitivi.

Il tipo e l'ordine delle letture devono corrispondere alle scritture.
`writeUTF`/`readUTF` usano il modified UTF-8 definito da `DataInput` e
`DataOutput`, non un normale file testuale UTF-8.

### Serializzazione

- `Serializable` è un'interfaccia marker.
- `serialVersionUID` identifica la versione compatibile della classe.
- Tutti gli oggetti raggiungibili dai campi devono essere serializzabili,
  salvo i campi `transient`.
- I campi `transient` non vengono ripristinati automaticamente.
- `readObject` e `writeObject` privati permettono una strategia personalizzata.

Le slide sottolineano che la serializzazione Java nativa è poco usata nei
sistemi moderni perché non è standardizzata tra linguaggi, può essere
inefficiente e lega i dati all'evoluzione delle classi.

### Accesso casuale

`RandomAccessFile` non deriva da `InputStream` o `OutputStream`; implementa
invece `DataInput` e `DataOutput`. `seek(long)` sposta il cursore espresso in
byte. Poiché un `int` occupa quattro byte, l'intero in posizione `n` inizia a:

```java
n * Integer.BYTES
```

### Testo ed encoding

- `Reader` e `Writer` lavorano con caratteri.
- `InputStreamReader` e `OutputStreamWriter` convertono tra byte e caratteri.
- La stessa codifica deve essere usata in scrittura e lettura.
- `BufferedReader.readLine()` restituisce `null` a fine file.
- JSON, TOML e YAML sono citati come formati testuali standard; il PDF non
  include esempi Java completi e non sono state aggiunte librerie esterne.

## Riepilogo della pagina 70

- Identificazione di file o directory: `File`.
- Accesso casuale: `RandomAccessFile`.
- Dati binari: `FileInputStream + BufferedInputStream + DataInputStream`.
- Oggetti: `FileInputStream + BufferedInputStream + ObjectInputStream`.
- Testo con codifica predefinita: `FileReader + BufferedReader`.
- Testo con codifica esplicita:
  `FileInputStream + InputStreamReader + BufferedReader`.
- Le versioni di scrittura sono duali alle precedenti.

## Ricostruzioni dichiarate

1. I path assoluti Unix sono sostituiti con una directory temporanea.
2. `UseStreamDumper` crea un piccolo file se viene eseguito autonomamente.
3. `UseRandomAccessFile` azzera il file prima della scrittura per rendere
   ripetibili le esecuzioni.
4. `SystemInOut` non chiude il reader collegato a `System.in`, perché la
   chiusura terminerebbe lo stream globale della JVM.
5. Le API standard e il frammento interno di `ArrayList` sono conservati come
   `.java.txt`: le slide omettono parti con `...` e non costituiscono sorgenti
   autonomi.
6. Sono stati aggiunti import, classi di supporto per i path e commenti
   esplicativi; non sono state aggiunte dipendenze esterne.

## Verifica

Tutte le 70 pagine sono state considerate. Le pagine con diagrammi sono
raccolte in `00-mappe-uml`; le pagine con estrazione testuale ambigua sono
state confrontate visivamente con il PDF.

Esito finale:

- **25 sorgenti Java compilati correttamente** con OpenJDK 21;
- **17 programmi con `main` eseguiti correttamente**;
- `SystemInOut` verificato fornendo `input di prova` su standard input;
- `UseRandomAccessFile` verificato redirigendo le 100.000 righe in un log
  temporaneo: la posizione `23000 * 4` contiene `23000` e l'area aggiunta con
  `setLength` contiene byte inizializzati a zero;
- **8 immagini PNG** controllate per leggibilità e corrispondenza col PDF;
- **3 frammenti `.java.txt`** conservati come documentazione non compilabile;
- nessun `.class`, `.bin` o file di testo generato è presente nella cartella
  dei sorgenti.
