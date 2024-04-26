
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenzy 221945
 */
public class ElectricityTechnicalRequest implements IElectricityTechnicalRequestRO , IElectricityTechnicalReq{
    private int id;
    private String title;
    private String date;
    private String description;
    private String feedback;
    private String status;

    public ElectricityTechnicalRequest(int id, String title, String date, String description, String feedback, String status) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.feedback = feedback;
        this.status = status;
    }
    
    public ElectricityTechnicalRequest( String title, String description ) {
        this.title = title;
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = today.format(formatter);
        this.description = description;
        this.feedback = "";
        this.status = "pending";
    }
    

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
        manageElectricityTechnicalSupportRequest();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        manageElectricityTechnicalSupportRequest();
    }

    @Override
    public int getId() {
        return id; 
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean requestElectricityTechnicalSupport(int requesterID){
        String sqlStmt = "INSERT INTO `electricitytechnicalrequest` (title , date , description , feedback , status , requesterID) VALUES ('" +this.title+ "', '" +this.date+ "' ,'" +this.description+ "', '" +this.feedback+ "', '" +this.status+ "', '" +requesterID+ "')";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
  
    public static ArrayList<ElectricityTechnicalRequest> viewElectricityTechnicalSupportRequest(){
        ArrayList <ElectricityTechnicalRequest> requests = new ArrayList<>();
        String sqlStmt = "SELECT etr.*, u.name " +
                 "FROM electricitytechnicalrequest AS etr , users AS u " +
                 "WHERE etr.requesterID = u.id;"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
                requests.add(new ElectricityTechnicalRequest(rs.getInt("id"), rs.getString("title"), rs.getString("date"),rs.getString("description") ,rs.getString("feedback"),rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;        
    }
    
    public boolean manageElectricityTechnicalSupportRequest(){
         String sqlStmt = "UPDATE `electricitytechnicalrequest` SET `status` = '" + this.status +"' , `feedback` = '" + this.feedback +"' WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
     public boolean deleteElectricityTechnicalSupportRequest(){
        
         String sqlStmt = "DELETE FROM `electricitytechnicalrequest` WHERE id = " + this.id;
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }


}
