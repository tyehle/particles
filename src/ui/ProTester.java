package ui;

import calc.CartesianVector;
import calc.Particle;
import calc.SquaredPoint;
import calc.StationaryPoint;
import java.util.ArrayList;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public class ProTester
{
    public static void main(String[] args)
    {
        Particle p = new Particle(255 << 24, new CartesianVector(0, 0));
        SquaredPoint point = new SquaredPoint(.001, 50, new CartesianVector(100, 100), true);
        ArrayList<StationaryPoint> list = new ArrayList<StationaryPoint>();
        list.add(point);
        while(p.getPosition().getX() < 200)
        {
//            System.out.println(p.getPosition().getX()+"\t"+p.getPosition().getY()+"\t"+p.getVelocity().getX()+"\t"+p.getVelocity().getY());
            p.updateVelocity(list, .002);
            p.move(.002);
        }
    }
}
