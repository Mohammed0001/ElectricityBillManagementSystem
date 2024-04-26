
package mms.electricitybillmanaggementsytsem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohammed 227996
 */
public class Category implements ICategorySubject {
    private int id;
    private double TariffRate;
    private double Tax;
    private int range;
    public Category Successor;
    private ArrayList<ICategoryObserver> observers = new ArrayList<>() ;

    public Category(){}
    
    public Category(int id){
        this.id = id;
        loadCategoryFromDatabase();
        setSuccessor();
        System.out.println(this);
    }

    public Category(int id, double TariffRate, double Tax, int range) {
        this.id = id;
        this.TariffRate = TariffRate;
        this.Tax = Tax;
        this.range = range;
    }
    
    
    
    private void loadCategoryFromDatabase(){
        String SqlStmt = "SELECT * FROM `categroy` WHERE id = " + this.id ;
        ResultSet category = Database.getInsatnce().selectStmt(SqlStmt);
        try {
            if(category.next()){
                Tax = category.getDouble("tax");
                TariffRate = category.getDouble("tariffRate");
                range = category.getInt("range");                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadObservers(){
        //String SqlStmt = "SELECT * FROM `categroy` , categoryobserver WHERE categoryID = categroy.id " ;
        String sqlStmt = "SELECT * FROM users WHERE type = 'employee' OR type = 'manager' OR type = 'customer'";
        ResultSet category = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (category.next()) {
                if (category.getString("type").equals("employee")) {
                    observers.add(new Employee(category.getInt("id")));
                }else if(category.getString("type").equals("id")){
                    observers.add(new Manager(category.getInt("id")));
                }else{
                    observers.add(new Customer(category.getInt("id")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    
    public double getTariffRate() {
        return TariffRate;
    }

    public void setTariffRate(double TariffRate) {
        this.TariffRate = TariffRate;
    }

    public double getTax() {
        return Tax;
    }

    public void setTax(double Tax) {
        this.Tax = Tax;
    }

    public ArrayList<ICategoryObserver> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<ICategoryObserver> observers) {
        this.observers = observers;
    }
    
    
    public void manageTariffRate(){
        
    }
    
    public void defineTax(){
        
    }

    public void setSuccessor(){
        if(Successor == null){
        System.out.println("Setting successor for category id: " + id);
        String SqlStmt = "SELECT * FROM `categroy` WHERE id = " + this.id ;
        ResultSet category = Database.getInsatnce().selectStmt(SqlStmt);
        try {
            if(category.next()){
                int successorId = category.getInt("successorId");
                String successorType = category.getString("successorType");

                if (successorId != 0) {
                    Category nextCategory = null;

                    // Create the appropriate successor based on successorType
                    if (successorType.equals("bronze")) {
                        nextCategory = new BronzeCategory(successorId);
                    } else if (successorType.equals("silver")) {
                        nextCategory = new SilverCategory(successorId);
                    } else if (successorType.equals("gold")) {
                        nextCategory = new GoldCategory(successorId);
                    }

                    // Set the successor
                    Successor = nextCategory;

                    // Recursive call to set successor for the next category
                    if (Successor != null) {
                        Successor.setSuccessor(); // Proceed to set successor for the next category
                    }
                } else {
                    // No valid successor found, terminate the chain
                    Successor = null;
                }
            }
//            if(Successor != null){
//                Successor.setSuccessor();
//            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
                }

    }
    
    
    
    public Category handleCategory(int meterReading){
        if (meterReading <= range ){
            return this;
        } else if (Successor != null) {
            return Successor.handleCategory(meterReading);
        } else {
            return null; 
        }
    }
    
    public boolean manageCategory(){
        loadObservers();
        String notification = "Category with range " + getRange() + " and Tariff rate " + TariffRate + " and tax " + Tax + " has been updated";
        updateAll(notification);
        String sqlStmt = "UPDATE categroy SET `range` = '" + this.range +"' , `tariffRate` = '" + this.TariffRate +"' , `tax` =  '"+this.Tax+"' WHERE id = " + this.id ;
        return Database.getInsatnce().updateStmt(sqlStmt);
    }
    
    public static ArrayList<Category> getCategories(){
        ArrayList <Category> categories = new ArrayList<>();
        String sqlStmt = "SELECT * FROM categroy WHERE id != '0'"; 
        ResultSet rs = Database.getInsatnce().selectStmt(sqlStmt);
        try {
            while (rs.next()){
                categories.add(new Category(rs.getInt("id") ,rs.getDouble("tariffRate"), rs.getDouble("tax"), rs.getInt("range")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;        
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
    
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", TariffRate=" + TariffRate + ", Tax=" + Tax + ", range=" + range + '}';
    }
    
    
}
