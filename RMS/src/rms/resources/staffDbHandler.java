/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;
import rms.StringConstants;
import java.sql.*;
/**
 *
 * @author rammy
 */
public class staffDbHandler {
    public void registerStaff(String name,String password,int age,double salary){
        boolean status=false;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String salt = utils.getRandomSalt();
            String encPass = utils.encryptPassword(password,salt);
            String sqlInsert = "INSERT INTO staff (name,salt,password,age,salary) VALUES ( '" + name + "', '" + salt + "', '" + encPass + "', " + age + ", " +
            salary + " )";
            int countInserted = stmt.executeUpdate(sqlInsert);
            if(countInserted != 0) System.out.println("Staff member successfully registered");
            status=true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public boolean loginStaff(String name,String password){
        boolean status=false;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String SqlSearch="SELECT salt,password FROM staff WHERE name='"+name+"'";
            ResultSet rSet=stmt.executeQuery(SqlSearch);
            rSet.next();
            String salt=rSet.getString("salt");
            String pass=rSet.getString("password");
            String givenPass=utils.encryptPassword(password, salt);
            if(givenPass.equals(pass))
            {
                System.out.println("Login Succesfull!");
                status=true;
            }
        }
        catch(SQLException ex){
            String temp=ex.getMessage();
            if(temp.equals("Illegal operation on empty result set."))
                System.out.println("No such staff exists.");
            else
                ex.printStackTrace();
        }
        return status;
    }
}
