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
public class nDashboard {
    
    JFrame frame = new JFrame("Welcome");
    
    public nDashboard()
    {

        JLabel heading = new JLabel("eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        JLabel subheading = new JLabel("Nurse Dashboard");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
        JButton button1 = new JButton("Home");
        JButton button2 = new JButton("Change Password");
        JButton button3 = new JButton("Logout");
        
       
        
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(heading);
        leftPanel.add(subheading);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        
        

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
        
        // The Nurse Menu Items
        MenuPanel menuPanel = new MenuPanel();
        contentPanel.add(menuPanel.menuu, BorderLayout.SOUTH);
        int bottomPadding = 350; // The PADDING
        menuPanel.menuu.setBorder(BorderFactory.createEmptyBorder(0, 0, bottomPadding, 0)); // activates the bottomPadding
    
        // Set layout manager for the frame
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        
        //frame.add(welcomePanel);
        
        // Add the content panel to the frame
        frame.add(contentPanel);

        // sets the frame visibility to true
        //frame.setVisible(true);

        // This method sets the width and height of the frame
        frame.setSize(800, 800); // Adjust the size as needed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private static class MenuPanel {
        JButton search = new JButton("Search");
        JButton nurse = new JButton("Nurse Profile");
        JButton viewSch = new JButton("View Schedule");

        JPanel menuu = new JPanel(new FlowLayout()); // Use FlowLayout for horizontal arrangement

        public MenuPanel() {
            Dimension buttonSize = new Dimension(250, 200); // Adjust the size as needed
            search.setPreferredSize(buttonSize);
            nurse.setPreferredSize(buttonSize);
            viewSch.setPreferredSize(buttonSize);

            menuu.add(search);
            menuu.add(nurse);
            menuu.add(viewSch);
        }
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
}
