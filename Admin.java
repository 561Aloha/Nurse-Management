/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author Romari
 */
public class Admin {
    private int adminID;
    private String password;
    
    public Admin(int adminID, String password)
    {
        this.adminID = adminID;
        this.password = password;
    }
    
    public int getAdminID()
    {
        return adminID;
    }
    
    public String getPassword()
    {
        return password;
    }
}
