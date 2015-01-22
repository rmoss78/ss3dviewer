/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3dviewer;

import java.util.ArrayList;
import static ss3dviewer.SPLSensorConstants.*;


/**
 *
 * @author rmoss
 */
public class PointCloud extends ArrayList {

    private ArrayList<PointXYZI> cloud;
    //int size;
    
    public PointCloud(int s){
        this.cloud = new ArrayList<PointXYZI>(s);
    }
    
}
