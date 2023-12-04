/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;

/**
 *
 * @author Romari
 */
public abstract class User implements Serializable {
    private int id;
    private String name;
    protected String password;
    
    public User(int id, String name, String password)
    {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    
    public int getID()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
}
