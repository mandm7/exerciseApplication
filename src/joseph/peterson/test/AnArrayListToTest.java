package joseph.peterson.test;

import java.util.ArrayList;

/**
 * Created by Joseph on 11/3/2015.
 */
public class AnArrayListToTest {
    //create attribute for class that is an arrayList.
    private ArrayList<Integer> testArray = new ArrayList<>();
    //create method to append a number to arrayList attribute.
        public void appendNumber(int aNumber){
            testArray.add(aNumber);
        }
        public void divide(int one, int two){
            int dividing = one/two;
        }
}
