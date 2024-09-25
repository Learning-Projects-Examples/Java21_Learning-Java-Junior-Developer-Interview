package org.learning.C01_LanguageFundamentals.Solutions;

import java.util.Arrays;

public class S05_Algorithm {

    public static void main(String[] args) {
        System.out.println("\n" + "##### ES1 #####");
        int[] numbers = {6, 9, 2, 10, 1};
        int[] result = bubbleSort(numbers);
        System.out.println("Result is: " );
        Arrays.stream(numbers).forEach(System.out::println);

        System.out.println("\n" + "##### ES2 #####");
        int target = 9;
        System.out.println("Result is: " + binaryResearch(numbers, target));

        System.out.println("\n" + "##### ES3 #####");
        String word = "Anna";
        System.out.println("Result is: " + isPalindrome(word));
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

}
