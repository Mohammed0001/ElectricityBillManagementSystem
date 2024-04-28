/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

import java.sql.Date;

/**
 *
 * @author Nada220961
 */
public class BankCard implements IPayBill { 
    private String cardNumber;// mn electricityusgae
    private int cvv;
    private String cardholderName; 
    private Date expiryDate;

    public BankCard(String cardNumber, int cvv, String cardholdername, Date expirydate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardholderName = cardholdername;
        this.expiryDate = expirydate;
    }
    
    

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

    @Override
    public void PayBill(double amount) {
     throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

      public static BankCard createAccount(String CardNumber ,int cvv, String cardholdername, Date expiryDate){
        String sqlStmt = "INSERT INTO `bankcard` (cardnumber, cvv, cardholdername, expirydate,amount) VALUES ('" + CardNumber + "','" + cvv + "','" + cardholdername + "','" + expiryDate + "', '1000')";
        Database s = Database.getInsatnce();
        boolean res = s.insertStmt(sqlStmt);
        return res?new BankCard(CardNumber,cvv,cardholdername,expiryDate):null;
    }

  
}
