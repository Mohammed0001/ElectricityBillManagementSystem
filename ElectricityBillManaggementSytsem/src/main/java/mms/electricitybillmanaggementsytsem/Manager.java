
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Mohammed 227996
 */
public class Manager extends User{

    public Manager(int id, String name, String username, String password) {
        super(id, name, username, password);
    }
    
    
    @Override 
    public void openHome(){
        new ManagerGUI(this).setVisible(true);
    }
}
