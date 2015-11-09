package mikecoleman.junitTests;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mike on 11/9/2015.
 */


public class JunitTests {
    @Test
    public void assertPractice(){
        int number1 = 1;
        int number2 = 2;
        int product = number1*number2;
        assertEquals(product,2);
    }

}
