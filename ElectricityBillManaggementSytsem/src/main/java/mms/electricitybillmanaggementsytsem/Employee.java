
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Nashwa 220488
 */
public class Employee extends User implements ICategoryObserver{
    
    public String shift;
    //Emloyee implements IElecTechReqR();

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
    
    @Override
    public void updateCategoryNotificstion(String str) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
