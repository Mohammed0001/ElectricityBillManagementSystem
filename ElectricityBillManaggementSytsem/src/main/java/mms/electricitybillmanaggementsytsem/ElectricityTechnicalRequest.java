
package mms.electricitybillmanaggementsytsem;

/**
 *
 * @author Kenzy 221945
 */
public class ElectricityTechnicalRequest implements IElectricityTechnicalRequestRO{
    private int id;
    private String title;
    private String date;
    private String description;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void requestElectricityTechnicalSupport(){
        
    }
}
