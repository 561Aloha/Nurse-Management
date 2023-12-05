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
public class ConcreteShiftIterator implements ShiftIterator{
    private int idx;
    private ArrayList<Shift> shifts;

    public ConcreteShiftIterator(ArrayList<Shift> shifts) {
        this.shifts = shifts;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        return idx < shifts.size();
    }

    @Override
    public Shift next() {
        return shifts.get(idx++);
    }
    
    @Override
    public boolean isDone()
    {
        return idx == shifts.size();
    }
}
