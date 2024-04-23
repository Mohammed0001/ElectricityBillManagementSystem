/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author dell
 */
public class Bill {
    private int id;
    private ElectricityUsageID ElectricityUsage;
    private IBillStatus status;
    private Payment Payment;
    
    public void calculateBill()
    {
        
    }
    
    public void viewBill()
    {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ElectricityUsageID getElectricityUsage() {
        return ElectricityUsage;
    }

    public void setElectricityUsage(ElectricityUsageID ElectricityUsage) {
        this.ElectricityUsage = ElectricityUsage;
    }
    
    public IBillStatus getStatus() {
       return status;
    }

    public void setStatus(IBillStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return Payment;
    }
    
    public void setPayment(Payment Payment) {
        this.Payment = Payment;
    }
    
    public boolean createBill(){
        String sqlStmt = "INSERT INTO `Bill` (status , ElectricityUsageID , Payment) VALUES ('" +this.status+ "' ,'" +this.ElectricityUsage+ "', '" +this.Payment+ "' , 'Bill')";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
    public boolean removeBill(){
        String sqlStmt = "DELETE FROM `Bill` WHERE id = " + this.id;
        return Database.getInsatnce().deleteStmt(sqlStmt);
    }
    
    public boolean updateBill(){
        String sqlStmt = "UPDATE `Bill` SET `status` = '" + this.status +"' , `ElectricityUsageID` = '" + this.ElectricityUsage.getId() +"' ,`Payment` = '" + this.Payment +"', WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    @Override
    public String toString() {
        return "Bill{" + "ElectricityUsage=" + ElectricityUsage + ", status=" + status + ", Payment=" + Payment + '}';
    }
}
