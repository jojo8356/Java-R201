package ex4;

import org.junit.Test;
import static org.junit.Assert.*;

public class DetectTest {

	@Test
    public void testMain_NoArgument() {
        String[] args = {};
        try {
            Detect.main(args);
        } catch (Exception e) {
            fail("Exception should not be thrown in the robust version.");
        }
    }

   
    @Test
    public void testMain_InvalidArgument() {
        String[] args = {"abc"};
        try {
            Detect.main(args); 
        } catch (Exception e) {
            fail("Exception should not be thrown in the robust version.");
        }
    }

    @Test
    public void testMain_LargeArgument() {
        String[] args = {"150"};
        try {
            Detect.main(args); 
        } catch (Exception e) {
            fail("Exception should not be thrown in the robust version.");
        }
    }
    
    @Test(expected = ArithmeticException.class)
    public void testConstr_NegArgument() {
        Detect d = new Detect(-2);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testSomme_NegArgument() {
        Detect d = new Detect(10);
    	d.sommeDesNPremiers(-5);
    }
}

