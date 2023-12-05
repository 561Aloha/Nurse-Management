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
public class ConcreteNurseIterator  implements NurseIterator{
    private int idx;
    private ArrayList<Nurse> nurses;

    public ConcreteNurseIterator(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        return idx < nurses.size();
    }

    @Override
    public Nurse next() {
        return nurses.get(idx++);
    }
    
    @Override
    public boolean isDone()
    {
        return idx == nurses.size();
    }
}
