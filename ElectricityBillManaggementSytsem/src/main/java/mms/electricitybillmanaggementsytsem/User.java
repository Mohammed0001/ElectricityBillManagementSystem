
package mms.electricitybillmanaggementsytsem;

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
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public User login(){
        return this;
    }
  
    public User manageLoginCredentials(){
        return this;
    }
    
    public boolean createAccount(){
        return true;
    }
    
    public boolean removeAccount(){
        return true;
    }
    
    public boolean updateAccount(){
        return true;
    }
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + '}';
    }
        

}   
