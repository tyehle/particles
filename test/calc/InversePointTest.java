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
import static org.junit.Assert.*;

/**
 *
 * @author Tobin
 */
public class InversePointTest
{
    
    public InversePointTest()
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
     * Test of accelerateParticle method, of class InversePoint.
     */
    @Test
    public void testAccelerateParticle()
    {
        System.out.println("accelerateParticle");
        Particle p = null;
        double dt = 0.0;
        InversePoint instance = null;
        instance.accelerateParticle(p, dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempCharge method, of class InversePoint.
     */
    @Test
    public void testGetTempCharge()
    {
        System.out.println("getTempCharge");
        InversePoint instance = null;
        double expResult = 0.0;
        double result = instance.getTempCharge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCharge method, of class InversePoint.
     */
    @Test
    public void testSetCharge()
    {
        System.out.println("setCharge");
        double q = 0.0;
        InversePoint instance = null;
        instance.setCharge(q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempHeight method, of class InversePoint.
     */
    @Test
    public void testGetTempHeight()
    {
        System.out.println("getTempHeight");
        InversePoint instance = null;
        double expResult = 0.0;
        double result = instance.getTempHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class InversePoint.
     */
    @Test
    public void testSetHeight()
    {
        System.out.println("setHeight");
        double h = 0.0;
        InversePoint instance = null;
        instance.setHeight(h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempAttract method, of class InversePoint.
     */
    @Test
    public void testGetTempAttract()
    {
        System.out.println("getTempAttract");
        InversePoint instance = null;
        boolean expResult = false;
        boolean result = instance.getTempAttract();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttract method, of class InversePoint.
     */
    @Test
    public void testSetAttract()
    {
        System.out.println("setAttract");
        boolean a = false;
        InversePoint instance = null;
        instance.setAttract(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of syncData method, of class InversePoint.
     */
    @Test
    public void testSyncData()
    {
        System.out.println("syncData");
        InversePoint instance = null;
        instance.syncData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class InversePoint.
     */
    @Test
    public void testClone()
    {
        System.out.println("clone");
        InversePoint instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
