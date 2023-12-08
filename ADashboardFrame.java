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
 * buttons for the admin user by overriding the abstract method from the 
 * superclass. Class also provides an accessor method to the frame which 
 * will enable the viewmanager class to attach the correct action listeners 
 * @author Romari
 */
public class ADashboardFrame extends DashboardFrame{
    //private instance variables 
    private JButton viewShiftsBtn = new JButton("View Shifts");
    private JButton nursesBtn = new JButton("View Nurses");
    private JButton addNurseBtn = new JButton("Add Nurse");
    private JButton createShiftBtn = new JButton("Create Shift");
    
    public ADashboardFrame()
    {   
        //setting the dimensions for the menu buttons
        Dimension buttonSize = new Dimension(250, 200); // Adjust the size as needed
        viewShiftsBtn.setPreferredSize(buttonSize);
        nursesBtn.setPreferredSize(buttonSize);
        addNurseBtn.setPreferredSize(buttonSize);
        createShiftBtn.setPreferredSize(buttonSize);
         
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
        
        //add nurse button action listener
        viewmanager.attachListener(addNurseBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshAddNurseFrame();
                    viewmanager.setVisibility(viewmanager.getAddNurseFrame().getFrame(), true);
                         
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
                    viewmanager.refreshAShiftsFrame();
                    viewmanager.setVisibility(viewmanager.getAShiftsFrame().getFrame(), true);
                         
                }
            }
        );
         
        //view nurses button action listener
        viewmanager.attachListener(nursesBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshNursesFrame();
                    viewmanager.setVisibility(viewmanager.getNursesFrame().getFrame(), true);
                         
                }
            }
        );
        
        //create new shift button action listener
        viewmanager.attachListener(createShiftBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    viewmanager.setVisibility(getFrame(), false);
                    getFrame().dispose();
                    viewmanager.refreshShiftCreationFrame();
                    viewmanager.setVisibility(viewmanager.getShiftCreationFrame().getFrame(), true);
                         
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
        menu.add(nursesBtn);
        menu.add(addNurseBtn);
        menu.add(createShiftBtn);        
        
    }
    
}
