
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
public class BankCardB implements IPayBillB{
    private int cardNumber;
    private int cvv;
    private String expiryDate;

    public BankCardB(int cardNumber, int cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    
    @Override
    public boolean payBill(Bill b) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = today.format(formatter);
        double amount = ( b.getAmount() + (0.025 * b.getAmount()) - (b.getAmount() * b.getDiscount()/100));
        String sqlStmt = "INSERT INTO `payment`(`type`, `date`, `billID`, `amount`) VALUES ('BankCard','"+date+"','"+b.getId()+"','"+amount+"')";
        b.setStatus(new BillPaid());
        int transNumber = 0;
        ResultSet id = Database.getInsatnce().selectStmt("SELECT LAST_INSERT_ID() AS id;");
        try {
            if(id.next()){transNumber = id.getInt("id");}
        } catch (SQLException ex) {
            Logger.getLogger(BankCardB.class.getName()).log(Level.SEVERE, null, ex);
        }
        String cSql = "INSERT INTO `bankcard`(`id`, `cardnumber`, `cvv`,`cardholdername` , `expirydate`, `amount` , `expDate`) VALUES ('"+transNumber+"','"+cardNumber+"','"+cvv+"','hold','2029-01-01','"+amount+"','"+expiryDate+"')";
        Database.getInsatnce().insertStmt(sqlStmt);
        return Database.getInsatnce().insertStmt(cSql);
    }
    
}
