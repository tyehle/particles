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
public class StationaryPointTest
{
    
    public StationaryPointTest()
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
     * Test of accelerateParticle method, of class StationaryPoint.
     */
    @Test
    public void testAccelerateParticle()
    {
        System.out.println("accelerateParticle");
        Particle p = null;
        double dt = 0.0;
        StationaryPoint instance = null;
        instance.accelerateParticle(p, dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class StationaryPoint.
     */
    @Test
    public void testClone()
    {
        System.out.println("clone");
        StationaryPoint instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of syncData method, of class StationaryPoint.
     */
    @Test
    public void testSyncData()
    {
        System.out.println("syncData");
        StationaryPoint instance = null;
        instance.syncData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class StationaryPoint.
     */
    @Test
    public void testSetPosition()
    {
        System.out.println("setPosition");
        CartesianVector position = null;
        StationaryPoint instance = null;
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTempPosition method, of class StationaryPoint.
     */
    @Test
    public void testGetTempPosition()
    {
        System.out.println("getTempPosition");
        StationaryPoint instance = null;
        CartesianVector expResult = null;
        CartesianVector result = instance.getTempPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class StationaryPoint.
     */
    @Test
    public void testGetPosition()
    {
        System.out.println("getPosition");
        StationaryPoint instance = null;
        CartesianVector expResult = null;
        CartesianVector result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class StationaryPointImpl extends StationaryPoint
    {

        public StationaryPointImpl()
        {
            super(null);
        }

        public void accelerateParticle(Particle p, double dt)
        {
        }

        public Object clone()
        {
            return null;
        }
    }
}
