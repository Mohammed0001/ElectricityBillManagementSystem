
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohammed 227996
 */
public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    //    private ISystemReport SystemReport;

    public User() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateAccount();
    }

    public String getUsername() {
        return username;
        
    }

    public void setUsername(String username) {
        this.username = username;
        updateAccount();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        updateAccount();
    }

    
    public static User login(String username , String password){
        String sqlStmt = "SELECT * FROM `users` WHERE username = '"+ username + "' AND password = '" + password +"';"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
                if (rs.getString("type").equals("admin")){
                    return new Employee();
                }else if(rs.getString("type").equals("customer")){
                    return new Customer();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
    public User manageLoginCredentials(String username , String Password){
        setUsername(username);
        setPassword(Password);
        return this;
    }
    
    public boolean createAccount(){
        String sqlStmt = "INSERT INTO `users` (name , username , password , type) VALUES ('" +this.name+ "' ,'" +this.username+ "', '" +this.password+ "' , 'user')";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
    public boolean removeAccount(){
        String sqlStmt = "DELETE FROM `users` WHERE id = " + this.id;
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }
    
    public boolean updateAccount(){
        String sqlStmt = "UPDATE `users` SET `name` = '" + this.name +"' , `username` = '" + this.username +"' , `password` =  '"+this.password+"' WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + '}';
    }
        
}   
