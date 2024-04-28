
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Technician extends User { 
    
    public String shift;
    private ElectricityTechnicalRequest ElecTechReq;

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    public Technician(int id, String name, String username, String password , String shift) {
        super(id, name, username, password);
        this.shift = shift;
    }
    
    @Override
    public boolean createAccount(){
        String sqluserStmt = "INSERT INTO `users` (name , username , password , type) VALUES ('" +super.getName()+ "' ,'" +super.getUsername()+ "', '" +super.getPassword()+ "' , 'technician')";
        if(Database.getInsatnce().insertStmt(sqluserStmt)){
            String getSql = "SELECT LAST_INSERT_ID() AS ID;";
            ResultSet id =  Database.getInsatnce().selectStmt(getSql);
            try {
                if(id.next()){
                    String sqlStmt = "INSERT INTO `technician` (userID , shift) VALUES ('" +id.getString("id")+ "' ,'" +this.shift+ "')";
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
        String sqlStmt = "UPDATE 'technicain' SET `shift` = '" + this.shift +"' WHERE userID = " + super.getId()+"";
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    @Override
     public boolean removeAccount(){
         super.removeAccount();
         String sqlStmt = "DELETE FROM 'technicain' WHERE userID = " + super.getId()+";";
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }

    public boolean RequestElecTechReq(ElectricityTechnicalRequest req){
        ElecTechReq = req;
        return ElecTechReq.requestElectricityTechnicalSupport(getId());
    }
    
    
     public static ArrayList<Technician> getTechs(){
        ArrayList <Technician> techs = new ArrayList <>();
        ResultSet rs = Database.getInsatnce().selectStmt("SELECT * FROM `users` , technician WHERE type = 'tech' AND id = userID");
        try {
            while (rs.next()){
               techs.add(new Technician(rs.getInt("id"),rs.getString("name"), rs.getString("username"), rs.getString("password") ,rs.getString("shift") ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return techs;
    }
     
    @Override
    public void openHome(){
        new TechnicianGUI(this).setVisible(true);
    }    
}
