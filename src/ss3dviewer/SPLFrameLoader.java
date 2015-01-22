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

    // Ladar sensor constants
    static final int imagesize = 32768;         // Size of image in pixels
    static final int numrows = 128;             // Number of rows in frame
    static final int numcols = 256;             // Number of columns in frame
    static final double xfov = 40.0;            // Field of view in X (Horizontal)
    static final double yfov = 20.0;            // Field of view in Y (vertical)
    static final double delta_range = 0.00625;  // meters per range count
    static final int araw_max = 1024;               // Max intenstiy (lower 10 bits of word)
    static final int araw_min = 0;                  // Max intenstiy (lower 10 bits of word)
    static final int rraw_max = 8192;               // Max Range (lower 13 bits of word)
    static final int rraw_min = 0;                  // Min Range

    // Data type of cloud
    private ArrayList<PointXYZI> cloud = new ArrayList<PointXYZI>(imagesize);

    public SPLFrameLoader(File framefile) throws IOException {

        BinaryReader in = new BinaryReader(framefile);

        // load up raw frame data points
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {

                double Theta = Math.toRadians((j - numcols / 2.0) / (numcols / 2.0) * xfov);
                double Phi = Math.toRadians((i - numrows / 2.0) / (numrows / 2.0) * yfov);

                // Read binary data from file
                int A = clamp( in.nextUByte() + (in.nextUByte() << 8), araw_min, araw_max );    // read and clamp amplitude value
                int R = clamp( in.nextUByte() + (in.nextUByte() << 8), rraw_min, rraw_max );    // read and camp range value
                
//                int A = in.nextUByte() + (in.nextUByte() << 8);    // read and clamp amplitude value
//                int R = in.nextUByte() + (in.nextUByte() << 8);    // read and camp range value
               
                // Convert raw binary to Ampl and Range
                double Range = R * delta_range;                  // Convert range to meters
                double Amplitude = (double) A / araw_max;        // Normalize amplitude to be 0-1

                // Convert polar to xyz
                double x = Range * cos(Phi) * sin(Theta);
                double y = Range * sin(Phi);
                double z = Range * cos(Phi) * cos(Theta);

                System.out.println("i=" + i + " j=" + j + " ampl=" + Amplitude + " range=" + Range + " x=" + x + " y=" + y + " z=" + z);

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

    public static int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    public static void main(String[] args) {
        File f = new File("C:\\Work\\temp\\java exam\\Ss3DViewer\\src\\ss3dviewer\\Frame0067");

//        System.out.println(args[0]);
        try {
            SPLFrameLoader x = new SPLFrameLoader(f);
        } catch (IOException ex) {
            System.out.println("Fail IOException");
        }

    }

}
