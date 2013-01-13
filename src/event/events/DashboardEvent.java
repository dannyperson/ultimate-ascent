/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package event.events;

import core.Sensor;

/**
 *
 * @author trevornielsen
 */
public class DashboardEvent extends SensorEvent{
    
    public DashboardEvent(Sensor source, int id, double data)
    {
        super(source, id, data);
    }
    
}
