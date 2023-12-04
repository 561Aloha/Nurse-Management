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
public class NurseCollection implements NurseAggregator {
    private ArrayList<Nurse> nurses;

    public NurseCollection(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    @Override
    public NurseIterator createIterator() {
        return new ConcreteNurseIterator(nurses);
    }
}
