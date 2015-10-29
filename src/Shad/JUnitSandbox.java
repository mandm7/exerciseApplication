package Shad;

/**
 * Created by Shad on 10/26/2015.
 */
import org.junit.Assert;
import org.junit.Test;

public class JUnitSandbox {


        junk meep = new junk();
        int sum;
        int testsum;
        int testsum2;
        boolean testbool;
        boolean testbool1;

        public JUnitSandbox() {
            this.sum = this.meep.sum(2, 5);
            this.testsum = 7;
            this.testsum2 = 8;
            this.testbool = true;
            this.testbool1 = false;
        }
// test Equales assert
      @Test
        public void testsum() {
            System.out.println(this.sum + " = " + this.testsum);
            Assert.assertEquals(7, (long) this.testsum);
        }
// Test NotEquals assert
        @Test
         public void testsum2() {
        System.out.println(this.sum + " = " + this.testsum);
        Assert.assertNotEquals(7, (long) this.testsum2);
    }

// test assert.True
    @Test
        public void UnitBool(){

            Assert.assertTrue("true", true);
            System.out.println(this.testbool);
        }
    // test assert.False
    @Test
    public void UnitBool1(){

        Assert.assertFalse("true", false);
        System.out.println(this.testbool);
    }
    }


