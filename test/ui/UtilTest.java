/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
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
public class UtilTest
{
    
    public UtilTest()
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
     * Test of getImageNoPreview method, of class Util.
     */
    @Test
    public void testGetImageNoPreview()
    {
        System.out.println("getImageNoPreview");
        Component parent = null;
        File rootDir = null;
        BufferedImage expResult = null;
        BufferedImage result = Util.getImageNoPreview(parent, rootDir);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageWithPreview method, of class Util.
     */
    @Test
    public void testGetImageWithPreview()
    {
        System.out.println("getImageWithPreview");
        Frame parent = null;
        BufferedImage expResult = null;
        BufferedImage result = Util.getImageWithPreview(parent);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBestLAF method, of class Util.
     */
    @Test
    public void testSetBestLAF()
    {
        System.out.println("setBestLAF");
        Util.setBestLAF();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scaleImage method, of class Util.
     */
    @Test
    public void testScaleImage()
    {
        System.out.println("scaleImage");
        BufferedImage in = null;
        double factor = 0.0;
        BufferedImage expResult = null;
        BufferedImage result = Util.scaleImage(in, factor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighRenderingHints method, of class Util.
     */
    @Test
    public void testSetHighRenderingHints()
    {
        System.out.println("setHighRenderingHints");
        Graphics2D g = null;
        Util.setHighRenderingHints(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
