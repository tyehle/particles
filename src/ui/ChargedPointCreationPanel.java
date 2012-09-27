package ui;

import calc.CartesianVector;
import calc.ConstantPoint;
import calc.InversePoint;
import calc.SquaredPoint;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public abstract class ChargedPointCreationPanel extends PointCreationPanel
{
    protected NumberField q, h;
    protected ButtonGroup attractionGroup;
    protected JRadioButton attract, repel;
    
    public ChargedPointCreationPanel()
    {
        super();
        JPanel p;
        
        q = new NumberField(COLUMNS);
        p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(new JLabel("Charge: "));
        p.add(q);
        add(p);
        
        h = new NumberField(COLUMNS);
        p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(new JLabel("Height: "));
        p.add(h);
        add(p);
        
        attractionGroup = new ButtonGroup();
        attract = new JRadioButton("Attract");
        repel = new JRadioButton("Repel");
        attractionGroup.add(attract);
        attractionGroup.add(repel);
        attract.setSelected(true);
        p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(attract);
        p.add(repel);
        add(p);
    }
    
    public static class InverseSquare extends ChargedPointCreationPanel
    {
        public InverseSquare()
        {
            super();
        }
        
        @Override
        public SquaredPoint createPoint()
        {
            double charge = q.getNumber();
            double height = h.getNumber();
            double x = xField.getNumber();
            double y = yField.getNumber();
            return new SquaredPoint(charge, height, new CartesianVector(x, y), true);
        }
    }
    
    public static class Constant extends ChargedPointCreationPanel
    {
        public Constant()
        {
            super();
        }
        
        @Override
        public ConstantPoint createPoint()
        {
            double charge = q.getNumber();
            double height = h.getNumber();
            double x = xField.getNumber();
            double y = yField.getNumber();
            return new ConstantPoint(charge, height, new CartesianVector(x, y), true);
        }
    }
    
    public static class Inverse extends ChargedPointCreationPanel
    {
        public Inverse()
        {
            super();
        }
        
        @Override
        public InversePoint createPoint()
        {
            double charge = q.getNumber();
            double height = h.getNumber();
            double x = xField.getNumber();
            double y = yField.getNumber();
            return new InversePoint(charge, height, new CartesianVector(x, y), true);
        }
    }
}