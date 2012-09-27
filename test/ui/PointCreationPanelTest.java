/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import calc.StationaryPoint;
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
public class PointCreationPanelTest
{
    
    public PointCreationPanelTest()
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
     * Test of createPoint method, of class PointCreationPanel.
     */
    @Test
    public void testCreatePoint()
    {
        System.out.println("createPoint");
        PointCreationPanel instance = new PointCreationPanelImpl();
        StationaryPoint expResult = null;
        StationaryPoint result = instance.createPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PointCreationPanelImpl extends PointCreationPanel
    {

        public StationaryPoint createPoint()
        {
            return null;
        }
    }
}
