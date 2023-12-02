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
public class ShiftCreationFrame {
    private JFrame frame = new JFrame("Welcome");  
    private JButton createShiftBtn = new JButton("Create Shift"); 
    private JTextField id = new JTextField(10);
    private JTextField type = new JTextField(10);
    private JTextField hospital = new JTextField(10);
    private JTextField date = new JTextField(10);
    
    public ShiftCreationFrame()
    {
        //Creating JLabel
        JLabel l1 = new JLabel("Shift ID");
        JLabel l2 = new JLabel("Shift Type");
        JLabel l3 = new JLabel("Hospital");
        JLabel l4 = new JLabel("Date");

        
        l1.setLabelFor(id);
        
        l2.setLabelFor(type);
        
        l3.setLabelFor(hospital);
        
        l4.setLabelFor(date);
        
        // Creating JLabel for the heading
        JLabel heading = new JLabel("Create New Shift");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        heading.setBounds(75, 50, 300, 30);

        // Creating JButton
        /////JButton loginBtn = new JButton("Login");
        createShiftBtn.setFont(new Font("Poppins", Font.ITALIC, 10));
        createShiftBtn.setBounds(50, 300, 100, 30);
        frame.add(createShiftBtn);

        


        /* This method specifies the location and size
         * of any component = > setBounds(x, y, width, height)
         * where x & y are cordinates from the top left
         * corner and remaining two parameters are the width
         * and height of the specific component.
         */
        l1.setBounds(50, 100, 150, 30);
        id.setBounds(175,100,150,30);

        l2.setBounds(50, 150, 150, 30);
        type.setBounds(175,150,150,30);
        
        l3.setBounds(50, 200, 150, 30);
        hospital.setBounds(175,200,150,30);
        
        l4.setBounds(50, 250, 150, 30);
        date.setBounds(175,250,150,30);


        /* changing appearance of the label
         * Font,text color,background color
         */
        l1.setFont(new Font("Poppins", Font.BOLD, 15));
        id.setFont(new Font("Poppins", Font.ITALIC, 15));
        
        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        type.setFont(new Font("Poppins", Font.ITALIC, 15));

        l3.setFont(new Font("Poppins", Font.BOLD, 15));
        hospital.setFont(new Font("Poppins", Font.ITALIC, 15));
        
        l4.setFont(new Font("Poppins", Font.BOLD, 15));
        date.setFont(new Font("Poppins", Font.ITALIC, 15));


        //adds the labels to the frame
        frame.add(l1);
        frame.add(id);
        frame.add(l2);
        frame.add(type);
        frame.add(l3);
        frame.add(hospital);
        frame.add(l4);
        frame.add(date);
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
        return createShiftBtn ;
    }

    public JTextField getID()
    {
        return id;
    }
    
    public JTextField getName()
    {
        return type;
    }
    
    public JTextField getPassword()
    {
        return hospital;
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
