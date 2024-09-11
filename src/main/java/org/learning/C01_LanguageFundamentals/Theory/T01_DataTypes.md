# Tipi di Dati in Java

Java è un linguaggio fortemente tipizzato, il che significa che ogni variabile deve avere un tipo di dato dichiarato. I tipi di dati in Java si dividono in due categorie principali: tipi primitivi e tipi di riferimento.

## Tipi Primitivi

I tipi primitivi sono i tipi di dati più basilari disponibili in Java. Ci sono 8 tipi primitivi:

1. **byte**: 8-bit con segno, range da -128 a 127
2. **short**: 16-bit con segno, range da -32,768 a 32,767
3. **int**: 32-bit con segno, range da -2^31 a 2^31-1
4. **long**: 64-bit con segno, range da -2^63 a 2^63-1
5. **float**: 32-bit IEEE 754 a virgola mobile
6. **double**: 64-bit IEEE 754 a virgola mobile
7. **boolean**: true o false
8. **char**: 16-bit Unicode, range da '\u0000' (0) a '\uffff' (65,535)

Esempio di dichiarazione e inizializzazione:

```java
int myNumber = 5;
char myChar = 'A';
boolean isJavaFun = true;
```

## Tipi di Riferimento

I tipi di riferimento sono usati per oggetti e array. Le principali categorie sono:

1. **Classi**: Definite dall'utente o predefinite (come String)
2. **Interfacce**: Definiscono un contratto per le classi
3. **Array**: Collezioni di elementi dello stesso tipo

Esempio:

```java
String myString = "Hello, Java!";
int[] myArray = {1, 2, 3, 4, 5};
```

## Conversione di Tipo (Casting)

Java supporta due tipi di casting:

1. **Implicito**: Conversione automatica da un tipo più piccolo a uno più grande
2. **Esplicito**: Richiede una dichiarazione esplicita per convertire da un tipo più grande a uno più piccolo

Esempio:

```java
int myInt = 9;
double myDouble = myInt; // Casting implicito

double anotherDouble = 9.78;
int anotherInt = (int) anotherDouble; // Casting esplicito
```

## Wrapper Classes

Java fornisce classi wrapper per ogni tipo primitivo, che consentono di utilizzare tipi primitivi come oggetti:

- Byte, Short, Integer, Long, Float, Double, Boolean, Character

Queste classi offrono metodi utili e consentono l'uso di tipi primitivi in contesti che richiedono oggetti.
