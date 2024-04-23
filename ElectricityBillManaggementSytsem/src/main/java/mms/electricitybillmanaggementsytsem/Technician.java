/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author mabou
 */
public class Technician extends User{
    
    public Technician(int id, String name, String username, String password) {
        super(id, name, username, password);
    }
    
    @Override
    public void openHome(){
        new TechnicianGUI(this).setVisible(true);
    }
    
}
