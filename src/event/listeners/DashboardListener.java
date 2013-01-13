/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package event.listeners;

import event.events.DashboardEvent;

/**
 *
 * @author trevornielsen
 */
public interface DashboardListener extends SensorChangeListener{
    
    public void changed(DashboardEvent e);
    
}
