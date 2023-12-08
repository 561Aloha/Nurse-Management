/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Romari
 */
public class ViewManager {
  
    private static ViewManager instance = new ViewManager();
    
    private LoginFrame loginframe;
    private NDashboardFrame ndashboard;
    private ADashboardFrame adashboard;
    private NShiftsFrame nshiftsframe;
    private AShiftsFrame ashiftsframe;
    private ScheduleFrame scheduleframe;
    private ChangePasswordFrame changepasswordframe;
    private NursesFrame nursesframe;
    private ShiftCreationFrame shiftcreationframe;
    private AddNurseFrame addnurseframe;
    
    private ViewManager()
    {   
    }
    
    public static ViewManager getInstance()
    {
        if(instance == null)
        {
            instance = new ViewManager();
        }
        return instance;
    }
    
    public void setVisibility(JFrame frame, boolean bool)
    {
        frame.setVisible(bool);
    }
   
    public void attachListener(JButton btn, ActionListener listener)
    {
        btn.addActionListener(listener);
    }
    
    
    public LoginFrame getLoginFrame()
    {
        return loginframe;
    }
    
    public NDashboardFrame getNDashboardFrame()
    {
        return ndashboard;
    }
    
    public ADashboardFrame getADashboardFrame()
    {
        return adashboard;
    }
    
    public NShiftsFrame getNShiftsFrame()
    {
        return nshiftsframe;
    }
    
    public AShiftsFrame getAShiftsFrame()
    {
        return ashiftsframe;
    }

    public ScheduleFrame getScheduleFrame()
    {
        return scheduleframe;
    }
   
    
    public ChangePasswordFrame getChangePasswordFrame()
    {
        return changepasswordframe;
    }
    
    public NursesFrame getNursesFrame()
    {
        return nursesframe;
    }
    
    public ShiftCreationFrame getShiftCreationFrame()
    {
        return shiftcreationframe;
    }

    public AddNurseFrame getAddNurseFrame()
    {
        return addnurseframe;
    }
    
    
    
    public void refreshLoginFrame()
    {
        loginframe = new LoginFrame();
    }
    
    public void refreshNDashboardFrame()
    {
        ndashboard = new NDashboardFrame();
    }
    
    public void refreshADashboardFrame()
    {
        adashboard = new ADashboardFrame();
    }
    
    public void refreshNShiftsFrame()
    {
        nshiftsframe = new NShiftsFrame();
    }
    
    public void refreshAShiftsFrame()
    {
        ashiftsframe = new AShiftsFrame();
    }

    public void refreshScheduleFrame()
    {
        scheduleframe = new ScheduleFrame();
    }
   
    
    public void refreshChangePasswordFrame()
    {
        changepasswordframe = new ChangePasswordFrame();
    }
    
    public void refreshNursesFrame()
    {
        nursesframe = new NursesFrame();
    }
    
    public void refreshShiftCreationFrame()
    {
        shiftcreationframe = new ShiftCreationFrame();
    }

    public void refreshAddNurseFrame()
    {
        addnurseframe = new AddNurseFrame();
    }
    
    
    
    
    
}
