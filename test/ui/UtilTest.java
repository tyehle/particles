package ui;

import java.awt.image.BufferedImage;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tobin
 */
public class UtilTest
{
    /**
     * Test of scaleImage method, of class Util.
     */
    @Test
    public void testScaleImage()
    {
        BufferedImage in = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
        double factor = .5;
        BufferedImage result = Util.scaleImage(in, factor);
        assertEquals(150, result.getWidth(), 0);
        assertEquals(100, result.getHeight(), 0);
        
        in = new BufferedImage(300, 200, BufferedImage.TYPE_INT_ARGB);
        factor = 2;
        result = Util.scaleImage(in, factor);
        assertEquals(600, result.getWidth(), 0);
        assertEquals(400, result.getHeight(), 0);
    }
}
