/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Romari
 */
public class Filter {
    
    public ArrayList<Shift> filterShiftsByHospital(ArrayList<Shift> shifts, int hospital)
    {
        //filer by hospital, type, date
        
        ArrayList<Shift> filteredShifts = new ArrayList<>();
        
        for(Shift shift: shifts)
        {
            if( (hospital == 1 && shift.getHospital().equals("Hospital A")) ||
                (hospital == 2 && shift.getHospital().equals("Hospital B")) ||
                (hospital == 3 && shift.getHospital().equals("Hospital C")) ||
                (hospital == 4 && shift.getHospital().equals("Hospital D"))
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
            if( (type == 1 && shift.getIsDay()==true) || (type == 0 && shift.getIsDay() ==false))
            {
                filteredShifts.add(shift);
            }
        }
        
        return filteredShifts;
    }
    
    //maybe
    public ArrayList<Shift> filterShiftsByDate(ArrayList<Shift> shifts)
    {
        //filer by hospital, type, date
        
        return shifts;
    }
}
