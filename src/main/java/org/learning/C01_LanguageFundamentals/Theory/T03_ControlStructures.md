# Strutture di Controllo in Java

Le strutture di controllo in Java permettono di gestire il flusso di esecuzione di un programma. Sono fondamentali per creare logica condizionale e ripetitiva nei programmi.

## 1. Strutture Condizionali

### If-Else
Usata per eseguire codice basato su condizioni.

```java
if (condizione) {
    // codice se la condizione è vera
} else if (altraCondizione) {
    // codice se l'altra condizione è vera
} else {
    // codice se nessuna condizione precedente è vera
}
```

### Switch
Usato per selezionare uno dei molti blocchi di codice da eseguire.

```java
switch (espressione) {
    case valore1:
        // codice
        break;
    case valore2:
        // codice
        break;
    default:
        // codice default
}
```

## 2. Strutture Iterative (Cicli)

### Ciclo For
Usato quando si conosce il numero di iterazioni in anticipo.

```java
for (inizializzazione; condizione; aggiornamento) {
    // corpo del ciclo
}
```

Varianti:
1. For-each (enhanced for loop):
   ```java
   for (Tipo elemento : collezione) {
       // corpo del ciclo
   }
   ```

2. For infinito:
   ```java
   for (;;) {
       // corpo del ciclo
   }
   ```

3. For con inizializzazioni multiple:
   ```java
   for (int i = 0, j = 10; i < j; i++, j--) {
       // corpo del ciclo
   }
   ```

### Ciclo While
Esegue un blocco di codice finché una condizione specificata è vera.

```java
while (condizione) {
    // corpo del ciclo
}
```

### Ciclo Do-While
Simile al while, ma garantisce che il corpo del ciclo venga eseguito almeno una volta.

```java
do {
    // corpo del ciclo
} while (condizione);
```

## 3. Istruzioni di Salto

### Break
Usato per uscire da un ciclo o uno switch.

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // esce dal ciclo quando i è 5
    }
}
```

### Continue
Salta il resto del corpo del ciclo e continua con la prossima iterazione.

```java
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue; // salta i numeri pari
    }
    System.out.println(i);
}
```

### Return
Esce da un metodo, opzionalmente restituendo un valore.

```java
public int trovaNumero(int[] array, int target) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == target) {
            return i; // restituisce l'indice e esce dal metodo
        }
    }
    return -1; // se non trovato
}
```

## Punti Chiave da Ricordare

- Le strutture di controllo permettono di creare logica complessa nei programmi.
- La scelta tra if-else e switch dipende dal numero di condizioni e dalla leggibilità.
- I cicli for sono ideali quando si conosce il numero di iterazioni, mentre while e do-while sono più flessibili.
- L'uso appropriato di break, continue e return può rendere il codice più efficiente e leggibile.
- È importante evitare cicli infiniti non intenzionali e assicurarsi che le condizioni di uscita siano sempre raggiungibili.
- Le strutture di controllo possono essere annidate, ma un eccessivo annidamento può rendere il codice difficile da leggere e mantenere.
