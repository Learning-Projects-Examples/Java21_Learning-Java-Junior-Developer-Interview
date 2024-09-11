# Strutture di Controllo in Java: Focus sui Cicli For

## Introduzione
Le strutture di controllo sono fondamentali in programmazione per gestire il flusso di esecuzione di un programma. In Java, esistono diverse strutture di controllo.

## Ciclo For
Il ciclo for è utilizzato quando si conosce in anticipo il numero di iterazioni da eseguire. La sua sintassi generale è:

```java
for (inizializzazione; condizione; aggiornamento) {
    // corpo del ciclo
}
```

- **Inizializzazione**: Viene eseguita una sola volta all'inizio del ciclo.
- **Condizione**: Viene verificata prima di ogni iterazione. Se falsa, il ciclo termina.
- **Aggiornamento**: Viene eseguito alla fine di ogni iterazione.

### Esempio base:
```java
for (int i = 0; i < 5; i++) {
    System.out.println("Iterazione " + i);
}
```

### Varianti del ciclo for:

1. **For-each** (introdotto in Java 5):
   ```java
   for (Tipo elemento : collezione) {
       // corpo del ciclo
   }
   ```

2. **Ciclo for infinito**:
   ```java
   for (;;) {
       // corpo del ciclo
   }
   ```

3. **Ciclo for con inizializzazioni multiple**:
   ```java
   for (int i = 0, j = 10; i < j; i++, j--) {
       // corpo del ciclo
   }
   ```

## Punti chiave da ricordare:
- Il ciclo for è ideale quando si conosce il numero di iterazioni.
- Le variabili dichiarate nell'inizializzazione hanno scope limitato al ciclo.
- Si può omettere qualsiasi parte del for (inizializzazione, condizione, aggiornamento), ma i punti e virgola sono obbligatori.
- Utilizzare il for-each quando possibile per una maggiore leggibilità del codice.