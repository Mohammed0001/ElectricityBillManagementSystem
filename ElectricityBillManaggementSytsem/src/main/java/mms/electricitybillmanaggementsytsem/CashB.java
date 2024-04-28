
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mabou
 */
public class CashB implements IPayBillB{
   
    public CashB() {
    }
    
        @Override
    public boolean payBill(Bill b) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = today.format(formatter);
        double amount = ( b.getAmount() + (0.025 * b.getAmount()) - (b.getAmount() * b.getDiscount()/100));
        String sqlStmt = "INSERT INTO `payment`(`type`, `date`, `billID`, `amount`) VALUES ('Cash','"+date+"','"+b.getId()+"','"+amount+"')";
        b.setStatus(new BillPaid());
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
}
