/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import core.Sensor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import event.events.DashboardEvent;
import event.listeners.DashboardListener;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author trevornielsen
 */
public class Dashboard2013 extends Sensor{
    
    public static int KEY_P = 0;
    public static int KEY_I = 1;
    public static int KEY_D = 2;
    public static int KEY_RESPONSE = 3;
    private String[] fieldNames = {"KEY_P", "KEY_I", "KEY_D", "KEY_RESPONSE"};
    private double[] initialValues = {1, 1, 1, 1};
    private Vector dashListeners;
    
    public Dashboard2013()
    {   
        super("Dashboard", 50, 3);
        
        for(int i = 0; i < fieldNames.length; i++)
        {
            SmartDashboard.putNumber(fieldNames[i], initialValues[i]);
        }
        
        dashListeners = new Vector();
    }
    
//    public void putDouble(String key, int value)
//    {
//        dash.putInt(key, value);
//        logInfo("Sent int" + value + "to dashboard key" + key + ".");
//    }
    
    protected void poll()
    {
        for(int i = 0; i < fieldNames.length; i++)
        {
            this.setState(i, SmartDashboard.getNumber(fieldNames[i]));
        }
    }

    protected void notifyListeners(int id, double newDatum) {
        DashboardEvent e = new DashboardEvent(this, id, newDatum);
        
        for (Enumeration en = dashListeners.elements(); en.hasMoreElements();)
        {
            ((DashboardListener) en.nextElement()).changed(e);
        }
        
    }
   
    public void addListener(DashboardListener l) {
        dashListeners.addElement(l);
    }

    public void removeListener(DashboardListener l) {
        dashListeners.removeElement(l);
    }
    
    public void sendDouble(int id, double data)
    {
        SmartDashboard.putNumber(fieldNames[id], data);
    }
}
