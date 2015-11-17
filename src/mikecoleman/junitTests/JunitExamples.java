package mikecoleman.junitTests;

import java.util.ArrayList;

/**
 * Created by Mike on 11/9/2015.
 * This class will contain all of our program logic to be tested. The Junit tests will be created in a separate file
 */

public class JunitExamples {

    // Multiply method to multiply two numbers together and store result in product
    public int multiply(int number1, int number2){
        int product = number1 * number2;
            return product;
    }

    public boolean isEven(int number1){
        boolean anEven = true;
        if(number1 % 2 != 0){
            anEven = false;
        }
        return anEven;
    }

    public double sameNumbers(double number1, double number2){
        return sameNumbers(number1, number2);
    }

    // Used for assertNotEquals in Junit tests
    double numberOne = 5.3;
    double numberTwo = 4.2;

    // Used for assertArrayEquals in Junit tests
    char arrayOne[] = {'a','b','c','d','e'};
    char arrayTwo[] = {'a','b','c','d','e'};

    // Used for assertNull, assertNotNull in Junit tests
    long numberThree = 345987;
    String numberFour = null;

    // Used for assertSame in Junit tests
    int numberFive = -5;
    int numberSix = -5;

    // Used for assertNotSame in Junit tests
    String someWord = "cool";
    String anotherWord = "awesome";

    // Used for assertThat
    String aNumber = "seven";

    // Used to create an ArrayList with a certain initial size, negative will throw exception, positive will cause test to fail
    public ArrayList<String> createArray(){
        ArrayList<String> myArrayList = new ArrayList<>(-2);
        return myArrayList;
    }

}
