/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanism;

import core.GRTLoggedProcess;
import edu.wpi.first.wpilibj.SpeedController;
import event.events.SwitchEvent;
import event.listeners.SwitchListener;
import sensor.GRTSwitch;

/**
 * Mechanism code for PickerUpper
 * @author Sidd and Nadia
 */
public class PickerUpper extends GRTLoggedProcess implements SwitchListener{
    private SpeedController rollerMotor;
    private SpeedController raiserMotor;
    private GRTSwitch limitUp;
    private GRTSwitch limitDown;
    private static double ROLLER_SF = 1, RAISE_SF = 1;
    
    public PickerUpper(SpeedController rollerMotor, SpeedController raiserMotor, 
            GRTSwitch limitUp,GRTSwitch limitDown) {
        super("PickerUpper mech");
        this.rollerMotor = rollerMotor;
        this.raiserMotor = raiserMotor;
        this.limitUp = limitUp;
        this.limitDown = limitDown;
        
        //TODO
    }
    
    public void raise() {
        //if the chalupa is already raised it will not raise further
        if (!limitUp.isPressed()) { 
            raiserMotor.set(1 * RAISE_SF);
        }
    }
    
    public void lower() {
        //if the chalupa is already lowered it will not lower further
        if (!limitDown.isPressed()) { 
            raiserMotor.set(-1 * RAISE_SF);
        }
    }
    
    public void pickUp() {
        rollerMotor.set(1 * ROLLER_SF);
    }
    
    public void spitOut() {
        rollerMotor.set(-1 * ROLLER_SF);
    }
    
    public void stopRoller() {
        rollerMotor.set(0);
    }
    
    public void stopRaiser() {
        raiserMotor.set(0);
    }

    public void switchStateChanged(SwitchEvent e) {
        if (e.getSource() == limitUp) {
            stopRaiser();
        }
        else if (e.getSource() == limitDown) {
            stopRaiser();
        }
    }
    
}
