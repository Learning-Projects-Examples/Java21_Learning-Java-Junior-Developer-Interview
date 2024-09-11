# 3. Colloquio Java: 

## Domande teoria:

1. Puoi spiegare cosa sono i design pattern in Java e fornire un esempio di un pattern comunemente usato?
I design pattern sono soluzioni proposte da programmatori esperti per risolvere problemi comuni allo sviluppo del software. Hanno delle caratteristiche principali tra cui: indipendenza nei confronti del linguaggio di programmaione, definiscono un vocabolario comune, sono basati su principi legati alla OOP. Esistono 3 grandi categorie di design pattern: 
- Structural pattern
- Creational pattern
- Behavioral pattern
Esistono poi altri tipi di pattern specifici per lo sviluppo in Java ad esempio il pattern DAO: che è utilizzato per separare la logica di accesso ai dati dal resto dell'applicazione. Può essere riassunto attraverso queste 3 caratteristiche:
- Fornisce un'interfaccia astratta per l'accesso e la manipolazione di diversi tipi di database o altre fonti di dati. 
- Incapsula la logica di accesso ai dati, rendendo l'applicazione indipendente dal tipo di storage. 
- Facilita la gestione delle connessioni e delle query al database.


2. Qual è la differenza tra ArrayList e LinkedList in Java? In quali scenari preferiresti usare l'uno rispetto all'altro?
Sia ArrayList che LinkedList fanno parte dell'interfaccia List che appartiene al CollectionsFramework. Si tratta di due liste che hanno un tipo di architettura metodi e capacità differenti:


   - Nel caso di ArrayList ci riferiamo ad un tipo di lista che si basa su un array dinamico sottostante usato per memorizzare gli elementi. Quando l'array interno di riempie, l'Arraylist crea automaticamente un nuovo array più grande e lo riempie. 
   Di default ha una capacità iniziale di 10 elementi che può essere modificato e definito al momento della creazione. Uno dei suoi vantaggi principali è l'accesso rapido agli elementi tramite indice. L'inserimento e la rimozione sono efficienti alla fine della lista ma potenzialmnte costosi in mezzo e all'inizio.


   - Nel caso di LinkedList ci riferiamo ad un tipo di lista che si basa su una struttura a catena di nodi, dove ogni nodo contiene un elemento ed un riferimento a un nodo precedente e successivo.  Le operazioni di inserimento e rimozione agli estremi della lista sono molto efficienti. Richiede più memoria rispetto ad ArrayList perché ogni elemento è incapsulato in un nodo che possiede anche riferimenti. Non ha bisogno di ridimensionamento come ArrayList, poiché aggiunge semplicemente nuovi nodi quando necessario. Perde di efficenza con gli accessi casuali.


Nel caso di un eCommerce con rare modifiche sarebbe probabilmente meglio utilizzare ArrayList per via dell'accesso rapido e casuale agli elementi, ha inoltre prestazioni migliori nella lettura sequenziale.
Nel caso di un sistema di gestione di task con aggiunte all'inizio della lista e rimozioni alla fine o inizio della lista sarebbe invece meglio utilizzare LinkedList per via della rimozione efficiente in testa e coda e per il nullo costo di ridimensionamento.


3. Puoi spiegare cosa sono le lambda expressions in Java e come vengono utilizzate?
Le lambda expression sono una feature introdotta da java8 in poi insieme agli Stream, gli Optional e il DateTime. Le lambda in Java permettono di creare una funzione anonima introducendo un nuovo tipo in Java: il tipo funzione anonima che può essere passato coem argomento e restituito a livello di metodo. Consentendo così di poter implementare un metodo nello stesso pezzo di codice in cui è necessario. Sono particolarmente utili quando si devono definire brevi funzioni non riutilizzate. 
A livello architettural si basano su classi anonime e interfacce funzionali. Essenzialmente, quando viene scritta una lambda, il compilatore Java genera una classe anonima che implementa un'interfaccia funzionale corrispondente. Quest'interfaccia funzionale, caratterizzata da un unico metodo astratto, definisce la "forma" della lambda, permettendo così al codice di essere type-safe e compatibile con il sistema di tipi di Java.
Le lambda sono formate da una lista di argomenti e da un Espressione oppure una serie di istruzioni.
Ad esempio
- ` (int x, int y) -> x + y //Prende come argomenti i valori x e y e resituisce l'espressione che consiste nella somma` 
- ` s -> s.length() //Prende un solo argomento (una stringa) e ne restituisce l'espressione: la lunghezza `
- ` () -> 50 //Non prende argomenti in entrata ma restituisce un valore  `
  - ` (String s) -> { System.out.println("Benvenuto ");
                       System.out.println(s); }  //Prende in input una stringa e restituisce una serie die di istruzioni. `


4. Cosa significa "immutabilità" in Java? Puoi fornire un esempio di una classe immutabile?
Un oggetto in Java di dice immutabile quando una volta creato e inizializzato, non può essere più modificato. questi oggetti possono essere manipolati quindi passati come argomenti, chiamare metodi di lettura ma nessun metodo dovrebbe consentire di modificare lo stato Ad esmepio un oggetto di tipo String è immutabile in quanto una volta creato, non è possibile modificarlo. Anche nel caso del metodo trim che rimuove eventuali spazi presenti all’inizio e la  fine della stringa. Questo metodo, come anche gli altri disponibili nella classe String, non modificano l’oggetto a cui vengono applicati ma agiscono su una copia dell’oggetto originario, restituendo appunto un nuovo oggetto con il contenuto modificato.


5. Puoi descrivere il concetto di "reflection" in Java e fornire un esempio di come potrebbe essere utilizzato?
La reflection è la capacità di un programma di esaminare, introspettare e modificare la propria struttura e comportamento durante l'esecuzione. In Java, permette di ispezionare classi, interfacce, campi e metodi a runtime, senza conoscere i nomi a tempo di compilazione.
   - Permette di ottenere informazioni su classi, metodi e campi.
   - Consente di creare istanze, invocare metodi e modificare campi dinamicamente.
   - Può accedere anche a membri privati, bypassando i normali controlli di accesso.
   - Generalmente più lenta dell'accesso diretto, quindi va usata con cautela.
Viene utilizzata principalemnte per Testing, frameworks (come Spring o Hibernate), serializzazione, e plugin systems.

## Analisi del codice

6. Analizza questo pezzo di codice:

``` java
public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
    boolean swapped;
    for (int i = 0; i < array.length - 1; i++) {
        swapped = false;
        for (int j = 0; j < array.length - i - 1; j++) {
            if (array[j].compareTo(array[j + 1]) > 0) {
                T temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}
```
Il codice presentato è un metodo che crea un algoritmo di ordinamento basato sul tipo "Bubble Sort". Utilizza i Generics: prende infatti in un put un array di valori che potrebbero essere int double ...
estende Comparable che è un interfaccia che si occupa di restituire un valore negativo o positivo in base alla comparazione.
All'interno del metodo viene definito un booleano che fungle da flag. viene eseguito un primo ciclo sulla lunghezza dell'array -1 e impostato lo swapped e false.
All'interno del ciclo viene eseguito un secondo ciclo sull'indice precedente a i. Dopo di che vien eimplementato il metodo dell'interfaccia compareTo, se l'indice di j comparato a quello dopo + ha un valore maggiore allora viene scambiato con uno swap. La variabile T temp (generics anch'essa) viene utilizzata per memorizzare temporaneamnte il valore più grande che viene poratto più avanti. Il tutto si ripete finoa  quando tutti gli swapped sono impostati a false e quindi tutti i valori opportuni sono stati ordinati.


## Scrittura codice
7. Scrivi una funzione in Java che accetta un array di interi e un intero target come input. La funzione deve trovare due numeri nell'array che sommati diano il target e restituire i loro indici in un nuovo array. Puoi assumere che ci sia sempre esattamente una soluzione e non puoi usare lo stesso elemento due volte.

```java

package test1.test3;

import java.util.Arrays;

public class TargetSum {


    public static void main(String[] args) {
        int [] numbers1 = {2, 7, 11, 15};
        int target1 = 9;

        int [] numbers2 = {6, 7, 11, 3};
        int target2 = 9;

        TargetSum targetSum = new TargetSum();

        int [] result1 = targetSum.findTwoSum(numbers1, target1);
        System.out.println("The Result is: " );
        Arrays.stream(result1).forEach(System.out::println);

        int [] result2 = targetSum.findTwoSum(numbers2, target2);
        System.out.println("The Result is: " );
        Arrays.stream(result2).forEach(System.out::println);

    }

    private int[] findTwoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i ++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int [] result = {i, j};
                    return result;
                }
            }
        }
        return new int[0];
    }



}


```