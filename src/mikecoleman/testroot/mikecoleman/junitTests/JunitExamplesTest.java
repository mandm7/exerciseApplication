package mikecoleman.junitTests;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


/**
 * Created by Mike on 11/9/2015.
 * This class contains all of the tests for the code
 */

public class JunitExamplesTest {
    // Instantiate JunitExamples class where code to be tested is found
    JunitExamples aTest = new JunitExamples();

    // assertEquals used to test if product is the expected result
    @Test
    public void testMultiply() throws Exception {
        int product = aTest.multiply(1, 2);
        assertEquals(2, product);
    }

    // assertTrue used to test if a number is even
    @Test
    public void testIsEven() throws Exception {
        boolean isEven = aTest.isEven(2);
        assertTrue("This is not an even number", isEven);
    }

    // assertNotEquals to test if two numbers are not equal
    @Test
    public void testSameNumbers() throws Exception {
        assertNotEquals("not equal",aTest.numberOne, aTest.numberTwo);
    }

    // assertArrayEquals to test if two arrays have the same elements
    @Test
    public void checkArrays() throws  Exception {
        assertArrayEquals(aTest.arrayOne, aTest.arrayTwo);
    }

    // assertNotNull and assertNull to test if an object is or is not null
    @Test
    public void checkNull() throws Exception {
        assertNotNull(aTest.numberThree);
        assertNull(aTest.numberFour);
    }

    // assertSame and assertNotSame used to test if two objects are or aren't the same
    @Test
    public void checkIfSame() throws Exception {
        assertSame(aTest.numberFive,aTest.numberSix);
        assertNotSame(aTest.someWord,aTest.anotherWord);
    }

    // assertThat used to test that a certain object contains a certain value
    @Test
    public void compareVariables() throws Exception {
        assertThat(aTest.aNumber,is("seven"));
    }

    /* fail used to ensure that an exception is thrown, in this case, the creation of an
    array index with a negative initial value will be a pass, if no exception is thrown,
    message "Exception was not thrown" is printed
     */
    @Test
    public void testException() {
        try {
            aTest.createArray();
            fail("Exception was not thrown");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add and change to a class that has a private attribute
   @Test
    public void testPrivateAdd() {
       // Instantiate our class TestSet with the private element exampleSet--a HashSet of Strings
       TestSet testThis = new TestSet();
       // Call addString method of TestSet class to add a String to the HashSet
       testThis.addString("happyString");

       try{
           Field myField = TestSet.class.getDeclaredField("exampleSet");
           // Set variable to public temporarily
           myField.setAccessible(true);
           // Get what is in the attribute and test it
           String someString = (String)myField.get(testThis);
           assertEquals("happinessString", someString);
           // Change what is in the attribute
           someString = "happierString";

       } catch (Exception e){
           e.printStackTrace();
       }

   }






}

