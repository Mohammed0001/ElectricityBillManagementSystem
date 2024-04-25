
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenzy 221945
 */

public class Customer extends User implements ICategoryObserver{
    private ArrayList<Bill> myBills ;

    public Customer(int id, String name, String username, String password) {
        super(id, name, username, password);
        //setMyBills();
    }

    public ArrayList<Bill> getMyBills() {
        return myBills;
    }

    public void setMyBills() {
        this.myBills = Bill.viewBills(super.getId());
    }

    public static ArrayList<Customer> getCustomers(){
        ArrayList <Customer> customers = new ArrayList <>();
        String sqlStmt = "SELECT * FROM `users` WHERE `type` = 'customer' ;"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
               customers.add(new Customer(rs.getInt("id"),rs.getString("name"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @Override 
    public boolean createAccount(){
        String sqlStmt = "INSERT INTO `users` (name , username , password , type) VALUES ('" +this.getName()+ "' ,'" +this.getUsername()+ "', '" +this.getPassword()+ "' , 'customer')";
        return Database.getInsatnce().insertStmt(sqlStmt); 
    }
    
    @Override
    public void updateCategoryNotification(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void openHome(){
        new CustomerGUI(this).setVisible(true);
    }
    
}
