/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3dviewer;

import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rmoss
 */
public class SPLFrameTest {
    
    public SPLFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCloud method, of class SPLFrame.
     */
//    @Test
//    public void testGetCloud() {
//        System.out.println("getCloud");
//        SPLFrame instance = null;
//        ArrayList<PointXYZI> expResult = null;
//        ArrayList<PointXYZI> result = instance.getCloud();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getCloudSizePts method, of class SPLFrame.
     */
    @Test
    public void testGetCloudSizePts() {
        System.out.println("getCloudSizePts");
        SPLFrame instance = new SPLFrame(new File("C:\\Work\\temp\\java exam\\Ss3DViewer\\src\\ss3dviewer\\Frame0067"));
        int expResult = 32768;
        int result = instance.getCloudSizePts();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDelimiter method, of class SPLFrame.
     */
    @Test
    public void testGetDelimiter() {
        System.out.println("getDelimiter");
        SPLFrame instance = new SPLFrame(new File("C:\\Work\\temp\\java exam\\Ss3DViewer\\src\\ss3dviewer\\Frame0067"));
        long expResult = 0xFEDCBA98L;
        long result = instance.getDelimiter();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getFrameCount method, of class SPLFrame.
//     */
//    @Test
//    public void testGetFrameCount() {
//        System.out.println("getFrameCount");
//        SPLFrame instance = null;
//        long expResult = 0L;
//        long result = instance.getFrameCount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFrameFile method, of class SPLFrame.
//     */
//    @Test
//    public void testGetFrameFile() {
//        System.out.println("getFrameFile");
//        SPLFrame instance = null;
//        File expResult = null;
//        File result = instance.getFrameFile();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loadCloud method, of class SPLFrame.
//     */
//    @Test
//    public void testLoadCloud() {
//        System.out.println("loadCloud");
//        File f = null;
//        SPLFrame instance = null;
//        instance.loadCloud(f);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class SPLFrame.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        SPLFrame.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
