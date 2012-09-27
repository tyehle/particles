/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.ArrayList;
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
public class ParticleTest
{
    
    public ParticleTest()
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
     * Test of getColor method, of class Particle.
     */
    @Test
    public void testGetColor()
    {
        System.out.println("getColor");
        Particle instance = null;
        int expResult = 0;
        int result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCharge method, of class Particle.
     */
    @Test
    public void testGetCharge()
    {
        System.out.println("getCharge");
        double expResult = 0.0;
        double result = Particle.getCharge();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMass method, of class Particle.
     */
    @Test
    public void testGetMass()
    {
        System.out.println("getMass");
        double expResult = 0.0;
        double result = Particle.getMass();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Particle.
     */
    @Test
    public void testGetPosition()
    {
        System.out.println("getPosition");
        Particle instance = null;
        CartesianVector expResult = null;
        CartesianVector result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVelocity method, of class Particle.
     */
    @Test
    public void testGetVelocity()
    {
        System.out.println("getVelocity");
        Particle instance = null;
        CartesianVector expResult = null;
        CartesianVector result = instance.getVelocity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Particle.
     */
    @Test
    public void testMove()
    {
        System.out.println("move");
        double t = 0.0;
        Particle instance = null;
        instance.move(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVelocity method, of class Particle.
     */
    @Test
    public void testUpdateVelocity()
    {
        System.out.println("updateVelocity");
        ArrayList<StationaryPoint> points = null;
        double t = 0.0;
        Particle instance = null;
        instance.updateVelocity(points, t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Particle.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Particle instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
