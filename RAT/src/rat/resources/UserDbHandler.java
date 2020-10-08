package rat.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rms.StringConstants;

public class UserDbHandler {

    public void registerStaff(String name,String password,int age,double salary){
        try(
            Connection conn =
            DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
        String salt = Utils.genRandomSalt();
        String encPass = Utils.encryptPassword(password,salt);
        String sqlInsert = "INSERT INTO staff (name,salt,password,age,salary)VALUES ( '" + name + "', '" + salt + "', '" + encPass + "', " + age + ", " + salary + " )";
        int countInserted = stmt.executeUpdate(sqlInsert);
        if(countInserted != 0) System.out.println("Staff member successfully registered");
        }
        catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    public boolean loginStaff(String name,String password){
        boolean status = false;
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
        )
        {
        String sqlSelect = "SELECT salt,password from staff WHERE name = '" + name+ "'";
        ResultSet rSet = stmt.executeQuery(sqlSelect);
        rSet.next();
        String dbSalt = rSet.getString("salt");
        String dbPassword = rSet.getString("password");
        String GiPassword = Utils.encryptPassword(password,dbSalt);
        if(GiPassword.equals(dbPassword))
            return true;

        return false;
        }
        catch(SQLException ex){
         System.out.println(ex);
        }
        return false;
    }
}