# Operatori in Java

Gli operatori in Java sono simboli speciali che eseguono operazioni specifiche su uno, due o tre operandi e restituiscono un risultato. Java offre diversi tipi di operatori per eseguire varie operazioni.

## Operatori Aritmetici

Usati per eseguire operazioni matematiche di base.

- `+` (addizione)
- `-` (sottrazione)
- `*` (moltiplicazione)
- `/` (divisione)
- `%` (modulo - resto della divisione)

Esempio:
```java
int a = 10, b = 3;
System.out.println(a + b);  // Output: 13
System.out.println(a - b);  // Output: 7
System.out.println(a * b);  // Output: 30
System.out.println(a / b);  // Output: 3 (divisione intera)
System.out.println(a % b);  // Output: 1
```

## Operatori Unari

Operano su un singolo operando.

- `+` (unario più)
- `-` (unario meno)
- `++` (incremento)
- `--` (decremento)
- `!` (NOT logico)

Esempio:
```java
int x = 5;
System.out.println(+x);  // Output: 5
System.out.println(-x);  // Output: -5
System.out.println(x++); // Output: 5 (post-incremento)
System.out.println(++x); // Output: 7 (pre-incremento)
System.out.println(!true); // Output: false
```

## Operatori di Assegnazione

Usati per assegnare valori alle variabili.

- `=` (assegnazione semplice)
- `+=`, `-=`, `*=`, `/=`, `%=` (assegnazione composta)

Esempio:
```java
int a = 10;
a += 5; // equivalente a: a = a + 5
System.out.println(a);  // Output: 15
```

## Operatori di Confronto

Usati per confrontare due valori.

- `==` (uguale a)
- `!=` (diverso da)
- `>` (maggiore di)
- `<` (minore di)
- `>=` (maggiore o uguale a)
- `<=` (minore o uguale a)

Esempio:
```java
int x = 5, y = 10;
System.out.println(x == y);  // Output: false
System.out.println(x != y);  // Output: true
System.out.println(x > y);   // Output: false
```

## Operatori Logici

Usati per combinare valori booleani.

- `&&` (AND logico)
- `||` (OR logico)
- `!` (NOT logico)

Esempio:
```java
boolean a = true, b = false;
System.out.println(a && b);  // Output: false
System.out.println(a || b);  // Output: true
System.out.println(!a);      // Output: false
```

## Operatori Condizionali

### Operatore Ternario

Un operatore condizionale che prende tre operandi.

Sintassi: `condizione ? espressione1 : espressione2`

Esempio:
```java
int x = 5, y = 10;
String result = (x > y) ? "x is greater" : "y is greater or equal";
System.out.println(result);  // Output: "y is greater or equal"
```

### Operatore instanceof

Usato per testare se un oggetto è un'istanza di una specifica classe o interfaccia.

Esempio:
```java
String str = "Hello";
System.out.println(str instanceof String);  // Output: true
```

## Operatori Bit a Bit

Operano sui singoli bit dei valori interi.

- `&` (AND bit a bit)
- `|` (OR bit a bit)
- `^` (XOR bit a bit)
- `~` (NOT bit a bit)
- `<<` (shift sinistro)
- `>>` (shift destro con segno)
- `>>>` (shift destro senza segno)

Esempio:
```java
int a = 5;  // 101 in binario
int b = 3;  // 011 in binario
System.out.println(a & b);  // Output: 1 (001 in binario)
System.out.println(a | b);  // Output: 7 (111 in binario)
System.out.println(a << 1); // Output: 10 (1010 in binario)
```

## Precedenza degli Operatori

Gli operatori in Java hanno una precedenza che determina l'ordine in cui vengono valutati in un'espressione.

Ordine di precedenza (dal più alto al più basso):
1. Operatori postfissi (`expr++`, `expr--`)
2. Operatori unari (`++expr`, `--expr`, `+expr`, `-expr`, `~`, `!`)
3. Moltiplicazione, divisione e modulo (`*`, `/`, `%`)
4. Addizione e sottrazione (`+`, `-`)
5. Shift (`<<`, `>>`, `>>>`)
6. Confronto (`<`, `>`, `<=`, `>=`, `instanceof`)
7. Uguaglianza (`==`, `!=`)
8. AND bit a bit (`&`)
9. XOR bit a bit (`^`)
10. OR bit a bit (`|`)
11. AND logico (`&&`)
12. OR logico (`||`)
13. Ternario (`? :`)
14. Assegnazione (`=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `^=`, `|=`, `<<=`, `>>=`, `>>>=`)

Esempio di precedenza:
```java
int result = 5 + 3 * 2;  // Result is 11, not 16
System.out.println(result);
```

La conoscenza approfondita degli operatori e della loro precedenza è fondamentale per scrivere codice Java efficiente e privo di errori.