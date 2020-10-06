package rms.resources;

import rms.models.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rms.StringConstants;

public class UserDbHandler {
    
    public void RegisterStaff(String nmae, String password, int age, double salary){
        try{
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        }
    {
        String salt = Utils.genRandomSalt();
        String pass = Utils.encryptPassword(password, salt);
        String sqlInsert = "INSERT into staff (name,salt,password,age,salary) VALUES ('"+ name + "', '" + salt + "', '" + pass + "', " + age + ", " + salary + ")";
        int countInserted = stmt.executeUpdate(sqlInsert);
        if(countInserted != 0)
            System.out.println("Successful Insertion");
    }
    catch(SQLException ex)
    {
        System.out.println(ex);
    }
    
}    
    
    public boolean loginStaff(String name, String password)
    {
        try{
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL, StringConstants.USER, StringConstants.PASS);
                Statement stmt = conn.createStatement();
        }
        {
            String sqlQuery = "SELECT salt.password from staff WHERE name = '" + name + "'";
            ResultSet rSet = stmt.executeQuery(sqlQuery);
            rSet.next();
            String salt = rSet.getString("Salt");
            String pass = rSet.getString("password");
            String given_pass = Utils.encryptPassword(password,salt);
            
            if(pass.equals(given_pass))
                return true;
            return false;
        }
        catch(SQLException ex){
            System.out.println(ex);
            System.out.println("STAFF DOES NOT EXIST");
            return false;
        }
        
    }
}

