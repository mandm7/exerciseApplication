package mikecoleman.junitTests;

import java.util.HashSet;

/**
 * Created by Mike on 11/13/2015.
 * This is a class that has a private attribute exampleSet of type HashSet
 * Our Junit test will be to add an element within the private HashSet
 */

public class TestSet {
    private HashSet<String> exampleSet = new HashSet<>();
    //create method to append a number to arrayList attribute.
    public void addString(String someString){
        exampleSet.add(someString);
        System.out.println(exampleSet);
    }
}
