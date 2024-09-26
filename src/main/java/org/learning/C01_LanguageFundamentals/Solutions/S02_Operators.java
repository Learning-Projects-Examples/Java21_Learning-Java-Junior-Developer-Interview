package org.learning.C01_LanguageFundamentals.Solutions;


public class S02_Operators {
    public static void main(String[] args) {
        System.out.println("\n" + "##### ES1 #####");
        double base = 3.80;
        double height = 5.15;
        System.out.println("Area of rectangle is: " + doRectangleArea(base, height));


        System.out.println("\n" + "##### ES2 #####");
        int number1 = 6;
        int number2 = 13;
        System.out.println(number1 + " is an odd number: " + oddNumber(number1));
        System.out.println(number2 + " is an odd number: " + oddNumber(number2));


        System.out.println("\n" + "##### ES3 #####");
        int first1 = 6;
        int second1 = 13;
        int first2 = 36;
        int second2 = 10;
        findMostBigNumber(first1, second1);
        findMostBigNumber(first2, second2);

        System.out.println("\n" + "##### ES4 #####");

        System.out.println("\n" + "##### ES5 #####");

        System.out.println("\n" + "##### ES6 #####");

        System.out.println("\n" + "##### ES7 #####");

        System.out.println("\n" + "##### ES8 #####");

        System.out.println("\n" + "##### ES9 #####");

        System.out.println("\n" + "##### ES10 #####");

    }

    private static double doRectangleArea(double b, double h) {
        return b*h;
    }
    private static boolean oddNumber(int n) {
        return n % 2 != 0;
    }
    private static void findMostBigNumber(int firstNumber, int secondNumber) {
        boolean result = firstNumber > secondNumber ? true : false;
        if (result) {
            System.out.println(firstNumber + " is > than " + secondNumber);
        } else {
            System.out.println(firstNumber + " is < than " + secondNumber);
        }

    }
}
