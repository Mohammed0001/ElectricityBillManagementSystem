
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SystemReport implements ISystemReport{
    private int id;
    private String title;
    private String date;
    private String description;
    private String feedback;
    private String status;
    private int requesterID;

    public SystemReport(int id, String title, String date, String description, String feedback, String status) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.feedback = feedback;
        this.status = status;
    }
    
    public SystemReport( String title, String description ) {
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
        manageSystemReport();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        manageSystemReport();
        
    }


    public int getId() {
        return id; 
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean requestsystemReport(int requesterID){
        String sqlStmt = "INSERT INTO `systemreport` (title , date , description , feedback , status , requesterID) VALUES ('" +this.title+ "', '" +this.date+ "' ,'" +this.description+ "', '" +this.feedback+ "', '" +this.status+ "', '" +requesterID+ "')";
        return Database.getInsatnce().insertStmt(sqlStmt);
       
    }
    
  
    public static ArrayList<SystemReport> viewSystemReport(){
        ArrayList <SystemReport> requests = new ArrayList<>();
        String sqlStmt = "SELECT etr.*, u.name " +
                 "FROM systemreport AS etr , users AS u " +
                 "WHERE etr.requesterID = u.id;"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
                requests.add(new SystemReport(rs.getInt("id"), rs.getString("title"), rs.getString("date"),rs.getString("description") ,rs.getString("feedback"),rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return requests;        
    }
    
    public boolean manageSystemReport(){
         String sqlStmt = "UPDATE `systemreport` SET `status` = '" + this.status +"' , `feedback` = '" + this.feedback +"' WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
     public boolean deleteSystemReport(){
        
         String sqlStmt = "DELETE FROM `systemreport` WHERE id = " + this.id;
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }

    @Override
    public String toString() {
        return "SystemReport{" + "id=" + id + ", title=" + title + ", date=" + date + ", description=" + description + ", feedback=" + feedback + ", status=" + status + ", requesterID=" + requesterID + '}';
    }
     
     
}
