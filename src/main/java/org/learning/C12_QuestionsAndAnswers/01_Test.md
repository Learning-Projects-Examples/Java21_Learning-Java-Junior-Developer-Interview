# Java interview - First simulation:

1. Puoi spiegare il concetto di ereditarietà in Java e come si implementa?Puoi spiegare il concetto di ereditarietà in Java e come si implementa?
    L’ereditarietà è uno dei 3 pilastri della programmazione ad oggetti insieme a poliformismo e incapsulamento. Consente ad una classe figlia di ereditare da una classe padre favorendo così la riutilizzabilità e la manutenibilità. Le classe figlie ereditando attraverso la keyword extends. È un concetto molto utile per andare a definire comportamenti specifici partendo da comportamenti più generici. Prendiamo l’esempio di una super classe Persona che è ereditata sia dalla sottoclasse Studente che Insegnate. La classe persona potrebbe avere un metodo generico “saluta” utile in entrambe le sottoclassi. Tuttavia la classe studente potrebbe avere un metodo “salutaProfessore”, così come la classe Insegnate potrebbe avere un ulteriore metodo “salutaAlunni”.


2. Qual è la differenza tra un'interfaccia e una classe astratta in Java?
    Le classi astratte vengono definite attraverso la keyword abstract che precede la keyword class, mentre le interface sono definite attraverso la keyword interface. Innanzitutto le classi astratte vengono ereditate mentre le interfacce vengono implementate. All’interno delle classi astratte i metodi possono essere implementati, mentre nelle interfacce no. Le classi astratte possono però avere metodi astratti che vengono implementati nelle classi figlie. Le interfacce possono avere solo cambi static e final, le classi astratte no. Una classe può implementare multiple interfacce, ma può estendere solo una classe astratta.
    In entrambi i casi prevale il concetto di ereditarietà e poliformismo tipico della programmazione ad oggetti.


3. Cosa sono le eccezioni in Java e come vengono gestite
    Le exception derivano dalla classe Throwable insieme ad Error. A loro volta si dividono in Checked e Unchecked. Le Unchecked (che derivano da Runtime Exception) sono quelle che un programmatore non è in grado di prevenire: ad esempio NullPointerException (il caso in cui un valore sia nullo) o ArithmeticException(il caso in cui venga eseguita una divisione per 0). Possono anche non essere dichiarate e gestite. Nel caso delle Checked si fa invece riferimento a quelle Exception prevedibili: ad esempio IOException o SQLException che devono essere dichiarate e gestite.
    È possibile inoltre creare le proprie Exception personalizzate estendono la classe Exception.
    Ci sono due modi principali di gestirle: catturandole attraverso un blocco try catch oppure lanciarle e lasciarle alla gestione del programma attraverso la keyword throw.


4. Spiega il concetto di polimorfismo e fai un esempio pratico.
    Il poliformismo è la capacità di assumere numerose forme. Sviluppare utilizzando il polimorfismo favorisce l’approccio SOLID, riducendo di gran lunga il boilerplate e incrementando così la riutilizzabilità la manutenibilità. Esistono due tipi di poliformismo: polimorfismo in fase di compilazione (overloading) e polimorfismo in fase di esecuzione (overriding). L’overriding consiste infatti nel riscrivere un metodo ereditato per cambiarne il comportamento e adattarlo alle nostre esigenze. L’overloading ci permette invece di avere più versioni dello stesso metodo, con numero e tipo di parametri diversi.
    Un esempio potrebbe essere una superclasse Poligono che ha un metodo per generare un area generica. La classe poligono estende ad esempio Quadrato e Rettangolo che definiscono le proprie regole per calcolare l’area. In questo esempio vediamo come il metodo per calcolare l’area può essere implementato in maniere differenti.


5. Cosa sono i generics in Java e perché sono utili?
    I generics sono stati introdotti da Java5, e coinvolgono i tipi parametrizzati. Sono molto importanti perché consentono di creare classi e interfacce e metodi per i quali il tipo di dato può essere specificato coem parametro. Vengono espressi attraverso ClassName<T> / oppure ObjectName T. Alcuni caratteri tipici sono T, E, V e K. Aiutano a garantire la type-safety al momento della compilazione. Attraverso un codice generico ad esempio si può creare un algoritmo in grado di estrarre i numeri maggiori i minori di una sequenza. Questo metodo potrebbe (se implementato con i generics) essere utilizzato con tanti tipi di dati: int / double / long.


6. Puoi spiegare cosa sono le collezioni in Java e menzionare alcune delle interfacce e classi principali del Java Collections Framework?
    Le Collection servono per organizzare dati in strutture con diverse architetture e fanno parte del Java Collections Framework insieme a Map e Iterator. All'interno sono presenti le interfacce: List Set e Queue. List si suddivide a sua volta in ArrayList, LinkedList e Vector, Set in HashSet e TreeSet e Queue in priority. Ogni struttura ha una propria caratteristica Strutturale e quindi anche un'ipotetico impiego diverso: ad esempio i Set rimuovono automaticamnete i duplicati: nel caso dell'HashSet l'architettura segue quella dell'HashTable posizionando ogni elemento in un hash casuale e non garantendo ordinamento. Mentre nel caso dell' HashMap l'archjitettura è quella ad albero in grado di ordinare automaticamente il contenuto. Nel caso delle List ArrayList ha una struttura che facilta l'insertimento perchè non conserva l'ordine di inserimento alc ontrario di LinkedList data la sua struttura a catena.


7. Qual è la differenza tra i modificatori di accesso public, private, protected e default (nessun modificatore) in Java?
    I modificatori di accesso sono una componente fondamentale per wuanto riguarda il concetto di incapsulamento in java. Gestiscono quello che è l'accesso alle componenti di un programma. 
       - Public consente l'accesso ovunque,
       - Private accessibilità all'interno della classe
       - Protected consente l'accesso alle classi e sottoclassi all'ineterno dello stesso package
       - Default (che si ottiene quando non si specifica alcun modificatore) accessibilità solo dalle classi dello stesso package


8. Cosa sono i thread in Java e perché sono utili nella programmazione?
      I thread in Java sono unità di esecuzione all'interno di un processo. Sono utili nella programmazione per diversi motivi:
   
      - Multitasking: Permettono l'esecuzione concorrente di più attività all'interno dello stesso programma.
      - Migliori prestazioni: Sfruttano al meglio i processori multi-core, distribuendo il carico di lavoro.
      - Reattività: Mantengono l'interfaccia utente reattiva mentre si eseguono operazioni lunghe in background.
      - Condivisione risorse: I thread condividono lo stesso spazio di memoria, facilitando la comunicazione.
      - Efficienza: Sono più efficienti in termini di risorse rispetto ai processi separati.
      - Modularità: Consentono di strutturare il codice in modo più modulare e organizzato.
      - Gestione I/O: Migliorano le prestazioni nelle operazioni di input/output.
      
      Per creare un Thread in Java è necessario estendere la classe Thread o implementando l'interfaccia Runnable.

### Code Analysis

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

### Code 
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
