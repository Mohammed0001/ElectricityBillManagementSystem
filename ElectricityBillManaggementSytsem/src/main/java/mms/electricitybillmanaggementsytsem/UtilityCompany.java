
package mms.electricitybillmanaggementsytsem;

import java.util.ArrayList;

/**
 *
 * @author Nashwa 220488
 */
public class UtilityCompany extends User{
    
   private  ArrayList<Integer> contactNumber;
   
    // private ArrayList<ISaleReportRO> SaleReport = new ArrayList<>();

    public ArrayList<Integer> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(ArrayList<Integer> contactNumber) {
        this.contactNumber = contactNumber;
    }
}
