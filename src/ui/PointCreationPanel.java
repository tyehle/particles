package ui;

import calc.StationaryPoint;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public abstract class PointCreationPanel extends JPanel
{
    public static final int COLUMNS = 15;
    
    protected NumberField xField, yField;
    /**
     * Makes a new point creation panel with a box layout and x and y fields.
     */
    public PointCreationPanel()
    {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel p;
        
        xField = new NumberField(COLUMNS);
        yField = new NumberField(COLUMNS);
        
        p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(new JLabel("X: "));
        p.add(xField);
        add(p);
        p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(new JLabel("Y: "));
        p.add(yField);
        add(p);
    }
    /**
     * Makes a stationary point from the information in the box.  If the
     * information is not correct this will throw an exception.
     * @return The stationary point made from the data in this panel
     */
    public abstract StationaryPoint createPoint();
}
