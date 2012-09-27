/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.Color;
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
public class PreciseColorTest
{
    
    public PreciseColorTest()
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
     * Test of addColor method, of class PreciseColor.
     */
    @Test
    public void testAddColor_double_PreciseColor()
    {
        System.out.println("addColor");
        double alpha = 0.0;
        PreciseColor c = null;
        PreciseColor instance = null;
        instance.addColor(alpha, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColor method, of class PreciseColor.
     */
    @Test
    public void testAddColor_double_Color()
    {
        System.out.println("addColor");
        double alpha = 0.0;
        Color c = null;
        PreciseColor instance = null;
        instance.addColor(alpha, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColor method, of class PreciseColor.
     */
    @Test
    public void testAddColor_double_int()
    {
        System.out.println("addColor");
        double alpha = 0.0;
        int c = 0;
        PreciseColor instance = null;
        instance.addColor(alpha, c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColor method, of class PreciseColor.
     */
    @Test
    public void testAddColor_4args()
    {
        System.out.println("addColor");
        double alpha = 0.0;
        double r = 0.0;
        double g = 0.0;
        double b = 0.0;
        PreciseColor instance = null;
        instance.addColor(alpha, r, g, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toColor method, of class PreciseColor.
     */
    @Test
    public void testToColor()
    {
        System.out.println("toColor");
        PreciseColor instance = null;
        Color expResult = null;
        Color result = instance.toColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toInt method, of class PreciseColor.
     */
    @Test
    public void testToInt()
    {
        System.out.println("toInt");
        PreciseColor instance = null;
        int expResult = 0;
        int result = instance.toInt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isChanged method, of class PreciseColor.
     */
    @Test
    public void testIsChanged()
    {
        System.out.println("isChanged");
        PreciseColor instance = null;
        boolean expResult = false;
        boolean result = instance.isChanged();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChanged method, of class PreciseColor.
     */
    @Test
    public void testSetChanged()
    {
        System.out.println("setChanged");
        boolean changed = false;
        PreciseColor instance = null;
        instance.setChanged(changed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
