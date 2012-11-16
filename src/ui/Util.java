package ui;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Contains useful static methods.
 * @author Tobin
 * @version 4.1
 */
public class Util
{
    /**
     * Gets an Image from a file.  Uses the JFileChooser class, which does not
     * provide image previews, just file names (list and detail views).  Returns
     * null if the user presses cancel.
     * @param parent The parent component
     * @param rootDir The directory to start the dialog in
     * @return The image, or null if the user pressed cancel
     */
    public static BufferedImage getImageNoPreview(Component parent, File rootDir)
    {
        // Set up the file chooser
        JFileChooser chooser = new JFileChooser(rootDir);
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("Images", ImageIO.getReaderFileSuffixes()));
        
        // Show the chooser
        int choice = chooser.showOpenDialog(parent);
        if(choice != JFileChooser.APPROVE_OPTION)
        {
            // The user did not press ok
            return null;
        }
        
        // Try to read the file, and loop this method if there is an error
        try
        {
            return ImageIO.read(chooser.getSelectedFile());
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(parent, "Error reading image.  Choose a valid image.", "Image", JOptionPane.ERROR_MESSAGE);
            return getImageNoPreview(parent, rootDir);
        }
    }
    /**
     * Gets an image from a file using a FileDialog.  This implementation
     * provides image previews, but no file filtering.  The user can select any
     * file, even a non image file and press ok.  If this happens there is an
     * error message and the user is asked to select a valid image file.  If the
     * user presses cancel then this will return null.
     * @param parent The parent frame
     * @return The image, or null if the user pressed cancel
     */
    public static BufferedImage getImageWithPreview(Frame parent)
    {
        FileDialog chooser = new FileDialog(parent, "Open Image", FileDialog.LOAD);
        chooser.setVisible(true);
        // The user pressed cancel
        if(chooser.getFile() == null)
        {
            return null;
        }
        
        File f = new File(chooser.getDirectory()+chooser.getFile());
        // Try to read the file, and loop this method if there is an error
        try
        {
            return ImageIO.read(f);
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(parent, "Error reading image.  Choose a valid image.", "Image", JOptionPane.ERROR_MESSAGE);
            return getImageWithPreview(parent);
        }
    }
    /**
     * Set the best available look-and-feel into use.
     */
    public static void setBestLAF()
    {
        /*
         * Set the look-and-feel.  On Linux, Motif/Metal is sometimes incorrectly used
         * which is butt-ugly, so if the system l&f is Motif/Metal, we search for a few
         * other alternatives.
         */
        try
        {
            // Set system L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            // Check whether we have an ugly L&F
            LookAndFeel laf = UIManager.getLookAndFeel();
            if (laf == null || laf.getName().matches(".*[mM][oO][tT][iI][fF].*") || laf.getName().matches(".*[mM][eE][tT][aA][lL].*"))
            {

                // Search for better LAF
                UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();

                String lafNames[] =
                {
                        ".*[gG][tT][kK].*",
                        ".*[wW][iI][nN].*",
                        ".*[mM][aA][cC].*",
                        ".*[aA][qQ][uU][aA].*",
                        ".*[nN][iI][mM][bB].*"
                };

                lf: for (String lafName: lafNames)
                {
                    for (UIManager.LookAndFeelInfo l: info)
                    {
                        if (l.getName().matches(lafName))
                        {
                            UIManager.setLookAndFeel(l.getClassName());
                            break lf;
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Error setting LAF: " + e);
        }
    }
    /**
     * Scales a BufferedImage by the factor given.  A factor of 1 will do
     * nothing, and a factor of 2 will return an image twice the size.
     * @param in The image to scale.
     * @param factor The factor to scale the image by
     * @return The scaled image
     */
    public static BufferedImage scaleImage(BufferedImage in, double factor)
    {
        // Create the new buffered image at the right size
        BufferedImage out = new BufferedImage((int)(in.getWidth()*factor),
                (int)(in.getHeight()*factor), in.getType());
        // We will draw on this to get the new image
        Graphics2D g = out.createGraphics();
        setHighRenderingHints(g);
        
        // Transform the image and draw onto the graphics
        AffineTransform transform = AffineTransform.getScaleInstance(factor, factor);
        g.drawRenderedImage(in, transform);
        return out;
    }
    /**
     * Sets rendering hints for the given graphics to high quality.
     * @param g The graphics object to set the hints
     */
    public static void setHighRenderingHints(Graphics2D g)
    {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    }
}
