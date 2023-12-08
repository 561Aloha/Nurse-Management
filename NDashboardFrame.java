/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that extends the DashboardFrame class, specifies and adds the menu 
 * buttons for the nurse user by overriding the abstract method from the 
 * superclass. Class also provides an accessor method to the frame which 
 * will enable the viewmanager class to attach the correct action listeners  
 * @author Romari
 */
public class NDashboardFrame extends DashboardFrame{
    //private instance variables 
    private JButton changePassBtn = new JButton("Change Password");
    private JButton viewShiftsBtn = new JButton("View Shifts");
    private JButton viewSchedBtn = new JButton("View Schedule");
    
    /**
     * constructor method that sets the size of the menu buttons, adds the menu
     * button panel to the content panel and attaches action listeners to the 
     * buttons 
     */
    public NDashboardFrame()
    {
        //setting the dimensions for the menu buttons
        Dimension buttonSize = new Dimension(250, 200); // Adjust the size as needed
        viewShiftsBtn.setPreferredSize(buttonSize);
        viewSchedBtn.setPreferredSize(buttonSize);
        changePassBtn.setPreferredSize(buttonSize);
        
        //adding menu panel to the content panel that was inherited from the super class
        getContentPanel().add( this.menuSetup(),BorderLayout.SOUTH);
        
        //retrieving the single instance of viewmanager and appysytem 
        ViewManager viewmanager = ViewManager.getInstance();
        AppSystem appsys = AppSystem.getInstance();
        
        //logout button action listener
        viewmanager.attachListener(getLogoutBtn(), 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshLoginFrame();
                    viewmanager.setVisibility(viewmanager.getLoginFrame().getFrame(), true);
                    appsys.setCurrentID(0);
                      
                }
            }
        );
        
        //change password button action listener
        viewmanager.attachListener(changePassBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshChangePasswordFrame();
                    viewmanager.setVisibility(viewmanager.getChangePasswordFrame().getFrame(), true);                         
                }
            }
        );
        
        //view shifts button action listener
         viewmanager.attachListener(viewShiftsBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshNShiftsFrame();
                    viewmanager.setVisibility(viewmanager.getNShiftsFrame().getFrame(), true);
                         
                }
            }
        );
         
         //view schedule button action listener
        viewmanager.attachListener(viewSchedBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshScheduleFrame();
                    viewmanager.setVisibility(viewmanager.getScheduleFrame().getFrame(), true);
                }
            }
        );
    }
    
    /**
     * method that overrides the abstract class method and adds the correct 
     * buttons for the admin dashboard options
     * @param menu the panel that contains the menu buttons
     */
    @Override
    protected void addMenuItems(JPanel menu)
    {   
        menu.add(viewShiftsBtn);
        menu.add(viewSchedBtn);
        menu.add(changePassBtn);   
        
    }
}
