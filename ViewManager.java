/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Romari
 */
public class ViewManager {
  
    public ViewManager()
    {   
 
    }
    
    public void setVisibility(JFrame frame, boolean bool)
    {
        frame.setVisible(bool);
    }
   
    public void attachListener(JButton btn, ActionListener listener)
    {
        btn.addActionListener(listener);
    }
    
    
}
