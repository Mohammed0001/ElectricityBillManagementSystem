

package mms.electricitybillmanaggementsytsem;

import java.util.Arrays;

/**
 *
 * @author Electricity BIll Management System 
 * G#1
 * 
 */


public class ElectricityBillManaggementSytsem {
    
    public static void main(String[] args) {
        new login().setVisible(true);
        Database.getInsatnce() ;
        System.out.println("Susscess!! in mms.electricitybillmanaggementsytsem.ElectricityBillManaggementSytsem.main()");

    }
 
}


