/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rar.resources;

import java.sql.*;
import rat.StringConstants;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rat.models.*;

/**
 *
 * @author Aditya
 */
public class StaffDbHandler {
    
    public void registerStaff(String name,String password,int age,double salary){
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            )
        {
         String salt = Utils.genRandomSalt();
         String encPass = Utils.encryptPassword(password,salt);
         String sqlInsert = "INSERT INTO staff (name,salt,password,age,salary) VALUES ('" + name + "','" + salt + "','" + encPass + "'," + age + "," + salary + ")";
         int countInserted = stat.executeUpdate(sqlInsert);
         if(countInserted != 0)
             System.out.println("Staff member successfully added");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public boolean loginStaff(String name, String password){
        boolean status = false;
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            )
        {
            String sql = "SELECT salt,password FROM staff WHERE name = '" + name + "'";
            ResultSet rSet = stmt.executeQuery(sql);
            rSet.next();
            String dbSalt;
            dbSalt = rSet.getString("salt");
            String dbPassword = rSet.getString("password");
            String pass = Utils.encryptPassword(password,dbSalt);
            
            if(dbPassword.equals(pass)){
                status =true;
            }
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return status;
    }
    
    public void deleteStaff(String name)
    {
        try
        (
            Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            )
    {
        String sqlDelete = "DELETE FROM staff WHERE name = '" + name + "'";
        int countDeleted = stmt.executeUpdate(sqlDelete);
        if(countDeleted != 0)
            System.out.println("Staff member record deleted");
    }
    catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList getStaffList(){
    ArrayList<Staff> staffList = new ArrayList();
    try
    (
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
    ){
      String str = "SELECT name,age,salary FROM staff";
      ResultSet rSet = stmt.executeQuery(str);
      
      while(rSet.next()){
          String name = rSet.getString("name");
          int age = rSet.getInt("age");
          double salary = rSet.getDouble("salary");
          
          staffList.add(new Staff(name,age,salary));
      }
      
    }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return staffList;
    }
    
    public void displayStaffInfo(){
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
        ){
          String strSelect = "SELECT name,age,salary FROM staff";
          ResultSet rSet = stmt.executeQuery(strSelect);
          
          System.out.printf("%-20s%-10s%-10s\n","Name","Age","Salary");
          while(rSet.next()){
              String name = rSet.getString("name");
              int age = rSet.getInt("age");
              double salary = rSet.getDouble("salary");
              System.out.printf("%-20s%-10d%-10.2f\n",name,age,salary);
          }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public Staff Staffmember(String name){
        Staff status = null;
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            )
        {
            String sql = "SELECT salary,age FROM staff WHERE name = '" + name + "'";
            ResultSet rSet = stmt.executeQuery(sql);
            rSet.next();
            int age = rSet.getInt("age");
            int salary = rSet.getInt("salary");
            status = new Staff(name,age,salary);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return status;
    }
}