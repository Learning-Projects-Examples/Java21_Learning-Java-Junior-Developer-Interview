# 4. Colloquio Java: 

## Domande teoria:

1. Puoi spiegare cosa sono i thread-safe singleton in Java e come si implementano?
2. Qual è la differenza tra HashMap e ConcurrentHashMap in Java?
3. Cosa sono le annotazioni in Java e puoi fornire alcuni esempi del loro utilizzo?
4. Puoi spiegare il concetto di "memory leak" in Java e come può essere prevenuto?
5. Cosa sono i metodi default nelle interfacce Java e perché sono stati introdotti?


#### 1. Thread-safe singleton
I **thread-safe singleton** sono un implementazione del pattern creazionale Singleton. Nel contesto multi-thread garantisce la sicurezza.
Il Singleton è un pattern che si assciura che una classe abbia una sola istanza fornando un punto di accesso globale. Thread-safe garantisce che il codice possa essere eseguito in sicurezza da più thread senza casusare prblemi di concorrenza.
Un Singleton thread-safe combina questi due concetti creando un'unica istanza di una classe che può essere utilizzata in modo sicuro in un ambiente multi-thread.
I modi per implementare un singleton thread-safe in java sono:


- **Inizializzazione Eager**
  - Perché usarla: 
    - Semplicità: È la più semplice da implementare. 
    - Garanzia di thread-safety: L'istanza viene creata al caricamento della classe, quindi non ci sono problemi di race condition.
  - Quando usarla:
    - Quando l'istanza è leggera e viene sempre utilizzata nell'applicazione. 
    - Quando non ci sono eccezioni o logica complessa nella creazione dell'istanza.


- **Inizializzazione Lazy**
  - Perché usarla:
    - Creazione ritardata: L'istanza viene creata solo quando effettivamente necessaria. 
    - Efficienza: Dopo la prima creazione, i controlli aggiuntivi sono minimi. 
  - Quando usarla:
    - Quando la creazione dell'istanza è costosa in termini di risorse. 
    - Quando l'istanza potrebbe non essere sempre necessaria. 
    - In scenari ad alte prestazioni dove la sincronizzazione potrebbe essere un collo di bottiglia.


- **Utilizzo di un enum**
  - Perché usarla:
    - Semplicità e robustezza: Garantisce thread-safety e serializzazione corretta senza sforzo aggiuntivo. 
    - Prestazioni: Le enum in Java sono intrinsecamente thread-safe e efficienti. 
  - Quando usarla:
    - Quando non si necessita di ereditarietà (le enum non possono essere estese).
    - Quando si vuole la massima garanzia di singolarità e thread-safety con il minimo codice.


#### 2. HashMap e ConcurrentHashMap
**HashMap** è una struttura dati in Java che implementa l'interfaccia *Map*. Memorizza coppie chiave-valore e permette l'accesso rapido ai valori tramite le loro chiavi. È efficiente per operazioni di inserimento, ricerca e rimozione. Non garantisce un ordine specifico degli elementi e non è thread-safe, quindi non è sicura per l'uso in ambienti multi-thread senza sincronizzazione esterna.


**ConcurrentHashMap** è una versione *thread-safe* di HashMap, progettata per l'uso in ambienti concorrenti. Offre alte prestazioni per operazioni di lettura e scrittura da parte di più thread contemporaneamente. Internamente, suddivide i dati in segmenti, permettendo l'accesso concorrente a diverse parti della mappa. Non permette chiavi o valori null e fornisce iteratori fail-safe. È ideale per applicazioni multi-thread che richiedono accessi frequenti e concorrenti a una mappa condivisa.


#### 3. Annotazioni in Java
Le annotazioni in Java sono una forma di metadati che forniscono informazioni aggiuntive sul codice. Sono introdotte dal simbolo ` @ ` e possono essere applicate a classi, metodi, variabili, parametri e altri elementi del codice.
Per quanto riguarda la sinstassi vengono quindi scritte ` @AnnotationName `.
Possono essere di due tipI:
 - **Built-in**: presenti "di default" in Java (`@Override, @Deprecated`) 
 - **Personalizzate**: definite attraverso una ` public @interface `
Possono essee applicate a classi, metodi, campi, parametri, ecc.
Sono visibili solo nel codice sorgente. 
Tenedenzialmente vengono utilizzate per generare del codice, per la configurazione nei framework, come analisi del codice o come compilazione condizionale.


Tre le più importanti annotazioni **built-in** ad esempio:
 - `@Override`: Indica che un metodo sovrascrive un metodo della superclasse
 - `@Deprecated`: Marca un elemento come obsoleto
 - `@SuppressWarnings`: Sopprime avvisi specifici del compilatore 
 - `@FunctionalInterface`: Indica che un'interfaccia è funzionale 


#### 4. Memory leak
Un memory leak si verifica quando un programma non riesce a liberare la memoria che non è più necessaria, causando un consumo progressivo e non intenzionale di risorse di sistema. 


Solitamente le cause più comuni sono:
- Riferimenti non rilasciati a oggetti non più utilizzati 
- Uso improprio di strutture dati statiche 
- Chiusura impropria di risorse (file, connessioni di rete, ecc.)
- Implementazioni errate di singleton o cache


Per prevenire questo tipo di fenomeno si consiglia di:
- Gestire correttamente le risorse (uso di try-with-resources in Java)
- Revisionare regolarmente il codice e utilizzare le best practices di programmazione


#### 5. Metodi di default
I metodi default sono un concetto introdotto con Java 8. Si tratta di metodi con un'implementazione definita all'interno di un'interfaccia. Permettono di aggiungere nuovi metodi alle interfacce senza rompere il codice esistente.


##### Sintassi:
```java
public interface MyInterface {
    default void myDefaultMethod() {
        System.out.println("This is a default method");
    }
}
```


- Hanno un'implementazione di default nell'interfaccia 
- Possono essere sovrascritti dalle classi che implementano l'interfaccia 
- Utilizzano la parola chiave `default`
- Sono implicitamente `public`


Sono stati introdotti per numerose ragioni: facilitano infatti l'aggiornamento delle librerie mantenendo la compatibilità con il codice cliet esistente. Permettono di aggiungere nuovi metodi alle interfacce senza rompere le attuali implementazioni. Con i metodi default, le interfacce possono ora fornire implementazioni concrete: una classe può "ereditare" implementazioni da multiple interfacce, simulando in parte l'ereditarietà multipla. 


## Analisi del codice

```java
public class MyClass<T extends Comparable<T>> {
    private T[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public MyClass(int capacity) {
        elements = (T[]) new Comparable[capacity];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            throw new IllegalStateException("MyClass is full");
        }
        int i = size - 1;
        while (i >= 0 && element.compareTo(elements[i]) < 0) {
            elements[i + 1] = elements[i];
            i--;
        }
        elements[i + 1] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return elements[index];
    }

    public int size() {
        return size;
    }
}
```

#### Struttura generale:
Innanzitutto è stata definita una classe hcce estende l'interfaccia *Comparable* utilizzata con i *Generics*. All'interno vi sono poi due variabili di istanza: un array di generics e un primitivo int per definire le dimensioni.
Vi è poi l'annotazione `@SuppressWarnings` sul costruttore per sopprimere gli avvisi del compilatore.
Inizialmente viene definita una capacità a livello di costruttore impostatata come capacità dell'array, la dimensione viene invece inizializzata a 0.
All'interno vi sono 3 metodi principali:
- **add** che prende come argomento un elemento generics e ha come return void
- **get** che prende come argomento un primitivo int e ritorna un generics
- **size** che ritorna la capacità come int


##### Metodo add
Il metodo add è responsabile dell'aggiunta di un elemento a all'interno della classe.
Viene eseguito un primo controllo e se la dimensione corrisponde alla lunghezza degli elementi viene lanciata l'exception `new IllegalStateException`
Se no si definisce un indice con la grandezza - 1. Dopo di che si esegue un ciclo while fino a quando i è >= 0 e nel caso in cui valori non siano ordinati in ordine crescente.
Se non sono ordinati vengono ordinati e spostati gli elementi maggiori per fare spazio al nuovo elemento. Successivamente l'intero elemento viene assegnato all'array e la dimensione aumenta.


##### Metodo get
Il metodo get ritorna invece l'elemento generics in base all'indice. Prima viene eseguito un controllo che lancia `new IndexOutOfBoundsException` quando è fuori capacità.

##### Metodo size 
Ritorna semplicemnte la dimensione dell'array.

#### Funzione
La funzione della classe è quella di creare un sistema per cui vengono aggiunti elementi generics ad un array. Dopo aver istanziato la classe e creato l'oggetto è quindi possibile aggiungere lementi, verificare l'elemento sulla base dell'indice e controllora la dimensione dell'array. Inoltre la classe non permette l'aggiunta di elementi oltre la capacità iniziale (non c'è un ridimensionamento dinamico).


## Scrittura codice 
Scrivi una funzione in Java che accetta una stringa come input e restituisce la lunghezza della sottostringa palindroma più lunga all'interno di essa. Una stringa è considerata palindroma se si legge allo stesso modo da sinistra a destra e da destra a sinistra.
Per esempio:
- Se l'input è "babad", la funzione dovrebbe restituire 3, perché la sottostringa palindroma più lunga è "bab" o "aba".
- Se l'input è "cbbd", la funzione dovrebbe restituire 2, perché la sottostringa palindroma più lunga è "bb".


```java
package test4;

public class PalindromeAdvanced {
    public static void main(String[] args) {
        String wordTest = "aba";
        String secondWordTest = "Ghtsaabbaafr";
        PalindromeAdvanced palindromeAdvanced = new PalindromeAdvanced();
        int result1 = palindromeAdvanced.longestSequenceOfPalindrome(wordTest);
        int result2 = palindromeAdvanced.longestSequenceOfPalindrome(secondWordTest);
        System.out.println("Result of first test is " + result1 + "\n" + "Result of second test is "  + result2);
    }

    private int longestSequenceOfPalindrome(String str) {
        if (str == null || str.isEmpty() || str.length() < 1)
            throw new IllegalArgumentException("Input cant be empty or longest more than 0");

        int maxLength = 0;
        for(int i = 0; i < str.length(); i++) {
            int length1 = expandAroundCenter(str, i, i); //Odd palindrome
            int length2 = expandAroundCenter(str, i, i + 1); //Even palindrome
            maxLength = Math.max(maxLength, Math.max(length1, length2));
        }

        return maxLength;
    }

    private int expandAroundCenter(String str, int left, int right) {
        while (left >= 0
                && right < str.length()
                && str.charAt(left) == str.charAt(right)) {
            left --;
            right++;
        }
        return right - left - 1;
    }
    

}
```

