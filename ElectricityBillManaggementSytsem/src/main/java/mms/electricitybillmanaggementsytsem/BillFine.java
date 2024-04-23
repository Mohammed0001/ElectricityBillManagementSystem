/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Karim 219226
 */
public class BillFine implements IBillStatus{
 
    private Payment payment;
    private double fine;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
    
    
    @Override
    public void viewBill()
    {
        
    }

    @Override
    public String toString() {
        return "BillFine{" + "payment=" + payment + '}';
    }
    
}
