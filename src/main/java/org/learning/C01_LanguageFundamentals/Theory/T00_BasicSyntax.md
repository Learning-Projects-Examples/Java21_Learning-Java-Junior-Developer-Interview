# Sintassi di Base in Java

La sintassi di base di Java definisce le regole fondamentali per scrivere codice Java corretto. Comprendere questi elementi è essenziale per iniziare a programmare in Java.

## Struttura di un Programma Java

Un programma Java di base ha la seguente struttura:

```java
public class NomeClasse {
    public static void main(String[] args) {
        // Il codice va qui
    }
}
```

- Ogni programma Java inizia con una dichiarazione di classe.
- Il metodo `main` è il punto di ingresso di ogni applicazione Java.

## Commenti

Java supporta tre tipi di commenti:

```java
// Commento su una singola linea

/*
   Commento
   su più
   linee
*/

/**
 * Commento Javadoc (usato per generare documentazione)
 * @author NomeAutore
 */
```

## Dichiarazione di Variabili

Le variabili in Java devono essere dichiarate prima dell'uso:

```java
tipo nomeVariabile = valore;
```

Esempio:
```java
int numero = 5;
String testo = "Hello";
boolean flag = true;
```

## Tipi di Dati Primitivi

Java ha otto tipi di dati primitivi:

- `byte`, `short`, `int`, `long` (numeri interi)
- `float`, `double` (numeri decimali)
- `boolean` (valori booleani)
- `char` (singoli caratteri)

```java
byte b = 100;
short s = 10000;
int i = 100000;
long l = 1000000000L;
float f = 3.14f;
double d = 3.14159265359;
boolean bool = true;
char c = 'A';
```

## Operatori

Java supporta vari operatori:

- Aritmetici: `+`, `-`, `*`, `/`, `%`
- Relazionali: `==`, `!=`, `>`, `<`, `>=`, `<=`
- Logici: `&&`, `||`, `!`
- Assegnazione: `=`, `+=`, `-=`, `*=`, `/=`, `%=`
- Incremento/Decremento: `++`, `--`

```java
int a = 10, b = 20;
int somma = a + b;
boolean confronto = (a < b);
```

## Strutture di Controllo

### If-Else
```java
if (condizione) {
    // codice se la condizione è vera
} else if (altraCondizione) {
    // codice se l'altra condizione è vera
} else {
    // codice se nessuna condizione è vera
}
```

### Switch
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

### Cicli

#### While
```java
while (condizione) {
    // codice da ripetere
}
```

#### Do-While
```java
do {
    // codice da ripetere
} while (condizione);
```

#### For
```java
for (inizializzazione; condizione; aggiornamento) {
    // codice da ripetere
}
```

#### For-Each (introdotto in Java 5)
```java
for (tipo elemento : collezione) {
    // codice da eseguire per ogni elemento
}
```

## Metodi

Definizione di un metodo:

```java
tipoRitorno nomeMetodo(tipoParametro1 parametro1, tipoParametro2 parametro2) {
    // corpo del metodo
    return valore; // se il tipo di ritorno non è void
}
```

Esempio:
```java
public int somma(int a, int b) {
    return a + b;
}
```

## Gestione delle Eccezioni

Java utilizza il blocco try-catch per gestire le eccezioni:

```java
try {
    // codice che potrebbe generare un'eccezione
} catch (TipoEccezione e) {
    // gestione dell'eccezione
} finally {
    // codice che viene sempre eseguito
}
```

## Importazione di Classi

Per utilizzare classi da altri package, è necessario importarle:

```java
import java.util.ArrayList;
import java.util.*; // importa tutte le classi dal package java.util
```

## Convenzioni di Denominazione

- Classi: iniziano con una lettera maiuscola (es. `NomeClasse`)
- Metodi e variabili: iniziano con una lettera minuscola (es. `nomeMetodo`, `nomeVariabile`)
- Costanti: tutte maiuscole con underscore (es. `NOME_COSTANTE`)
- Package: tutti minuscoli (es. `com.esempio.progetto`)

Seguire queste convenzioni è importante per la leggibilità e la manutenibilità del codice.

La sintassi di base di Java fornisce le fondamenta per scrivere programmi Java. Padroneggiare questi concetti è essenziale per diventare un programmatore Java efficace.