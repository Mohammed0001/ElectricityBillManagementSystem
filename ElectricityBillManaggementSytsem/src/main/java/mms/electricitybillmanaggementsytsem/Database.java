
package mms.electricitybillmanaggementsytsem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G#1 Group Work
 * 
 **/
    
 

//private String url = "jdbc:mysql://localhost:3306/ElecBillMangament";
//    private String user = "root";
//    private String passwordd="";

public class Database {
    //private String url = "jdbc:sqlserver://Mohammeds-lapto;databaseName=ElecBillMangament";
    
    private String url = "jdbc:mysql://elecbillmangament-elecbillmangament.e.aivencloud.com:12543/defaultdb?sslMode=REQUIRED";
    private String user = "avnadmin";
    private String passwordd = "AVNS_gYNICaI53vjOPlpmtza";

    private Connection connection;
    private Statement statment;

    private static Database dbInstance; 
    
    public Database(){
        try {
//          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
       try {
            connection = DriverManager.getConnection(url, user, passwordd);
            if (connection != null) {
                System.out.println("Database Connected Successfully!");
            }
            statment = connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static Database getInsatnce(){
        if (dbInstance == null){
            dbInstance = new Database();
        }
        return dbInstance;
    }
    
    public ResultSet selectStmt(String sqlSelect){
        ResultSet result = null;
        try{
            result = statment.executeQuery(sqlSelect);
            return result;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    public boolean insertStmt(String sqlInsert){
        try{
            statment.execute(sqlInsert);
            return true;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    public boolean updateStmt(String sqlUpdate){
        try{
            statment.execute(sqlUpdate);
            return true;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    
    public boolean deleteStmt(String sqlDelete){
        try{
            statment.execute(sqlDelete);
            return true;
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return false;
    }
// nada

//    public void saveBankCard(BankCard bankCard) throws SQLException {
//    String query = "INSERT INTO bank_cards (card_number, cvv, expiry_date, card_holder_name) VALUES (1 2, 3, 4)";
//        try (PreparedStatement stmt = conn.prepareStatement(query)) {
//            stmt.setDouble(1, bankCard.getCardNumber());
//            stmt.setDouble(2, bankCard.getcvv());
//            stmt.setString(3, bankCard.getExpiryDate());
//            stmt.setString(4, bankCard.getCardHolderName());
//            stmt.executeUpdate();
//        }
//}
  
   
}


