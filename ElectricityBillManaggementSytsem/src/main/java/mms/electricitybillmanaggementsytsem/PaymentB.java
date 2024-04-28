package mms.electricitybillmanaggementsytsem;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mms.electricitybillmanaggementsytsem.Database;
import mms.electricitybillmanaggementsytsem.Payment;


/**
 *
 * @author mabou
 */
public class PaymentB {
    private int transactionNumber;
    private double amount;
    private String date;
    private IPayBillB type;
    private Bill bill;
    
    public PaymentB(){
    } 
    
    public PaymentB(Bill bill) {
        this.bill = bill;
    }
        
    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IPayBillB getType() {
        return type;
    }

    public void setType(IPayBillB type) {
        this.type = type;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
  
    public boolean payBill(){
        return type.payBill(bill);
    }
    
    public static ArrayList<PaymentB> viewInvoices( int custid) {
        ArrayList<PaymentB> payments =  new ArrayList<>();
        ResultSet rs = Database.getInsatnce().selectStmt("SELECT * FROM payment;");

        try {
            while(rs.next()){
                PaymentB p = new PaymentB();
                p.setTransactionNumber(rs.getInt("transactionNumber"));
                p.setDate(rs.getString("date"));
                p.setAmount(rs.getInt("amount"));
                payments.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return payments;
    }
}
