
package mms.electricitybillmanaggementsytsem;

import java.util.ArrayList;

/**
 *
 * @author Nashwa 220488
 */
public class UtilityCompany extends User{
    
   private  ArrayList<Integer> contactNumber;

    public UtilityCompany(int id, String name, String username, String password) {
        super(id, name, username, password);
    }
   
    // private ArrayList<ISaleReportRO> SaleReport = new ArrayList<>();

    public ArrayList<Integer> getContactNumber() {
        
        return contactNumber;
    }

    public void setContactNumber(ArrayList<Integer> contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    @Override
    public void openHome(){
        new UtilityCompanyGUI(this).setVisible(true);
    }
    
   
    
}
