

package mms.electricitybillmanaggementsytsem;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *

 * @author Electricity BIll Management System 
 * G#1
 */
public class ElectricityBillManaggementSytsem {
    
    public static void main(String[] args) {
       new login().setVisible(true);
       
//              BankCardForm bankCardForm = new BankCardForm();
//     bankCardForm.setVisible(true);

// InstaPayform  InstaPayform = new InstaPayform ();
//        InstaPayform .setVisible(true);


        Database.getInsatnce() ;
//        User u = new User();
//        u.setName("Karim");
//        u.setPassword("KarimPass");
//        u.setUsername("karimm");


//        System.out.println(u.createAccount());
        ResultSet rs = Database.getInsatnce().selectStmt("SELECT * FROM users;");
        try {
            while(rs.next()){
                
                System.out.println(rs.getString("name")+" id : " + rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityBillManaggementSytsem.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Susscess!! in mms.electricitybillmanaggementsytsem.ElectricityBillManaggementSytsem.main()");
    }
    
    
    
    
    
    
 
}


