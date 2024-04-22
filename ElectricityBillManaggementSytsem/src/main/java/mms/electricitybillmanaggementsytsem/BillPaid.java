/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author dell
 */
public class BillPaid implements IBillStatus{
    
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    @Override
    public void viewBill()
    {
        
    }

    @Override
    public String toString() {
        return "BillPaid{" + "payment=" + payment + '}';
    }
    
}
