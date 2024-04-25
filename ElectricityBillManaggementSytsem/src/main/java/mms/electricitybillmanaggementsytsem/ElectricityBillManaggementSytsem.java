

package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Electricity BIll Management System 
 * G#1
 * 
 */


public class ElectricityBillManaggementSytsem {
    
    public static void main(String[] args) {
//       Category cat = new Category(0);
       new login().setVisible(true);
       Database.getInsatnce() ;
       System.out.println("Susscess!! in mms.electricitybillmanaggementsytsem.ElectricityBillManaggementSytsem.main()");

    }
 
}


