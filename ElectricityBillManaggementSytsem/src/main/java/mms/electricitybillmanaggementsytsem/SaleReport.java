
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
public class SaleReport {
    private int id;
    private String title;
    private String date;
    private float totalSale;

    public SaleReport(int id, String title, String date, float totalSale) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.totalSale = totalSale;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public float getTotalSale() {
        return totalSale;
    }
    
    public static ArrayList<SaleReport> viewSaleReports(){
        ArrayList <SaleReport> reports = new ArrayList<>();
        String sqlStmt = "SELECT * FROM `salereport`;"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
                reports.add(new SaleReport(rs.getInt("id") , rs.getString("title"), rs.getString("date"), rs.getFloat("totalSale")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reports;        
    }
    
     public boolean addSaleReport(){
        String sqlStmt = "INSERT INTO `salereport` (title , date , totalSale) VALUES ('" +this.title+ "', '" +this.date+ "', '" +this.totalSale+ "' )";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
     
    public boolean removeSaleReport(){
         String sqlStmt = "DELETE FROM `SaleReport` WHERE id = " + this.id;
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }
     
    
}
