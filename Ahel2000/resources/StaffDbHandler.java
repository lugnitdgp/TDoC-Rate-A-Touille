/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.resources;

/**
 *
 * @author User
 */
import java.util.*;
import javaapplication1.StringConstants;
import javaapplication1.Utils;
import java.sql.*;
import javaapplication1.models.Staff;
public class StaffDbHandler {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public void registerStaff(String name,String password,int age,double salary){
 try(
 Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
 Statement stmt = conn.createStatement();
 ){
 String salt = Utils.genRandomSalt();
 //System.out.println(salt);
 //String salt="ahel";
 String encPass = Utils.encryptPassword(password,salt);
 System.out.println(encPass);
 String sqlInsert = "INSERT INTO staff (name,salt,password,age,salary)VALUES ( '" + name + "', '" + salt + "', '" + encPass + "', " + age + ", " +salary + " )";
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
 Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
 Statement stmt = conn.createStatement();
 ){
 String sqlSelect = "SELECT salt,password from staff WHERE name = '" + name+ "'";
 ResultSet rSet = stmt.executeQuery(sqlSelect);
 rSet.next();
 String dbSalt = rSet.getString("salt");
 String dbPass = rSet.getString("password");
 String pass = Utils.encryptPassword(password,dbSalt);
 if(dbPass.equals(pass))
 status = true;
 }
 catch(SQLException ex){
 ex.printStackTrace();
 }
 return status;
}    

public void deleteStaff(String name){
 try(
 Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
 Statement stmt = conn.createStatement();
 ){
 String sqlDelete = "DELETE FROM staff WHERE name = '" + name + "'";
 int countDeleted = stmt.executeUpdate(sqlDelete);
 if(countDeleted != 0) System.out.println("Staff member record deleted");
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
