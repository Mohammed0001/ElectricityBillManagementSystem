
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohammed 227996
 */
public class ElectricityUsage {
    private int id;
    private int meterReading;
    private Category category;

    
    public ElectricityUsage(){
       
    }
    
    public ElectricityUsage(int id , int x){
//       category = new Category(0);

    }
    
    public ElectricityUsage(int meterReading){
       this.meterReading = meterReading;
       category = new Category(0);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(int meterReading) {
        this.meterReading = meterReading;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public boolean generateUsage(int custID){
        category = category.handleCategory(meterReading);
        category.addObserver(new Customer(custID));
        System.out.println("Handled Catgeory : " + category);
        String sqlStmt = "INSERT INTO `electricityusage`( `meterReading`, `categoryID`, `customerID`) VALUES ('"+this.getMeterReading()+"','"+category.getId()+"','"+custID+"')";
        if (Database.getInsatnce().insertStmt(sqlStmt)) {
            String getIdStmt = "SELECT LAST_INSERT_ID() AS id;";
            ResultSet getid =  Database.getInsatnce().selectStmt(getIdStmt);
            try {
                if (getid.next()) {
                    this.id = getid.getInt("id");
                    Bill b = new Bill(0, this, new BillPending() );
                    if(b.createBill()){
                        return true;
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ElectricityUsage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return false;
    }
    
    public static ElectricityUsage getusage(int custID){
        String sqlStmt = "SELECT * FROM `electricityusage` WHERE customerID = '"+custID+"' ORDER BY id DESC LIMIT 1 ;"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
                ElectricityUsage eu =  new ElectricityUsage();
                eu.setMeterReading(rs.getInt("meterReading"));
                return eu;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }

}
