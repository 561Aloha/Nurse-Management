/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Romari
 */
public class ShiftManager 
{
    private Date date = new Date();
    
    public ShiftManager()
    {
        
    }
    
    public void createShift(ArrayList<Shift> availableShifts, Shift shift)
    {
        availableShifts.add(shift);
    }
    
    public void reserveShift(ArrayList<Shift> availableShifts, Nurse currentNurse, Shift shift)
    {
        for (Shift availableShift : availableShifts) 
        {
            if(availableShift.getShiftID() == shift.getShiftID())
            {
                availableShifts.remove(availableShift);
                currentNurse.reserveShift(shift);
            }
        }
    }
    
    
    public void cancelReservation(ArrayList<Shift> availableShifts, Nurse currentNurse, int shiftID)
    {
        ArrayList<Shift> nurseSchedule = currentNurse.getNurseSchedule();
        for (Shift currentShift : nurseSchedule) 
        {
            if(currentShift.getShiftID() == shiftID)
            {
                availableShifts.add(currentShift);
                nurseSchedule.remove(currentShift);
            }
        }
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
    
}
