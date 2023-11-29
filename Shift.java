/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;
import java.text.SimpleDateFormat;

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
    
    public Shift(int shiftID, boolean isDay, String hospital, Date shiftDate)
    {
        this.shiftID = shiftID;
        this.isDay = isDay;
        this.hospital = hospital;
        this.shiftDate = shiftDate;
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
    
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String type="";
        if(isDay==true)
        {
            type = "Day";
        }
        else
        {
            type="Night";
        }
        
        return Integer.toString(getShiftID()) + " " + type + " " + getHospital() + " " + " " + formatter.format(getShiftDate());
    }
}
