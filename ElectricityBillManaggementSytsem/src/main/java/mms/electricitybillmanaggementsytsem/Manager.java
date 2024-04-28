
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Mohammed 227996
 */

public class Manager extends User implements ICategoryObserver {
    
    IElectricityTechnicalRequestRO elec = new ElectricityTechnicalRequest();
    
    
    
    public Manager(int id){
        super(id);
    }
    
    public Manager(int id, String name, String username, String password) {
        super(id, name, username, password);
    }
    
     @Override 
    public boolean createAccount(){
        String sqlStmt = "INSERT INTO `users` (name , username , password , type) VALUES ('" +this.getName()+ "' ,'" +this.getUsername()+ "', '" +this.getPassword()+ "' , 'manager')";
        return Database.getInsatnce().insertStmt(sqlStmt); 
    }
    
    @Override 
    public void openHome(){
        new ManagerGUI(this).setVisible(true);
    }

    @Override
    public void updateCategoryNotification(String str) {
        String sqlStmt = "UPDATE `users` SET `notification` = '" + str +"' WHERE id = " + getId() ;
        Database.getInsatnce().updateStmt(sqlStmt);
    }
}
