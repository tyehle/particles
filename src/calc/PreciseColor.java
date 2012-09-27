package calc;

import java.awt.Color;

/**
 * Does not store transparency information.
 * @author Tobin
 * @version 4.1
 */
public class PreciseColor
{
    private double r, g, b;
    private boolean changed;
    
    /**
     * Creates a new PreciseColor from the give color.
     * @param c The color of this new PreciseColor
     */
    public PreciseColor(Color c)
    {
        this(c.getRGB());
    }
    
    /**
     * Creates a new PreciseColor from the 32 bits of an int.
     * @param argb The color of the new PreciseColor
     */
    public PreciseColor(int argb)
    {
        b = argb & 0xff;
        g = argb >> 8 & 0xff;
        r = argb >> 16 & 0xff;
        
        changed = false;
    }

    /**
     * Creates a new color from red, green, and blue components.
     * @param r The red component for this color
     * @param g The green component for this color
     * @param b The blue component for this color
     */
    public PreciseColor(double r, double g, double b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        
        changed = false;
    }
    
    /**
     * Adds the given color with the given transparency to this color.
     * @param alpha The transparency of the given color [0 , 255]
     * @param c The color to add to this one
     */
    public void addColor(double alpha, PreciseColor c)
    {
        addColor(alpha, c.r, c.g, c.b);
    }
    
    /**
     * Adds the given color with the given transparency to this color.
     * @param alpha The transparency of the given color [0 , 255]
     * @param c The color to add to this one
     */
    public void addColor(double alpha, Color c)
    {
        addColor(alpha, c.getRGB());
    }
    
    /**
     * Adds the given color with the given transparency to this color.
     * @param alpha The transparency of the given color [0 , 255]
     * @param c The color to add to this one
     */
    public void addColor(double alpha, int c)
    {
        addColor(alpha, (c >> 16 & 0xff), (c >> 8 & 0xff), (c & 0xff));
    }
    
    public void addColor(double alpha, double r, double g, double b)
    {
//        this.r = (r * alpha/255) + this.r*(255-alpha)/255;
//        this.g = (g * alpha/255) + this.g*(255-alpha)/255;
//        this.b = (b * alpha/255) + this.b*(255-alpha)/255;
        this.r = addChannel(alpha, r, this.r);
        this.g = addChannel(alpha, g, this.g);
        this.b = addChannel(alpha, b, this.b);
    }
    
    private double addChannel(double alpha, double source, double backdrop)
    {
        return (1-alpha/255)*backdrop + alpha/255*source;
    }
    
    /**
     * Converts this to a Color.
     * @return The closest color equivalent to this color
     */
    public Color toColor()
    {
        return new Color(Math.round(r), Math.round(g), Math.round(b), 255);
    }
    
    /**
     * Converts this color to an integer representation, where the first 8 bits
     * are the alpha chanel, the next 8 are red, the next 8 are green, and the
     * last 8 are blue.  In this case the alpha channel is always fully opaque,
     * or 255.
     * @return The closest 8 bit per channel integer representation of this
     * color 
     */
    public int toInt()
    {
        int c = 255 << 24;//alpha
        c |= Math.round(r) << 16;
        c |= Math.round(g) << 8;
        c |= Math.round(b);
        return c;
    }
    
    public boolean isChanged()
    {
        return changed;
    }

    public void setChanged(boolean changed)
    {
        this.changed = changed;
    }
}
