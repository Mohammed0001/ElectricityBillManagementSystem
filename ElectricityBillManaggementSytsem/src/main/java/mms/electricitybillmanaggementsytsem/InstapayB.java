
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author mabou
 */
public class InstapayB implements IPayBillB{
    private String handle;

    public InstapayB(String handle) {
        this.handle = handle;
    }
    
    @Override
    public boolean payBill(Bill b) {
        String sqlStmt = "INSERT INTO payment () VALUES(); ";
        return Database.getInsatnce().insertStmt(sqlStmt);
    }
    
}
