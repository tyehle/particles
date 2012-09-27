package ui;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;

/**
 *
 * @author Tobin
 * @version 4.1
 */
public class NumberField extends JTextField
{

    public NumberField()
    {
        super();
        ((AbstractDocument)getDocument()).setDocumentFilter(new DoubleDocumentFilter());
    }
    
    public NumberField(String text)
    {
        super();
        ((AbstractDocument)getDocument()).setDocumentFilter(new DoubleDocumentFilter());
        setText(text);//make sure the text goes through the filter
    }

    public NumberField(int columns)
    {
        super(columns);
        ((AbstractDocument)getDocument()).setDocumentFilter(new DoubleDocumentFilter());
    }

    public NumberField(String text, int columns)
    {
        super(columns);
        ((AbstractDocument)getDocument()).setDocumentFilter(new DoubleDocumentFilter());
        setText(text);
    }

    public NumberField(Document doc, String text, int columns)
    {
        super(doc, "", columns);
        ((AbstractDocument)getDocument()).setDocumentFilter(new DoubleDocumentFilter());
        setText(text);
    }
    /**
     * Gets the number in this field.  If there is a partial representation of a
     * number then any unspecified data will be filled in in the following
     * manner.  Any missing exponent will be 1, any missing number will be 1,
     * and any missing decimal will be 0.  For example "-.32e-" will evaluate to
     * -.32e-1, "-" will be -1, and "-23." will be -23.0
     * @return The double in this field
     */
    public double getNumber()
    {
        String contents = getText();
        
        if(contents.matches("-?|-?\\d*?(\\.\\d*?)?(\\d+e-?)"))
        {
            /*
             * 
             */
            contents += "1";
        }
        else if(contents.matches("-?\\d*\\."))
        {
            /*
             * "-.", ".", "-23.", and "37." should be
             *   0 ,  0 ,  -23  , and  37  respectivly which should happen if I
             * just add a 0 to the end of the string.
             */
            contents += "0";
        }
        return Double.parseDouble(contents);
    }
}
