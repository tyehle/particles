package calc;

import java.io.Serializable;
import java.util.ArrayList;
import util.Sinestra;

/**
 * Represents a particle of the image
 * @author Tobin
 * @version 4.1
 */
public class Particle implements Serializable
{
//    public static final long SerialVersionUID = 1L;
    
    // The color of this particle
    int color;
    
    // The position of this particle
    CartesianVector position;
    
    // The velocity of the particle
    CartesianVector velocity;
    /**
     * Makes a new particle with the given color, position, and velocity.
     * @param color The color of the new particle
     * @param position The position of the new particle
     * @param velocity The velocity of the new Particle
     */
    public Particle(int color, CartesianVector position, CartesianVector velocity)
    {
        this.color = color;
        this.position = position;
        this.velocity = velocity;
    }
    /**
     * Makes a new particle with the given color, position, and no velocity.
     * @param color The color of the new particle
     * @param position The position of the new particle
     */
    public Particle(int color, CartesianVector position)
    {
        this(color, position, new CartesianVector(0, 0));
    }
    /**
     * The color of the particle
     * @return 
     */
    public int getColor()
    {
        return color;
    }
    /**
     * Gets the charge on this particle for electostatic calculations
     * @return The charge
     */
    public static double getCharge()
    {
        return Sinestra.PARTICLE_CHARGE;
    }
    /**
     * Gets the mass of the particle for use in determining how it should be
     * accelerated
     * @return The mass of this particle
     */
    public static double getMass()
    {
        return Sinestra.PARTICLE_MASS;
    }
    /**
     * Gets the position of this particle.  Note through this method the
     * position can be changed using the set methods in the CartesianVector
     * class.
     * @return The position of this particle
     */
    public CartesianVector getPosition()
    {
        return position;
    }
    /**
     * Gets the velocity of this particle.  Note through this method the
     * velocity can be changed using the set methods in the CartesianVector
     * class.
     * @return The velocity of this particle
     */
    public CartesianVector getVelocity()
    {
        return velocity;
    }
    /**
     * Moves this particle to a new location based on the current velocity.  The
     * given time is the time in seconds the particle is supposed to have moved
     * within.
     * @param t The time over which the particle is moving in seconds
     */
    public void move(double t)
    {
        // x = x0 + v*t
        position.x = position.x + t * velocity.x;
        position.y = position.y + t * velocity.y;
    }
    /**
     * Updates the velocity of this particle.
     * @param points The list of points that accelerate the particle
     * @param t the amount of time over which the particle should be
     * accelerated
     */
    public void updateVelocity(ArrayList<StationaryPoint> points, double t)
    {
        for(StationaryPoint p : points)
        {
            p.accelerateParticle(this, t);
        }
    }
    
    @Override
    public String toString()
    {
        return "v: "+velocity+", p: "+position;
    }
}