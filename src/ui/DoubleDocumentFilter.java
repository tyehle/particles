package ui;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 * A document filter which only allows decimals in standard or scientific
 * notation.
 * @author Tobin
 * @version 4.1
 */
public class DoubleDocumentFilter extends DocumentFilter
{
    /**
     * Typically called when writing to the document.
     * @param fb
     * @param offset
     * @param string
     * @param attr
     * @throws BadLocationException 
     */
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
    {
        if(isValid(fb.getDocument(), offset, 0, string))
        {
            super.insertString(fb, offset, string, attr);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException
    {
        super.remove(fb, offset, length);
    }
    /**
     * Typically called when pasting to the document.
     * @param fb
     * @param offset
     * @param length
     * @param text
     * @param attrs
     * @throws BadLocationException 
     */
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException
    {
        if(isValid(fb.getDocument(), offset, length, text))
        {
            super.replace(fb, offset, length, text, attrs);
        }
        else
        {
            Toolkit.getDefaultToolkit().beep();
        }
    }
    /**
     * Tells whether or not the given string is a valid input for the document.
     * @param s The string to test
     * @return If the given string is valid input
     */
    private boolean isValid(Document d, int offset, int length, String text)
    {
        try
        {
            String s = d.getText(0, offset) + text + d.getText(offset + length, d.getLength() - offset - length);
            return s.matches("-?\\d*?(\\.\\d*?)?(\\d+e-?\\d*)?");
        }
        catch (BadLocationException ex)
        {
            return false;
        }
    }
}
