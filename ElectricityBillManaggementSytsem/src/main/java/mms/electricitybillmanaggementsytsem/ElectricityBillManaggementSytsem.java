

package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Electricity BIll Management System 
 * G#1
 */
public class ElectricityBillManaggementSytsem {
    
    public static void main(String[] args) {
        Database.getInsatnce() ;
        ResultSet rs = Database.getInsatnce().selectStmt("SELECT * FROM stock");
        try {
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityBillManaggementSytsem.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("mms.electricitybillmanaggementsytsem.ElectricityBillManaggementSytsem.main()");
    }
}
