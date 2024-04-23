

package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Electricity BIll Management System 
 * G#1
 */
public class ElectricityBillManaggementSytsem {
    
    public static void main(String[] args) {
        new login().setVisible(true);
        Database.getInsatnce() ;
        System.out.println("Susscess!! in mms.electricitybillmanaggementsytsem.ElectricityBillManaggementSytsem.main()");
    }
    
}
