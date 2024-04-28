
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author mabou
 */
public class CashB implements IPayBillB{
   
    public CashB() {
    }
    
    @Override
    public boolean payBill(Bill b) {
        String sqlStmt = "INSERT INTO payment () VALUES(); ";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
}
