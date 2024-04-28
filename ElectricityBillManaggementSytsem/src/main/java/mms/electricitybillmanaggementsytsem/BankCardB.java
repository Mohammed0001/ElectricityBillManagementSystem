
package mms.electricitybillmanaggementsytsem;

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
        String sqlStmt = "INSERT INTO payment () VALUES(); ";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
}
