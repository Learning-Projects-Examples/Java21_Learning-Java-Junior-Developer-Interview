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
float myFloat = 3.14f; //  'f' = float
long myLong = 123456789L; // 'L' = long
```

### Precisione e Arrotondamento

È importante notare che i tipi a virgola mobile (float e double) possono avere problemi di precisione in alcuni calcoli. Ad esempio:

```java
float a = 0.1f;
float b = 0.2f;
float c = a + b;
System.out.println(c); // It may not print exactly 0.3
```

Per calcoli che richiedono alta precisione, considerare l'uso della classe `BigDecimal`.

## Tipi di Riferimento

I tipi di riferimento sono usati per oggetti e array. Le principali categorie sono:

1. **Classi**: Definite dall'utente o predefinite (come String)
2. **Interfacce**: Definiscono un contratto per le classi
3. **Array**: Collezioni di elementi dello stesso tipo
4. **Enum**: Tipo speciale di classe che rappresenta un gruppo di costanti

Esempio:

```java
import java.util.ArrayList;
import java.util.List;

String myString = "Hello, Java!";
int[] myArray = {1, 2, 3, 4, 5};
List<String> myList = new ArrayList<>(); // Example of interface
```

## Varargs (Argomenti Variabili)

Java supporta i metodi con un numero variabile di argomenti (varargs) usando la sintassi `...`. Questo permette di passare un numero arbitrario di argomenti dello stesso tipo a un metodo.

### Sintassi

```java
public void varArgsMethod(type ... args) {
    // method body
}
```
#### Esempi di utilizzo

```java

public class example {
    public static int sum(int... numeri) {
        int tot = 0;
        for (int n : numbers) {
            tot += n;
        }
        return tot;
    }
}

```

### Punti Chiave

- I varargs devono essere l'ultimo parametro nella lista dei parametri del metodo.
- Un metodo può avere al massimo un parametro varargs.
- Internamente, i varargs sono trattati come un array.
- Possono essere utilizzati con qualsiasi tipo di dato, inclusi i tipi di riferimento.

#### Utilizzo con altri parametri 

Esempio:
```java
public static void printInfo(String name, int... votes) {
    System.out.print(name + ", votes: ");
    for (int v : votes) {
        System.out.print(v + " ");
    }
    System.out.println();
}

printInfo("Alice", 20, 45, 70);
```

## Conversione di Tipo (Casting)

Java supporta due tipi di casting:

1. **Implicito (Widening)**: Conversione automatica da un tipo più piccolo a uno più grande
2. **Esplicito (Narrowing)**: Richiede una dichiarazione esplicita per convertire da un tipo più grande a uno più piccolo

Esempio:

```java
int myInt = 9;
double myDouble = myInt; // implicit Casting

double anotherDouble = 9.78;
int anotherInt = (int) anotherDouble; // explicit Casting
```

### Attenzione al Casting

Il casting esplicito può portare a perdita di dati o precisione. Ad esempio:

```java
int largeNumber = 1234567;
byte smallByte = (byte) largeNumber; // data loss
System.out.println(smallByte); 
```

## Wrapper Classes

Java fornisce classi wrapper per ogni tipo primitivo, che consentono di utilizzare tipi primitivi come oggetti:

- Byte, Short, Integer, Long, Float, Double, Boolean, Character

Queste classi offrono metodi utili e consentono l'uso di tipi primitivi in contesti che richiedono oggetti.

Esempio di uso:

```java
Integer wrappedInt = Integer.valueOf(42);
int primitiveInt = wrappedInt.intValue();

// Autoboxing e unboxing
Integer autoboxed = 100; // autoboxing
int unboxed = autoboxed; // unboxing
```

### Vantaggi delle Wrapper Classes

1. Consentono l'uso di tipi primitivi in collezioni generiche
2. Forniscono metodi utili (es. `parseInt()` in `Integer`)
3. Permettono di rappresentare valori null, cosa non possibile con i primitivi

## Best Practices

1. Usare il tipo più appropriato per il tuo dato, considerando range e precisione necessari
2. Fare attenzione alle conversioni implicite ed esplicite per evitare perdite di dati
3. Utilizzare le wrapper classes quando hai bisogno di funzionalità aggiuntive o devi lavorare con collezioni generiche
4. Per grandi numeri o calcoli ad alta precisione, considerare l'uso di `BigInteger` e `BigDecimal`



## 💻 In pratica
Per mettere in pratica i concetti puoi consultare gli esercizi di riferimento: **[E01_DataTypes](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C01_LanguageFundamentals/Exercises/E01_DataTypes.md)**