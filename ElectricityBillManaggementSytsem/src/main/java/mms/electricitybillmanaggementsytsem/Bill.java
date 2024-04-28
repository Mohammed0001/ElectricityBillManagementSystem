
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim 219226
 */

public class Bill {
    private int id;
    private ElectricityUsage ElectricityUsage;
    private IBillStatus status;
    private float discount;
    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }    

    public float getDiscount() {
        return discount;
    }

    public void setDiscount (float disocunt) {
        this.discount = disocunt;
    }

    
    public Bill(int id , float discount){
        this.id = id;
        this.discount = discount;
    }
    
    public Bill(int id, ElectricityUsage ElectricityUsage, IBillStatus status) {
        this.id = id;
        this.ElectricityUsage = ElectricityUsage;
        this.status = status;
    }

    public Bill( int id,float discount, float amount , IBillStatus status) {
        this.id = id;
        this.status = status;
        this.discount = discount;
        this.amount = amount;
    }
    
    
    

    
    
    public void calculateBill()
    {
        this.amount = (float) (ElectricityUsage.getCategory().getTax() * (float) ElectricityUsage.getCategory().getTariffRate() * (float) ElectricityUsage.getMeterReading());
    }
    
    
    public Bill viewBill()
    {
        Bill b;
        String sqlStmt = "SELECT * FROM `bill` WHERE id = "+ id ; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
               b = new Bill(rs.getInt("id"), new ElectricityUsage(rs.getInt("electricityUsageID")), new BillPending());
               return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public static ArrayList<Bill> viewBills(int custid){
        ArrayList<Bill> bills = new ArrayList<>();
        System.out.println(custid);
        String sqlStmt;
        if(custid == 0){
           sqlStmt = "SELECT * FROM `bill`"; 
        }else{
            sqlStmt = "SELECT * FROM bill " +
                      "INNER JOIN electricityusage ON bill.electricityUsageID = electricityusage.id " +
                      "WHERE  electricityusage.customerID = "+ custid ; 
        }
        try {
            ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
            int i =0;
            while (rs.next()){
               bills.add(new Bill(rs.getInt("id"),rs.getFloat("discount"), rs.getFloat("amount"), new BillPending()));
                System.out.println(bills.get(i));
                i+=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
        
    }

    public boolean setDiscount(){
        String sqlStmt = "UPDATE `bill` SET `discount` = '" + this.discount +"' WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ElectricityUsage getElectricityUsage() {
        return ElectricityUsage;
    }

    public void setElectricityUsage(ElectricityUsage ElectricityUsage) {
        this.ElectricityUsage = ElectricityUsage;
    }
    
    public IBillStatus getStatus() {
       return status;
    }

    public void setStatus(IBillStatus status) {
        this.status = status;
        updateBill();
    }

    public boolean createBill(){
        calculateBill();
        String sqlStmt = "INSERT INTO `bill` (status , electricityUsageID  , discount , amount) VALUES ('pending' ,'" +this.ElectricityUsage.getId()+ "' , '0' , "+ this.amount +")";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
    public boolean removeBill(){
        String sqlStmt = "DELETE FROM `bill` WHERE id = " + this.id;
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }
    
    public boolean updateBill(){
        String sqlStmt = "UPDATE `bill` SET `status` = '" + this.status.toString() +"' , `electricityUsageID` = '" + this.ElectricityUsage.getId() +"'  WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    @Override
    public String toString() {
        return "Bill{" + "ElectricityUsage=" + ElectricityUsage + ", status=" + status + '}';
    }
}
