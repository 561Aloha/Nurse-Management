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
public class Nurse {
    private int nurseID;
    private String name;
    private String password;
    private ArrayList<Shift> nurseSchedule;
    
    public Nurse(int nurseID, String name, String password)
    {
        this.nurseID = nurseID;
        this.name = name;
        this.password = password;
    }
    
    public int getNurseID()
    {
        return nurseID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public ArrayList<Shift> getNurseSchedule()
    {
        return nurseSchedule;
    }
    
    public void changePassword(String password)
    {
        this.password = password;
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
