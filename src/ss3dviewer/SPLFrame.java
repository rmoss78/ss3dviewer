/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3dviewer;

import java.io.File;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static ss3dviewer.SPLSensorConstants.*;

/**
 *
 * @author rmoss
 */
public class SPLFrame {
    
    // Instance Variables
    private long delimiter;
    private File framefile;
    private PointCloud cloud;
    
    // Constructor
    public SPLFrame(File f) {
        this.framefile = f;
        this.cloud = loadCloud(this.framefile);
    }    
    
    public PointCloud getCloud(){
        return this.cloud;
    }
    
    public long getDelimiter(){
        return this.delimiter;
    }
    
    // Load point cloud from binary file
    public PointCloud loadCloud(File f){
        
        BinaryReader in = new BinaryReader(framefile);
        
        for (int i = 0; i < numrows; i++) {
            for (int j = 0; j < numcols; j++) {

                double Theta = Math.toRadians((j - numcols / 2.0) / (numcols / 2.0) * xfov);
                double Phi = Math.toRadians((i - numrows / 2.0) / (numrows / 2.0) * yfov);

                // Read binary data from file
                int A = clamp( in.nextUByte() + (in.nextUByte() << 8), araw_min, araw_max );    // read and clamp amplitude value
                int R = clamp( in.nextUByte() + (in.nextUByte() << 8), rraw_min, rraw_max );    // read and camp range value
                              
                // Convert raw binary to Ampl and Range
                double Range = R * delta_range;                  // Convert range to meters
                double Amplitude = (double) A / araw_max;        // Normalize amplitude to be 0-1

                // Convert polar to xyz
                double x = Range * cos(Phi) * sin(Theta);
                double y = Range * sin(Phi);
                double z = Range * cos(Phi) * cos(Theta);

                PointXYZI point = new PointXYZI(x, y, z, A);
                this.cloud.add(point);
            }
        }
        
        return this.cloud;
    }
    
    // Clamp integer values at min and max
    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
        
}
