
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Mohammed 227996
 */
public class GoldCategory extends Category{

    public GoldCategory(int id) {
        super(id);
    }
    
    
    @Override
     public Category handleCategory(int meterReading){
        return this;
    }
  
}
