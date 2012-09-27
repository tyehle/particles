package calc;

/**
 * 10^(n-1)*x/(x^2+h^2)^(n/2)
 * @author Tobin
 * @version 1
 */
public class GeneralPoint extends StationaryPoint
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
    
    private final int order;
    private double coefficient;
    
    public GeneralPoint(CartesianVector position, double charge, double height, int order, boolean attract)
    {
        super(position);
        q = tempQ = charge;
        h = tempH = height;
        this.attract = tempAttract = (short) (attract ? 1 : -1);
        
        this.order = order;
        coefficient = Math.pow(10, order - 1);// 10^n-1
    }

    @Override
    public void accelerateParticle(Particle p, double dt)
    {
        // F = 10^(n-1)*x/(x^2+h^2)^(n/2)

        // Horizontal distance between this point and the particle
        double xd = position.x - p.position.x;
        double yd = position.y - p.position.y;
        double d = Math.sqrt(xd*xd + yd*yd);

        // The force on the particle
        double denominator = h*h + d*d;
        double f = (d * k * q * Particle.getCharge()) / 
                (denominator * denominator * denominator);

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

    @Override
    public Object clone()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
