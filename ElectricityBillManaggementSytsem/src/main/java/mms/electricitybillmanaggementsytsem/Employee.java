
package mms.electricitybillmanaggementsytsem;

import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nashwa 220488
 */
public class Employee extends User implements ICategoryObserver{
    
    public String shift;
    //Emloyee implements IElecTechReqR();

    public Employee(int id, String name, String username, String password , String shift) {
        super(id, name, username, password);
        this.shift = shift;
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
        String sqluserStmt = "INSERT INTO `users` (name , username , password , type) VALUES ('" +super.getName()+ "' ,'" +super.getUsername()+ "', '" +super.getPassword()+ "' , 'employee')";
        if(Database.getInsatnce().insertStmt(sqluserStmt)){
            String getSql = "SELECT LAST_INSERT_ID() AS id;";
            ResultSet id =  Database.getInsatnce().selectStmt(getSql);
            try {
                if(id.next()){
                    String sqlStmt = "INSERT INTO `employee` (userID , shift) VALUES ('" +id.getString("id")+ "' ,'" +this.shift+ "')";
                    return Database.getInsatnce().insertStmt(sqlStmt);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    @Override
    public boolean updateAccount(){
        super.updateAccount();
        String sqlStmt = "UPDATE `employee` SET shift = '" + this.shift +"' WHERE userID = " + super.getId()+";)";
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    @Override
     public boolean removeAccount(){
         super.removeAccount();
         String sqlStmt = "DELETE FROM 'employee' WHERE userID = " + super.getId()+";";
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }
     
     public static ArrayList<Employee> getEmployees(){
        ArrayList <Employee> employees = new ArrayList <>();
        ResultSet rs = Database.getInsatnce().selectStmt("SELECT * FROM `users` , employee WHERE type = 'employee' AND id = userID");
        try {
            while (rs.next()){
               employees.add(new Employee(rs.getInt("id"),rs.getString("name"), rs.getString("username"), rs.getString("password") ,rs.getString("shift") ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
     @Override
     public void openHome(){
         new EmployeeGUI(this).setVisible(true);
     }
     
}
