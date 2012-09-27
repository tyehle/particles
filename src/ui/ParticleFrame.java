package ui;

import calc.CartesianVector;
import calc.GraphicsThread;
import calc.Particle;
import calc.SquaredPoint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public class ParticleFrame extends JFrame
{
    /**
     * Makes a new Particle frame.
     */
    public ParticleFrame()
    {
        // Set up the frame
        super("Particles");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        
        ParticleListener listener = new ParticleListener(this);
        addKeyListener(listener);
        addMouseListener(listener);
    }
    /**
     * The main method for the program.  Starts up a new ParticleFrame.
     * @param args cmd arguments
     */
    public static void main(String[] args)
    {
        Util.setBestLAF();
        ParticleFrame frame = new ParticleFrame();
        
        BufferedImage image = Util.getImageWithPreview(frame);
        if(image == null) // The user pressed cancel
        {
            System.exit(0);
        }
        
        GraphicsThread g = new GraphicsThread(generateParticles(image, frame,
                new Dimension(frame.getWidth()/16, frame.getHeight()/16), 8000), frame);
        frame.setVisible(true);
        frame.createBufferStrategy(2);
        
        g.start();
        
//        g.tempPoints.add(new SquaredPoint(.00000001, 15, frame.getRandomScreenPosition(), true));
//        g.tempPoints.add(new SquaredPoint(.00000001, 15, frame.getRandomScreenPosition(), true));
//        g.tempPoints.add(new SquaredPoint(.00000001, 15, frame.getRandomScreenPosition(), true));
        
        // (461.56412902425024, 73.39790019464907)
        // (997.6251239680996, 679.1726502536895)
        g.tempPoints.add(new SquaredPoint(.00000001, 15, new CartesianVector(461.56412902425024, 73.39790019464907), true));
        g.tempPoints.add(new SquaredPoint(.00000001, 15, new CartesianVector(997.6251239680996, 679.1726502536895), true));
        
//        g.tempPoints.add(new SquaredPoint(.00000001, 15, new CartesianVector(frame.getWidth()*3/16, frame.getHeight()*3/8), true));
//        g.tempPoints.add(new SquaredPoint(.00000001, 15, new CartesianVector(frame.getWidth()*13/16, frame.getHeight() / 2), true));
    }
    
    private static Particle[] generateParticles(BufferedImage image, ParticleFrame frame, Dimension target, int numParticles)
    {
        System.out.println("generating image");
        double factor = Math.max(target.width/(double)image.getWidth(), target.height/(double)image.getHeight());
        image = Util.scaleImage(image, factor);
        
        Particle[] particles = new Particle[image.getWidth() * image.getHeight()];
        Particle p;
        int color, x, y;
        for (int i = 0; i < image.getHeight(); i++)
        {
            for (int j = 0; j < image.getWidth(); j++)
            {
                color = image.getRGB(j, i);
                x = (frame.getWidth() - image.getWidth()) / 2 + j;
                y = (frame.getHeight() - image.getHeight()) / 2 + i;
                p = new Particle(color + (2 << 24), new CartesianVector(x, y));
                particles[i*image.getWidth() + j] = p;
            }
        }
        
        System.out.println(particles.length+" particles created");
        
        Random r = new Random();
        for (int i = 0; i < particles.length; i++)
        {
            int index = r.nextInt(particles.length);
            p = particles[i];
            particles[i] = particles[index];
            particles[index] = p;
        }
        
        Particle array[] = new Particle[Math.min(numParticles, particles.length)];
        System.arraycopy(particles, 0, array, 0, array.length);
        for (int i = 0; i < array.length; i++)
        {
            if(array[i] == null)
            {
                System.out.println(i);
            }
        }
        
        System.out.println(array.length+" particles chosen");
        
        return array;
    }
    
    private CartesianVector getRandomScreenPosition()
    {
        CartesianVector c = new CartesianVector(Math.random() * (getWidth() - 100) + 50, Math.random() * (getHeight() - 100) + 50);
        System.out.println(c);
        return c;
    }
}