/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Romari
 */
public class Shift implements Serializable{
    private int shiftID;
    private boolean isDay;
    private String hospital;
    private Date shiftDate = new Date();
    
    public Shift(int shiftID, boolean isDay, String hospital, Date shiftDate)
    {
        this.shiftID = shiftID;
        this.isDay = isDay;
        this.hospital = hospital.toLowerCase();
        this.shiftDate = shiftDate;
        
        try {
            this.serializeShift(Integer.toString(this.shiftID));
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
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
    

    public Date getShiftDate()
    {
        return shiftDate;
    }
    
    
    public void serializeShift(String filename) throws IOException {
    
        File directory = new File("shifts");
        if (!directory.exists()) {
            directory.mkdirs(); // Create the folder if it doesn't exist
        }

        // Combine the folder path and filename
        String fullPath = "shifts" + File.separator + filename;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            out.writeObject(this);
        }
    }
    
    public String getShiftDateString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return (formatter.format(getShiftDate()));
    }
    public String getTimeString()
    {
        if (this.getIsDay()==true)
        {
            return "7am-7pm";
        }
        else{
            return "7pm-7am";
        }
    }
}
