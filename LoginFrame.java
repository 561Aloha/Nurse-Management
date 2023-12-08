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
 *
 * @author Romari
 */
public class LoginFrame {
    private JFrame frame = new JFrame("Login");  
    private JButton loginBtn = new JButton("Login"); 
    private JTextField name = new JTextField(10);
    private JPasswordField password = new JPasswordField(10);
    
    
    public LoginFrame()
    {
     
        //Creating JLabel
        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("Password");

  
        l1.setLabelFor(name);

        //Creating JPasswordField
        l2.setLabelFor(password);
        // Creating JLabel for the heading
        JLabel heading = new JLabel("Welcome to eNurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        heading.setBounds(100, 50, 300, 30);

        JLabel subheading = new JLabel("please sign in");
        subheading.setFont(new Font("Poppins", Font.ITALIC, 10));
        subheading.setBounds(100, 70, 300, 30);

  

        // Creating JButton
        loginBtn.setFont(new Font("Poppins", Font.ITALIC, 10));
        loginBtn.setBounds(100, 200, 100, 30);
        frame.add(loginBtn);




        /* This method specifies the location and size
         * of any component = > setBounds(x, y, width, height)
         * where x & y are cordinates from the top left
         * corner and remaining two parameters are the width
         * and height of the specific component.
         */
        l1.setBounds(100, 100, 50, 30);
        name.setBounds(200,100,150,30);

        l2.setBounds(100, 150, 125, 30);
        password.setBounds(200,150,150,30);


        /* changing appearance of the label
         * Font,text color,background color
         */
        l1.setFont(new Font("Poppins", Font.BOLD, 15));
        name.setFont(new Font("Poppins", Font.ITALIC, 15));

        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        name.setFont(new Font("Poppins", Font.ITALIC, 15));



        //adds the labels to the frame
        frame.add(l1);
        frame.add(name);
        frame.add(l2);
        frame.add(password);
        frame.add(heading);   
        frame.add(subheading);

        frame.setLayout(null);

        //sets the frame visibility to true
        frame.setVisible(true);

        //This method sets the width and height of the frame
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ViewManager viewmanager = ViewManager.getInstance();
        AppSystem appsys = AppSystem.getInstance();
        
        viewmanager.attachListener(loginBtn, 
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String id = name.getText();
                    String pass = password.getText();
                
                    if (appsys.verifyLogin(Integer.parseInt(id), pass)==true)
                    {
                                            
                        viewmanager.setVisibility(frame, false);
                        frame.dispose();
                        
                        if(Integer.parseInt(id) == appsys.getAdminID())
                        {
                            viewmanager.refreshADashboardFrame();
                            viewmanager.setVisibility(viewmanager.getADashboardFrame().getFrame(), true);
                        }
                        else
                        {
                            viewmanager.refreshNDashboardFrame();
                            viewmanager.setVisibility(viewmanager.getNDashboardFrame().getFrame(), true);
                        }
                        
                        name.setText("");
                        password.setText("");
                        
                    }       
                    else {
                       JOptionPane.showMessageDialog(frame, "Invalid ID or Password. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                       name.setText("");
                       password.setText("");
                    }
                }
            }
        );
        
    }
    
    
    public JFrame getFrame()
    {
        return frame;
    }
}
