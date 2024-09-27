package org.learning.C01_LanguageFundamentals.Solutions;

import java.math.BigDecimal;
import java.util.Objects;

public class S01_DataTypes {

    public static void main(String[] args) {
        System.out.println("\n" + "##### ES1 #####");
        S01_DataTypes s01= new S01_DataTypes();
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


        System.out.println("\n" + "##### ES6 #####");
        Person person1 = new Person();
        person1.setName("Bill");
        person1.setSurname("Smith");
        person1.setAge(20);
        person1.setWorker(false);
        person1.setSanityCode(172783930201L);

        Person person2 = new Person("Alice", "Smith", 22, true, 172783930202L ,1120.56);

        System.out.println(person1.getName() + " has " + person1.getAge()
                            + " and " +
                           person2.getName()  + " has " + person2.getAge());


        System.out.println("\n" + "##### ES7 #####");
        float a = 0.1f;
        float b = 0.2f;

        double x = 0.1;
        double y = 0.2;

        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");

        PrecisionLoss precisionLoss = new PrecisionLoss();
        float floatResult = precisionLoss.floatMultiply(a, b);
        double doubleResult = precisionLoss.doubleMultiply(x, y);
        BigDecimal bigDecimalResult = precisionLoss.bigDecimalMultiply(bd1, bd2);
        System.out.println("Float result of " + a + " * " + b + " is = " + floatResult);
        System.out.println("Double result of " + x + " * " + y + " is = " + doubleResult);
        System.out.println("BigDecimal result of " + bd1 + " * " + bd2 + " is = " + bigDecimalResult);


        System.out.println("\n" + "##### ES8 #####");
        NumberConverter nc = new NumberConverter();
        int intValue = 42;
        System.out.println("Int value = " + intValue);
        System.out.println("Int to Long: " + nc.intToLong(intValue));
        System.out.println("Int to Float: " + nc.intToFloat(intValue));
        System.out.println("Int to Double: " + nc.intToDouble(intValue) + "\n");

        long longValue = 1234567890123L;
        System.out.println("Long value = " + longValue);
        System.out.println("Long to Int: " + nc.longToInt(longValue));
        System.out.println("Long to Float: " + nc.longToFloat(longValue));
        System.out.println("Long to Double: " + nc.longToDouble(longValue) + "\n");

        float floatValue = 3.14f;
        System.out.println("Float value = " + floatValue);
        System.out.println("Float to Int: " + nc.floatToInt(floatValue));
        System.out.println("Float to Long: " + nc.floatToLong(floatValue));
        System.out.println("Float to Double: " + nc.floatToDouble(floatValue)+ "\n");

        double doubleValue = 3.14159265359;
        System.out.println("Double value = " + doubleValue);
        System.out.println("Double to Int: " + nc.doubleToInt(doubleValue));
        System.out.println("Double to Long: " + nc.doubleToLong(doubleValue));
        System.out.println("Double to Float: " + nc.doubleToFloat(doubleValue) + "\n");


        System.out.println("\n" + "##### ES9 #####");
        Triangle t1 = new Triangle(99, 37);
        System.out.println("Result with int result is " + t1.doAreaWithIntResult());
        System.out.println("Result with double result is " + t1.doAreaWithDoubleResult());


        System.out.println("\n" + "##### ES10 #####");
        System.out.println("The First day of Week is " + DayOfWeek.MONDAY);

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
        for (int n: numbers) {
            sum += n;
        }
        return sum / numbers.length;
    }
}

 class Person{
    String name;
    String surname;
    int age;
    boolean worker;
    long sanityCode;
    double averageSalary;

     public Person() {
     }

     public Person(String name, String surname, int age, boolean worker, long sanityCode, double averageSalary) {
         this.name = name;
         this.surname = surname;
         this.age = age;
         this.worker = worker;
         this.sanityCode = sanityCode;
         this.averageSalary = averageSalary;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getSurname() {
         return surname;
     }

     public void setSurname(String surname) {
         this.surname = surname;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public boolean isWorker() {
         return worker;
     }

     public void setWorker(boolean worker) {
         this.worker = worker;
     }

     public long getSanityCode() {
         return sanityCode;
     }

     public void setSanityCode(long sanityCode) {
         this.sanityCode = sanityCode;
     }

     public double getAverageSalary() {
         return averageSalary;
     }

     public void setAverageSalary(double averageSalary) {
         this.averageSalary = averageSalary;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Person person = (Person) o;
         return age == person.age && worker == person.worker && sanityCode == person.sanityCode && Double.compare(averageSalary, person.averageSalary) == 0 && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, surname, age, worker, sanityCode, averageSalary);
     }
 }
 class PrecisionLoss {
     public float floatMultiply(float a, float b) {
         return  a * b;
     }

     public double doubleMultiply(double x, double y) {
         return x * y;
     }

     public BigDecimal bigDecimalMultiply(BigDecimal bd1, BigDecimal bd2) {
         return bd1.multiply(bd2);
     }
 }
 class NumberConverter {

     public long intToLong(int value) {
         return (long) value;
     }
     public float intToFloat(int value) {
         return (float) value;
     }
     public double intToDouble(int value) {
         return (double) value;
     }
     public int longToInt(long value) {
         return (int) value;
     }
     public float longToFloat(long value) {
         return (float) value;
     }

     public double longToDouble(long value) {
         return (double) value;
     }


     public int floatToInt(float value) {
         return (int) value;
     }

     public long floatToLong(float value) {
         return (long) value;
     }

     public double floatToDouble(float value) {
         return (double) value;
     }


     public int doubleToInt(double value) {
         return (int) value;
     }

     public long doubleToLong(double value) {
         return (long) value;
     }

     public float doubleToFloat(double value) {
         return (float) value;
     }
 }
 class Triangle {
    int base;
    int height;

     public Triangle(int base, int height) {
         this.base = base;
         this.height = height;
     }

    public int doAreaWithIntResult() {
         return base * height / 2;
    }

    public double doAreaWithDoubleResult() {
         double b = (double) base;
         double h = (double) height;
         return b * h / 2;
    }
 }
 enum DayOfWeek{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
 }
