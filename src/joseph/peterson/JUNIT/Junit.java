package joseph.peterson.JUNIT;

import org.junit.Test;
//don't forget the static for the assertEquals. It took me forever to figure out this problem.
import static org.junit.Assert.*;

/**
 * Created by Joseph on 10/29/2015.
 */
public class Junit {
    ///////////////////////////////////////////////HAPPY PATHS////////////////////////////////////////////////////////
    @Test
    public void test(){
    }
    public static void main(String[] args) {
        Junit myThis = new Junit();
        myThis.go();


    }
    public void go(){
       int three = Math.addExact(3,4);
        assertEquals(7,7);
    }
    public static int add(int one, int two){
        return one + two;

    }
}
