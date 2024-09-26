# Sintassi di Base in Java

La sintassi di base di Java definisce le regole fondamentali per scrivere codice Java corretto. Comprendere questi elementi è essenziale per iniziare a programmare in Java.

## Struttura di un Programma Java

Un programma Java di base ha la seguente struttura:

```java

public class ClassName {
    public static void main(String[] args) {
        // Code here
    }
}
```

- Ogni programma Java inizia con una dichiarazione di classe.
- Il metodo `main` è il punto di ingresso di ogni applicazione Java.

## Commenti

Java supporta tre tipi di commenti:

```java

// Inline comment 

/*
   More
   line
   of
   comment
*/

/**
 * Javadoc comment (used to create documentation)
 * @author AuthorName
 */
```

## Dichiarazione di Variabili

Le variabili in Java devono essere dichiarate prima dell'uso:

```java

type variableName = value;

```

Esempio:
```java

int numb = 5;
String text = "Hello world!";
boolean flag = true;

```

## Tipi di Dati Primitivi

Java ha otto tipi di dati primitivi, che sono i mattoni fondamentali per la rappresentazione dei dati. Questi tipi sono integrati nel linguaggio e offrono efficienza in termini di memoria e prestazioni:

- `byte`, `short`, `int`, `long` (numeri interi di diverse dimensioni)
- `float`, `double` (numeri decimali con precisione singola e doppia)
- `boolean` (valori logici vero/falso)
- `char` (singoli caratteri Unicode)

Ogni tipo ha un range specifico di valori e usi consigliati in base alle esigenze di precisione e spazio di memoria.

🔎 Per approfondire consulta: **[DataTypes](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C01_LanguageFundamentals/Theory/T01_DataTypes.md)**

## Operatori

Gli operatori in Java sono simboli speciali che eseguono operazioni specifiche su uno, due o tre operandi e restituiscono un risultato. Java supporta una vasta gamma di operatori per eseguire operazioni aritmetiche, confronti, operazioni logiche e altro:

- Aritmetici: `+`, `-`, `*`, `/`, `%` (per calcoli matematici)
- Relazionali: `==`, `!=`, `>`, `<`, `>=`, `<=` (per confronti)
- Logici: `&&`, `||`, `!` (per operazioni booleane)
- Assegnazione: `=`, `+=`, `-=`, `*=`, `/=`, `%=` (per assegnare valori)
- Incremento/Decremento: `++`, `--` (per aumentare o diminuire di 1)

La comprensione di questi operatori è fondamentale per scrivere espressioni e controlli logici efficaci in Java.

🔎 Per approfondire consulta: **[Operators](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C01_LanguageFundamentals/Theory/T02_Operators.md)**

## Strutture di Controllo

Le strutture di controllo in Java permettono di modificare il flusso di esecuzione del programma in base a condizioni specifiche. Queste strutture sono essenziali per creare programmi dinamici e reattivi:

- **If-Else**: Permette l'esecuzione condizionale del codice.
- **Switch**: Offre un modo efficiente per gestire multiple condizioni.
- **Cicli**:
    - While: Esegue il codice finché una condizione è vera.
    - Do-While: Simile al while, ma garantisce almeno un'esecuzione.
    - For: Ideale per iterazioni con un conteggio noto.
    - For-Each: Semplifica l'iterazione su collezioni.

Queste strutture consentono di creare logiche complesse e gestire vari scenari all'interno dei programmi Java.

🔎 Per approfondire consulta: **[ControlStructures](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C01_LanguageFundamentals/Theory/T03_ControlStructures.md)**


## Metodi

I metodi in Java sono blocchi di codice che eseguono specifiche operazioni. Sono fondamentali per organizzare la logica del programma e promuovere il riutilizzo del codice.

Definizione generale di un metodo:

```java
accessModifier(optional) typeModifier(optional) returnType nameMethod(typeArg1 argument1, typeArg2 argument2) {
    // method's body
    return value; // if return type isn't void
}
```

- **Modificatori di accesso** (come `public`, `private`) sono opzionali e controllano la visibilità del metodo.
- **Modificatori di tipo** (come `static`, `final`) sono opzionali e definiscono caratteristiche speciali del metodo.
- Il **tipo di ritorno** può essere un tipo di dato specifico o `void` se il metodo non restituisce nulla.
- I **parametri** sono opzionali; un metodo può non accettare argomenti.

🔎 Per approfondire i *modificatori* consulta: [Modifiers](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C02_OOP/Theory/T06_Modifiers.md)

Esempio di un metodo semplice:
```java
public int sum(int a, int b) {
    return a + b;
}
```

I metodi possono variare notevolmente in complessità:
- Possono avere zero o più parametri.
- Possono restituire un valore (`return`) o essere `void`.
- Possono contenere logica complessa o essere semplici istruzioni.

L'uso appropriato dei metodi aiuta a:
- Organizzare il codice in unità logiche.
- Evitare la duplicazione del codice.
- Migliorare la leggibilità e la manutenibilità del programma.


## Gestione delle Eccezioni

Le eccezioni in Java rappresentano condizioni anomale che possono verificarsi durante l'esecuzione di un programma. Java offre diversi meccanismi per gestire queste situazioni:

- **Try-Catch**:
    - Racchiude il codice che potrebbe generare un'eccezione
    - Cattura e gestisce specifici tipi di eccezioni

- **Try-Catch-Finally**:
    - Simile al Try-Catch
    - Aggiunge un blocco 'finally' che viene sempre eseguito, indipendentemente dal verificarsi di eccezioni

- **Try-With-Resources**:
    - Gestisce automaticamente la chiusura di risorse (come file o connessioni)
    - Semplifica la gestione di risorse che richiedono una chiusura esplicita

- **Throws**:
    - Dichiara che un metodo può lanciare specifiche eccezioni
    - Delega la gestione dell'eccezione al chiamante del metodo

- **Throw**:
    - Lancia esplicitamente un'eccezione
    - Utile per segnalare condizioni di errore all'interno del codice

La gestione delle eccezioni è fondamentale per creare programmi robusti e affidabili, permettendo di gestire situazioni impreviste in modo controllato.

🔎 Per approfondire consulta: **[ExceptionHandling](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C03_ExceptionHandling/Theory)**

## Importazione di Classi

Per utilizzare classi da altri package, è necessario importarle:

```java
import java.util.ArrayList;
import java.util.*; // to import all classes from package java.util
```

## Convenzioni di Denominazione

- Classi: iniziano con una lettera maiuscola e poi proseguono in *camelCase* (es. `ClassName`)
- Metodi e variabili: sono in *camelCase* (prima lettera minuscola e lettera di iniziale della seconda parola maiuscola) (es. `nomeMetodo`, `nomeVariabile`)
- Costanti: tutte maiuscole con underscore (es. `CONSTANT_NAME`)
- Package: tutti minuscoli (es. `com.example.project`) di solito si sceglie com, org, net, it perché si usa il nome dle dominio al contrario: `project.example.com`

Seguire queste convenzioni è importante per la leggibilità e la manutenibilità del codice.

La sintassi di base di Java fornisce le fondamenta per scrivere programmi Java.

# Concetti avanzati

## Java 7+ features:

### Sintassi per numeri binari e separatori in numeri letterali 

```java
int binary = 0b1010;
long bigNumber = 1_000_000_000;
```
<br>

## Java 8+ features:
### Espressioni Lambda

Le espressioni lambda forniscono una sintassi concisa per implementare interfacce funzionali:

```java
Runnable r = () -> System.out.println("Hello World");
```

### Method References

I method references offrono una sintassi ancora più concisa per le lambda in certi casi:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);
```

### Stream API

Gli Stream forniscono un modo potente e flessibile per processare collezioni di dati in modo dichiarativo:

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
                 .filter(n -> n % 2 == 0)
                 .mapToInt(Integer::intValue)
                 .sum();
```

Gli Stream permettono operazioni come filtraggio, mappatura, riduzione e molto altro, spesso con migliori prestazioni e codice più leggibile rispetto ai cicli tradizionali.

🔎 Per approfondire consulta: **[Java8Features](https://github.com/Learning-Projects-Examples/Java21_Learning-Java-Junior-Developer-Interview/blob/main/src/main/java/org/learning/C08_Java8Features/Theory)**

<br>

## Java 9+ features:
### RIMOSSO: Underscore come Identificatore

L'uso dell'underscore come identificatore è stato deprecato in Java 8 e rimosso in Java 9:

```java
// Invalid from Java 9
String _ = "underscore";
```

<br>

## Java 10+ features:
### Uso di 'var'

Java 10 ha introdotto l'inferenza di tipo locale con la keyword 'var':

```java
var numbers = 10; // compiler infers that value is int
var text = "Hello world!"; // compiler infers that value is int String
```
<br>

## Java 14+ features:
### Switch Expressions migliorata

Una forma più espressiva e concisa dello switch:

```java
String result = switch (day) {
    case "MONDAY", "FRIDAY" -> "Busy day";
    case "TUESDAY", "THURSDAY" -> "Normal day";
    case "WEDNESDAY" -> "Meeting day";
    case "SATURDAY", "SUNDAY" -> "Weekend";
    default -> "Unknown day";
};
```

### Pattern Matching per instanceof (standard da Java 16+)

Una sintassi più concisa per il type casting dopo un controllo instanceof:

```java
if (obj instanceof String s) {
    // direct use of s
    System.out.println(s.length());
}
```

### Record (standard da Java 16+)

Una sintassi concisa per creare classi di dati immutabili:

```java
record Point(int x, int y) {}
```

<br>

## Java 15+ features:
### Text Blocks

Multiline string literals con una sintassi più pulita:

```java
String html = """
              <html>
                  <body>
                      <p>Hello, World</p>
                  </body>
              </html>
              """;
```
<br>

### Sealed Classes (standard da Java 17+)

Una nuova sintassi per limitare quali classi possono estendere una classe o implementare un'interfaccia:

```java
public sealed class Shape permits Circle, Rectangle, Square {}
```


