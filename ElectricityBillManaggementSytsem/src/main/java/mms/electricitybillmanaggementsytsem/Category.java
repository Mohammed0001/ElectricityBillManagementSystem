
package mms.electricitybillmanaggementsytsem;

import java.util.ArrayList;

/**
 *
 * @author Mohammed 227996
 */
public class Category implements ICategorySubject{
    private double TariffRate;
    private double Tax;
    private Category Successor;
    private ArrayList<ICategoryObserver> observers ;
    
    public void manageTariffRate(){
        
    }
    
    public void defineTax(){
        
    }

    @Override
    public void addObserver(ICategoryObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ICategoryObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void updateAll(String str) {
        for (ICategoryObserver observer : observers) {
            observer.updateCategoryNotification(str);
        }
    }
    
    
}
