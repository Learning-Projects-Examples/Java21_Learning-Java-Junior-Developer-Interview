package org.learning.C01_LanguageFundamentals.Solutions;

public class S05_ControlStructuresBase {

    public static void main(String[] args) {
        System.out.println("##### ES1 #####");
        printEvenNumbers();

        System.out.println("\n");
        System.out.println("##### ES2 #####");
        sumNumbers();

        System.out.println("\n");
        System.out.println("##### ES3 #####");
        doTable(7);
        doTable(13);

        System.out.println("\n");
        System.out.println("##### ES4 #####");
        factorial(5);
        factorial(10);

        System.out.println("\n");
        System.out.println("##### ES5 #####");
        reverseString("ciao");
        reverseString("Parola lunghissima");

        System.out.println("\n");
        System.out.println("##### ES6 #####");
        fizzBuzz();

        System.out.println("\n");
        System.out.println("##### ES7 #####");
        asteriskTriangle(10);

        System.out.println("\n");
        System.out.println("##### ES8 #####");
        fibonacciSerie(10);
    }

    private static void printEvenNumbers() {
        for (int i = 0; i <= 20; i++) {
            if(i % 2 == 0)
            System.out.println(i + " is a even number");
        }
    }

    private static void sumNumbers() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers from 1 to 100 is: " + sum);
    }

    private static void doTable(int n) {
        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            System.out.println("Result of " + n + " * " + i + " = " + result );
        }
    }

    private static void factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        System.out.println("Factorial calculate of " + n + " is " + f);

    }

    private static void reverseString(String str) {
        String reverseStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }
        System.out.println("Reverse of " + str + " is " + reverseStr);
    }

    private static void fizzBuzz() {
        final String F = "FIZZ";
        final String B = "BUZZ";
        final String FB = "FIZZ_BUZZ";
        for (int i = 1; i <= 100; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println(i + " = " + FB);
            } else if (i % 3 == 0) {
                System.out.println(i + " = " + F);
            } else if (i % 5 == 0) {
                System.out.println(i + " = " + B);
            }
        }


    }

    private static void asteriskTriangle(int n) {
        for (int i = 1; i <= n; i++){
            System.out.println();
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }

        }
    }

    private static void fibonacciSerie(int limit) {
        int n1 = 0;
        int n2 = 1;

        for (int i = 0; i < limit; i++) {
            int temp3 = n2 + n1;
            n1 = n2;
            n2 = temp3;
            System.out.println(temp3);
        }
    }

}
