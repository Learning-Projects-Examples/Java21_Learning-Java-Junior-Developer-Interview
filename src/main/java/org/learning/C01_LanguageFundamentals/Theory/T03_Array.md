# Array in Java

Gli array in Java sono strutture dati che permettono di memorizzare multiple variabili dello stesso tipo. Sono oggetti in Java, il che significa che sono creati dinamicamente.

## Dichiarazione e Inizializzazione

### Dichiarazione
```java
tipo[] nomeArray;
// oppure
tipo nomeArray[];
```

Esempio:
```java
int[] numeri;
String[] parole;
```

### Inizializzazione
1. Inizializzazione con dimensione specifica:
   ```java
   numeri = new int[5];
   ```

2. Inizializzazione con valori:
   ```java
   int[] numeri = {1, 2, 3, 4, 5};
   ```

3. Dichiarazione e inizializzazione combinate:
   ```java
   String[] giorni = new String[]{"Lun", "Mar", "Mer", "Gio", "Ven", "Sab", "Dom"};
   ```

## Accesso agli Elementi

Gli elementi di un array sono accessibili tramite il loro indice, che parte da 0.

```java
int[] numeri = {10, 20, 30, 40, 50};
System.out.println(numeri[0]); // Output: 10
System.out.println(numeri[2]); // Output: 30

numeri[1] = 25; // Modifica il valore dell'elemento all'indice 1
```

## Lunghezza dell'Array

La proprietà `length` restituisce la lunghezza dell'array:

```java
int[] numeri = {1, 2, 3, 4, 5};
System.out.println(numeri.length); // Output: 5
```

## Iterazione sugli Array

### Usando for loop
```java
int[] numeri = {1, 2, 3, 4, 5};
for (int i = 0; i < numeri.length; i++) {
    System.out.println(numeri[i]);
}
```

### Usando for-each loop
```java
int[] numeri = {1, 2, 3, 4, 5};
for (int numero : numeri) {
    System.out.println(numero);
}
```

## Array Multidimensionali

Java supporta array multidimensionali, che sono essenzialmente array di array.

### Dichiarazione e Inizializzazione
```java
int[][] matrice = new int[3][3];
```

oppure

```java
int[][] matrice = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Accesso agli Elementi
```java
System.out.println(matrice[1][2]); // Output: 6
```

### Iterazione su Array Multidimensionali
```java
for (int i = 0; i < matrice.length; i++) {
    for (int j = 0; j < matrice[i].length; j++) {
        System.out.print(matrice[i][j] + " ");
    }
    System.out.println();
}
```

## Array Irregolari (Jagged Arrays)

Gli array irregolari sono array multidimensionali dove le sotto-array possono avere lunghezze diverse.

```java
int[][] irregolare = new int[3][];
irregolare[0] = new int[3];
irregolare[1] = new int[2];
irregolare[2] = new int[4];
```

## Metodi Utili per gli Array

Java fornisce la classe `java.util.Arrays` con metodi utili per lavorare con gli array:

1. `Arrays.sort(array)`: Ordina l'array.
2. `Arrays.binarySearch(array, elemento)`: Cerca un elemento nell'array (l'array deve essere ordinato).
3. `Arrays.fill(array, valore)`: Riempie l'array con un valore specifico.
4. `Arrays.copyOf(array, nuovaLunghezza)`: Crea una copia dell'array con una nuova lunghezza.
5. `Arrays.equals(array1, array2)`: Confronta due array per l'uguaglianza.

Esempio:
```java
import java.util.Arrays;

int[] numeri = {5, 2, 8, 1, 9};
Arrays.sort(numeri);
System.out.println(Arrays.toString(numeri)); // Output: [1, 2, 5, 8, 9]

int indice = Arrays.binarySearch(numeri, 5);
System.out.println("Indice di 5: " + indice); // Output: 2

int[] copia = Arrays.copyOf(numeri, 7);
System.out.println(Arrays.toString(copia)); // Output: [1, 2, 5, 8, 9, 0, 0]
```

## Limitazioni degli Array

1. Dimensione fissa: Una volta creato, la dimensione dell'array non può essere modificata.
2. Tipo omogeneo: Tutti gli elementi devono essere dello stesso tipo.
3. Nessuna funzionalità integrata: Gli array non forniscono metodi per aggiungere o rimuovere elementi dinamicamente.

Per superare queste limitazioni, Java offre strutture dati più avanzate come `ArrayList` o `LinkedList` nella Java Collections Framework.

Gli array sono fondamentali in Java e sono ampiamente utilizzati in molti algoritmi e strutture dati. Comprendere bene il loro funzionamento è essenziale per qualsiasi sviluppatore Java.