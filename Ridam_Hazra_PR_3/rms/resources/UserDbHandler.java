package rms.resources;

import rms.models.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rms.StringConstants;
import java.util.ArrayList;

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
            String pass = rSet.getString("Password");
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
       return false; 
    }

        public void deleteStaff(String name){
        
            try(
                Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                ){
                String sqlDelete = "DELETE FROM staff WHERE name = '" + name + "'";
                int countDeleted = stmt.executeUpdate(sqlDelete);
                if(countDeleted != 0) 
                    System.out.println("Staff member record deleted");
                }
            catch(SQLException ex){
                ex.printStackTrace();
             }
        }

        public ArrayList getStaffList(){
            ArrayList<Staff> staffList = new ArrayList();
        try(
            Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            ){
             String strSelect = "SELECT name,age,salary FROM staff";

            ResultSet rSet = stmt.executeQuery(strSelect);
            while(rSet.next()) {
            String name = rSet.getString("name");
            int age = rSet.getInt("age");
            double salary = rSet.getDouble("salary");
            staffList.add(new Staff(name,age,salary));
            }
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
        return staffList;
        
        }

        public void displayStaffInfo(){
        
        try(
            Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            ){
            String strSelect = "SELECT name,age,salary FROM staff";
            ResultSet rSet = stmt.executeQuery(strSelect);
            System.out.printf("%-20s%-10s%-10s\n","Name","Age","Salary");
            
            while(rSet.next()) {
            String name = rSet.getString("name");
            int age = rSet.getInt("age");
            double salary = rSet.getDouble("salary");
            System.out.printf("%-20s%-10d%-10.2f\n",name,age,salary);
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
 
    }

}