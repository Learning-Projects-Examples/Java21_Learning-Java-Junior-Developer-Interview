# Algoritmi in Java

## Introduzione
Gli algoritmi sono sequenze di istruzioni ben definite per risolvere un problema specifico. In Java, come in altri linguaggi di programmazione, gli algoritmi sono fondamentali per creare software efficiente e funzionale.

## Tipi di Algoritmi

### 1. Algoritmi di Ordinamento
- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort

### 2. Algoritmi di Ricerca
- Ricerca Lineare
- Ricerca Binaria

### 3. Algoritmi su Grafi
- Depth-First Search (DFS)
- Breadth-First Search (BFS)
- Dijkstra's Algorithm

### 4. Algoritmi di Programmazione Dinamica
- Fibonacci Sequence
- Knapsack Problem

### 5. Algoritmi Greedy
- Prim's Algorithm
- Kruskal's Algorithm

## Implementazione in Java

### Esempio: Bubble Sort

```java
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                // swap arr[j+1] and arr[j]
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
```

### Esempio: Ricerca Binaria

```java
public static int binarySearch(int[] arr, int x) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] == x)
            return mid;
        if (arr[mid] < x)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}
```

## Complessità Computazionale
- Notazione O-grande (Big O Notation)
- Analisi del tempo di esecuzione
- Analisi dello spazio di memoria

## Ottimizzazione degli Algoritmi
- Tecniche di ottimizzazione
- Trade-off tra tempo e spazio

## Esercizi Pratici
1. Implementare un algoritmo di ordinamento a scelta e testarlo su un array di interi.
2. Creare un algoritmo per trovare il numero più frequente in un array.
3. Implementare un algoritmo per verificare se una stringa è un palindromo.
