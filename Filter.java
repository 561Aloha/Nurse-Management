/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Romari
 */
public class Filter extends JPanel{
    
    
    
    private ArrayList<Shift> shifts; // Assuming you have a list of shifts
    private JRadioButton ABtn = new JRadioButton("Hospital A");
    private JRadioButton BBtn = new JRadioButton("Hospital B");
    private JRadioButton CBtn = new JRadioButton("Hospital C");
    private JRadioButton DBtn = new JRadioButton("Hospital D");
    private JRadioButton dayBtn = new JRadioButton("Day");
    private JRadioButton nightBtn = new JRadioButton("Night");

    private JLabel titleLabel = new JLabel("Filter Shifts");
    private JButton submitButton = new JButton("Submit");
    
    
    public Filter(ArrayList<Shift> shifts) {
        this.shifts = shifts;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        ButtonGroup hospitalGroup = new ButtonGroup();

        hospitalGroup.add(ABtn);
        hospitalGroup.add(BBtn);
        hospitalGroup.add(CBtn);
        hospitalGroup.add(DBtn);
        hospitalGroup.add(dayBtn);
        hospitalGroup.add(nightBtn);

        this.add(titleLabel);
        this.add(ABtn);
        this.add(BBtn);
        this.add(CBtn);
        this.add(DBtn);
        this.add(dayBtn);
        this.add(nightBtn);
        this.add(submitButton);

        ABtn.addActionListener(createHospitalActionListener(1));
        BBtn.addActionListener(createHospitalActionListener(2));
        CBtn.addActionListener(createHospitalActionListener(3));
        DBtn.addActionListener(createHospitalActionListener(4));

        dayBtn.addActionListener(createTypeActionListener(1));
        nightBtn.addActionListener(createTypeActionListener(0));
        //submitButton.addActionListener(submitActionListener());
    }
    
    
    public ArrayList<Shift> filterShiftsByHospital(ArrayList<Shift> shifts, int hospital)
    {
        //filer by hospital, type, date
        
        ArrayList<Shift> filteredShifts = new ArrayList<>();
        
        for(Shift shift: shifts)
        {
            if( (hospital == 1 && shift.getHospital().equals("hospital a")) ||
                (hospital == 2 && shift.getHospital().equals("hospital b")) ||
                (hospital == 3 && shift.getHospital().equals("hospital c")) ||
                (hospital == 4 && shift.getHospital().equals("hospital d"))
            )
            {
                filteredShifts.add(shift);
            }
        }
        
        return filteredShifts;
    }
    
    public ArrayList<Shift> filterShiftsByType(ArrayList<Shift> shifts, int type)
    {
        //filer by hospital, type, date
        
        ArrayList<Shift> filteredShifts = new ArrayList<>();
        
        for(Shift shift: shifts)
        {
            if( (type == 1 && shift.getIsDay()==true) || (type == 2 && shift.getIsDay() ==false))
            {
                filteredShifts.add(shift);
            }
        }
        
        return filteredShifts;
    }
    
    //maybe
 
    
     public ArrayList<Shift> filterShiftsByHospital(int hospital) {
        return filterShiftsByHospital(shifts, hospital);
    }

    // Method to filter shifts by type without passing a list (assumes use of instance variable)
    public ArrayList<Shift> filterShiftsByType(int type) {
        return filterShiftsByType(shifts, type);
    }
    
    
    public JRadioButton getABtn()
    {
        return ABtn;
    }
    
    public JRadioButton getBBtn()
    {
        return BBtn;
    }
    
    public JRadioButton getCBtn()
    {
        return CBtn;
    }
    
    public JRadioButton getDBtn()
    {
        return DBtn;
    }
    
    public JRadioButton getDayBtn()
    {
        return dayBtn;
    }
    
    public JRadioButton getNightBtn()
    {
        return nightBtn;
    }
    
    public JButton getSubmitBtn()
    {
        return submitButton;
    }
    
    private ActionListener createHospitalActionListener(int hospital) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Shift> filteredShifts = filterShiftsByHospital(hospital);
                System.out.println("Filtered shifts by hospital: " + filteredShifts);
            }
        };
    }

    
    /*
    private ActionListener submitActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle submission logic here
                System.out.println("Submit button clicked!");
                if (ABtn.isSelected() || ABtn.isSelected() || ABtn.isSelected() || ABtn.isSelected()) 
                {
                    if(ABtn.isSelected())
                    {
                        filterShiftsByHospital(1);
                    }
                    else if(BBtn.isSelected())
                    {
                        filterShiftsByHospital(2);
                    }
                    else if(CBtn.isSelected())
                    {
                        filterShiftsByHospital(3);
                    }
                    else if(DBtn.isSelected())
                    {
                        filterShiftsByHospital(4);
                    }
                }
            }
        };
    }*/

    private ActionListener createTypeActionListener(int type) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Shift> filteredShifts = filterShiftsByType(type);
                System.out.println("Filtered shifts by type: " + filteredShifts);
            }
        };
    }
}
