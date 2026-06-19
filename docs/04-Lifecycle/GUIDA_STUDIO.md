# Guida ragionata a `04-Lifecycle`

## L'idea che sblocca il capitolo

La domanda da fare davanti a ogni campo o metodo è:

> Questa cosa appartiene a **ogni singolo oggetto** oppure alla **classe nel
> suo insieme**?

- Se appartiene al singolo oggetto, è un membro **di istanza** (non `static`).
- Se ne esiste una sola copia condivisa, appartiene alla classe ed è `static`.

Nelle slide “codice dinamico” viene usato informalmente come contrario di
statico. Il termine più preciso in Java è **codice di istanza**. Non va confuso
con il binding dinamico del polimorfismo, che è un altro argomento.

## 1. Statico e istanza nel primo `Point3D`

Apri `01-statico-misto/Point3D.java`.

```java
double x;
double y;
double z;
```

Questi campi non sono statici. Ogni oggetto ha le proprie coordinate:

```java
Point3D p1 = new Point3D();
Point3D p2 = new Point3D();
```

La situazione mentale è:

```text
p1 ──> oggetto Point3D { x, y, z }
p2 ──> altro Point3D   { x, y, z }

classe Point3D ──> zero, max(...)
```

`p1.x` e `p2.x` sono due celle diverse. Invece:

```java
static Point3D zero = new Point3D();
```

crea una sola variabile `zero`, condivisa da tutta la classe. Per questo si usa:

```java
Point3D.zero
```

Il metodo:

```java
double getSquaredModulus()
```

lavora sul punto che riceve la chiamata:

```java
p1.getSquaredModulus();
```

Dentro il metodo, `this` è proprio `p1`.

Il metodo:

```java
static Point3D max(Point3D[] ps)
```

non rappresenta il comportamento di un punto specifico. Riceve tutti i punti
come argomento, quindi si chiama sulla classe:

```java
Point3D.max(array);
```

### Regola pratica

| Forma | Significato | `this` disponibile? |
|---|---|---|
| `oggetto.metodo()` | Operazione su quell'oggetto | Sì |
| `oggetto.campo` | Stato di quell'oggetto | — |
| `Classe.metodo()` | Operazione generale della classe | No |
| `Classe.campo` | Unico valore condiviso | — |

Un metodo statico non può scrivere semplicemente `x` o usare `this.x`, perché
non sa **quale** oggetto dovrebbe scegliere. Può usare `elem.x`, perché `elem`
indica esplicitamente un oggetto.

`main` è statico per lo stesso motivo: la JVM deve poter avviare il programma
prima di aver creato un oggetto della classe.

## 2. Perché le slide sembrano tutte uguali

Stanno trasformando gradualmente lo stesso esempio:

1. `01-statico-misto`: `build`, `zero` e `max` sono tutti in `Point3D`.
2. `02-build-fluente`: `build` restituisce `this`.
3. `03-helper-points`: la parte statica viene spostata nella helper class
   `Points`.
4. `04-costruttore-point3d`: `build` viene sostituito da un vero costruttore.

Il punto non è imparare quattro programmi: è vedere quattro modi di
organizzare la stessa responsabilità.

## 3. `return this` e stile fluente

Nel primo esempio:

```java
Point3D p = new Point3D();
p.build(10, 20, 30);
```

`build` restituisce `void`.

Nella variante fluente, `build` termina con:

```java
return this;
```

Ora il riferimento allo stesso oggetto torna al chiamante:

```java
Point3DBis p = new Point3DBis().build(10, 20, 30);
```

Non vengono creati due oggetti. `new Point3DBis()` crea l'unico oggetto;
`build(...)` lo modifica e restituisce quel medesimo riferimento.

## 4. Perché separare `Point3D` e `Points`

La slide 13 lascia in `Point3D` solo lo stato e il comportamento del singolo
punto. La slide 14 mette le operazioni generali in `Points`:

```java
Point3D p = new Point3D().build(1, 2, 3);
Point3D zero = Points.zero;
Point3D massimo = Points.max(array);
```

È lo stesso schema di libreria:

```text
Object      / Objects
Collection  / Collections
Array       / Arrays
Point3D     / Points
```

Nota importante: `Points.zero` non è davvero immutabile. È un riferimento
statico a un oggetto modificabile. Più avanti si userebbero `final`, campi
privati e immutabilità per proteggerlo meglio.

## 5. Costruttori e `new`

Con:

```java
Point3D p = new Point3D(10, 20, 30);
```

succedono tre cose:

1. viene allocato un nuovo oggetto;
2. i campi ricevono inizialmente i valori di default (`0.0`);
3. viene eseguito il costruttore, con `this` riferito al nuovo oggetto.

Nel costruttore:

```java
Point3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
}
```

- `this.x` è il campo dell'oggetto;
- `x` è il parametro ricevuto.

Appena dichiari un costruttore con argomenti, Java non aggiunge più
automaticamente quello vuoto. Quindi `new Point3D()` non funziona, a meno che
tu non dichiari esplicitamente anche `Point3D()`.

## 6. Overloading dei costruttori

`Person` ha tre costruttori con lo stesso nome ma parametri diversi:

```java
new Person("Mario");
new Person("Gino", 1979);
new Person("Carlo", 1971, true);
```

Il compilatore sceglie usando **numero e tipi degli argomenti**. Il tipo di
ritorno non può distinguere due metodi sovraccarichi.

In `Person` il codice di inizializzazione è ripetuto. `Person2` lo migliora:

```java
Person2(String name, int birth) {
    this(name, birth, false);
}
```

Qui `this(...)` non significa “questo oggetto” usato come valore: significa
“chiama un altro costruttore della stessa classe”. Deve essere la prima
istruzione del costruttore.

## 7. Overloading dei metodi

In `ExampleOverloading`:

```java
m(double, int)
m(int, double)
```

La chiamata `m(1, 1)` è ambigua: Java potrebbe convertire il primo oppure il
secondo `int` in `double`, senza una scelta migliore.

La chiamata `m(1.5, 1.5)` non è compatibile: convertire `double` in `int`
richiederebbe un restringimento non automatico.

Invece:

```java
m2(1.5, 1.5); // sceglie m2(double, double)
m2(1, 1);     // sceglie m2(int, int)
```

## 8. Package e livelli di accesso

Un package organizza classi correlate. Se un file dichiara:

```java
package it.unibo.esempio;
```

deve trovarsi, rispetto alla radice dei sorgenti, nel percorso:

```text
it/unibo/esempio/
```

I livelli introdotti nelle slide sono:

| Modificatore | Chi può accedere |
|---|---|
| `public` | Qualunque classe |
| nessun modificatore | Solo classi dello stesso package |
| `private` | Solo la classe che dichiara il membro |

Una classe top-level `public` deve stare in un file con lo stesso nome:
`public class Complex` richiede `Complex.java`.

## 9. `final` e le costanti

```java
private static final int SIZE = 100;
```

Leggila da destra verso sinistra:

- `int`: è un intero;
- `final`: dopo l'assegnazione non può cambiare;
- `static`: ne esiste una sola copia per la classe;
- `private`: è utilizzabile solo dentro `MagicExample`.

Le costanti vengono scritte in `MAIUSCOLO_CON_UNDERSCORE`.

`SIZE` rende comprensibile il significato di `100` e permette di modificarlo
in un solo punto. Un numero scritto direttamente senza spiegazione viene
chiamato “magic number”.

## 10. Memoria e garbage collector

Ogni `new` alloca un oggetto nell'heap. Un oggetto resta utilizzabile finché è
raggiungibile tramite almeno un riferimento attivo.

```java
Point3D p = new Point3D();
p = null;
```

Se nessun altro riferimento punta a quell'oggetto, esso diventa idoneo alla
raccolta. Non viene necessariamente eliminato subito: il garbage collector
decide quando intervenire.

`GC.java` crea oggetti senza conservare i riferimenti. Diventano quindi
rapidamente irraggiungibili e la JVM può recuperare la loro memoria. Il
programma usa intenzionalmente un ciclo infinito ed è solo dimostrativo.

Il garbage collector recupera memoria, ma non sostituisce la chiusura esplicita
di file, socket o altre risorse esterne.

## 11. Come leggere Mandelbrot senza perdersi

Le responsabilità sono separate:

- `Complex`: rappresenta **un** numero complesso; i suoi metodi sono di istanza.
- `Mandelbrot`: conserva posizione e configurazione del calcolo; quasi tutto è
  di istanza.
- `Mandelbrot.MAX_PRODUCT`: è una costante unica, quindi `static final`.
- `MandelbrotApp`: contiene configurazione generale e `main`, quindi usa
  membri statici.
- `Picture`: dipendenza grafica fornita separatamente, assente nel PDF.

Questa applicazione riunisce tutto il capitolo: oggetti con stato, costruttori,
metodi di istanza, costanti statiche e una classe di avvio.

## Ordine consigliato per studiare i sorgenti

1. Esegui `01-statico-misto/UsePoint3D`.
2. Confronta soltanto le righe cambiate in `02-build-fluente`.
3. Confronta `01-statico-misto/Point3D` con la coppia
   `03-helper-points/Point3D` e `Points`.
4. Passa a `04-costruttore-point3d` e osserva che `build` scompare.
5. Studia insieme `Person` e `Person2`.
6. Chiudi con `MagicExample`, `GC` e le tre classi Mandelbrot.

La frase da tenere in testa è:

> L'istanza descrive **questo oggetto**; `static` descrive **la classe in
> generale**.
