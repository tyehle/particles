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
public class CartesianVectorTest
{
    
    private CartesianVector v;
    
    public CartesianVectorTest()
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
        v = new CartesianVector(1, 1);
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getX method, of class CartesianVector.  Depends on the
     * constructor
     */
    @Test
    public void testGetX()
    {
        assertEquals(1.0, v.getX(), 0);
        v.x = 3;
        assertEquals(3, v.getX(), 0);
        v.x = -3;
        assertEquals(-3, v.getX(), 0);
        v.x = 0;
        assertEquals(0, v.getX(), 0);
    }

    /**
     * Test of getY method, of class CartesianVector.
     */
    @Test
    public void testGetY()
    {
        assertEquals(1.0, v.getY(), 0);
        v.y = 3;
        assertEquals(3, v.getY(), 0);
        v.y = -3;
        assertEquals(-3, v.getY(), 0);
        v.y = 0;
        assertEquals(0, v.getY(), 0);
    }

    /**
     * Test of getMagnitude method, of class CartesianVector.
     */
    @Test
    public void testGetMagnitude()
    {
        assertEquals(Math.sqrt(2), v.getMagnitude(), 0);
        v.x = 0;
        assertEquals(1, v.getMagnitude(), 0);
        v.y = 0;
        assertEquals(0, v.getMagnitude(), 0);
        v.x = -3;
        v.y = -4;
        assertEquals(5, v.getMagnitude(), 0);
    }

    /**
     * Test of getAngle method, of class CartesianVector.
     */
    @Test
    public void testGetAngle()
    {
        assertEquals(Math.PI /4, v.getAngle(), 0);
        v.x = 0;
        assertEquals(Math.PI / 2, v.getAngle(), 0);
        v.x = 1;
        v.y = 0;
        assertEquals(0, v.getAngle(), 0);
        v.x = -1;
        v.y = 1;
        assertEquals(Math.PI * 3 / 4, v.getAngle(), 0);
        v.x = -Math.sqrt(3);
        v.y = -1;
        assertEquals(-Math.PI * 5.0 / 6.0, v.getAngle(), 0);
    }

    /**
     * Test of setX method, of class CartesianVector.
     */
    @Test
    public void testSetX()
    {
        v.setX(2);
        assertEquals(2, v.x, 0);
        v.setX(0);
        assertEquals(0, v.x, 0);
        v.setX(-10);
        assertEquals(-10, v.x, 0);
    }

    /**
     * Test of setY method, of class CartesianVector.
     */
    @Test
    public void testSetY()
    {
        v.setY(2);
        assertEquals(2, v.y, 0);
        v.setY(0);
        assertEquals(0, v.y, 0);
        v.setY(-10);
        assertEquals(-10, v.y, 0);
    }

    /**
     * Test of scaleX method, of class CartesianVector.
     */
    @Test
    public void testScaleX()
    {
        v.scaleX(2);
        assertEquals(2, v.x, 0);
        assertEquals(1, v.y, 0);
        v.scaleX(.5);
        assertEquals(1, v.x, 0);
        assertEquals(1, v.y, 0);
        v.scaleX(-5.3);
        assertEquals(-5.3, v.x, 0);
        assertEquals(1, v.y, 0);
    }

    /**
     * Test of scaleY method, of class CartesianVector.
     */
    @Test
    public void testScaleY()
    {
        v.scaleY(2);
        assertEquals(2, v.y, 0);
        assertEquals(1, v.x, 0);
        v.scaleY(.5);
        assertEquals(1, v.y, 0);
        assertEquals(1, v.x, 0);
        v.scaleY(-5.3);
        assertEquals(-5.3, v.y, 0);
        assertEquals(1, v.x, 0);
    }

    /**
     * Test of scale method, of class CartesianVector.
     */
    @Test
    public void testScale()
    {
        v.scale(2);
        assertEquals(2, v.x, 0);
        assertEquals(2, v.y, 0);
        assertEquals(Math.sqrt(2)*2, v.getMagnitude(), 0);
        v.scale(.5);
        assertEquals(1, v.x, 0);
        assertEquals(1, v.y, 0);
        assertEquals(Math.sqrt(2), v.getMagnitude(), 0);
        v.scale(-5.3);
        assertEquals(-5.3, v.x, 0);
        assertEquals(-5.3, v.y, 0);
        assertEquals(Math.sqrt(2*5.3*5.3), v.getMagnitude(), 0);
    }

    /**
     * Test of rotate method, of class CartesianVector.
     */
    @Test
    public void testRotate()
    {
        v.rotate(Math.PI / 2);
        assertEquals(Math.sqrt(2), v.getMagnitude(), 0.0000000001);
        assertEquals(-1, v.x, 0.0000000001);
        assertEquals(1, v.y, 0.000000001);
        assertEquals(Math.PI * 3.0 /4.0, v.getAngle(), 0.0000000001);
        v.rotate(Math.PI / -4);
        assertEquals(0, v.x, 0.0000000001);
        assertEquals(Math.sqrt(2), v.y, 0.0000000001);
    }

    /**
     * Test of add method, of class CartesianVector.
     */
    @Test
    public void testAdd()
    {
        CartesianVector w = new CartesianVector(2, 3);
        v.add(w);
        assertEquals(3, v.x, 0);
        assertEquals(4, v.y, 0);
        
        w.x = -4;
        w.y = -.5;
        v.add(w);
        assertEquals(-1, v.x, 0);
        assertEquals(3.5, v.y, 0);
    }
    
    /**
     * Test of the dot method, of class CartesianVector.
     */
    @Test
    public void testDot()
    {
        CartesianVector w = new CartesianVector(2, 3);
        assertEquals(2, v.dot(v), 0);
        assertEquals(13, w.dot(w), 0);
        assertEquals(5, v.dot(w), 0);
        
        w.x = 0;
        assertEquals(3, v.dot(w), 0);
        
        w.y = 0;
        assertEquals(0, v.dot(w), 0);
        
        w.x = 2;
        assertEquals(2, v.dot(w), 0);
        
        w.x = -2;
        assertEquals(-2, v.dot(w), 0);
        
        w.y = -3;
        assertEquals(-5, v.dot(w), 0);
    }

    /**
     * Test of clone method, of class CartesianVector.
     */
    @Test
    public void testClone()
    {
        CartesianVector w = (CartesianVector) v.clone();
        assertFalse(w == v);
        assertEquals(v.x, w.x, 0);
        assertEquals(v.y, w.y, 0);
    }
}
