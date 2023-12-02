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
public class ChangePasswordFrame {
    private JFrame frame = new JFrame("Welcome");  
    private JButton submitChangeBtn = new JButton("Submit Change"); 
    private JPasswordField oldpassword = new JPasswordField(10);
    private JPasswordField newpassword = new JPasswordField(10);
    
    public ChangePasswordFrame()
    {
        //Creating JLabel
        JLabel l1 = new JLabel("Old Password");
        JLabel l2 = new JLabel("New Password");

        //Creating JTextField
        ////JTextField name = new JTextField(10);
        l1.setLabelFor(oldpassword);

        //Creating JPasswordField
        /////JPasswordField password = new JPasswordField(10);
        l2.setLabelFor(newpassword);
        
        // Creating JLabel for the heading
        JLabel heading = new JLabel("Change Your Password");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        heading.setBounds(75, 50, 300, 30);

        // Creating JButton
        /////JButton loginBtn = new JButton("Login");
        submitChangeBtn.setFont(new Font("Poppins", Font.ITALIC, 10));
        submitChangeBtn.setBounds(75, 200, 100, 30);
        frame.add(submitChangeBtn);




        /* This method specifies the location and size
         * of any component = > setBounds(x, y, width, height)
         * where x & y are cordinates from the top left
         * corner and remaining two parameters are the width
         * and height of the specific component.
         */
        l1.setBounds(50, 100, 150, 30);
        oldpassword.setBounds(175,100,150,30);

        l2.setBounds(50, 150, 150, 30);
        newpassword.setBounds(175,150,150,30);


        /* changing appearance of the label
         * Font,text color,background color
         */
        l1.setFont(new Font("Poppins", Font.BOLD, 15));
        oldpassword.setFont(new Font("Poppins", Font.ITALIC, 15));

        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        newpassword.setFont(new Font("Poppins", Font.ITALIC, 15));



        //adds the labels to the frame
        frame.add(l1);
        frame.add(oldpassword);
        frame.add(l2);
        frame.add(newpassword);
        frame.add(heading);   
        

        /* layout set to null ->
         * as no layout managers used
         * in this example (like FlowLayout,BoxLayout.etc)
         */
        frame.setLayout(null);

        //This method sets the width and height of the frame
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

        
    public JButton getBtn()
    {
        return submitChangeBtn;
    }

    public JPasswordField getOldPassword()
    {
        return oldpassword;
    }

    public JPasswordField getNewPassword()
    {
        return newpassword;
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
