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
public class ADashboardFrame extends DashboardFrame{
    
    private JButton viewShiftsBtn = new JButton("View Shifts");
    private JButton nursesBtn = new JButton("View Nurses");
    private JButton addNurseBtn = new JButton("Add Nurse");
    private JButton createShiftBtn = new JButton("Create Shift");
    
    public ADashboardFrame()
    {   
        Dimension buttonSize = new Dimension(250, 200); // Adjust the size as needed
        
        viewShiftsBtn.setPreferredSize(buttonSize);
        nursesBtn.setPreferredSize(buttonSize);
        addNurseBtn.setPreferredSize(buttonSize);
        createShiftBtn.setPreferredSize(buttonSize);
          
        getContentPanel().add( this.menuSetup(),BorderLayout.SOUTH);   
    }
    

    public JButton getViewShiftsBtn()
    {
        return viewShiftsBtn;
    }
    
    public JButton getNursesBtn()
    {
        return nursesBtn;
    }
    
    public JButton getAddNurseBtn()
    {
        return addNurseBtn;
    }
    
    public JButton getCreateShiftBtn()
    {
        return createShiftBtn;
    }

    @Override
    public void addMenuItems(JPanel menu)
    {
        
        menu.add(viewShiftsBtn);
        menu.add(nursesBtn);
        menu.add(addNurseBtn);
        menu.add(createShiftBtn);        
        
    }
    
}
