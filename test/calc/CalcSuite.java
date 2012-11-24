/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

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
    calc.StationaryPointTest.class, calc.GraphicsThreadTest.class,
    calc.ConstantPointTest.class, calc.CartesianVectorTest.class,
    calc.InversePointTest.class, calc.SquaredPointTest.class,
    calc.ThreadingTest.class, calc.PreciseColorTest.class,
    calc.GeneralPointTest.class
})
public class CalcSuite
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
