/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.DocumentFilter.FilterBypass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tobin
 */
public class DoubleDocumentFilterTest
{
    
    public DoubleDocumentFilterTest()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of insertString method, of class DoubleDocumentFilter.
     */
    @Test
    public void testInsertString() throws Exception
    {
        System.out.println("insertString");
        FilterBypass fb = null;
        int offset = 0;
        String string = "";
        AttributeSet attr = null;
        DoubleDocumentFilter instance = new DoubleDocumentFilter();
        instance.insertString(fb, offset, string, attr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class DoubleDocumentFilter.
     */
    @Test
    public void testRemove() throws Exception
    {
        System.out.println("remove");
        FilterBypass fb = null;
        int offset = 0;
        int length = 0;
        DoubleDocumentFilter instance = new DoubleDocumentFilter();
        instance.remove(fb, offset, length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class DoubleDocumentFilter.
     */
    @Test
    public void testReplace() throws Exception
    {
        System.out.println("replace");
        FilterBypass fb = null;
        int offset = 0;
        int length = 0;
        String text = "";
        AttributeSet attrs = null;
        DoubleDocumentFilter instance = new DoubleDocumentFilter();
        instance.replace(fb, offset, length, text, attrs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
