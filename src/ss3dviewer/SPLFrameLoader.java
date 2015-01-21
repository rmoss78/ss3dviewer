/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3dviewer;

import java.io.File;
import java.io.IOException;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;

/**
 *
 * @author rmoss
 */
public class SPLFrameLoader {

    static final int imagesize = 32768;
    static final int numrows = 128;
    static final int numcols = 256;
    static final double xfov = 40.0;
    static final double yfov = 20.0;

    private ArrayList<PointXYZI> cloud = new ArrayList<PointXYZI>(imagesize);

    public SPLFrameLoader(File framefile) throws IOException {

        BinaryReader in = new BinaryReader(framefile);
        PointXYZI point1 = new PointXYZI(1.1, 1.2, 1.3, 100.7);
        PointXYZI point2 = new PointXYZI(9.9, 8.8, 7.7, 98.7);
//        PrintStream out = System.out;

//        PointCloud cloud = new PointCloud();

        // load up raw frame data points
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {
                System.out.print("i=" + i);
                System.out.println(" j=" + j);
                double Theta = Math.toRadians( (j - numcols/2.0)/(numcols/2.0)*xfov );
                double Phi = Math.toRadians( (i - numrows/2.0)/(numrows/2.0)*yfov );
                Short A = in.nextShort();
                //System.out.print(" ampl=" + A);
                Short R = in.nextShort();
                //System.out.println(" range=" + R);
                
                double x = R*cos(Phi)*sin(Theta);
                double y = R*sin(Phi);
                double z = R*cos(Phi)*cos(Theta);
                
                PointXYZI point = new PointXYZI(x, y, z, A);
                this.cloud.add(point);
            }
        }

        System.out.printf("ArrayList Size = %d\n", this.cloud.size());

    }
    
    //[i, j, R, I] to [x, y, z, I] converter
    private void PolartoXYZIConverter() {
        
         short ampl;
         short range;

        for (int i = 1; i < numrows; i++) {
            System.out.println("i is: " + i);
            for (int j = 1; j < numcols; j++) {
                System.out.println("j is: " + i);
            }
        }
        
    }

//    private ArrayList<PointXYZI> LoadPoints(FileInputStream in, ArrayList<PointXYZI> points) {
//
//        int c;
//        
//        try {
//            while ((c = in.read()) != -1) {
//                points.add(c);
//            }
//        }finally {
//            if (in != null) {
//                in.close();
//            }
//        }
//        
//        return points;
//    }
    public static void main(String[] args) {
        File f = new File("C:\\Work\\temp\\java exam\\Ss3DViewer\\src\\ss3dviewer\\Frame0066");

//        System.out.println(args[0]);
        try {
            SPLFrameLoader x = new SPLFrameLoader(f);
        } catch (IOException ex) {
            System.out.println("Fail IOException");
        }

    }

}
