package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public class PointCreationDialog extends JDialog
{
    public static final HashMap<String, PointCreationPanel> cards;
    static
    {
        cards = new HashMap<String, PointCreationPanel>(3);
        Util.setBestLAF();
        cards.put("Inverse Square (k/x^2)", new ChargedPointCreationPanel.InverseSquare());
        cards.put("Constant (k)", new ChargedPointCreationPanel.Constant());
        cards.put("Inverse (k/x)", new ChargedPointCreationPanel.Inverse());
    }
    
    private JButton ok, cancel;
    private JComboBox type;
    private JPanel centerPanel;
    private CardLayout cardLayout;
    private String currentType;
    
    public PointCreationDialog(Frame owner)
    {
        super(owner, "New Point", true);
        setLayout(new BorderLayout());
        JPanel p;// Temp panel for layout
        
        ButtonHandler bh = new ButtonHandler();
        ok = new JButton("Ok");
        ok.addActionListener(bh);
        cancel = new JButton("Cancel");
        cancel.addActionListener(bh);
        p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p.add(ok);
        p.add(cancel);
        add(p, BorderLayout.SOUTH);
        
        type = new JComboBox(cards.keySet().toArray(new String[cards.size()]));
        type.addActionListener(bh);
        p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.add(new JLabel("Type: "));
        p.add(type);
        add(p, BorderLayout.NORTH);
        
        cardLayout = new CardLayout();
        centerPanel = new JPanel(cardLayout);
        for(String s : cards.keySet())
        {
            centerPanel.add(cards.get(s), s);
        }
        // Set the first card visible
        currentType = cards.keySet().iterator().next();
        cardLayout.show(centerPanel, currentType);
        
        add(centerPanel, BorderLayout.CENTER);
        
        pack();
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Object source = e.getSource();
            if(source == ok)
            {
                System.out.println("Ok");
                cards.get(currentType).createPoint();
            }
            else if(source == cancel)
            {
                dispose();
            }
            else if(source == type)
            {
                currentType = (String) type.getSelectedItem();
                cardLayout.show(centerPanel, currentType);
            }
        }
    }
    
    public static void main(String[] args)
    {
        Util.setBestLAF();
        PointCreationDialog d = new PointCreationDialog(null);
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        d.setVisible(true);
    }
}
