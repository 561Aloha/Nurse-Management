/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Romari
 * @param <E>
 */
public class Sort<E> extends JPanel {
    private JRadioButton hospitalOpt = new  JRadioButton("Hospital");
    private JRadioButton shiftOpt = new JRadioButton("Shift");
    private JRadioButton dateOpt = new JRadioButton("Date");

    private JLabel titleLabel = new JLabel("Sorting");
    private JButton submitButton = new JButton("Sort");
    
    public Sort()
    {
        
    }
    
    public Comparator<Nurse> getCompByNurseName() {
        return new Comparator<Nurse>() {
            @Override
            public int compare(Nurse nurse1, Nurse nurse2) {
                return nurse1.getName().compareTo(nurse2.getName());
            }
        };
    }
    
    public Comparator<Shift> getCompByShiftDate() {
        return new Comparator<Shift>() {
            @Override
            public int compare(Shift shift1, Shift shift2) {
                return shift1.getShiftDate().compareTo(shift2.getShiftDate());
            }
        };
    }
    
    public Comparator<Shift> getCompByShiftHospital() {
        return new Comparator<Shift>() {
            @Override
            public int compare(Shift shift1, Shift shift2) {
                return shift1.getHospital().compareTo(shift2.getHospital());
            }
        };
    }
    
    public Comparator<Shift> getCompByShiftType() {
        return new Comparator<Shift>() {
            @Override
            public int compare(Shift shift1, Shift shift2) {
                String s1;
                String s2;
                if (shift1.getIsDay() == true)
                {
                    s1 = "true";
                }
                else
                {
                    s1 = "false";
                }
                if (shift2.getIsDay() == true)
                {
                    s2 = "true";
                }
                else
                {
                    s2 = "false";
                }
                return s1.compareTo(s2);
            }
        };
    }
    
    public void sortCollection(ArrayList<E> arrList, Comparator<E> comp)
    {
        Collections.sort(arrList, comp);
    }
    
}
