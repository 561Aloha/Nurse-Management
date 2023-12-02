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
public class AddNurseFrame {
    private JFrame frame = new JFrame("Welcome");  
    private JButton addNurseBtn = new JButton("Add Nurse"); 
    private JTextField id = new JTextField(10);
    private JTextField name = new JTextField(10);
    private JPasswordField password = new JPasswordField(10);
    
    public AddNurseFrame()
    {
        //Creating JLabel
        JLabel l1 = new JLabel("ID");
        JLabel l2 = new JLabel("Name");
        JLabel l3 = new JLabel("Password");

        //Creating JTextField
        ////JTextField name = new JTextField(10);
        l1.setLabelFor(id);
        
        l2.setLabelFor(name);
        
        //Creating JPasswordField
        /////JPasswordField password = new JPasswordField(10);
        l3.setLabelFor(password);
        
        // Creating JLabel for the heading
        JLabel heading = new JLabel("Add New Nurse");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        heading.setBounds(75, 50, 300, 30);

        // Creating JButton
        /////JButton loginBtn = new JButton("Login");
        addNurseBtn.setFont(new Font("Poppins", Font.ITALIC, 10));
        addNurseBtn.setBounds(50, 250, 100, 30);
        frame.add(addNurseBtn);




        /* This method specifies the location and size
         * of any component = > setBounds(x, y, width, height)
         * where x & y are cordinates from the top left
         * corner and remaining two parameters are the width
         * and height of the specific component.
         */
        l1.setBounds(50, 100, 150, 30);
        id.setBounds(175,100,150,30);

        l2.setBounds(50, 150, 150, 30);
        name.setBounds(175,150,150,30);
        
        l3.setBounds(50, 200, 150, 30);
        password.setBounds(175,200,150,30);


        /* changing appearance of the label
         * Font,text color,background color
         */
        l1.setFont(new Font("Poppins", Font.BOLD, 15));
        id.setFont(new Font("Poppins", Font.ITALIC, 15));
        
        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        name.setFont(new Font("Poppins", Font.ITALIC, 15));

        l3.setFont(new Font("Poppins", Font.BOLD, 15));
        password.setFont(new Font("Poppins", Font.ITALIC, 15));



        //adds the labels to the frame
        frame.add(l1);
        frame.add(id);
        frame.add(l2);
        frame.add(name);
        frame.add(l3);
        frame.add(password);
        frame.add(heading);   
        

        /* layout set to null ->
         * as no layout managers used
         * in this example (like FlowLayout,BoxLayout.etc)
         */
        frame.setLayout(null);
        
        //frame.setVisible(true);

        //This method sets the width and height of the frame
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JButton getBtn()
    {
        return addNurseBtn;
    }

    public JTextField getID()
    {
        return id;
    }
    
    public JTextField getName()
    {
        return name;
    }
    
    public JPasswordField getPassword()
    {
        return password;
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
