/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Nada220961
 */
public class BankCard implements IPayBill { 
    private String cardNumber;// mn electricityusgae
    private int cvv;
    private String cardholdername; 

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentFees(double paymentFees) {
        this.paymentFees = paymentFees;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getAmount() {
        return amount;
    }
    
     public int getcvv() {
        
        return cvv;
    }

    public double getPaymentFees() {
        return paymentFees;
    }
    private double amount;
    private double paymentFees;

    public void payBill(double amount) {
     throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    

    private String expirydate;
    String getExpiryDate() {
        return expirydate;
    }

    String getCardHolderName() {
        return cardholdername;
    }

    @Override
    public void PayBill(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

      public static boolean createAccount(String CardNumber ,int cvv, String cardholdername){
        String sqlStmt = "INSERT INTO `bankcard` (cardnumber, cvv, cardholdername) VALUES ('" + CardNumber + "','" + cvv + "','" + cardholdername + "')";
        boolean res = Database.getInsatnce().insertStmt(sqlStmt);
        return res;
    }

  
}
