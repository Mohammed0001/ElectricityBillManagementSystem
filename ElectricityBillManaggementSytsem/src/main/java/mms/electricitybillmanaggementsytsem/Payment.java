/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Nada220961
 */

    public abstract class Payment implements IPayBill {
    private int transactionNumber;
    private String type;
    private int value;
    private double discount;
    private String date;
    private IPayBill payBill;

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public String getType() {
        return type;
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

    public IPayBill getPayBill() {
        return payBill;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setPayBill(IPayBill payBill) {
        this.payBill = payBill;
    }

    public abstract void payBill(double amount);
    
    public void viewInvoice() {
        // implementation
    }
    
    public void addDiscount(double discount) {
        // implementation
    }
    
    // getters and setters for all properties
}
