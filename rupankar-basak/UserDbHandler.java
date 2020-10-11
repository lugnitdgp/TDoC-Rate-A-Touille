/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rat.StringConstants;

/**
 *
 * @author RUP <your.name at your.org>
 */
public class UserDbHandler 
{
    public void RegisterStaff(String name,String password,int age,double salary)
    {
            try(
                Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
               Statement stmt=conn.createStatement();
                    )
        {
            String salt=Utils.genRandomSalt();
            String pass=Utils.encryptPassword(password,salt);
            String SqlInsert ="INSERT INTO staff (name,salt,password,age,salary) VALUES (' "+name+" ', ' "+salt+"',' "+pass+" ', "+age+","+salary+")";
              int countInserted=stmt.executeUpdate(SqlInsert);
              if (countInserted!=0) System.out.println("Successful insertion");
          }
        catch(SQLException ex)
        {
             System.out.println(ex);
        }
    }
    public boolean loginStaff(String name,String password)
    {
        try(
               Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
               Statement stmt=conn.createStatement();  
                )
        {
            String sqlQuery="SELECT salt.password FROM STAFF where name= '"+ name+" ";
        ResultSet rset=stmt.executeQuery(sqlQuery);
        rset.next();
        
        String dbsalt=rset.getString("salt");
        String dbpassword=rset.getString("password");
        String GiPassword=Utils.encryptPassword(password,dbsalt);
        
        if(GiPassword.equals(dbpassword))
                return true;
        
        return false;
        }
        catch(SQLException ex)
        {
             System.out.println(ex);
        }
        return false;
        
    }
}
