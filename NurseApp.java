/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        Filter filter = new Filter();
        
        //frames
        LoginFrame loginframe = new LoginFrame();
        NDashboardFrame ndashboard = new NDashboardFrame();
        ADashboardFrame adashboard = new ADashboardFrame();
        NShiftsFrame nshiftsframe = new NShiftsFrame();
        AShiftsFrame ashiftsframe = new AShiftsFrame();
        ScheduleFrame scheduleframe = new ScheduleFrame();
        ChangePasswordFrame changepasswordframe = new ChangePasswordFrame();
        NursesFrame nursesframe = new NursesFrame();
        ShiftCreationFrame shiftcreationframe = new ShiftCreationFrame();
        AddNurseFrame addnurseframe = new AddNurseFrame();
        
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
        
        
        ///////////////////////////////change password frame///////////////////////////////
        //submit change button action listener
        viewmanager.attachListener(changepasswordframe.getBtn(), 
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
        
        
        ///////////////////////////////admin nurses frame///////////////////////////////
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
    }
}
