package calc;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public class ConstantPoint extends StationaryPoint
{
    /**The charge on this point*/
    private double q;
    private double tempQ;
    /**The height of the point from the particle surface*/
    private double h;
    private double tempH;
    /**Whether this point should attract or repel*/
    private short attract;
    private short tempAttract;

    /**
     * Makes a new constant point with the given charge, height above the
     * surface, position, and attraction.
     * @param charge The charge of the point in Coloumbs.
     * @param h The height of the point above the surface in meters.
     * @param position The position of the point on the surface.
     * @param attract Whether the point should attract or repel
     */
    public ConstantPoint(double charge, double h, CartesianVector position, boolean attract)
    {
        super(position);
        tempQ = q = charge;
        tempH = this.h = h;
        
        tempAttract = this.attract = (short) (attract ? 1 : -1);
    }
    /**
     * Increments the velocity of the given particle based on the attraction or
     * repulsion from this stationary point.  This point will exert a force on
     * each particle according to the following equation.  F = (d k q_1 q_2) / (h^2 + d^2)^(1/2)
     * @param p The point to accelerate
     * @param dt The time over which the particle is accelerating
     */
    @Override
    public void accelerateParticle(Particle p, double dt)
    {
        // F = (d k q_1 q_2) / (h^2 + d^2)^(1/2)

        // Horizontal distance between this point and the particle
        double xd = position.x - p.position.x;
        double yd = position.y - p.position.y;
        double d = Math.sqrt(Math.hypot(xd, yd));

        // The force on the particle
        double denominator = Math.hypot(h, d);
        double f = (d * k * q * Particle.getCharge()) / Math.sqrt(
                denominator * denominator * denominator);

        // dv/dt = a = F/m
        // dv = F/m*dt
        double dv = f / Particle.getMass() * dt;

        // dvx = dv cos(arctan(yd/xd))
        // dvx = dv 1/sqrt((yd/xd)^2 + 1)
        denominator = Math.sqrt((yd / xd) * (yd / xd) + 1);
        double dvx = dv / denominator * attract;
        
        // dvy = dv sin(arctan(yd/xd))
        // dvy = dv yd/(xd*sqrt((yd/xd)^2 + 1))
        double dvy = dv / denominator * yd / xd * attract;
        
        if(xd < 0)
        {
            // arctan domain fix
            dvx *= -1;
            dvy *= -1;
        }

        // Update the velocities
        p.velocity.x = p.velocity.x + dvx;
        p.velocity.y = p.velocity.y + dvy;
    }
    /**
     * @return The temporary charge on this particle.
     */
    public double getTempCharge()
    {
        return tempQ;
    }
    /**
     * Sets the temporary charge on this particle.  To change the actual charge
     * on the particle the temporary charge must be changed, and then the
     * syncData method must be called by the computation thread.
     * @param q The new charge of this point
     */
    public void setCharge(double q)
    {
        this.tempQ = q;
    }
    /**
     * @return The temporary height of this point above the particle surface
     */
    public double getTempHeight()
    {
        return tempH;
    }
    /**
     * Sets the temporary height of this point above the particle surface.  To
     * change the actual height of the particle the temporary height must be
     * changed, and then the syncData method must be called by the computation
     * thread.
     * @param h The new height of this point
     */
    public void setHeight(double h)
    {
        this.tempH = h;
    }
    /**
     * @return Whether this point attracts or repels particles
     */
    public boolean getTempAttract()
    {
        return tempAttract == 1;
    }
    /**
     * Sets this point to be attracting or repelling.  Note this only sets the
     * temporary value.  To update the value the computation thread uses the
     * temporary data needs to be synchronized.
     * @param a Whether this point should attract particles or repel them
     */
    public void setAttract(boolean a)
    {
        if(a)
        {
            attract = 1;
        }
        else
        {
            attract = -1;
        }
    }
    /**
     * Syncs the temp data with the data used by the attraction points.
     */
    @Override
    public void syncData()
    {
        // update the position
        super.syncData();
        
        // Update the information in this class.
        q = tempQ;
        h = tempH;
        attract = tempAttract;
    }
    /**
     * Makes a new instance of a constant point with all the same parameters as
     * this one.
     * @return A full copy of this point
     */
    @Override
    public Object clone()
    {
        return new ConstantPoint(q, h, new CartesianVector(position.x,
                position.y), (attract == 1));
    }
}
