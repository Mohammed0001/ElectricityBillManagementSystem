/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada220961
 */

    public class Payment {
    private int transactionNumber;
    private int value;
    private double discount;
    private String date;
    private IPayBill type;
    
    
    
    public void setPaymentType(IPayBill type){
        this.type = type;
    }
    
    public void payBill(){
        type.PayBill(value);
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public int getValue() {
        return value;
    }

    public double getDiscount() {
        return discount;
    }

    public String getDate() {
        return date;
    }


    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Payment> viewInvoices() {
        ArrayList<Payment> payments =  new ArrayList<>();
        ResultSet rs = Database.getInsatnce().selectStmt("SELECT * FROM users;");

        try {
            while(rs.next()){
                Payment p = new Payment();
                payments.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return payments;
    }
    
    public void addDiscount(double discount) {
        
    }
    
   
}
