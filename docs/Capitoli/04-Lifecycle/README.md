# 04-Lifecycle — codice estratto

Sorgente: `../04-Lifecycle.pdf`

- Pagine analizzate: **43 su 43**
- Slide con codice o frammenti Java: **19**
- File Java prodotti: **19**
- Versione usata per la verifica: **JDK 21**

La formattazione è stata normalizzata, ma nomi, valori e comportamento sono
quelli delle slide. Le diverse versioni di `Point3D` sono in directory separate
per evitare conflitti tra classi omonime.

Per capire il capitolo partendo dal codice, leggere
[GUIDA_STUDIO.md](./GUIDA_STUDIO.md).

## Inventario

| Directory e file | Pagine | Stato | Note |
|---|---:|---|---|
| `01-statico-misto/Point3D.java` | 6 | Compilabile | Campi e metodi di istanza insieme a membri statici |
| `01-statico-misto/UsePoint3D.java` | 7 | Compilabile | Uso di receiver oggetto e receiver classe |
| `02-build-fluente/Point3DBis.java` | 9 | Compilabile | `build` restituisce `this` |
| `02-build-fluente/UsePoint3DBis.java` | 10 | Compilabile | Concatenazione `new ...().build(...)` |
| `03-helper-points/Point3D.java` | 13 | Compilabile | Classe di istanza senza parte statica |
| `03-helper-points/Points.java` | 14 | Compilabile | Helper class con funzionalità statiche |
| `03-helper-points/UsePoint3D.java` | 15 | Compilabile | Uso della separazione `Point3D`/`Points` |
| `04-costruttore-point3d/Point3D.java` | 18-19 | Compilabile | I puntini della slide sono stati lasciati come commento |
| `04-costruttore-point3d/UsePoint3D.java` | 18-19 | Compilabile | Classe contenitore aggiunta per rendere autonome le istruzioni |
| `05-overloading-costruttori/Person.java` | 20 | Compilabile con avviso | Conserva l'uso deprecato di `Date.getYear()` mostrato nella slide |
| `05-overloading-costruttori/UsePerson.java` | 21 | Compilabile con avviso | Mostra la selezione fra tre costruttori |
| `06-this-tra-costruttori/Person2.java` | 22 | Compilabile con avviso | Riutilizzo dei costruttori mediante `this(...)` |
| `07-overloading-metodi/ExampleOverloading.java` | 24 | Compilabile | Chiusura finale della classe esplicitata |
| `08-costanti-final/MagicExample.java` | 32 | Compilabile | Costante `private static final` |
| `08-costanti-final/GuessMyNumberApp.java` | 33 | Compilabile | Può richiedere una console reale durante l'esecuzione |
| `09-garbage-collector/GC.java` | 37 | Compilabile | Ciclo infinito intenzionale: non eseguirlo senza motivo |
| `10-mandelbrot/Complex.java` | 40 | Compilabile | Modello dei numeri complessi |
| `10-mandelbrot/Mandelbrot.java` | 41 | Compilabile | Calcolo delle iterazioni |
| `10-mandelbrot/MandelbrotApp.java` | 42 | Dipendenza esterna | Richiede la classe `Picture`, citata ma non fornita nel PDF |

## Note di fedeltà

- `Person.currentYear` e `Person2.currentYear` usano
  `new java.util.Date().getYear()` come nelle slide. Il metodo è deprecato e
  restituisce l'anno meno 1900: il sorgente è fedele, ma non è un esempio da
  copiare in un programma moderno.
- In `Mandelbrot`, `maxIter` è un `double` anche se il costruttore riceve un
  `int`, come nella slide.
- In `MandelbrotApp.greyColorFromIterations`, il parametro `maxIter` non viene
  usato e il metodo consulta `MAX_ITER`, come nella slide.
- `Picture` non è stata inventata: la slide 39 la descrive come classe fornita
  separatamente e il suo codice non compare nel PDF.

## Compilazione

Ogni directory rappresenta un esempio indipendente. Da PowerShell:

```powershell
Set-Location 01-statico-misto
javac *.java
java UsePoint3D
```

Non compilare in un'unica invocazione tutte le directory: alcune contengono
volutamente classi omonime che rappresentano versioni successive.
