package joseph.peterson.test;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Joseph on 11/2/2015.
 */
public class MyJunitTest {

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
            int aNumber = (Integer)myField.get(ATest);
            assertEquals(1, aNumber);
            //change what is in the attribute.
            aNumber = 2;
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //last thing to do for junit is test that an exception has been thrown.


        @Rule
        //what is final?
        public final ExpectedException exception = ExpectedException.none();

        @Test
        public void myException() {
            AnArrayListToTest letsTestThis = new AnArrayListToTest();

            exception.expect(IndexOutOfBoundsException.class);
            letsTestThis.appendNumber(2);
        }
    }

