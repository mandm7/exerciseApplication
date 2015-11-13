package joseph.peterson.test;


import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Joseph on 11/2/2015.
 */
public class MyJunitTest {
//alt+enter over red will add what libraries you need to the classpath.
    @Test
    public void testAddPerson() {
        int sum = 3 + 3;
        assertEquals(sum,6);

        double sumOne = 2.4 + 2.7;
        assertNotEquals(5.1,4);

        //checking two arrays to see if they equal.
        int[] anArray = {1,2,3,4,5,6,7,8,9,10};
        int[] anotherArray = {1,2,3,4,5,6,7,8,9,10};
        assertArrayEquals(anArray, anotherArray);

        //assertNotSame
        assertNotSame("this","that");

        //asserts an object isn't null.
        assertNotNull(10);
        assertNull(null);
        assertSame(2,2);
        assertThat("123",is("123"));

        //set attribute of AnArrayListToTest class to public

        //first we need instance
        AnArrayListToTest ATest = new AnArrayListToTest();
        ATest.appendNumber(1);
        //get the attribute and store in variable.
        try{
            Field myField = AnArrayListToTest.class.getDeclaredField("testArray");
            //set variable to public.
            myField.setAccessible(true);
            //get what is in the attribute and test it.
            ArrayList valuesList = (ArrayList)myField.get(ATest);
            assertEquals(1, valuesList.get(0));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //last thing to do for junit is test that an exception has been thrown.

        @Test
        public void myException() {
            try {
                AnArrayListToTest letsTestThis = new AnArrayListToTest();
                letsTestThis.divide(4,0);
                //its this fail method to test if exception has been thrown or not.
                fail("Should have thrown exception");
            }
            catch (Exception e){

            }
        }

    }
//something is acting strange.

