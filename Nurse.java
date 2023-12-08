/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Romari
 */
public class Nurse extends User implements Serializable{
    private  ArrayList<Shift> nurseSchedule = new ArrayList<>();
    private boolean serialized; 
    
    public Nurse(int nurseID, String name, String password)
    {
        
        super(nurseID, name, password);
       
        
        try {
            this.serializeNurse(Integer.toString(getID()));
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
    }
    
    public ArrayList<Shift> getNurseSchedule()
    {
        return this.nurseSchedule;
    }
    
    public void changePassword(String newPassword)
    {
        this.password = newPassword;
    }
    
    public void reserveShift(Shift shift)
    {
        this.nurseSchedule.add(shift);
        try {
            this.serializeNurse(Integer.toString(getID()));
            System.out.println("After reserve Shift");
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
        AppSystem appsys = AppSystem.getInstance();
        appsys.addNurse(this);
    }
    
    public void cancelShift(Shift shift)
    {
        this.nurseSchedule.remove(shift);
        try {
            this.serializeNurse(Integer.toString(getID()));
            System.out.println("After reserve Shift");
        } catch (IOException e) {
            // Handle exception or propagate it
            System.err.println("Serialization failed: " + e.getMessage());
        }
       
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(getID()) + " " + getName() + " " + getPassword();
    }
    
    public void serializeNurse(String filename) throws IOException {
 
        File directory = new File("nurses");
        if (!directory.exists()) {
            directory.mkdirs(); // Create the folder if it doesn't exist
        }

        // Combine the folder path and filename
        String fullPath = "nurses" + File.separator + filename;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fullPath))) {
            this.serialized = true;
            out.writeObject(this);
        }
    }
}
