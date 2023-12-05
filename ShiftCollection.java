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
public class ShiftCollection implements ShiftAggregator{
    private ArrayList<Shift> shifts;

    public ShiftCollection(ArrayList<Shift> shifts) {
        this.shifts = shifts;
    }

    @Override
    public ShiftIterator createIterator() {
        return new ConcreteShiftIterator(shifts);
    }
}
