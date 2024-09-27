package org.learning.C01_LanguageFundamentals.Solutions;

public class S03_ControlStructure {

    public static void main(String[] args) {
        System.out.println("\n" + "##### ES1 #####");
        System.out.print(7 + " is prime: ");
        System.out.println(isPrime(7));
        System.out.print(4 + " is prime: ");
        System.out.println(isPrime(4));

        System.out.println("\n" + "##### ES2 #####");
        fizzBuzz();


    }

    public static boolean isPrime(int number) {
        if(number < 2 ) {
            return false;
        }
        for (int i = 2; i < number; i++) {
           if (number % i == 0) {
               return false;
           }
        }
        return true;
    }
    public static void fizzBuzz() {
        String f = "FIZZ";
        String b = "BUZZ";
        String fb = "FIZZ_BUZZ";
        for (int i = 0; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(fb);
            } else if(i % 3 == 0) {
                System.out.println(f);
            } else if (i % 5 == 0) {
                System.out.println(b);

            }
        }

    }
}
