
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Khaled 222655
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
