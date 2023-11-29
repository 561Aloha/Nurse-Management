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
public class Nurse extends User{
    private ArrayList<Shift> nurseSchedule;
    
    public Nurse(int nurseID, String name, String password)
    {
        super(nurseID, name, password);
    }
    
    public ArrayList<Shift> getNurseSchedule()
    {
        return nurseSchedule;
    }
    
    public void changePassword(String newPassword)
    {
        this.password = newPassword;
    }
    
    public void reserveShift(Shift shift)
    {
        this.nurseSchedule.add(shift);
    }
    
    public void cancelShift(Shift shift)
    {
        this.nurseSchedule.remove(shift);
    }
}
