/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.Sinestra;
import static org.junit.Assert.*;

/**
 *
 * @author Tobin
 */
public class ConstantPointTest
{
    private ConstantPoint p;
    
    public ConstantPointTest()
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
        p = new ConstantPoint(Sinestra.PARTICLE_CHARGE * 1000, 1, new CartesianVector(1, 1), true);
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of accelerateParticle method, of class ConstantPoint.
     */
    @Test
    public void testAccelerateParticle()
    {
        Particle particle = new Particle(0, new CartesianVector(5, 5));
    }

    /**
     * Test of getTempCharge method, of class ConstantPoint.
     */
    @Test
    public void testGetTempCharge()
    {
        System.out.println("getTempCharge");
        ConstantPoint instance = null;
        double expResult = 0.0;
        double result = instance.getTempCharge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCharge method, of class ConstantPoint.
     */
    @Test
    public void testSetCharge()
    {
        System.out.println("setCharge");
        double q = 0.0;
        ConstantPoint instance = null;
        instance.setCharge(q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempHeight method, of class ConstantPoint.
     */
    @Test
    public void testGetTempHeight()
    {
        System.out.println("getTempHeight");
        ConstantPoint instance = null;
        double expResult = 0.0;
        double result = instance.getTempHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class ConstantPoint.
     */
    @Test
    public void testSetHeight()
    {
        System.out.println("setHeight");
        double h = 0.0;
        ConstantPoint instance = null;
        instance.setHeight(h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempAttract method, of class ConstantPoint.
     */
    @Test
    public void testGetTempAttract()
    {
        System.out.println("getTempAttract");
        ConstantPoint instance = null;
        boolean expResult = false;
        boolean result = instance.getTempAttract();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttract method, of class ConstantPoint.
     */
    @Test
    public void testSetAttract()
    {
        System.out.println("setAttract");
        boolean a = false;
        ConstantPoint instance = null;
        instance.setAttract(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of syncData method, of class ConstantPoint.
     */
    @Test
    public void testSyncData()
    {
        System.out.println("syncData");
        ConstantPoint instance = null;
        instance.syncData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class ConstantPoint.
     */
    @Test
    public void testClone()
    {
        System.out.println("clone");
        ConstantPoint instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
