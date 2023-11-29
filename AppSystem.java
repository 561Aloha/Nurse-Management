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
public class AppSystem {
    private Admin systemAdmin;// = new Admin(1000, "admin");
    private Nurse testNurse;
    private ArrayList<Shift> availableShifts = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    //private ArrayList<String> hospitals;
    private int currentUserID;
    private Date currentDate = new Date();
    
    public AppSystem()
    {
       systemAdmin = new Admin(1000, "admin", "admin");
       testNurse = new Nurse(1001,"Test Nurse", "test");
       
       //availableShifts.add(new Shift(2000,true,"Hospital A", new Date(40, 9, 19)));
       //hospitals.add("Hospital A");
       //hospitals.add("Hospital B");
       //hospitals.add("Hospital C");
       //hospitals.add("Hospital D");
    }
    
    public Nurse getCurrentNurse()
    {
        for(Nurse nurse: nurses)
        {
            if(currentUserID == nurse.getID())
            {
                return nurse;
            }
        }
        return null;
    }
    
    public void setCurrentID(int ID)
    {
        currentUserID = ID;
    }
    
    public ArrayList<Nurse> getNurses()
    {
        return nurses;
    }
    
    public ArrayList<Shift> getAvailableShifts()
    {
        return availableShifts;
    }
    
    public void verifyLogin(int ID, String password)
    {
        if (ID == systemAdmin.getID())
        {
            if(password.equals(systemAdmin.getPassword()))
            {
                setCurrentID(ID);
                System.out.println("Admin Login successful");
                //return;
            }
        }
        else
        {
            for(Nurse nurse: nurses)
            {
                if(ID == nurse.getID())
                {
                    setCurrentID(ID);
                    System.out.println("Nurse Login successful");
                    //return;
                }
            }
        }
    }
    
    public void verifyOldPass(String oldPassword, String newPassword)
    {
        for(Nurse nurse: nurses)
            {
                if(currentUserID == nurse.getID())
                {
                    if (oldPassword.equals(nurse.getPassword()))
                    {
                        nurse.changePassword(newPassword);
                    }
                    //return;
                }
            }
    }
    
    public void addNurse(int nurseID, String name, String password)
    {
        nurses.add(new Nurse(nurseID, name, password));
    }
    
    public void deleteNurse(int nurseID)
    {
        for(Nurse nurse: nurses)
        {
            if(nurseID == nurse.getID())
            {
                nurses.remove(nurse);
            }
        }
    }
}
