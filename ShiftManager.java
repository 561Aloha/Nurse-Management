/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.AppSystem.removeShiftFile;

/**
 *
 * @author Romari
 */
public class ShiftManager 
{
    private Date date = new Date();
    AppSystem appsys = AppSystem.getInstance();
    
    public ShiftManager()
    {
        
    }
    
    public void createShift(ArrayList<Shift> availableShifts, Shift shift)
    {
        availableShifts.add(shift);
    }
    
    
    public void reserveShift( Shift shift)
    {

        Nurse currentNurse = appsys.getCurrentNurse();
        appsys.removeNurseFile(currentNurse);
        currentNurse.reserveShift(shift);
        appsys.setCurrentID(currentNurse.getID());
        appsys.removeShiftFile(shift);
        
       

    }
    
    public void cancelReservation(Shift shift)
    {
        
        appsys.getCurrentNurse().cancelShift(shift);
    }
    
    
    
    public void deleteShift(ArrayList<Shift> availableShifts, int shiftID)
    {
        for (Shift availableShift : availableShifts) 
        {
            if(availableShift.getShiftID() == shiftID)
            {
                availableShifts.remove(availableShift);
            }
        }
    }
    
    public void removeExpired(ArrayList<Shift> availableShifts)
    {
        for (Shift availableShift : availableShifts) 
        {
            if(availableShift.getShiftDate().getTime() < date.getTime())
            {
                availableShifts.remove(availableShift);
            }
        }
    }
    
    public void recreateShift(ArrayList<Shift> availableShifts, Shift shift)
    {
        availableShifts.add(shift);
        try {
            shift.serializeShift(Integer.toString(shift.getShiftID()));
        } catch (IOException ex) {
            Logger.getLogger(ShiftManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addShift(Shift shift) 
    {
        appsys.getAvailableShifts().add(shift);
    }
    
    public void removeShift(Shift shift)
    {
        appsys.getAvailableShifts().remove(shift);
        removeShiftFile(shift);
    }
    
}
