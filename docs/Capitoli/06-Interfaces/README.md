# 06 — Composizione, riuso e sostituibilità: le interface

Materiale ricostruito da `06-Interfaces.pdf`.

- Pagine del PDF: **52**
- Pagine analizzate: **1-52**
- Anno accademico delle slide: **2025/2026**
- Java usato per la verifica: **OpenJDK 21**
- Compatibilità prevista degli esempi: **Java 8 o successivo**

## Come eseguire gli esempi

Ogni sottocartella rappresenta uno scenario autonomo, perché le slide
riutilizzano intenzionalmente nomi come `Lamp` e `Device` in versioni diverse.

Con la configurazione VS Code presente nella cartella `docs`:

1. aprire un file `Use*.java`, `*Demo.java` oppure `BindingDemo.java`;
2. premere `F5`;
3. scegliere **Java: avvia il file aperto**.

Il task compila tutti i `.java` presenti nella stessa sottocartella.

## Inventario dei sorgenti

| Cartella / file | Pagine | Stato | Contenuto |
|---|---:|---|---|
| `01-composizione/Lamp.java` | 8-9 | Compilabile | Stato, incapsulamento e gestione dell'intensità |
| `01-composizione/TwoLampsDevice.java` | 10-12, 17 | Compilabile | Composizione di esattamente due `Lamp` e delegazione |
| `01-composizione/LampsRow.java` | 18-19 | Compilabile | Composizione 0..N mediante array e celle `null` |
| `01-composizione/UseComposition.java` | — | Aggiunta didattica | Client eseguibile per i tre esempi precedenti |
| `02-senza-interfacce/DomusControllerWithoutReuse.java` | 20-21 | **Frammento non autonomo** | Schema volutamente incompleto che mostra duplicazione e scarso riuso |
| `03-domotica-polimorfica/Device.java` | 24-25 | Compilabile | Contratto comune dei dispositivi |
| `03-domotica-polimorfica/Lamp.java` | 8-9, 26 | Compilabile | `Lamp implements Device` |
| `03-domotica-polimorfica/TV.java` | 26, 36 | Compilabile | Implementazione concreta di `Device` |
| `03-domotica-polimorfica/Radio.java` | 24, 26, 31, 37 | Completamento minimo | Corpo omesso dal PDF, aggiunto per rendere autonomo il client |
| `03-domotica-polimorfica/DomusController.java` | 33-35 | Compilabile | Composizione polimorfica mediante `Device[]` |
| `03-domotica-polimorfica/DeviceUtilitiesBefore.java` | 30 | Compilabile | Logica duplicata e overload per tipi concreti |
| `03-domotica-polimorfica/DeviceUtilities.java` | 31, 43 | Compilabile | Un solo metodo riusabile sul tipo `Device` |
| `03-domotica-polimorfica/InterfaceAssignmentsDemo.java` | 28-29 | Compilabile | Interfacce come tipi, assegnamenti e non istanziabilità |
| `03-domotica-polimorfica/UseDomusController.java` | 37 | Compilabile | Client con `Lamp`, `TV` e `Radio` nello stesso controllore |
| `04-binding/BindingDemo.java` | 43-44 | Compilabile con correzioni dichiarate | Tipo statico, tipo runtime, early e late binding |
| `05-implementazione-multipla/Device.java` | 48 | Compilabile | Primo contratto |
| `05-implementazione-multipla/Luminous.java` | 48 | Compilabile | Secondo contratto |
| `05-implementazione-multipla/Lamp.java` | 48 | Completamento minimo | Una classe implementa due interfacce |
| `05-implementazione-multipla/UseMultipleInterfaces.java` | — | Aggiunta didattica | Due viste dello stesso oggetto tramite tipi diversi |
| `06-estensione-interfacce/Device.java` | 50 | Compilabile | Contratto di dispositivo |
| `06-estensione-interfacce/Luminous.java` | 50 | Compilabile | Contratto di entità luminosa |
| `06-estensione-interfacce/LuminousDevice.java` | 49-50 | Compilabile | Interfaccia che estende due interfacce |
| `06-estensione-interfacce/Lamp.java` | 50 | Completamento minimo | Implementazione del contratto composto |
| `06-estensione-interfacce/UseLuminousDevice.java` | — | Aggiunta didattica | Client eseguibile |

## Concetti essenziali della dispensa

### Dipendenze tra oggetti

- **Associazione — “uses”**: un oggetto usa temporaneamente un altro oggetto.
- **Composizione — “has-a”**: lo stato di un oggetto contiene riferimenti ad
  altri oggetti. Nelle slide il rombo UML pieno è posto dal lato del
  contenitore.
- **Aggregazione**: forma più debole della composizione; gli oggetti aggregati
  hanno una vita concettualmente autonoma e il loro riferimento può essere
  esposto all'esterno.
- **Specializzazione — “is-a”**: relazione di sottotipo.
- **Delegazione**: un oggetto realizza un'operazione inoltrandola agli oggetti
  che contiene, come `TwoLampsDevice.switchOnBoth()`.

Le molteplicità UML mostrate sono:

- `2` tra `TwoLampsDevice` e `Lamp`;
- `0..N` tra `LampsRow` e `Lamp`;
- `0..N` tra `DomusController` e gli oggetti che rispettano `Device`.

### Notazione UML usata

Un class diagram rappresenta una classe con tre aree: nome, campi e metodi.

- `-` indica un membro privato;
- `+` indica un membro pubblico;
- la sottolineatura indica un membro statico;
- il rombo indica composizione;
- la freccia indica associazione;
- il triangolo indica generalizzazione;
- una linea tratteggiata con triangolo indica `implements`;
- `<<Interface>>` identifica un'interfaccia.

### Interfacce come contratti e tipi

`Device` separa il contratto dall'implementazione. Una variabile di tipo
`Device` può riferire un oggetto di qualsiasi classe che implementi quel
contratto, ma attraverso quella variabile sono visibili soltanto le operazioni
dichiarate da `Device`.

```java
Device device = new Lamp();
device.switchOn();       // consentito dal contratto
// device.brighten();    // non dichiarato da Device
```

Un'interfaccia non è istanziabile:

```java
// new Device(); // errore
```

### Sottotipi, sostituibilità e polimorfismo

Se `Lamp implements Device`, allora `Lamp` è sottotipo di `Device`. Il
principio di sostituibilità di Liskov afferma che un oggetto del sottotipo deve
poter essere usato dove il programma si aspetta il supertipo.

`DomusController` sfrutta questa proprietà: dipende soltanto da `Device`, non
da `Lamp`, `TV` o `Radio`. Aggiungere una nuova implementazione non richiede
un nuovo ciclo in `switchAll`.

### Tipo statico, tipo runtime e binding

In:

```java
Device device = new Lamp();
```

- il tipo statico di `device` è `Device`;
- il tipo runtime dell'oggetto è `Lamp`.

Le chiamate ai metodi d'istanza usano **late/dynamic binding**: il corpo viene
scelto in base alla classe runtime. I metodi statici usano invece
**early/static binding**.

### Altri meccanismi delle interfacce

Secondo le slide:

- un'interfaccia non contiene campi d'istanza o costruttori;
- i metodi astratti dell'interfaccia sono implicitamente `public`;
- una classe può implementare più interfacce;
- un'interfaccia può estendere più interfacce;
- Java permette campi statici, metodi statici e, da Java 8, metodi `default`.

Il PDF cita questi ultimi meccanismi ma **non presenta un sorgente completo**
con metodi `default` o statici; per fedeltà non è stato inventato un ulteriore
esempio.

Esempi di libreria citati nelle slide:

- `java.lang.Appendable`;
- `java.io.DataInput`;
- `java.io.Serializable`, interfaccia marker;
- `javax.swing.Icon`;
- `ImageIcon implements Icon, Serializable, Accessible`;
- `ObjectInput extends DataInput`.

## Ricostruzioni e differenze rispetto alle slide

1. A pagina 9 il corpo di `Lamp.toString()` è tagliato dal bordo della slide.
   È stata aggiunta una rappresentazione minima, chiaramente marcata nel file.
2. A pagina 21 `DomusController` è volutamente schematico e usa classi non
   definite in quel frammento. È conservato come non autonomo.
3. Le pagine 26, 48 e 50 sostituiscono parti delle implementazioni con `...`.
   Sono stati aggiunti soltanto stato e metodi minimi necessari alle demo,
   marcandoli come completamenti tecnici.
4. A pagina 44 erano presenti il refuso `implememts`, metodi implementativi
   senza `public` e codice client fuori da una classe. Sono stati corretti e
   raccolti in `BindingDemo.main`.
5. I file `UseComposition`, `UseMultipleInterfaces` e `UseLuminousDevice`
   sono client aggiunti per poter avviare e osservare gli esempi.

## Verifica

Tutte le 52 pagine sono state considerate. Le slide con codice sono state
controllate anche quando l'estrazione testuale separava le lettere o tagliava
il layout; le pagine UML 16, 17, 19 e 20 sono state ispezionate graficamente.

Esito della compilazione:

- **23 sorgenti compilabili verificati con successo** tramite `javac`;
- eseguiti con successo `UseComposition`, `InterfaceAssignmentsDemo`,
  `UseDomusController`, `BindingDemo`, `UseMultipleInterfaces` e
  `UseLuminousDevice`;
- `02-senza-interfacce/DomusControllerWithoutReuse.java` è l'unico sorgente
  intenzionalmente non compilabile: conserva lo schema parziale della pagina
  21 e dipende dalle classi concrete che la slide non definisce.
