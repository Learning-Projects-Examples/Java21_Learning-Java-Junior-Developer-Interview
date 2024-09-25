# 1. Colloquio Java

## Domante di teoria
1. Puoi spiegare il concetto di ereditarietà in Java e come si implementa?Puoi spiegare il concetto di ereditarietà in Java e come si implementa?
2. Qual è la differenza tra un'interfaccia e una classe astratta in Java?
3. Cosa sono le eccezioni in Java e come vengono gestite?
4. Spiega il concetto di polimorfismo e fai un esempio pratico.
5. Cosa sono i generics in Java e perché sono utili?


#### 1. Ereditarietà
L’ereditarietà è uno dei 3 pilastri della programmazione ad oggetti insieme a poliformismo e incapsulamento. Consente ad una classe figlia di ereditare da una classe padre favorendo così la riutilizzabilità e la manutenibilità. Le classe figlie ereditando attraverso la keyword extends. È un concetto molto utile per andare a definire comportamenti specifici partendo da comportamenti più generici. Prendiamo l’esempio di una super classe Persona che è ereditata sia dalla sottoclasse Studente che Insegnate. La classe persona potrebbe avere un metodo generico “saluta” utile in entrambe le sottoclassi. Tuttavia la classe studente potrebbe avere un metodo “salutaProfessore”, così come la classe Insegnate potrebbe avere un ulteriore metodo “salutaAlunni”.


#### 2. Classe astratta vs interfaccia
Le classi astratte vengono definite attraverso la keyword abstract che precede la keyword class, mentre le interface sono definite attraverso la keyword interface. Innanzitutto le classi astratte vengono ereditate mentre le interfacce vengono implementate. All’interno delle classi astratte i metodi possono essere implementati, mentre nelle interfacce no. Le classi astratte possono però avere metodi astratti che vengono implementati nelle classi figlie. Le interfacce possono avere solo cambi static e final, le classi astratte no. Una classe può implementare multiple interfacce, ma può estendere solo una classe astratta.
In entrambi i casi prevale il concetto di ereditarietà e poliformismo tipico della programmazione ad oggetti.


#### 3. Exception
Le exception derivano dalla classe Throwable insieme ad Error. A loro volta si dividono in Checked e Unchecked. Le Unchecked (che derivano da Runtime Exception) sono quelle che un programmatore non è in grado di prevenire: ad esempio NullPointerException (il caso in cui un valore sia nullo) o ArithmeticException(il caso in cui venga eseguita una divisione per 0). Possono anche non essere dichiarate e gestite. Nel caso delle Checked si fa invece riferimento a quelle Exception prevedibili: ad esempio IOException o SQLException che devono essere dichiarate e gestite.
È possibile inoltre creare le proprie Exception personalizzate estendono la classe Exception.
Ci sono due modi principali di gestirle: catturandole attraverso un blocco try catch oppure lanciarle e lasciarle alla gestione del programma attraverso la keyword throw.


#### 4. Poliformismo
Il poliformismo è la capacità di assumere numerose forme. Sviluppare utilizzando il polimorfismo favorisce l’approccio SOLID, riducendo di gran lunga il boilerplate e incrementando così la riutilizzabilità la manutenibilità. Esistono due tipi di poliformismo: polimorfismo in fase di compilazione (overloading) e polimorfismo in fase di esecuzione (overriding). L’overriding consiste infatti nel riscrivere un metodo ereditato per cambiarne il comportamento e adattarlo alle nostre esigenze. L’overloading ci permette invece di avere più versioni dello stesso metodo, con numero e tipo di parametri diversi.
Un esempio potrebbe essere una superclasse Poligono che ha un metodo per generare un area generica. La classe poligono estende ad esempio Quadrato e Rettangolo che definiscono le proprie regole per calcolare l’area. In questo esempio vediamo come il metodo per calcolare l’area può essere implementato in maniere differenti.


#### 5. Generics
I generics sono stati introdotti da Java5, e coinvolgono i tipi parametrizzati. Sono molto importanti perché consentono di creare classi e interfacce e metodi per i quali il tipo di dato può essere specificato coem parametro. Vengono espressi attraverso ClassName<T> / oppure ObjectName T. Alcuni caratteri tipici sono T, E, V e K. Aiutano a garantire la type-safety al momento della compilazione. Attraverso un codice generico ad esempio si può creare un algoritmo in grado di estrarre i numeri maggiori i minori di una sequenza. Questo metodo potrebbe (se implementato con i generics) essere utilizzato con tanti tipi di dati: int / double / long.



## Analisi codice

```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num : nums) {
        pq.offer(num);
        if (pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}
```

##### Scopo del metodo:
Il metodo findKthLargest trova il k-esimo elemento più grande in un array di interi. Ad esempio, se k=1, trova l'elemento più grande; se k=2, trova il secondo elemento più grande, e così via.


##### Funzionamento dell'algoritmo:
Utilizza una PriorityQueue come min-heap di dimensione k.
Itera attraverso l'array, inserendo ogni elemento nella coda.
Se la dimensione della coda supera k, rimuove l'elemento più piccolo (in testa alla coda).
Alla fine, la testa della coda conterrà il k-esimo elemento più grande.


##### Struttura dati utilizzata:
PriorityQueue: è usata come min-heap, mantenendo sempre l'elemento più piccolo in testa.
Questa scelta è efficiente perché permette di mantenere solo i k elementi più grandi in ogni momento.


##### Dettagli implementativi:
pq.offer(num): inserisce un nuovo elemento nella coda.
pq.poll(): rimuove e restituisce l'elemento in testa (il più piccolo).
pq.peek(): restituisce, senza rimuovere, l'elemento in testa.


##### Complessità:
Temporale: O(N log k), dove N è la lunghezza dell'array. Ogni inserimento/rimozione nella PriorityQueue costa O(log k).
Spaziale: O(k) per mantenere la PriorityQueue di dimensione k.


##### Vantaggi:
Efficiente per grandi array e piccoli valori di k.
Non richiede di ordinare l'intero array.


##### Limitazioni:
Potrebbe non essere la soluzione più efficiente per k molto grandi o prossimi alla dimensione dell'array.


## Scrittura codice
Scrivi una funzione in Java che accetta un array di interi e restituisce la somma di tutti i numeri pari presenti nell'array.
Per esempio:

Se l'input è [1, 2, 3, 4, 5, 6], la funzione dovrebbe restituire 12 (2 + 4 + 6).
Se l'input è [1, 3, 5, 7], la funzione dovrebbe restituire 0.
Se l'input è [2, 4, 6, 8], la funzione dovrebbe restituire 20.

```java
 private int sumEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    private int sumEvenNumbersClassic(int[] numbers) {
        int sum = 0;
        for (int n : numbers) {
            if (n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }

```
