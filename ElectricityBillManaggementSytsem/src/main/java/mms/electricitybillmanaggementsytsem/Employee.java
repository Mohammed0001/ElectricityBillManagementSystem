
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Nashwa 220488
 */
public class Employee extends User implements ICategoryObserver{
    
    public String shift;
    //Emloyee implements IElecTechReqR();

    public Employee() {
        System.out.println("mms.electricitybillmanaggementsytsem.Employee.<init>()");
    }

    
    
    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    @Override
    public void updateCategoryNotification(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public boolean createAccount(){
        super.createAccount();
        String sqlStmt = "INSERT INTO `employee` (userID , shift) VALUES ('" +super.getId()+ "' ,'" +this.shift+ "')";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
    @Override
    public boolean updateAccount(){
        super.updateAccount();
        String sqlStmt = "UPDATE 'employee' SET `shift` = '" + this.shift +" WHERE userID = " + super.getId()+";)";
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    @Override
     public boolean removeAccount(){
         super.removeAccount();
         String sqlStmt = "DELETE FROM 'employee' WHERE userID = " + super.getId()+";";
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }
     
      
     
    
}
