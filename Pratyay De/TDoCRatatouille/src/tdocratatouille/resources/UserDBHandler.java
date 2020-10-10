/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.resources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tdocratatouille.StringConstants;
import tdocratatouille.models.Staff;
/**
 *
 * @author Divyo
 */
public class UserDBHandler {
    
    public void RegisterStaff(String name, String password, int age, double salary){
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
            String salt = Utils.genRandomSalt();
            String pass = Utils.encryptPassword(password,salt);
            String SqlInsert = "INSERT into staff (name,salt,password,age,salary) VALUES ('" + name + "', '" + salt + "', '" + pass + "', " + age + "," + salary + ")";
            int countInserted = stmt.executeUpdate(SqlInsert);
            if(countInserted !=0) System.out.println("Successful Insertion");
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public boolean loginStaff(String name, String password){
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
          String SqlSearch = "SELECT salt,password from staff WHERE name = '" + name + "'";  
          ResultSet rSet = stmt.executeQuery(SqlSearch);
          rSet.next();
          
          String dbsalt = rSet.getString("salt");
          String dbPassword = rSet.getString("password");
          String givenPassword = Utils.encryptPassword(password, dbsalt);
          
          if(dbPassword.equals(givenPassword))
              return true;
          
          return false;
          
        }
        catch(SQLException ex){
            System.out.println(ex);
            System.out.println("User does not exist");//Task -- Print if user name is not found
            return false;
        }
    }
    
    public ArrayList getStaff(){
        ArrayList<Staff> users = new ArrayList();
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                ){
            String SqlQuery = "SELECT id,name,age,salary FROM staff";
            ResultSet rSet = stmt.executeQuery(SqlQuery);
            
            while(rSet.next()){
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                double salary = rSet.getDouble("salary");
                int age = rSet.getInt("age");
                users.add(new Staff(id,name,age,salary));
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return users;
    }
    
}
