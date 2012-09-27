/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Tobin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    ui.PointCreationDialogTest.class, ui.PointCreationPanelTest.class,
    ui.ParticleListenerTest.class, ui.ProTesterTest.class,
    ui.ChargedPointCreationPanelTest.class, ui.ParticleFrameTest.class,
    ui.UtilTest.class, ui.NumberFieldTest.class,
    ui.DoubleDocumentFilterTest.class
})
public class UiSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}
