# 5. Colloquio Java: 

## Domande teoria:

1. Cos'è il multithreading in Java e quali sono i vantaggi del suo utilizzo?
2. Spiega il concetto di "final" in Java. Come può essere applicato a variabili, metodi e classi? 
3. Cosa sono gli stream in Java e come possono essere utili nella programmazione? 
4. Descrivi il concetto di "try-with-resources" in Java. Quando e perché lo utilizzeresti? 
5. Cos'è l'annotation @Override in Java e perché è importante usarla?


#### 1. Multithreading
Innanzitutto un *Thread* è un'unità di esecuzione indipendente all'interno di un processo.
Il **multithreading** in Java è una tecnica di programamzione che consiste nel processo di esecuzione di due o più di questi thread simultaneamente.
Java offre supporto nativo per il multithreading attraverso la classe `Thread` e l'interfaccia `Runnable`.
Quello del multithreading è un processo noto come *Concurrency* perché ogni Thread è eseguito parallelamente all'altro. 
C'è da considerare che più Thread non allocano spazio di memoria differente quindi c'è un significativo risparmio di risorse in memoria. 
Ci sono numerosi vantaggi nell'utilizzo del multithrading tra i principali:
- Sono indipendenti, quindi gli utenti possono eseguire più operazioni alla volta
- Se un thread solleva un'eccezione, proprio per la loro indipendenza, gli altri non verranno bloccati
- Migliorano le prestazioni dell'applicazione, sfruttando al meglio le moderne CPU multi-core
- Consentono una migliore reattività dell'interfaccia utente nelle applicazioni grafiche


Tuttavia, il multithreading introduce anche delle sfide, in particolare quando più thread accedono a risorse condivise. Qui entra in gioco il concetto di **synchronization**.
La sincronizzazione in Java viene implementata utilizzando la keyword `synchronized`: Questo meccanismo serve a garantire che solo un thread alla volta possa accedere a una risorsa condivisa o eseguire un blocco di codice critico. 


Quando utilizzare synchronized:
- Quando più thread accedono e modificano la stessa variabile condivisa 
- Quando si vuole evitare condizioni di race (race conditions)
- Per implementare sezioni critiche del codice che devono essere eseguite atomicamente
Il modificatore `synchronized` può essere applicato a metodi o a blocchi e inq uesti contesti previene l'accesso concorrente a risorse condivise, garantisce la consistenza dei dati, aiuta a evitare problemi come deadlock e race conditions.
C'è comunque da considerare che può ridurre le prestazioni se usata eccessivamente o portare a deadlock.
È importante tenere a mente alcune linee guida:
- Sincronizzare solo le parti di codice che effettivamente necessitano di protezione 
- Evitare di sincronizzare blocchi di codice troppo grandi per non compromettere le prestazioni 
- Utilizzare strutture dati thread-safe come `ConcurrentHashMap` o `AtomicInteger` quando possibile


#### 2. Final
`final` è un modificatore di stato utilizzato in Java per definire le parti di codice in cui sono necessari comportamenti costanti e immutabili. 
Può essere utilizzato in tre contesti diversi:
- Variabili: `public final String DB_NAME = "db_test;`
- Metodi: `public final void deposit(BigDecimal import) {}`
- Classi: `public final class Configuration {}`


Se la keyword viene applicata alla variabile una volta assegnate, non possono essere riassegnate. Garantisce così che i valori non cambino, riducendo gli errori e comunica l'intento che certi valori non devono essere modificati.
Per le variabili di istaza devono essere inizializzate al moemnto della dichiarazione o nel costruttore. 
Le variabili locali final quando assegnate non possono essere riassegnate creando così costanti nei metodi.
Qunado utilizzate come parametri dei metodi non possono essere modificate all'interno dei metodi. 
Quando vi è un riferimento final per gli oggetti il riferimento non può essere cambiato, ma l'oggetto stesso può essere modificato (se mutabile). Per oggetti mutabili, final impedisce solo la riassegnazione del riferimento, non la modifica dell'oggetto stesso.


Se la keyword viene applicata al metodo impedisce alle sottoclassi di sovrascrivere il metodo mantenendo il comportamento roiginale (anche se si usa `@Override`). Si stipula così una sorta di contratto di classe che garantisce che il comportamento del metodo rimanga costante in tutte le sottoclassi. Viene utilizzato soprattutto  per la sicurezza in ambienti multithreading riducendo il rischio di comportamenti inaspettati in scenari concorrenti. Ad esempio nel metodo `public final void deposit(BigDecimal import) {}` immaginato all'interno di un contesto bancario all'interno classe `baseAccount{}` che è estesa da `savingsAccount{}`, non può essere sovrascritto nella lasse figlia. In questo modo viene garantito che l'operazione di deposito sia univoca per tutte le classi creando un comportamento immutabile.


Se la keyword viene applicata alla classe significa che questa non può essere ereditata rendendo così impossibile modificare il comportamento della classe. Indica inoltre che la classe è stata progettata per non essere estesa, chiarendo le intenzioni del progettista. Ad esempio nella classe `public final class Configuration {}` permette di stabilire una configurazione immutabile magari con un nome del server e una porta che non possono o devono essere modificati.


#### 3. API Stream
Gli Stream sono una funzionalità introdotta con Java 8 che permettono di processare sequenze di elementi in modo dichiarativo.
Non memorizzano i dati: ma riescono a "spostare" i dati da una fonte a una destinazione, applicando trasformazioni lungo il percorso.
Uno dei maggiori vantaggi degli stream è la loro natura lazy. Ciò significa che le operazioni non vengono eseguite immediatamente, ma solo quando è necessario, migliorando così l'efficienza, soprattutto quando si lavora con grandi quantità di dati.
Sono utilizzati sopratutto sulle operazioni su collezioni. Invece di scrivere loop espliciti e gestire manualmente l'iterazione, gli stream ci permettono di esprimere cosa vogliamo fare con i dati in un modo più dichiarativo.


Esistono due tipi di operazioni eseguite dagli stream:
- **Operazioni intermedie:**
    Queste operazioni restituiscono un nuovo stream, permettendo di concatenare più operazioni. Non producono un risultato finale e non modificano lo stream originale. Esempi includono `filter(), map(), flatMap(), distinct(), sorted(),` ecc. 
  - **Operazioni terminali:**
  Queste operazioni producono un risultato o un "side-effect" e terminano lo stream. Dopo un'operazione terminale, lo stream non può essere riutilizzato. Alcune operazioni terminali restituiscono un valore `(come collect(), reduce(), findFirst(), count())`, mentre altre possono sembrare "void" perché eseguono un'azione senza restituire un valore esplicito `(come forEach() o forEachOrdered())`.

Confronto tra approccio classico e con stream:

```java
 
public static double doAverage(List<Integer>  numbers) {
int sum = 0;
    for (int n :  numbers) {
        sum += n;
    }
    
    return (double) sum / numbers.size();
}

public static double doAverageWithStream(List<Integer> numbers) {
    return numeri.stream()
                 .mapToInt(Integer::intValue)
                 .average()
                 .orElse(0.0);
    }
   
```


#### 4. Try With Resources
Il concetto "try-with-resources" in Java è un costrutto introdotto in Java 7 per gestire in modo più semplice e sicuro le risorse che devono essere chiuse dopo l'uso. È particolarmente utile quando si lavora con risorse come file, connessioni di rete o database.
I punti chiave sono i seguenti:
- **Sintassi:** Usa un blocco try con parentesi tonde () dopo la parola chiave try, dove si dichiarano e inizializzano le risorse. 
- **Chiusura automatica:** Le risorse dichiarate nel blocco try-with-resources vengono chiuse automaticamente alla fine del blocco, indipendentemente dal fatto che si verifichi un'eccezione o meno. 
- **Implementazione di AutoCloseable:** Le risorse utilizzate devono implementare l'interfaccia AutoCloseable. 
- **Ordine di chiusura:** Le risorse vengono chiuse in ordine inverso rispetto alla loro dichiarazione.

##### Esempio di utilizzo:
```java

try (FileInputStream fis = new FileInputStream("file.txt");
     BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}

```
**Quando utilizzarlo:**
- Con risorse che devono essere chiuse dopo l'uso (file, connessioni, ecc.). 
- Per evitare memory leak o altri problemi legati a risorse non chiuse correttamente. 
- Si desidera rendere il codice più pulito e leggibile, eliminando la necessità di blocchi finally espliciti per chiudere le risorse. 
- Per gestire in modo più robusto le eccezioni che potrebbero verificarsi durante la chiusura delle risorse.


#### 5. @Override
L'annotation `@Override`è un annotazione *built-in* che serve a indicare che un metodo in una sottoclasse sta sovrascrivendo un metodo della sua superclasse o implementando un metodo di un'interfaccia. 


È importante perché:
- **Chiarezza del codice:**
    Rende esplicita l'intenzione del programmatore di sovrascrivere un metodo.
    Migliora la leggibilità del codice, rendendo immediatamente chiaro quali metodi sono sovrascritti. 
- **Prevenzione degli errori:**
    Se si usa `@Override` su un metodo che non sta effettivamente sovrascrivendo o implementando nulla, il compilatore genererà un errore. Aiuta a catturare errori comuni come refusi nei nomi dei metodi o firme non corrispondenti. 
- **Sicurezza durante il refactoring:**
    Se il metodo nella superclasse viene modificato, il compilatore segnalerà un errore nei metodi annotati con `@Override` nelle sottoclassi, evidenziando potenziali problemi.


##### Esempio di utilizzo:
```java
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    // Compiler error ->
    // @Override
    // public void makeSound(String loudness) {
    //     System.out.println("Woof " + loudness + "!");
    // }
}
```

Il metodo `makeSound()` in `Dog` è correttamente annotato con `@Override`, indicando che sta sovrascrivendo il metodo della classe `Animal.`
Il metodo commentato con una firma diversa `makeSound(String loudness)` causerebbe un errore di compilazione se l'annotation `@Override` fosse decommentata, poiché non esiste un metodo corrispondente nella superclasse da sovrascrivere.


## Analisi del codice:

```java
public class ConcurrentModificationExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        for (String item : list) {
            System.out.println(item);
            if (item.equals("Two")) {
                list.remove(item);
            }
        }
    }
}
```

##### Struttura:
All'interno viene eseguito e imlementato tutto all'interno del main.
Viene inizializzata una lista con il tipo ArrayList e dopodichè aggiunte all'interno tre Stringhe.
Dopo di chè viene eseguito un ciclo.


##### Funzionamento: 
Il loop for-each itera sugli elementi della lista stampando gli elementi. Quando all'interno del blocco condizionale if si verifica che l'elemento corrisponde a "Two" l'elemento viene rimosso. Nella lista saranno presenti "One" e "Three".
In Console di vedranno invece "One" e "Two". Questo perchè nel momento in cui "Two" viene rimosso la grandezza viene ridimensionata e il ciclo viene eseguito su una size che corrisonde a 2 già "ciclata".


##### Miglioramento:

```java

public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("One");
    list.add("Two");
    list.add("Three");

    list.removeIf(item -> item.equals("Two"));

    for (String item : list) {
        System.out.println(item);
    }
}

```

## Scrittura codice:
Scrivi una funzione in Java che accetta un array di interi e un intero k come parametri. La funzione deve trovare e restituire il k-esimo elemento più grande nell'array.
- L'array può contenere duplicati. 
- Puoi assumere che k sia sempre valido, 1 ≤ k ≤ lunghezza dell'array.

```java

import java.util.Arrays;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums1, 2)); // Output: 5

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums2, 4)); // Output: 4
    }
}


```




