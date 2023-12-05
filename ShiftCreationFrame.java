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
    private JFrame frame = new JFrame("Create Shift");  
    
    private JButton noChangesBtn = new JButton("Go Back/No Changes");
    private JButton createShiftBtn = new JButton("Create Shift"); 
    private JTextField id = new JTextField(10);
    private JTextField type = new JTextField(10);
    private JTextField hospital = new JTextField(10);
    private JTextField dateD = new JTextField(3);
    private JTextField dateM = new JTextField(3);
    private JTextField dateY = new JTextField(3);
    
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
        
        l4.setLabelFor(dateD);
        
        // Creating JLabel for the heading
        JLabel heading = new JLabel("Create New Shift");
        heading.setFont(new Font("Poppins", Font.BOLD, 20));
        heading.setBounds(75, 50, 300, 30);

        // Creating JButton
        /////JButton loginBtn = new JButton("Login");
        createShiftBtn.setFont(new Font("Poppins", Font.ITALIC, 10));
        createShiftBtn.setBounds(50, 325, 200, 30);
        frame.add(createShiftBtn);
        
        noChangesBtn.setFont(new Font("Poppins", Font.ITALIC, 10));
        noChangesBtn.setBounds(50, 375, 200, 30);
        frame.add(noChangesBtn);

        


        /* This method specifies the location and size
         * of any component = > setBounds(x, y, width, height)
         * where x & y are cordinates from the top left
         * corner and remaining two parameters are the width
         * and height of the specific component.
         */
        l1.setBounds(50, 100, 100, 30);
        id.setBounds(175,100,170,30);

        l2.setBounds(50, 150, 100, 30);
        type.setBounds(175,150,170,30);
        
        l3.setBounds(50, 200, 100, 30);
        hospital.setBounds(175,200,170,30);
        
        l4.setBounds(50, 250, 100, 30);
        dateD.setBounds(175,250,30,30);
        dateM.setBounds(235,250,30,30);
        dateY.setBounds(295,250,50,30);
        
        JLabel dateLabelD = new JLabel("DD");
        dateLabelD.setFont(new Font("Poppins", Font.ITALIC, 10));
        dateLabelD.setBounds(180, 275, 30, 30);
        
        JLabel dateLabelM = new JLabel("MM");
        dateLabelM.setFont(new Font("Poppins", Font.ITALIC, 10));
        dateLabelM.setBounds(240, 275, 30, 30);
        
        JLabel dateLabelY = new JLabel("YYYY");
        dateLabelY.setFont(new Font("Poppins", Font.ITALIC, 10));
        dateLabelY.setBounds(303, 275, 30, 30);
       
        
        
        /* changing appearance of the label
         * Font,text color,background color
         */
        l1.setFont(new Font("Poppins", Font.BOLD, 15));
        id.setFont(new Font("Poppins", Font.ITALIC, 15));
        
        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        type.setFont(new Font("Poppins", Font.ITALIC, 15));

        l3.setFont(new Font("Poppins", Font.BOLD, 15));
        hospital.setFont(new Font("Poppins", Font.ITALIC, 15));
        
        l4.setFont(new Font("Poppins", Font.BOLD, 16));
        dateD.setFont(new Font("Poppins", Font.ITALIC, 16));
        dateM.setFont(new Font("Poppins", Font.ITALIC, 16));
        dateY.setFont(new Font("Poppins", Font.ITALIC, 16));


        //adds the labels to the frame
        frame.add(l1);
        frame.add(id);
        frame.add(l2);
        frame.add(type);
        frame.add(l3);
        frame.add(hospital);
        frame.add(l4);
        frame.add(dateD);
        frame.add(dateM);
        frame.add(dateY);
        frame.add(heading);   
        frame.add(dateLabelD);
        frame.add(dateLabelM);
        frame.add(dateLabelY);
        

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
    
    public JFrame getFrame()
    {
        return frame;
    }
    
     public JButton getCreateShiftBtn()
    {
        return createShiftBtn ;
    }

    public JTextField getID()
    {
        return id;
    }
    
    public JTextField getType()
    {
        return type;
    }
    
    public JTextField getHospital()
    {
        return hospital;
    }
    
    public JTextField getDateD()
    {
        return dateD;
    }
    
    public JTextField getDateM()
    {
        return dateM;
    }
    
    public JTextField getDateY()
    {
        return dateY;
    }
    
    public JButton getNoChangesBtn()
    {
        return noChangesBtn;
    }
}
