/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rar.resources;
import rat.StringConstants;
import java.sql.*;
/**
 *
 * @author Aditya
 */
public class DbHandler {
    
    public boolean connection(){
        boolean status = false;
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            )
        {
            status = true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return status;
    }
}
