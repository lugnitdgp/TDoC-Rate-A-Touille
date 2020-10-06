package rat.resources;
import rat.StringConstants;
import java.sql.*;
import java.util.ArrayList;
import rat.models.Staff;


public class UserDbHandler {
    boolean status=false;
    //register
    public void registerStaff(String name,String password,int age,double salary){
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
            //code TBD
           
            
        }
        catch(SQLException ex){
        ex.printStackTrace();
    
        }
    }
    //login
    public boolean loginStaff(String name,String password){
        boolean status=false;
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
             {
            //code TBD
                 String sqlselect="SELECT salt,password FROM staff WHERE name='"+name+"'";
                 ResultSet rSet=stmt.executeQuery(sqlselect);
                 rSet.next(); //first is the headings
                 String dbSalt=rSet.getString("salt");
                 String dbPass=rSet.getString("password");
                 //TBD..
            
            }
        catch(SQLException ex){
        ex.printStackTrace();
    
        }
        return status;
        
    }
    public void deleteStaff(String name){
         try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
            //code TBD
            String sqlquery="DELETE FROM STAFF WHERE name='"+name+"')";
            int count=stmt.executeUpdate(sqlquery);
            if(count!=0) System.out.println("staff record deleted");
           
            
        }
        catch(SQLException ex){
        ex.printStackTrace();
    
        }
    }
    public ArrayList getStaffList(){
        ArrayList<Staff> staffList=new ArrayList();
         try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
            //code TBD
            String sqlquery="SELECT name,age,salary FROM staff";
            ResultSet rSet=stmt.executeQuery(sqlquery);
            while(rSet.next()){
                String name=rSet.getString("name");
                int age=rSet.getInt("age");
                double salary=rSet.getDouble("salary");
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
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
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
