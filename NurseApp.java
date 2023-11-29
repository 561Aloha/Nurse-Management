/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Romari
 */
public class NurseApp {
    public static void main(String[] args)
    {
        AppSystem appsys = new AppSystem();
        ViewManager viewmanager = new ViewManager();
        ShiftManager shiftmanager = new ShiftManager();
        Sort sort = new Sort();
        Filter filter = new Filter();
        
        Shift shift1 = new Shift(2000,true,"Hospital A", new Date(120, 10, 15));
        Shift shift2 = new Shift(2000,false,"Hospital B", new Date(123, 1, 11));
        Shift shift3 = new Shift(2000,true,"Hospital C", new Date(122, 4, 22));
        Shift shift4 = new Shift(2000,true,"Hospital D", new Date(123, 9, 1));
        
        shiftmanager.createShift(appsys.getAvailableShifts(), shift1);
        shiftmanager.createShift(appsys.getAvailableShifts(), shift2);
        shiftmanager.createShift(appsys.getAvailableShifts(), shift3);
        shiftmanager.createShift(appsys.getAvailableShifts(), shift4);
        
        
        System.out.println("Original shifts");
        ArrayList<Shift> shifts =  appsys.getAvailableShifts();
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        
        
        //sorting
        ///////////////////////////////////////////////////////////////////////
        //testing sort shifts by date
        sort.sortCollection(shifts, sort.getCompByShiftDate());
        System.out.println("Sorted shifts by date");
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        //testing sort shifts by hospital
        sort.sortCollection(shifts, sort.getCompByShiftHospital());
        System.out.println("Sorted shifts by hospital");
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        //testing sort shifts by type
        sort.sortCollection(shifts, sort.getCompByShiftType());
        System.out.println("Sorted shifts by type");
        for(Shift shift: shifts)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        
        
        //filtering
        ///////////////////////////////////////////////////////////////////////
        //testing filter shifts by hospital
        System.out.println("filtering hospital A shifts");
        ArrayList<Shift> shiftsA = filter.filterShiftsByHospital(shifts, 1);
        for(Shift shift: shiftsA)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering hospital B shifts");
        ArrayList<Shift> shiftsB = filter.filterShiftsByHospital(shifts, 2);
        for(Shift shift: shiftsB)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering hospital C shifts");
        ArrayList<Shift> shiftsC = filter.filterShiftsByHospital(shifts, 3);
        for(Shift shift: shiftsC)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering hospital D shifts");
        ArrayList<Shift> shiftsD = filter.filterShiftsByHospital(shifts, 4);
        for(Shift shift: shiftsD)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
         //testing filter shifts by type
        System.out.println("filtering night shifts");
        ArrayList<Shift> shiftsNight = filter.filterShiftsByType(shifts, 0);
        for(Shift shift: shiftsNight)
        {
            System.out.println(shift.toString());
        }
        System.out.println("");
        
        System.out.println("filtering day shifts");
        ArrayList<Shift> shiftsDay = filter.filterShiftsByType(shifts, 1);
        for(Shift shift: shiftsDay)
        {
            System.out.println(shift.toString());
        }
    }
}
