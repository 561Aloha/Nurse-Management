/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Romari
 */
public class ShiftManager 
{
    public ShiftManager()
    {
        
    }
    
    //public void reserveShift(int currentUserID, Shift shift, )
    //{
    
    //}
    
    public void cancelShift(ArrayList<Shift> availableShifts, int shiftID)
    {
        for (Shift availableShift : availableShifts) 
        {
            if(availableShift.getShiftID() == shiftID)
            {
                availableShifts.remove(availableShift);
            }
        }
    }
    
    
    
}
