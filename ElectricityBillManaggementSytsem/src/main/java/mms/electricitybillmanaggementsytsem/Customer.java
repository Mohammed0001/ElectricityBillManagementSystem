
package mms.electricitybillmanaggementsytsem;

import java.util.ArrayList;

/**
 *
 * @author Kenzy 221945
 */
public class Customer extends User implements ICategoryObserver{
    private ArrayList<Bill> myBills ;

    public ArrayList<Bill> getMyBills() {
        return myBills;
    }

    public void setMyBills(ArrayList<Bill> myBills) {
        this.myBills = myBills;
    }
    

    @Override
    public void updateCategoryNotification(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
