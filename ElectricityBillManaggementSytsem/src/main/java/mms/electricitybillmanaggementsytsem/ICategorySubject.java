
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Nashwa 220488
 */
public interface ICategorySubject {
    public void addObserver(ICategoryObserver observer);
    public void removeObserver(ICategoryObserver observer);

    public void updateAll(String str);
    
}
