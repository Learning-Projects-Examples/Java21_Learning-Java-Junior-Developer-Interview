package org.learning.C01_LanguageFundamentals.Solutions;

public class S01_Basic_DataTypes {

    public static void main(String[] args) {
        System.out.println("\n" + "##### ES1 #####");
        S01_Basic_DataTypes s01= new S01_Basic_DataTypes();
        s01.printVariablesTypes();

        System.out.println("\n" + "##### ES2 #####");
        double celsius = 2.5;
        double farenheit = s01.convertCelsiusToFar(celsius);
        System.out.println(celsius + " °Celsius are " + farenheit + " °Fahrenheit ");

        System.out.println("\n" + "##### ES3 #####");
        int [] numbers = {33, 44, 55, 66, 77};
        int sum = s01.sumOfArray(numbers);
        System.out.println("Sum of values is: " + sum);


        System.out.println("\n" + "##### ES4 #####");
        s01.wrapperDemonstrate();


        System.out.println("\n" + "##### ES5 #####");
        double average = s01.doAverage(2, 4, 5, 10);
        System.out.println("Average of values is: " + average);

    }

    private void printVariablesTypes() {
        int i = 50;
        short s = 3;
        double d = 5.088;
        float f = 3.33f;
        long l = 50987L;
        char c = '*';
        boolean b = true;
        System.out.println("int = " + i);
        System.out.println("short = " + s);
        System.out.println("double = " + d);
        System.out.println("float = " + f);
        System.out.println("char = " + c);
        System.out.println("boolean = " + b);
    }
    private double convertCelsiusToFar(double c) {
        return c * 33.8;
    }
    private int sumOfArray(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }
    private void wrapperDemonstrate() {
        System.out.println("Autoboxing: from Primitive type to Wrapper class");
        int primitiveInt = 5;
        Integer boxedInt = primitiveInt;
        System.out.println(primitiveInt + " wrapping -> " + boxedInt);

        char primitiveChar = '*';
        Character boxedChar = primitiveChar;
        System.out.println(primitiveChar + " wrapping -> " + boxedChar);

        long primitiveLong = 12345678L;
        Long boxedLong = primitiveLong;
        System.out.println(primitiveLong + " wrapping -> " + boxedLong);

        float primitiveFloat = 12.89f;
        Float boxedFloat = primitiveFloat;
        System.out.println(primitiveFloat + " wrapping -> " + boxedFloat);

        System.out.println("Unboxing: from Wrapper to primitive");
        Double wrappedDouble = Double.valueOf(20.05);
        double unboxedDouble = wrappedDouble;
        System.out.println(wrappedDouble + " unwrapping -> " + unboxedDouble);

        Short wrappedShort = Short.valueOf((short) 1);
        short unboxedShort = wrappedShort;
        System.out.println(wrappedShort + " unwrapping -> " + unboxedShort);

        Boolean wrappedBoolean = Boolean.valueOf(true);
        boolean unboxedBoolean = wrappedBoolean;
        System.out.println(wrappedBoolean + " unwrapping -> " + unboxedBoolean);


    }
    private double doAverage(int... numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }
}
