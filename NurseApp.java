/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;



/**
 *
 * @author Romari
 */
public class NurseApp {
    public static void main(String[] args)
    {
        AppSystem appsys = new AppSystem();
        ViewManager viewmanager = new ViewManager();
        ShiftManager shiftmanager = new ShiftManager();
        Sort sort = new Sort();
        //Filter filter = new Filter();
        
        //frames
        LoginFrame loginframe = new LoginFrame();
        NDashboardFrame ndashboard = new NDashboardFrame();
        ADashboardFrame adashboard = new ADashboardFrame();
        NShiftsFrame nshiftsframe = new NShiftsFrame();
        AShiftsFrame ashiftsframe = new AShiftsFrame();
        //ScheduleFrame scheduleframe = new ScheduleFrame();
        ChangePasswordFrame changepasswordframe = new ChangePasswordFrame();
        NursesFrame nursesframe = new NursesFrame();
        ShiftCreationFrame shiftcreationframe = new ShiftCreationFrame();
        AddNurseFrame addnurseframe = new AddNurseFrame();
        
        //public static ArrayList<Nurse> getNurseList() 
        //{
           // return appsys.getAvailableShifts;
        //}
    
        
        /*
        Shift shift1 = new Shift(2000,true,"Hospital A", new Date(120, 10, 15));
        Shift shift2 = new Shift(2000,false,"Hospital B", new Date(123, 1, 11));
        Shift shift3 = new Shift(2000,true,"Hospital C", new Date(122, 4, 22));
        Shift shift4 = new Shift(2000,true,"Hospital D", new Date(123, 9, 1));
        
        shiftmanager.createShift(appsys.getAvailableShifts(), shift1);
        shiftmanager.createShift(appsys.getAvailableShifts(), shift2);
        shiftmanager.createShift(appsys.getAvailableShifts(), shift3);
        shiftmanager.createShift(appsys.getAvailableShifts(), shift4);
        
        
        System.out.println("Original shifts");
        ArrayList<Shift> shifts =  appsys.getAvailableShifts();
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        
        
        //sorting
        ///////////////////////////////////////////////////////////////////////
        //testing sort shifts by date
        sort.sortCollection(shifts, sort.getCompByShiftDate());
        System.out.println("Sorted shifts by date");
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        //testing sort shifts by hospital
        sort.sortCollection(shifts, sort.getCompByShiftHospital());
        System.out.println("Sorted shifts by hospital");
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        //testing sort shifts by type
        sort.sortCollection(shifts, sort.getCompByShiftType());
        System.out.println("Sorted shifts by type");
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        
        
        //filtering
        ///////////////////////////////////////////////////////////////////////
        //testing filter shifts by hospital
        System.out.println("filtering hospital A shifts");
        ArrayList<Shift> shiftsA = filter.filterShiftsByHospital(shifts, 1);
        for(Shift shift: shiftsA)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering hospital B shifts");
        ArrayList<Shift> shiftsB = filter.filterShiftsByHospital(shifts, 2);
        for(Shift shift: shiftsB)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering hospital C shifts");
        ArrayList<Shift> shiftsC = filter.filterShiftsByHospital(shifts, 3);
        for(Shift shift: shiftsC)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering hospital D shifts");
        ArrayList<Shift> shiftsD = filter.filterShiftsByHospital(shifts, 4);
        for(Shift shift: shiftsD)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
         //testing filter shifts by type
        System.out.println("filtering night shifts");
        ArrayList<Shift> shiftsNight = filter.filterShiftsByType(shifts, 0);
        for(Shift shift: shiftsNight)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering day shifts");
        ArrayList<Shift> shiftsDay = filter.filterShiftsByType(shifts, 1);
        for(Shift shift: shiftsDay)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        */
        
        //ArrayList<Nurse> nursesTest2 = appsys.getNurses();
        
        
        
       
        
        System.out.println("Listing nurses");
        ArrayList<Nurse> nursesTest = appsys.getNurses();
        for(Nurse nurse: nursesTest)
        {
            System.out.println(nurse.toString());
        }
        System.out.println("");
        
        System.out.println("Listing shifts");
        ArrayList<Shift> shiftsTest = appsys.getAvailableShifts();
        for(Shift shift: shiftsTest)
        {
            System.out.println(shift.toString());
        }
        
        
        
        ///////////////////////////////login frame///////////////////////////////
        //login button action listener
        viewmanager.attachListener(loginframe.getBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String id = loginframe.getJtxtField().getText();
                    String password = loginframe.getPassField().getText();
                
                    if (appsys.verifyLogin(Integer.parseInt(id), password)==true)
                    {
                        
                        
                        viewmanager.setVisibility(loginframe.getFrame(), false);
                        
                        if(Integer.parseInt(id) == appsys.getAdminID())
                        {
                            viewmanager.setVisibility(adashboard.getFrame(), true);
                        }
                        else
                        {
                            viewmanager.setVisibility(ndashboard.getFrame(), true);
                        }
                        
                        loginframe.getJtxtField().setText("");
                        loginframe.getPassField().setText("");
                        
                        //ScheduleFrame.Schedule obj = new ScheduleFrame().new Schedule();
                        //obj.displayShifts();
                    }       
                }
            }
        );
        
        
        ///////////////////////////////nurse dashboard frame///////////////////////////////
        //logout button action listener
        viewmanager.attachListener(ndashboard.getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(ndashboard.getFrame(), false);
                    viewmanager.setVisibility(loginframe.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //change password button action listener
        viewmanager.attachListener(ndashboard.getChangePassBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(ndashboard.getFrame(), false);
                    viewmanager.setVisibility(changepasswordframe.getFrame(), true);                         
                }
            }
        );
        
        //view shifts button action listener
         viewmanager.attachListener(ndashboard.getViewShiftsBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(ndashboard.getFrame(), false);
                    viewmanager.setVisibility(nshiftsframe.getFrame(), true);
                         
                }
            }
        );
         
        //view schedule button action listener
        viewmanager.attachListener(ndashboard.getViewSchedBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    ScheduleFrame scheduleframe = new ScheduleFrame();
                    ///////////////////////////////schedule frame (nurse)///////////////////////////////
        //logout button action listener
        viewmanager.attachListener(scheduleframe.getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(scheduleframe.getFrame(), false);
                    viewmanager.setVisibility(loginframe.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //home button action listener
        viewmanager.attachListener(scheduleframe.getHomeBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(scheduleframe.getFrame(), false);
                    viewmanager.setVisibility(ndashboard.getFrame(), true);
                         
                }
            }
        );
                    viewmanager.setVisibility(ndashboard.getFrame(), false);
                    viewmanager.setVisibility(scheduleframe.getFrame(), true);
                    
                    
                    
                }
            }
        );
        
        
        
        ///////////////////////////////change password frame///////////////////////////////
        //submit change button action listener
        viewmanager.attachListener(changepasswordframe.getSubmitChangeBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String oldPassword = changepasswordframe.getOldPassword().getText();
                    String newPassword = changepasswordframe.getNewPassword().getText();
                
                    if (appsys.verifyOldPass(oldPassword, newPassword)==true)
                    {
                        viewmanager.setVisibility(ndashboard.getFrame(), true);
                        viewmanager.setVisibility(changepasswordframe.getFrame(), false);
                        changepasswordframe.getOldPassword().setText("");
                        changepasswordframe.getNewPassword().setText("");
                    }       
                }
            }
        );
        
        //go back button action listener
        viewmanager.attachListener(changepasswordframe.getNoChangesBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(changepasswordframe.getFrame(), false);
                    viewmanager.setVisibility(ndashboard.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        
        ///////////////////////////////add nurse frame///////////////////////////////
        //add nurse button action listener
        viewmanager.attachListener(addnurseframe.getBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String id = addnurseframe.getID().getText();
                    String name = addnurseframe.getName().getText();
                    String password = addnurseframe.getPassword().getText();
                    appsys.addNurse(Integer.parseInt(id), name, password);
                    viewmanager.setVisibility(addnurseframe.getFrame(), false);
                    viewmanager.setVisibility(adashboard.getFrame(), true);                         
                }
            }
        );
        
        //go back button action listener
        viewmanager.attachListener(addnurseframe.getNoChangesBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(addnurseframe.getFrame(), false);
                    viewmanager.setVisibility(adashboard.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        
        ///////////////////////////////admin dashboard frame///////////////////////////////
        //logout button action listener
        viewmanager.attachListener(adashboard.getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(adashboard.getFrame(), false);
                    viewmanager.setVisibility(loginframe.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //add nurse button action listener
        viewmanager.attachListener(adashboard.getAddNurseBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(adashboard.getFrame(), false);
                    viewmanager.setVisibility(addnurseframe.getFrame(), true);
                         
                }
            }
        );
        
        //view shifts button action listener
         viewmanager.attachListener(adashboard.getViewShiftsBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(adashboard.getFrame(), false);
                    viewmanager.setVisibility(ashiftsframe.getFrame(), true);
                         
                }
            }
        );
         
        //view nurses button action listener
        viewmanager.attachListener(adashboard.getNursesBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(adashboard.getFrame(), false);
                    viewmanager.setVisibility(nursesframe.getFrame(), true);
                         
                }
            }
        );
        
        //create new shift button action listener
        viewmanager.attachListener(adashboard.getCreateShiftBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(adashboard.getFrame(), false);
                    viewmanager.setVisibility(shiftcreationframe.getFrame(), true);
                         
                }
            }
        );
        
        
        ///////////////////////////////nurses frame (admin)///////////////////////////////
        //logout button action listener
        viewmanager.attachListener(nursesframe.getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(nursesframe.getFrame(), false);
                    viewmanager.setVisibility(loginframe.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //home button action listener
        viewmanager.attachListener(nursesframe.getHomeBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(nursesframe.getFrame(), false);
                    viewmanager.setVisibility(adashboard.getFrame(), true);
                         
                }
            }
        );
        
        //remove nurse action listener 
        viewmanager.attachListener(nursesframe.getDeleteShiftsBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    nursesframe.deleteSelectedNurse();
                }
            }
        );
        
        
        
        ///////////////////////////////shifts frame (nurse)///////////////////////////////
        //logout button action listener
        viewmanager.attachListener(nshiftsframe.getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(nshiftsframe.getFrame(), false);
                    viewmanager.setVisibility(loginframe.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //home button action listener
        viewmanager.attachListener(nshiftsframe.getHomeBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(nshiftsframe.getFrame(), false);
                    viewmanager.setVisibility(ndashboard.getFrame(), true);
                         
                }
            }
        );
        
        
        
        ///////////////////////////////shifts frame (admin)///////////////////////////////
        //logout button action listener
        viewmanager.attachListener(ashiftsframe.getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(ashiftsframe.getFrame(), false);
                    viewmanager.setVisibility(loginframe.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //home button action listener
        viewmanager.attachListener(ashiftsframe.getHomeBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(ashiftsframe.getFrame(), false);
                    viewmanager.setVisibility(adashboard.getFrame(), true);
                         
                }
            }
        );
        
        
        
        
        
        
        ///////////////////////////////shift creation frame (admin)///////////////////////////////
        //go back button action listener
        viewmanager.attachListener(shiftcreationframe.getNoChangesBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(shiftcreationframe.getFrame(), false);
                    viewmanager.setVisibility(adashboard.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        //create shift button action listener
        viewmanager.attachListener(shiftcreationframe.getCreateShiftBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    
                    Integer id = Integer.valueOf(shiftcreationframe.getID().getText());
                    
                    boolean isday = true;
                    String type = shiftcreationframe.getType().getText().toLowerCase();
                    if(type.equals("night"))
                    {
                        isday = false;
                    }
                    
                    String hospital = shiftcreationframe.getHospital().getText().toLowerCase();
                    
                    Integer dateD = Integer.valueOf(shiftcreationframe.getDateD().getText());
                    Integer dateM = Integer.valueOf(shiftcreationframe.getDateM().getText());
                    Integer dateY = Integer.valueOf(shiftcreationframe.getDateY().getText());
                    Date date = new Date(dateY-1900,dateM-1,dateD);
                    
                    
                    
                    shiftmanager.createShift(appsys.getAvailableShifts(), new Shift(id,isday,hospital,date));
                    
                    viewmanager.setVisibility(shiftcreationframe.getFrame(), false);
                    viewmanager.setVisibility(adashboard.getFrame(), true);
                    appsys.setCurrentID(0);
                         
                }
            }
        );
        
        
    }
}
