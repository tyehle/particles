 package calc;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public abstract class StationaryPoint
{
    // Coulomb constant = 1/(4*pi*e_0) = c^2*u_0/(4*pi) = c^2 * 10^-7
    protected final double k = 8.9875517873681764e9;
    
    // The temporary position of the point, which can be updated at any time
    CartesianVector tempPosition;
    // The actual position of the particle which is copied from the temporary
    // position after every frame by the computation thread.
    CartesianVector position;
    
    public ReentrantLock lock;
    
    /**
     * Makes a new stationary point with the given position.
     * @param position The position of the new point
     */
    protected StationaryPoint(CartesianVector position)
    {
        this.position = position;
        tempPosition = (CartesianVector) position.clone();
        
        lock = new ReentrantLock(false);
    }
    
    /**
     * Increments the velocity of the given particle based on the attraction or
     * repulsion from this stationary point.
     * @param p The point to accelerate
     * @param dt The time over which the particle is accelerating
     */
    public abstract void accelerateParticle(Particle p, double dt);
    
    /**
     * Returns a copy of this stationary point.
     * @return the copy of this point
     */
    @Override
    public abstract Object clone();
    
    /**
     * Syncs the changes made to this point during the last frame to the object.
     * This method is called by the computation thread after each frame is
     * rendered.  Subclasses should override this method to sync any data
     * besides position, but they must either call this method or update the
     * position.  If the current thread is not the holder of this point's
     * lock this method will throw an IllegalMonitorStateException
     */
    public void syncData()
    {
        if(!lock.isHeldByCurrentThread())
        {
            throw new IllegalMonitorStateException();
        }
        position.x = tempPosition.x;
        position.y = tempPosition.y;
    }

    /**
     * Sets the temporary position of this point.  The actual position will
     * be updated when the computation thread calls the syncData method.  If the
     * current thread is not the holder of this point's lock then this method
     * will throw an IllegalMonitorStateException.
     * @param position The new position of the point
     */
    public void setPosition(CartesianVector position)
    {
        if(!lock.isHeldByCurrentThread())
        {
            throw new IllegalMonitorStateException();
        }
        this.tempPosition = position;
    }
    /**
     * Gets the temporary position of this point.  If the current thread is not
     * the owner of this point's lock then this method will throw an
     * IllegalMonitorStateException.
     * @return The temporary position of this point
     */
    public CartesianVector getTempPosition()
    {
        if(!lock.isHeldByCurrentThread())
        {
            throw new IllegalMonitorStateException();
        }
        return tempPosition;
    }
    /**
     * Gets the position of the point.
     * @return The position of the point
     */
    public CartesianVector getPosition()
    {
        return position;
    }
}