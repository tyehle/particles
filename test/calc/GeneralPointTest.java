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
public class GeneralPointTest
{
    
    public GeneralPointTest()
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
     * Test of accelerateParticle method, of class GeneralPoint.
     */
    @Test
    public void testAccelerateParticle()
    {
        System.out.println("accelerateParticle");
        Particle p = null;
        double dt = 0.0;
        GeneralPoint instance = null;
        instance.accelerateParticle(p, dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class GeneralPoint.
     */
    @Test
    public void testClone()
    {
        System.out.println("clone");
        GeneralPoint instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
