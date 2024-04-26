/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author mabou
 */
public class Admin extends User {
    private static Admin adminInstance;

   
    
    private Admin(int id, String name, String username, String password) {
        super(id, name, username, password);
    }
    
    public static Admin getAdmin(int id, String name, String username, String password){
        if(adminInstance == null){
            adminInstance = new  Admin(id, name, username, password);
        }
        return adminInstance;
    }
    
    @Override 
    public void openHome(){
        new AdminGUI(this).setVisible(true);
    }
    
}
