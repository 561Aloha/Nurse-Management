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
public class NDashboardFrame {
    private JFrame frame = new JFrame("Welcome");
    private JButton changePassBtn = new JButton("Change Password");
    private JButton logoutBtn = new JButton("Logout");
    
    private JButton viewShiftsBtn = new JButton("View Shifts");
    private JButton viewSchedBtn = new JButton("View Schedule");
    
    public NDashboardFrame()
    {

        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Nurse Dashboard");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
        
       
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(changePassBtn );
        buttonPanel.add(logoutBtn);
        
        

        //The Header BorderLayout
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(buttonPanel, BorderLayout.NORTH);
        contentPanel.add(new JSeparator(), BorderLayout.CENTER); // Horizontal Line
        
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        contentPanel.add(welcomeLabel); 
        
        
        JPanel menu = new JPanel(new FlowLayout()); // Use FlowLayout for horizontal arrangement
        Dimension buttonSize = new Dimension(250, 200); // Adjust the size as needed
        viewShiftsBtn.setPreferredSize(buttonSize);
        viewSchedBtn.setPreferredSize(buttonSize);

        menu.add(viewShiftsBtn);
        menu.add(viewSchedBtn);
        
        contentPanel.add(menu, BorderLayout.SOUTH);
        int bottomPadding = 350;
        menu.setBorder(BorderFactory.createEmptyBorder(0, 0, bottomPadding, 0));    
         
        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //frame.add(welcomePanel);
        
        // Add the content panel to the frame
        frame.add(contentPanel);

        // This method sets the width and height of the frame
        frame.setSize(800, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public JButton getChangePassBtn()
    {
        return changePassBtn;
    }
    
    public JButton getLogoutBtn()
    {
        return logoutBtn;
    }
    
    public JButton getViewShiftsBtn()
    {
        return viewShiftsBtn;
    }
    
    public JButton getViewSchedBtn()
    {
        return viewSchedBtn;
    }
   
}
