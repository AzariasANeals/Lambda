

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LambdaDemoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LambdaDemoTest
{
    /**
     * Default constructor for test class LambdaDemoTest
     */
    public LambdaDemoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    // normal
    @Test
    public void testDemoAddOperation()
    {
        int expected = 5;
        int x = 3;
        int y = 2;
        int actual = LambdaDemo.demoAddOperation(x,y);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testDemoSubOperation()
    {
        int expected = 1;
        int x = 3;
        int y = 2;
        int actual = LambdaDemo.demoSubOperation(x,y);
        assertEquals(expected, actual);
    }   
    
    @Test
    public void testDemoMultiplicationOperation()
    {
        int expected = 6;
        int x = 3;
        int y = 2;
        int actual = LambdaDemo.demoMultiplicationOperation(x,y);
        assertEquals(expected, actual);
    }   
    
    // exception
    @Test
    public void testDemoDivisionOperationZero()
    {
        boolean expected = true;
        boolean actual = false;
        int x = 3;
        int y = 0;
        int z = 0;
        
        try
        {
            z = LambdaDemo.demoDivisionOperation(x,y);    
        }
        catch(ArithmeticException ae)
        {
            actual = true;
        }
        
        assertEquals(expected, actual);
    }   
    
    // To figure out the actual expected value since java will not
    //   throw an overflow exception; you have use binary arithmetic
    //   and twos complement. However, you can also just run the test
    //   once and see what the result is.
    // The maximum size for a signed java int currently is (2^31)-1 for
    //    the positive value which is 2147483647 so if you add 2 you
    //    overflow the value since the 32 bit is used to indicate a 
    //    a positive or negative number
    //    
    @Test 
    public void testDemoAddOperationOverflow()
    {
        int expected = -2147483647;
        int x = 2147483647;
        int y = 2;
        int actual = LambdaDemo.demoAddOperation(x,y);
        assertEquals(expected, actual);        
    }
    
    // To figure out the actual expected value since java will not
    //   throw an overflow exception; you have use binary arithmetic
    //   and twos complement. However, you can also just run the test
    //   once and see what the result is.
    //  Since the largest negative number is -2,147,483,648 (-2147483648)
    //   or 2^31, an overflow condition will occur and the value returned
    //   will not be valid.
    @Test 
    public void testDemoSubOperationOverflow()
    {
        int expected = 2147483646;
        int x = -2147483648;
        int y = 2;
        int actual = LambdaDemo.demoSubOperation(x,y);
        assertEquals(expected, actual);        
    }    
}
