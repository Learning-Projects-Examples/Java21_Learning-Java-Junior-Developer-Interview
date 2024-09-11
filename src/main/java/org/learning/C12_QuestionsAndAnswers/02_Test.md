# Java interview - Second simulation:

1. Puoi spiegarmi cosa sono i costruttori in Java e qual è il loro scopo principale?
    I costruttori alcuni dei principali metodi di Java: hanno lo stesso nome della classe che "costrusicono" e non hanno alcun tipo di ritorno. Permettono di "costruire un oggetto" che viene poi istanziato attraverso al keyword new. C'è molto margine di personalizzazione per quando riguarda i costruttori: si può avere ad esempio un costruttore vuoto, uno con tutti glia rgomenti, unoc he prende solo alcuni argomenti a secodna dell'esigenza.
    Prendiamo ad esempio uan classe Book presente all'interno di un sistema BookStore, potrebbe magari essere possibile inserire dei campi nulli ad esempio "NewEdition" o "Award". In questo caso è per esempio necessario impostare un costruttore che ometta questi due parametri.


2. Qual è la differenza tra una classe astratta e un'interfaccia in Java?
   Le classi astratte vengono definite attraverso la keyword abstract che precede la keyword class, mentre le interface sono definite attraverso la keyword interface. Innanzitutto le classi astratte vengono ereditate mentre le interfacce vengono implementate. All’interno delle classi astratte i metodi possono essere implementati, mentre nelle interfacce no. Le classi astratte possono però avere metodi astratti che vengono implementati nelle classi figlie. Le interfacce possono avere solo cambi static e final, le classi astratte no. Una classe può implementare multiple interfacce, ma può estendere solo una classe astratta. In entrambi i casi prevale il concetto di ereditarietà e poliformismo tipico della programmazione ad oggetti.


3. Cosa significa "polimorfismo" nel contesto della programmazione orientata agli oggetti?
   Il poliformismo è la capacità di assumere numerose forme. Sviluppare utilizzando il polimorfismo favorisce l’approccio SOLID, riducendo di gran lunga il boilerplate e incrementando così la riutilizzabilità la manutenibilità. Esistono due tipi di poliformismo: polimorfismo in fase di compilazione (overloading) e polimorfismo in fase di esecuzione (overriding). L’overriding consiste infatti nel riscrivere un metodo ereditato per cambiarne il comportamento e adattarlo alle nostre esigenze. L’overloading ci permette invece di avere più versioni dello stesso metodo, con numero e tipo di parametri diversi. Un esempio potrebbe essere una superclasse Poligono che ha un metodo per generare un area generica. La classe poligono estende ad esempio Quadrato e Rettangolo che definiscono le proprie regole per calcolare l’area. In questo esempio vediamo come il metodo per calcolare l’area può essere implementato in maniere differenti.


4. Puoi descrivere brevemente il concetto di "garbage collection" in Java?
Il Garbage collector è un sistema presente in alcuni linguaggi di programmazione ad esempio in C, C++ o in Java. Consente di liberare lo spazio in memoria partendo dai riferimenti non utilizzati. Nel caso di Java è del tutto automatico: opera in background, può essere influenzato ma non direttamente controllato dal programmatore. Avviene infatti durante il ciclo di vita del programma: gli oggetti sono creati sull'heap (aread i memoria dedicata al prgramma). Durante il ciclo di vita del programma vengono creati nuovi oggetti rendndone alcuni obsoleti. Il garbage collector opera in 3 fasi attraverso dei puntatori: 
 - Marca gli oggetti attivi (differenziandoli da quelli obsoleti)
 - Pulisce gli oggetti obsoleti (svuotando gli spazi di memoria precedentemente occupati)
 - Compatta gli oggetti rimanenti in memoria.


5. Cosa sono le eccezioni in Java e come si gestiscono?
   Le exception derivano dalla classe Throwable insieme ad Error. A loro volta si dividono in Checked e Unchecked. Le Unchecked (che derivano da Runtime Exception) sono quelle che un programmatore non è in grado di prevenire: ad esempio NullPointerException (il caso in cui un valore sia nullo) o ArithmeticException(il caso in cui venga eseguita una divisione per 0). Possono anche non essere dichiarate e gestite. Nel caso delle Checked si fa invece riferimento a quelle Exception prevedibili: ad esempio IOException o SQLException che devono essere dichiarate e gestite. È possibile inoltre creare le proprie Exception personalizzate estendono la classe Exception. Ci sono due modi principali di gestirle: catturandole attraverso un blocco try catch oppure lanciarle e lasciarle alla gestione del programma attraverso la keyword throw.

## Analisi del codice

6. Analizza questo pezzo di codice:

``` java
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
        ListNode nextTemp = current.next;
        current.next = prev;
        prev = current;
        current = nextTemp;
    }
    return prev;
}
```

Il codice definisce una classe ListNode che rappresenta un nodo in una lista concatenata. Ogni nodo ha un valore (val) e un riferimento al nodo successivo (next).
Il metodo reverseList prende come input la testa (head) di una lista concatenata e la inverte.
L'algoritmo utilizza tre puntatori:

prev: inizialmente null, terrà traccia del nodo precedente
current: inizialmente punta alla testa della lista, è il nodo attualmente in esame
nextTemp: usato per memorizzare temporaneamente il prossimo nodo


Il ciclo while continua finché non abbiamo esaminato tutti i nodi (current != null):

Salva il riferimento al prossimo nodo in nextTemp
Inverte il collegamento del nodo corrente facendolo puntare al precedente
Sposta prev al nodo corrente
Sposta current al prossimo nodo (salvato in nextTemp)


Alla fine, prev sarà la nuova testa della lista invertita, quindi viene restituito.

## Scrittura codice
7. Scrivi una funzione che accetta una stringa come input e restituisce true se la stringa è un palindromo, false altrimenti. Un palindromo è una parola, frase, numero o altra sequenza di caratteri che si legge allo stesso modo in entrambe le direzioni, ignorando spazi, punteggiatura e differenze tra maiuscole e minuscole.

```java

public class Main {

    private final String IP = " is palindrome:";

    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }
    public void run() {
        String wordPal = "anna";
        String wordPalUpper = "Anna";
        String wordNotPal = "Ettore";
        String phrasePal = "Ala deed ala";
        System.out.println("\n" + wordPal + IP);
        isPalindrome(wordPal);

        System.out.println("\n" + wordPalUpper + IP);
        isPalindrome(wordPalUpper);

        System.out.println("\n" + wordNotPal+ IP);
        isPalindrome(wordNotPal);

        System.out.println("\n" + phrasePal + IP);
        isPalindrome(phrasePal);

    }

    private boolean isPalindrome(String word) {
        if (word.isEmpty() || word.isBlank()) {
            throw new IllegalArgumentException("Input can't be empty");
        }

        // Create clean version of word
        String cleanWord = word.toLowerCase().replaceAll("\\s+", "");

        // Create reversed version
        String reversedWord = new StringBuilder(cleanWord).reverse().toString();

        // Compare the strings
        System.out.println(cleanWord.equals(reversedWord));
        return cleanWord.equals(reversedWord);
    }


}

```