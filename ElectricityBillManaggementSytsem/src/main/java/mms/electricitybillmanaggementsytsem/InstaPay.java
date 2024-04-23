/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nada220961
 */
public class InstaPay implements IPayBill {
    private double amount;
    private double paymentFees;
    private final String instaPayHandle;

    public InstaPay(String instaPayHandle) {
        this.instaPayHandle = instaPayHandle;
    }

    public double getAmount() {
        return amount;
    }

    public double getPaymentFees() {
        return paymentFees;
    }

    public String getInstaPayHandle() {
        return instaPayHandle;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentFees(double paymentFees) {
        this.paymentFees = paymentFees;
    }
    
    
    
    
    
    @Override
    public void PayBill(double amount) {
        //to be implemented
    }
    
    public static boolean createAccount(String ipHandle){
        String sqlStmt = "INSERT INTO `instapay` (instapayhandle, amount) VALUES ('" + ipHandle + "', '1000')";
        boolean res = Database.getInsatnce().insertStmt(sqlStmt);
        return res;
    }
}
