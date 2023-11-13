/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;

/**
 *
 * @author Romari
 */
public class Shift {
    private int shiftID;
    private boolean isDay;
    private String hospital;
    private int nurseID;
    private Date shiftDate = new Date();
    
    public Shift(int shiftID, boolean isDay, String hospital)
    {
        this.shiftID = shiftID;
        this.isDay = isDay;
        this.hospital = hospital;
        this.nurseID = 0;
    }
    
    public int getShiftID()
    {
        return shiftID;
    }
    
    public boolean getIsDay()
    {
        return isDay;
    }
    
    public String getHospital()
    {
        return hospital;
    }
    
    public int getNurseID()
    {
        return nurseID;
    }
    
    public void assignNurseID(int nurseID)
    {
        this.nurseID = nurseID;
    }
    
    public Date getShiftDate()
    {
        return shiftDate;
    }
}
