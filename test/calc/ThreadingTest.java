/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tobin
 */
public class ThreadingTest
{
    
    public ThreadingTest()
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
     * Test Threads
     */
    @Test
    public void testThreads()
    {
        int count = 10000;
        ExecutorService s = Executors.newFixedThreadPool(40);
        LinkedList<Future<Long>> futures = new LinkedList<Future<Long>>();
        for (int i = 0; i < count; i++)
        {
            futures.add(s.submit(new Timer(10000000)));
        }
        
        long[] times = new long[count];
        
        System.out.println("All threads started ...");
        
        for(int i = 0; i < count; i++)
        {
            try
            {
                times[i] = futures.pop().get();
            }
            catch(InterruptedException e) { System.out.println("Interrupted"); }
            catch(ExecutionException e) { System.out.println("ExecutionExecption"); }
        }
        
        Arrays.sort(times);
        
        long range = (times[count-1] - times[0]);
        System.out.println("Range: " + range);
        
//        int[] frequencies = new int[100];
        int partitions = 1000;
        int index = 0;
        for(int i = 0; i < partitions; i++)
        {
            int frequency = 0;
            for(; times[index] < times[0] + (i+1)*(double)range/(double)partitions; frequency++, index++) { }
//            frequencies[i] = frequency;
            System.out.println(((i+.5)*(double)range/(double)partitions)+"\t"+frequency);
        }
    }
    
    private class Timer implements Callable<Long>
    {
        private int count, limit;
        
        public Timer(int limit)
        {
            this.limit = limit;
        }
        
        @Override
        public Long call()
        {
            long start = System.nanoTime();
            
            while(count != limit)
            {
                Math.sqrt(count);
                count++;
            }
            
            return System.nanoTime() - start;
        }
    }

//    /**
//     * 
//     */
//    @Test
//    public void testGetMass()
//    {
//        
//    }
}
