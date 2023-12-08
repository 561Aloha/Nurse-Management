/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.List;

/**
 *
 * @author Romari
 */
public class AppSystem {
    
    private static AppSystem instance = null;
    
    private Admin systemAdmin;
    private static ArrayList<Shift> availableShifts = new ArrayList<>();
    private static ArrayList<Nurse> nurses = new ArrayList<>();
    private static int currentUserID;
    
    
    private AppSystem()
    {
       currentUserID = 0 ;
       systemAdmin = new Admin(1000, "admin", "admin");
       
       
       //serialize nurses
       File nurseFolder = new File("nurses");
       File[] nurseFiles = nurseFolder.listFiles();
        
       for (File nurseFile : nurseFiles) 
       {
           if (nurseFile.isFile()) {
               try (ObjectInputStream nurseOis = new ObjectInputStream(new FileInputStream(nurseFile))) 
               {
                   Nurse nurseObject = (Nurse) nurseOis.readObject();
                   nurses.add(nurseObject);
                   System.out.println(nurseObject.getID());
                   ArrayList<Shift> nurseSchedule = nurseObject.getNurseSchedule();
                   for(Shift shift1 : nurseSchedule) {
                    System.out.println(shift1);
                    }
               } catch (IOException | ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }
       }
       
        
       //serialize available shifts
       File shiftFolder = new File("shifts");
       File[] shiftFiles = shiftFolder.listFiles();

       for (File shiftFile : shiftFiles) 
       {
           if (shiftFile.isFile()) {
               try (ObjectInputStream shiftOis = new ObjectInputStream(new FileInputStream(shiftFile))) 
               {
                   Shift shiftObject = (Shift) shiftOis.readObject();
                   availableShifts.add(shiftObject);
                   System.out.println(shiftObject.getShiftID());
               } catch (IOException | ClassNotFoundException e) {
                   e.printStackTrace();
               }
           }
       }
        
        
    }
    

    public static AppSystem getInstance()
    {
       
        if (instance == null) 
        {
            instance = new AppSystem();
        }
      
        return instance;
    }
    
    public Nurse getCurrentNurse()
    {
        System.out.println(currentUserID+ "From getCurrentNurse");
        
        for(Nurse nurse: nurses)
        { System.out.println(nurse.getID()+ "Get ID From getCurrentNurse");
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
    
   
    public ArrayList<Nurse> getNurseList() {
        return nurses;
    }
    
    public ArrayList<Shift> getAvailableShifts()
    {
        return availableShifts;
    } 

    
    public int getAdminID()
    {
        return systemAdmin.getID();
    }
    
    public boolean verifyLogin(int ID, String password)
    {
        if (ID == systemAdmin.getID())
        {
            if(password.equals(systemAdmin.getPassword()))
            {
                setCurrentID(ID);
                System.out.println("Admin Login successful");
                return true;
            }
        }
        else
        {
            for(Nurse nurse: nurses)
            {
                if(ID == nurse.getID())
                {
                    if(password.equals(nurse.getPassword()))
                    {
                        setCurrentID(ID);
                        System.out.println("Nurse Login successful");
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
    
    public boolean verifyOldPass(String oldPassword, String newPassword)
    {
        for(Nurse nurse: nurses)
        {
            if(currentUserID == nurse.getID())
            {
                if (oldPassword.equals(nurse.getPassword()))
                {
                    nurse.changePassword(newPassword);
                    return true;
                }
            }
        }
        return false;
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
    
    
    public static void removeNurseFile(Nurse nurse){
        //nurses.remove(nurse);
        //System.out.println("removed");
        String directoryPath = "nurses";
        String filename = "nurses" + File.separator + String.valueOf(nurse.getID());
        File fileToDelete = new File(filename);
        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (isDeleted) {
                System.out.println("Nurse file deleted successfully.");
            } else {
                System.out.println("Failed to delete the nurse file.");
            }
        }    
    }
    
    public static void removeShiftFile(Shift shift){
        availableShifts.remove(shift);
        System.out.println("removed shift");
        String directoryPath = "shifts";
        String filename = "shifts" + File.separator + String.valueOf(shift.getShiftID());
        File fileToDelete = new File(filename);
        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (isDeleted) {
                System.out.println("Shift file deleted successfully.");
            } else {
                System.out.println("Failed to delete the shift file.");
            }
        }    
    }
     
  
    public void addNurse(Nurse nurseObject)
    {
        nurses.add(nurseObject);
    }
    
    public void changePassword()
    {
        Nurse nurse = getCurrentNurse();
        removeNurseFile(nurse);
        try {
            nurse.serializeNurse(Integer.toString(nurse.getID()));
        } catch (IOException ex) {
            Logger.getLogger(AppSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
