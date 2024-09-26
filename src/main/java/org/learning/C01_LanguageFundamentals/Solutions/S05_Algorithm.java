package org.learning.C01_LanguageFundamentals.Solutions;

import java.util.Arrays;

public class S05_Algorithm {

    public static void main(String[] args) {
        System.out.println("\n" + "##### ES1 #####");
        int[] numbers = {6, 9, 2, 10, 1};
        int[] result = bubbleSort(numbers);
        System.out.print("Result is: " );
        printArray(result);

        System.out.println("\n" + "##### ES2 #####");
        int target = 9;
        System.out.println("Result is: " + binaryResearch(numbers, target));

        System.out.println("\n" + "##### ES3 #####");
        String word = "Anna";
        System.out.println("Result is: " + isPalindrome(word));

        System.out.println("\n" + "##### ES4 #####");
        int[] numbers2 = {6, 9, 2, 10, 1, 33, 2, 89, 80};
        int[] mergeArray = mergeSort(numbers2, 0, numbers2.length - 1);
        System.out.print("Result is: ");
        printArray(mergeArray);

        System.out.println("\n" + "##### ES5 #####");
        int[] numbers3 = {6, 9, 2, 10, 1, 33, 2, 89, 80, 7, 100};
        int[] quickArray = quickSort(numbers3, 0, numbers3.length - 1);
        System.out.print("Result is: ");
        printArray(quickArray);

    }

    private static int[] bubbleSort(int[] numbers) {
       int temp;
       for( int i = 0; i < numbers.length -1; i++) {
           for (int j = 0; j < numbers.length - i - 1; j++) {
               if (numbers[j] > numbers[j+1]) {
                   temp = numbers[j];
                   numbers[j] = numbers[j+1];
                   numbers[j+1] = temp;
               }
           }
       }
        return numbers;
    }
    private static int binaryResearch(int[] numb, int n) {
       int [] sortedNumb = Arrays.stream(numb).sorted().toArray();
       int left = 0;
       int right = sortedNumb.length -1;
       while(left <= right) {
           int center = left + (right - left) / 2;
           if (sortedNumb[center] == n) {
               return sortedNumb[center];
           }
           if (sortedNumb[center] < n) {
               left = center + 1;
           } else {
               right = center -1;
           }
       }

       return -1;
    }
    private static boolean isPalindrome(String word) {
        String cleanWord = word.toLowerCase().replaceAll("[0-9]+\\s", "");
        int left = 0;
        int right = cleanWord.length() -1;
        while(right > left) {
           if(cleanWord.charAt(right) != cleanWord.charAt(left)) {
            return false;
           }
            left++;
            right--;
        }
        return true;
    }
    private static void merge(int[] numbers, int left, int center, int right) {
        int n1 = center - left + 1;
        int n2 = right - center;
        int[] arLeft = new int[n1];
        int[] arRight = new int[n2];


        System.arraycopy(numbers, left, arLeft, 0, n1);
        System.arraycopy(numbers, center + 1, arRight, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (arLeft[i] <= arRight[j]) {
                numbers[k] = arLeft[i];
                i++;
            } else {
                numbers[k] = arRight[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            numbers[k] = arLeft[i];
            i++;
            k++;
        }

        while (j < n2) {
            numbers[k] = arRight[j];
            j++;
            k++;
        }
    }
    private static int[] mergeSort(int[] numbers, int left, int right) {
        if (left < right) {
            int center = left + (right - left) / 2;

            mergeSort(numbers, left, center);
            mergeSort(numbers, center + 1, right);


            merge(numbers, left, center, right);
        }
        return numbers;
    }
    private static int[] quickSort(int[] numbers, int left, int right) {
        if(left < right) {
            int pivotIndex = partition(numbers, left, right);
            quickSort(numbers, left, pivotIndex - 1);
            quickSort(numbers, pivotIndex + 1,  right);
        }
        return numbers;
    }
    private static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if(numbers[j] <= pivot) {
                i++;
                swap(numbers, i, j);
            }

        }
        swap(numbers, i + 1, right);
        return i + 1;
    }
    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    private static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
