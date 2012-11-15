/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

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
        BufferedImage result = Util.getImageNoPreview(null, new File("."));
        // if this does not throw any exceptions that is fine.
        // I really do not want to write gui tests
    }

    /**
     * Test of getImageWithPreview method, of class Util.
     */
    @Test
    public void testGetImageWithPreview()
    {
        BufferedImage result = Util.getImageWithPreview(null);
        // Ditto here.  Just check for any exceptions that could be thrown
    }

    /**
     * Test of scaleImage method, of class Util.
     */
    @Test
    public void testScaleImage()
    {
        BufferedImage in = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
        double factor = .5;
        BufferedImage result = Util.scaleImage(in, factor);
        assertEquals(150, result.getWidth(), 1);
        assertEquals(100, result.getHeight(), 1);
        
        in = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
        factor = 2;
        result = Util.scaleImage(in, factor);
        assertEquals(600, result.getWidth(), 1);
        assertEquals(400, result.getHeight(), 1);
    }
}
