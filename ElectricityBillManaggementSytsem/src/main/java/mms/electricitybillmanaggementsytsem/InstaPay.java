/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Nada220961
 */
public class InstaPay implements IPayBill {
    private double amount;
    private String instaPayHandle;
    private double paymentFees;

    public double getAmount() {
        return amount;
    }

    public String getInstaPayHandle() {
        return instaPayHandle;
    }

    public double getPaymentFees() {
        return paymentFees;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInstaPayHandle(String instaPayHandle) {
        this.instaPayHandle = instaPayHandle;
    }

    public void setPaymentFees(double paymentFees) {
        this.paymentFees = paymentFees;
    }

  
    

    @Override
    public void PayBill(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
