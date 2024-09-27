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
        swapVariables(5, 10);


        System.out.println("\n" + "##### ES5 #####");
        System.out.print("Version with i++ (0 <= target <= 50) -> ");
        incrementOrDecrementWithTarget(20);

        System.out.print("\n" + "Version with j-- (target >= 50) -> ");
        incrementOrDecrementWithTarget(60);
        System.out.println();


        System.out.println("\n" + "##### ES6 #####");
        System.out.print(2000 + " is a leap year: ");
        System.out.println(isLeapYear(2000));
        System.out.print(1705 + " is a leap year: ");
        System.out.println(isLeapYear(1705));
        System.out.print(2024 + " is a leap year: ");
        System.out.println(isLeapYear(2024));

        System.out.println("\n" + "##### ES7 #####");
        System.out.print("Absolute of value: " + 5 + " is: ");
        System.out.println(calculateAbsoluteOfNumber(5));
        System.out.print("Absolute of value: " + -6 + " is: ");
        System.out.println(calculateAbsoluteOfNumber(-6));


        System.out.println("\n" + "##### ES8 #####");
        visualizeBitABitOperator(12, 13);
        System.out.println();
        visualizeBitABitOperator(20, 333);

        System.out.println("\n" + "##### ES9 #####");
        System.out.print(64 + " is a power of 2 = ");
        System.out.println(isPowerOfTwo(64));

        System.out.print(120 + " is a power of 2 = ");
        System.out.println(isPowerOfTwo(120));

        System.out.print(25 + " is a power of 2 = ");
        System.out.println(isPowerOfTwo(25));

        System.out.println("\n" + "##### ES10 #####");
        System.out.print("Result of " + 2 + " " + 6 + " and " + 1 + " is: ");
        System.out.println(greaterThanThreeNumbers(2, 6, 1));

    }

    private static double doRectangleArea(double b, double h) {
        return b * h;
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
    private static void swapVariables(int a, int b) {
        System.out.println("Value of a is: " + a);
        System.out.println("Value of b is: " + b);
        b = a + b; // 1 + 2 = 3
        a = b - a; // 3 - 1 = 2
        b = b - a; // 3 - 2 = 1
        System.out.println("Value of a after the swap is: " + a);
        System.out.println("Value of b after the swap is: " + b);
    }
    private static void incrementOrDecrementWithTarget(int target) {
        if (target >= 0 && target <= 50) {
            for (int i = 1; i <= 10; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (int j = 10; j > 0; j--) {
                System.out.print(j + " ");
            }
        }

    }
    private static boolean isLeapYear(long year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private static String calculateAbsoluteOfNumber(int n) {
            return n >= 0 ? "|" + n + "|" : "|" + -n + "|";
    }
    private static void visualizeBitABitOperator(int a, int b) {
        if(a < 0 || b < 0 ) {
            throw new RuntimeException("Value must be positive integer");
        }
        int resA = a&b;
        int resB = a|b;
        int resC = a^b;
        int resD = a << 2;
        int resE = b >> 1;
        boolean resF = a % 2 == 0 && a > b;
        boolean resG = b % 2 != 0 && b <= 50;


        System.out.println("a) AND bit a bit (&) between numbers: " + a + ", " + b + " = " + Integer.toBinaryString(resA));
        System.out.println("b) OR bit a bit (|) between numbers: " + a + ", " + b + " = " + Integer.toBinaryString(resB));
        System.out.println("c) XOR bit a bit (^) between numbers: " + a + ", " + b + " = " + Integer.toBinaryString(resC));
        System.out.println("d) Double Left SHIFT (<<) of " + a + " = " + Integer.toBinaryString(resD));
        System.out.println("e) One Right SHIFT (>>): of " + b + " = " + Integer.toBinaryString(resE));
        System.out.println("f) AND Logic first number : " + a + " is even and is greater than " + b + " = " + resF);
        System.out.println("g) OR second number: " +  b + " is odd and smaller or equal of 50 = " + resG);
    }
    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    private static int greaterThanThreeNumbers(int a, int b, int c) {
        int largest = a * ((a > b && a > c) ? 1 : 0) +
                b * ((b > a && b > c) ? 1 : 0) +
                c * ((c > a && c > b) ? 1 : 0);
        return largest;

    }
}
