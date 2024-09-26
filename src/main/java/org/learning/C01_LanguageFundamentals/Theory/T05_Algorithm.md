# Algoritmi in Java: Dalla Teoria alla Pratica

Gli algoritmi sono una componente fondamentale della computer science e dello sviluppo software. In Java, come in altri linguaggi di programmazione, la comprensione e l'implementazione efficiente degli algoritmi sono cruciali per creare software performante e scalabile.

## Categorie Principali di Algoritmi

#### Algoritmi di Ordinamento
- *Bubble Sort*
- *Selection Sort*
- *Insertion Sort*
- *Merge Sort*
- *Quick Sort*

#### Algoritmi di Ricerca
- *Ricerca Lineare*
- *Ricerca Binaria*

#### Algoritmi su Grafi
- *Depth-First Search (DFS)*
- *Breadth-First Search (BFS)*
- *Dijkstra's Algorithm*

#### Algoritmi di Programmazione Dinamica
- *Fibonacci Sequence*
- *Knapsack Problem*

#### Algoritmi Greedy
- *Prim's Algorithm*
- *Kruskal's Algorithm*



Di seguito sarà mostrata un breve panoramica su alcuni degli algoritmi maggiormente utilizzati:

## Algoritmi base: Bubble Sort

Il Bubble Sort è uno degli algoritmi di ordinamento più semplici, ma anche meno efficienti per grandi dataset.

#### Implementazione

```java
public static void bubbleSort(int[] arr) {
    boolean swapped;
    for (int i = 0; i < arr.length - 1; i++) {
        swapped = false;
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // swap
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}
```

#### Analisi
- **Complessità temporale**:
   - Caso peggiore e medio: O(n^2)
   - Caso migliore: O(n) (quando l'array è già ordinato)
- **Complessità spaziale**: O(1)
- **Stabilità**: Stabile

#### Vantaggi e Svantaggi
- **Vantaggi**:
   - Semplice da implementare e capire
   - Efficiente per piccoli dataset o array quasi ordinati
- **Svantaggi**:
   - Molto inefficiente per grandi dataset
   - Performance peggiore rispetto ad altri algoritmi di ordinamento

## Algoritmi base: Ricerca Lineare

La ricerca lineare è l'algoritmo di ricerca più semplice, che esamina ogni elemento della lista sequenzialmente.

#### Implementazione

```java
public static int linearSearch(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == x) {
            return i; // Element found, return index of research
        }
    }
    return -1; // Element not found
}
```

#### Analisi
- **Complessità temporale**:
   - Caso peggiore e medio: O(n)
   - Caso migliore: O(1) (quando l'elemento è il primo)
- **Complessità spaziale**: O(1)

#### Vantaggi e Svantaggi
- **Vantaggi**:
   - Semplice da implementare
   - Funziona su array non ordinati
- **Svantaggi**:
   - Inefficiente per grandi dataset

## Algoritmi base: Ricerca Binaria

La ricerca binaria è un algoritmo efficiente per trovare un elemento in un array ordinato.

#### Implementazione

```java
public static int binarySearch(int[] arr, int x) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == x) {
            return mid; // Element found
        }
        if (arr[mid] < x) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // Element not found
}
```

#### Analisi
- **Complessità temporale**: O(log n)
- **Complessità spaziale**: O(1) per l'implementazione iterativa, O(log n) per quella ricorsiva
- **Prerequisito**: L'array deve essere ordinato

#### Vantaggi e Svantaggi
- **Vantaggi**:
   - Molto efficiente per grandi dataset
   - Riduce drasticamente il numero di confronti necessari
- **Svantaggi**:
   - Richiede che l'array sia ordinato
   - Meno efficiente della ricerca lineare per array molto piccoli

## Algoritmi base: Sequenza di Fibonacci

La sequenza di Fibonacci è una serie di numeri in cui ogni numero è la somma dei due precedenti.

#### Implementazione Ricorsiva (inefficiente)

```java
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}
```

#### Implementazione Iterativa (efficiente)

```java
public static int fibonacciIterative(int n) {
    if (n <= 1) return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
```

#### Analisi
- **Complessità temporale**:
   - Ricorsiva: O(2^n) (molto inefficiente)
   - Iterativa: O(n)
- **Complessità spaziale**:
   - Ricorsiva: O(n) dovuta allo stack delle chiamate ricorsive
   - Iterativa: O(1)

#### Vantaggi e Svantaggi
- **Implementazione Ricorsiva**:
   - Vantaggi: Semplice e intuitiva
   - Svantaggi: Estremamente inefficiente per numeri grandi
- **Implementazione Iterativa**:
   - Vantaggi: Efficiente in termini di tempo e spazio
   - Svantaggi: Meno intuitiva della versione ricorsiva

## Algoritmi Avanzati: Merge Sort

Il Merge Sort è un eccellente esempio di algoritmo divide-et-impera e merita un'analisi approfondita.

### Principio di Funzionamento
1. **Divisione**: L'array viene diviso ricorsivamente in due metà.
2. **Conquista**: Le sottoliste vengono ordinate ricorsivamente.
3. **Combinazione**: Le sottoliste ordinate vengono fuse in un'unica lista ordinata.

### Implementazione in Java

```java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
```


### Analisi della Complessità
- **Tempo**: O(n log n) in tutti i casi
- **Spazio**: O(n) per l'array ausiliario

### Vantaggi e Svantaggi
- **Vantaggi**:
   - Stabile (mantiene l'ordine relativo di elementi uguali)
   - Efficiente per grandi dataset
   - Predicibile (sempre O(n log n))
- **Svantaggi**:
   - Richiede spazio aggiuntivo
   - Meno efficiente di Quick Sort per array piccoli

## Algoritmi Avanzati: QuickSelect

QuickSelect è un algoritmo efficiente per trovare il k-esimo elemento più grande (o più piccolo) in un array non ordinato.

### Principio di Funzionamento
1. Scegli un elemento pivot (solitamente l'ultimo elemento).
2. Partiziona l'array attorno al pivot.
3. Se l'indice del pivot è uguale a k, abbiamo trovato il k-esimo elemento.
4. Altrimenti, ricorre sulla metà appropriata dell'array.

### Implementazione in Java

```java
public class QuickSelect {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### Analisi della Complessità
- **Tempo**:
   - Caso medio: O(n)
   - Caso peggiore: O(n²) (raro con una buona implementazione)
- **Spazio**: O(1) in-place

### Vantaggi e Svantaggi
- **Vantaggi**:
   - Molto efficiente per trovare il k-esimo elemento senza ordinare l'intero array
   - Utilizza spazio costante
- **Svantaggi**:
   - Nel caso peggiore (raro), può degenerare a O(n²)
   - Non stabile: non mantiene l'ordine relativo di elementi uguali


## Complessità Computazionale

### Notazione O-grande (Big O Notation)
- Descrive il comportamento asintotico di un algoritmo
- Esempi comuni: O(1), O(log n), O(n), O(n log n), O(n^2), O(2^n)

### Analisi del Tempo di Esecuzione
- Caso migliore, caso medio, caso peggiore
- Importanza dell'analisi asintotica vs. performance reale

### Analisi dello Spazio di Memoria
- Spazio ausiliario vs. spazio totale
- Trade-off tra tempo e spazio

## Ottimizzazione degli Algoritmi

### Tecniche di Ottimizzazione
- Memoization e tabulazione per problemi di programmazione dinamica
- Utilizzo di strutture dati appropriate (es. HashSet per ricerche veloci)
- Algoritmi randomizzati (es. Quick Sort con pivot casuale)

### Trade-off tra Tempo e Spazio
- Esempio: Hash table vs. array ordinato per ricerche
- Importanza del contesto nell'ottimizzazione (es. vincoli di memoria vs. velocità)

## Considerazioni Pratiche in Java

### Uso delle Collections Framework
- `Collections.sort()` per ordinamento (usa una variante di Merge Sort e Quick Sort)
- `Arrays.binarySearch()` per ricerca binaria efficiente

### Parallelizzazione
- `Arrays.parallelSort()` per sfruttare sistemi multi-core
- Stream API per operazioni parallele su collezioni

### Profiling e Benchmarking
- Utilizzo di JMH (Java Microbenchmark Harness) per misurare le performance
- Importanza di testare con dataset realistici


## Riepilogo Complessità Algoritmi in Java

| Algoritmo       | Complessità Temporale | Complessità Spaziale | Note |
|-----------------|----------------------|----------------------|------|
| **Bubble Sort** | Migliore: O(n) <br> Medio: O(n²) <br> Peggiore: O(n²) | O(1) | - Stabile <br> - In-place <br> - Semplice da implementare |
| **Ricerca Lineare** | Migliore: O(1) <br> Medio: O(n) <br> Peggiore: O(n) | O(1) | - Funziona su array non ordinati <br> - Semplice ma inefficiente per grandi dataset |
| **Ricerca Binaria** | Migliore: O(1) <br> Medio: O(log n) <br> Peggiore: O(log n) | O(1) (iterativa) <br> O(log n) (ricorsiva) | - Richiede un array ordinato <br> - Molto efficiente per grandi dataset |
| **Fibonacci (Ricorsivo)** | O(2ⁿ) | O(n) | - Semplice da implementare <br> - Estremamente inefficiente per n grandi |
| **Fibonacci (Iterativo)** | O(n) | O(1) | - Molto più efficiente della versione ricorsiva |
| **Merge Sort** | Migliore: O(n log n) <br> Medio: O(n log n) <br> Peggiore: O(n log n) | O(n) | - Stabile <br> - Efficiente per grandi dataset <br> - Richiede spazio aggiuntivo |
| **Quick Sort** | Migliore: O(n log n) <br> Medio: O(n log n) <br> Peggiore: O(n²) | O(log n) | - In-place <br> - Molto efficiente nella pratica <br> - Instabile |
| **QuickSelect** | Migliore/Medio: O(n) <br> Peggiore: O(n²) | O(1) | - In-place <br> - Efficiente per trovare il k-esimo elemento <br> - Basato sul principio del QuickSort |
