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
    private ArrayList<Shift> availableShifts;
    private ArrayList<Nurse> nurses;
    private int currentUserID;
    private Date currentDate = new Date();
    
    public AppSystem()
    {
       systemAdmin = new Admin(1000, "admin");
    }
    
    public void verifyLogin(int ID, String password)
    {
        if (ID == systemAdmin.getAdminID())
        {
            if(password.equals(systemAdmin.getPassword()))
            {
                currentUserID = ID;
                System.out.println("Admin Login successful");
            }
        }
        else
        {
            for(Nurse nurse: nurses)
            {
                if(ID == nurse.getNurseID())
                {
                    currentUserID = ID;
                    System.out.println("Nurse Login successful");
                }
            }
        }
    }
}
