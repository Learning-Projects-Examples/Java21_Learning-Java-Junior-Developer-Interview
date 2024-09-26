# 7. Colloquio Java

## Domande teoria:


## Analisi del codice:


## Scrittura codice:

Esercizio: **Trova la coppia di numeri**
Scrivi una funzione in Java che accetta un array di interi e un intero target come input. La funzione deve trovare due numeri nell'array che sommati diano il target e restituire i loro indici in un nuovo array.

```java
package ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FindNumbersCouple {

    public static void main(String[] args) {
        int[] firstTest = {2, 7, 11, 15, 3, 6};
        int firstTarget = 9;
        System.out.println("Results are: ");
        List<int[]> results = findAllCouples(firstTest, firstTarget);
        for (int[] result : results) {
            System.out.println(Arrays.toString(result));
        }
    }

    private static List<int[]> findAllCouples(int[] initialsNumbers, int target) {
        List<int[]> resultsList = new ArrayList<>();
        if(initialsNumbers.length <= 1) {
            throw new RuntimeException("Input requires at least 2 numbers");
        }
        for (int i = 0; i < initialsNumbers.length; i++) {
            for (int j = i + 1; j < initialsNumbers.length; j++) {
                if (initialsNumbers[i] + initialsNumbers[j] == target) {
                    resultsList.add(new int[]{i, j});
                }
            }
        }
        return resultsList;
    }
}
```







