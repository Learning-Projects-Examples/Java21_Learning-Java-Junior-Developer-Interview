# 6. Colloquio Java

## Domande teoria:

1. Puoi spiegare cosa sono le collezioni in Java e menzionare alcune delle interfacce e classi principali del Java Collections Framework?
2. Qual è la differenza tra i modificatori di accesso public, private, protected e default (nessun modificatore) in Java?
3. Cosa sono i thread in Java e perché sono utili nella programmazione?
4. Puoi spiegare il concetto di "serializzazione" in Java e perché è importante?
5. Puoi spiegare cosa sono le "variabili d'istanza" e le "variabili di classe" (statiche) in Java? Qual è la differenza principale tra di loro e in quali situazioni useresti l'una piuttosto che l'altra?


#### 1. Collections
Le Collection servono per organizzare dati in strutture con diverse architetture e fanno parte del Java Collections Framework insieme a Map e Iterator. All'interno sono presenti le interfacce: **List Set** e **Queue.** List si suddivide a sua volta in *ArrayList,* *LinkedList* e *Vector*, Set in *HashSet* e *TreeSet* e Queue in *Priority*. Ogni struttura ha una propria caratteristica Strutturale e quindi anche un'ipotetico impiego diverso: ad esempio i Set rimuovono automaticamnete i duplicati: nel caso dell'HashSet l'architettura segue quella dell'HashTable posizionando ogni elemento in un hash casuale e non garantendo ordinamento. Mentre nel caso dell' HashMap l'archjitettura è quella ad albero in grado di ordinare automaticamente il contenuto. Nel caso delle List ArrayList ha una struttura che facilta l'insertimento perchè non conserva l'ordine di inserimento alc ontrario di LinkedList data la sua struttura a catena.


#### 2. Modidicatori di accesso
I modificatori di accesso sono una componente fondamentale per wuanto riguarda il concetto di incapsulamento in java. Gestiscono quello che è l'accesso alle componenti di un programma.
- `Public` consente l'accesso ovunque,
- `Private` accessibilità all'interno della classe
- `Protected` consente l'accesso alle classi e sottoclassi all'ineterno dello stesso package
- `Default` (che si ottiene quando non si specifica alcun modificatore) accessibilità solo dalle classi dello stesso package.


#### 3. Thread
I thread in Java sono unità di esecuzione all'interno di un processo. Sono utili nella programmazione per diversi motivi:

- **Multitasking:** Permettono l'esecuzione concorrente di più attività all'interno dello stesso programma.
- **Migliori prestazioni:** Sfruttano al meglio i processori multi-core, distribuendo il carico di lavoro.
- **Reattività:** Mantengono l'interfaccia utente reattiva mentre si eseguono operazioni lunghe in background.
- **Condivisione risorse:** I thread condividono lo stesso spazio di memoria, facilitando la comunicazione.
- **Efficienza:** Sono più efficienti in termini di risorse rispetto ai processi separati.
- **Modularità:** Consentono di strutturare il codice in modo più modulare e organizzato.
- **Gestione I/O:** Migliorano le prestazioni nelle operazioni di input/output.

Per creare un Thread in Java è necessario estendere la classe Thread o implementando l'interfaccia Runnable.



#### 4. Serializzazione
La serializzazione è un meccanismo in Java che permette di convertire lo stato di un oggetto in una sequenza di byte. Questo processo è fondamentale per:

* Trasferire oggetti attraverso la rete (ad esempio, in applicazioni client-server).
* Salvare lo stato di un oggetto su un supporto di memorizzazione persistente (come un file o un database).
* Passare oggetti tra diverse Java Virtual Machines (JVMs).

Per rendere un oggetto serializzabile, la sua classe deve implementare l'interfaccia `java.io.Serializable.` Questa è un'interfaccia marker che non contiene metodi, ma segnala al compilatore che l'oggetto può essere serializzato.


##### Sinstassi:
```java
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    // ... costruttori e metodi ...
}
```


La serializzazione è importante per diverse ragioni:

* **Persistenza:** Permette di salvare lo stato di un'applicazione e ripristinarlo successivamente.
* **Comunicazione:** Facilita lo scambio di dati complessi tra sistemi diversi.
* **Caching:** Può essere usata per memorizzare temporaneamente oggetti in cache.



#### 5. Variabili di istanza vs Variabili di classe
| Caratteristica | Variabili d'istanza | Variabili di classe (statiche) |
|----------------|---------------------|--------------------------------|
| Dichiarazione | All'interno della classe, fuori dai metodi | All'interno della classe, con keyword 'static' |
| Copia | Ogni istanza ha la propria copia | Una sola copia condivisa per tutte le istanze |
| Inizializzazione | Quando viene creata un'istanza della classe | Quando la classe viene caricata in memoria |
| Valori | Possono variare tra le istanze | Uguali per tutte le istanze |
| Accesso | Attraverso i metodi dell'istanza | Direttamente attraverso il nome della classe |
| Esistenza | Esistono finché esiste l'oggetto | Esistono finché la classe è caricata in memoria |
| Memoria | Occupano memoria per ogni istanza | Occupano memoria una sola volta per classe |
| Uso tipico | Dati specifici dell'oggetto | Dati condivisi, contatori, costanti di classe |

##### Esempio:
```java
public class Car {
    private String model;  // Variabile d'istanza
    private static int totalCars = 0;  // Variabile di classe

    public Car(String model) {
        this.model = model;
        totalCars++;  // Incrementa il contatore statico
    }

    public static int getTotalCars() {
        return totalCars;
    }
}
```


## Analisi del codice:

```java
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public void decrement() {
        count.decrementAndGet();
    }

    public int getValue() {
        return count.get();
    }
}
```

#### Scopo della Classe
La classe `ThreadSafeCounter` implementa un contatore thread-safe, progettato per funzionare correttamente in un ambiente multi-thread.

#### Componenti Chiave

* **Variabile di Istanza**
```java
private AtomicInteger count = new AtomicInteger(0);
```
- Utilizza `AtomicInteger` invece di `int` per garantire operazioni atomiche thread-safe.
- Inizializzato a 0.

* **Metodi**
- Incremento
```java
public void increment() {
    count.incrementAndGet();
}
```
- Utilizza `incrementAndGet()` di `AtomicInteger` per un incremento atomico.
- Garantisce thread-safety senza necessità di sincronizzazione esplicita.

* Decremento
```java
public void decrement() {
    count.decrementAndGet();
}
```
- Simile a `increment()`, ma utilizza `decrementAndGet()` per un decremento atomico.

* Lettura del Valore
```java
public int getValue() {
    return count.get();
}
```
- Restituisce il valore corrente del contatore in modo thread-safe.

#### Vantaggi in Ambiente Multi-thread
1. **Atomicità**: Tutte le operazioni sono atomiche, evitando race conditions.
2. **Performance**: Utilizza tecniche come Compare-and-Swap (CAS), più efficienti dei lock tradizionali.
3. **Semplicità**: Elimina la necessità di sincronizzazione manuale.
4. **Consistenza**: Garantisce letture e scritture consistenti anche con accessi concorrenti.


## Scrittura codice:

Scrivi una classe Java chiamata FileAnalyzer che accetta il percorso di un file di testo come input e fornisce i seguenti metodi:

- `int countWords():` conta il numero totale di parole nel file.
- `Map<String, Integer> getTopNWords(int n):` restituisce una mappa delle N parole più frequenti e il loro conteggio, ordinate per frequenza decrescente.
- `double averageWordLength():` calcola la lunghezza media delle parole nel file.

```java
package ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileAnalyzer {

    private final String FILE_PATH;
    private List<String> words;

    public FileAnalyzer(String filePath) throws IOException {
        FILE_PATH = filePath;
        words = readFile();
    }

    public int countWords() throws IOException {
        return words.size();
    }

    public Map<String, Integer> getTopNWords(int n) throws IOException {
        Map<String, Long> wordFrequency = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long maxCount = Collections.max(wordFrequency.values());

        return wordFrequency.entrySet().stream()
                .filter(e -> e.getValue() == maxCount)
                .sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public double averageWordLength() throws IOException {
        return words.stream().mapToInt(String::length).average().getAsDouble();
    }

    private List<String> readFile() throws IOException {
        words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                words.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        return words;
    }


}

```





