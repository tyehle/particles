/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tobin
 */
public class NumberFieldTest
{
    
    public NumberFieldTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getNumber method, of class NumberField.
     */
    @Test
    public void testGetNumber()
    {
        System.out.println("getNumber");
        NumberField instance = new NumberField();
        double expResult = 0.0;
        double result = instance.getNumber();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
