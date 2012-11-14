package calc;

/**
 * Double precision vector class with various manipulation methods
 * @author Tobin
 * @version 4.1
 */
public class CartesianVector implements Cloneable
{
    // The components of the vector
    double x, y;
    /**
     * Makes a new CartesianVector with the given components.
     * @param x The x component of the vector
     * @param y The y component of the vector
     */
    public CartesianVector(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    /**
     * @return The x component of this vector
     */
    public double getX()
    {
        return x;
    }
    /**
     * @return The y component of this vector
     */
    public double getY()
    {
        return y;
    }
    /**
     * @return The total magnitude of this vector
     */
    public double getMagnitude()
    {
        return Math.sqrt(x * x + y * y);
    }
    /**
     * @return 
     */
    public double getAngle()
    {
        return Math.atan2(y, x);
    }
    
    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void scaleX(double factor)
    {
        x *= factor;
    }

    public void scaleY(double factor)
    {
        y *= factor;
    }

    public void scale(double factor)
    {
        x *= factor;
        y *= factor;
    }
    /**
     * Rotates this vector by the given angle.
     * @param angle The angle in radians to rotate the vector
     */
    public void rotate(double angle)
    {
        // 9.35% faster than using both trig operations and 1% faster than using sin
        double cos = Math.cos(angle);
        double sin = Math.sin(angle); // Math.sqrt(1 - cos * cos); removes the sign

        double xTemp = x * cos - y * sin;
        y = y * cos + xTemp * sin;
        x = xTemp;
    }

    public void add(CartesianVector v)
    {
        this.y += v.y;
        this.x += v.x;
    }
    
    /**
     * Does the euclidian inner product of this vector and the given vector.  
     * This operation does not change the value of either vector.
     * @param v The second operand of the dot product
     * @return The dot product of this vector and the given vector
     */
    public double dot(CartesianVector v)
    {
        return x*v.x + y*v.y;
    }
    
    @Override
    public String toString()
    {
        return "("+x+", "+y+")";
    }
    
    
    @Override
    public Object clone()
    {
        return new CartesianVector(x, y);
    }
}