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
    
    public static int KEY_DRIVETRAIN_L = 0;
    public static int KEY_DRIVETRAIN_R = 1;
    private String[] fieldNames = {"KEY_DRIVETRAIN_L", "KEY_DRIVETRAIN_R"};
    private double[] initialValues = {1, 1};
    private Vector dashListeners;
    
    public Dashboard2013()
    {   
        super("Dashboard", 50, 2);
        
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
			this.setState(0, SmartDashboard.getNumber(fieldNames[0]));
    }

    protected void notifyListeners(int id, double newDatum) {
        DashboardEvent e = new DashboardEvent(this, id, newDatum);
        logInfo("Datum:" + fieldNames[id] + " Datum: " + newDatum);
        
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
    
//    public void sendNumber(int id, double data)
//    {
//        SmartDashboard.putNumber(fieldNames[id], data);
//    }
}
