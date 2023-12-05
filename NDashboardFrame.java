/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Romari
 */
public class NDashboardFrame extends DashboardFrame{
   
    private JButton changePassBtn = new JButton("Change Password");
    private JButton viewShiftsBtn = new JButton("View Shifts");
    private JButton viewSchedBtn = new JButton("View Schedule");
    
    public NDashboardFrame()
    {
        Dimension buttonSize = new Dimension(250, 200); // Adjust the size as needed
        
        viewShiftsBtn.setPreferredSize(buttonSize);
        viewSchedBtn.setPreferredSize(buttonSize);
        changePassBtn.setPreferredSize(buttonSize);
          
        getContentPanel().add( this.menuSetup(),BorderLayout.SOUTH);
        
    }
    
    public JButton getChangePassBtn()
    {
        return changePassBtn;
    }
    
    public JButton getViewShiftsBtn()
    {
        return viewShiftsBtn;
    }
    
    public JButton getViewSchedBtn()
    {
        return viewSchedBtn;
    }
    
    @Override
    public void addMenuItems(JPanel menu)
    {   
        menu.add(viewShiftsBtn);
        menu.add(viewSchedBtn);
        menu.add(changePassBtn);   
        
    }
}
