package calc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.MemoryImageSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import ui.ParticleFrame;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public class GraphicsThread extends Thread
{
    private static final HashMap<RenderingHints.Key, Object> renderingHints;
    static
    {
        renderingHints = new HashMap<RenderingHints.Key, Object>();
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    }
    
    /**The frame to draw graphics on*/
    private ParticleFrame frame;
    
    /**The list of particles in the image*/
    private Particle particles[];
    
    /**The Memory image source to make the image to display on the screen*/
    private MemoryImageSource source;
    /**The array of color data used by the memory image source*/
    private int pix[];
    private PreciseColor preciseImage[];
    /**The image updated by the memory image source and drawn on the frame*/
    private Image sourceImage;
    
    /**The background color for the program*/
    private final int backgroundColor = 255 << 24;
    private final double fade = 1;
    private final double particleTranceparency = 10;
    
    /**The list of stationary points that affect the particles*/
    protected ArrayList<StationaryPoint> stationaryPoints;
    /**The list of temporary points which are updated by the AWT thread, and
     * then synchronized with the other stationary points*/
    public LinkedList<StationaryPoint> tempPoints;

    /**
     * 
     * @param particles
     * @param frame 
     */
    public GraphicsThread(Particle particles[], ParticleFrame frame)
    {
        super("Graphics Thread");
        this.frame = frame;
        this.stationaryPoints = new ArrayList<StationaryPoint>();
        this.tempPoints = new LinkedList<StationaryPoint>();

        // Set up the array of particles
        pix = new int[frame.getWidth() * frame.getHeight()];
        Arrays.fill(pix, backgroundColor);
        this.particles = particles;
        
        // Set up precise color data
        preciseImage = new PreciseColor[frame.getWidth() * frame.getHeight()];
        for(int i = 0; i < preciseImage.length; i++)
        {
            preciseImage[i] = new PreciseColor(backgroundColor);
        }

        // Set up the memory image source
        source = new MemoryImageSource(frame.getWidth(), frame.getHeight(), pix, 0, frame.getWidth());
        source.setAnimated(true);
        source.setFullBufferUpdates(false);
        sourceImage = frame.createImage(source);
    }

    @Override
    public void run()
    {
        while (true)
        {
            updateParticles(.08);
            drawGraphics();
            syncStationaryPoints();
        }
    }

    /**
     * Updates the positions of all the particles based on their current
     * velocity.  Will wait for particles that are flagged as not updated
     * by the calculation thread.
     * @param t the time since the last loop
     */
    private void updateParticles(double t)
    {
        // age every pixel that needs it
        for(int i = 0; i < preciseImage.length; i++)
        {
            if(preciseImage[i].isChanged())
            {
                preciseImage[i].addColor(fade, backgroundColor);
                if(preciseImage[i].toInt() == backgroundColor)
                {
                    preciseImage[i].setChanged(false);
                }
                
                pix[i] = preciseImage[i].toInt();
            }
        }
        
        
        // update and draw each particle
        for (int i = 0; i < particles.length; i++)
        {
            // Update the velocity of the particle
            particles[i].updateVelocity(stationaryPoints, t);

            // Move the particle
            particles[i].move(t);
            
            // Draw the new position
            if (isOnScreen(particles[i].position))
            {
                int index = ((int)particles[i].position.y) * frame.getWidth() + (int) (particles[i].position.x);
                preciseImage[index].addColor(particleTranceparency, particles[i].color);
                preciseImage[index].setChanged(true);
            }
        }
    }
    
    /**
     * First syncs all of the data from stationary points, and then adds newly
     * created points in the list of temp points to the list of points.
     */
    private void syncStationaryPoints()
    {
        for(StationaryPoint p : stationaryPoints)
        {
            p.lock.lock();
            try
            {
                p.syncData();
            }
            finally
            {
                p.lock.unlock();
            }
        }
        
        while(!tempPoints.isEmpty())
        {
            stationaryPoints.add(tempPoints.removeFirst());
        }
    }

    /**
     * Returns true if the given vector is within the range of the screen
     * @param v The vector to test
     * @return if the given vector is on screen
     */
    private boolean isOnScreen(CartesianVector v)
    {
        return v.x >= 0 && v.y >= 0 && v.x < frame.getWidth() && v.y < frame.getHeight();
    }

    private void drawGraphics()
    {
        source.newPixels();
        Graphics2D g = (Graphics2D)frame.getBufferStrategy().getDrawGraphics();
        g.setRenderingHints(renderingHints);
//        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
//        System.out.println(sourceImage.getHeight(null)+", "+sourceImage.getWidth(null));
        g.drawImage(sourceImage, 0, 0, null);
        
//        g.setColor(Color.RED);
//        for(StationaryPoint p : stationaryPoints)
//        {
//            g.fillOval((int)p.getPosition().getX() - 5, (int)p.getPosition().getY() - 5, 10, 10);
//        }
        
        g.dispose();
        frame.getBufferStrategy().show();
    }
}