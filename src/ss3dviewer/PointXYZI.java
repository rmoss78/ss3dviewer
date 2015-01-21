/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3dviewer;

import javafx.geometry.Point3D;

/**
 *
 * @author rmoss
 * New data type to hold XYZ plus Intensity by extending Point3D.
 * 
 */
public class PointXYZI extends Point3D {
    
//    private Point3D coords;
    private double intensity;
    
    public PointXYZI(double x, double y, double z, double I){
//        coords = new Point3D(x, y, z);
        super(x, y, z);
        intensity = I;
    }
    
    public double getIntensity(){
        return intensity;
    }
                
}
