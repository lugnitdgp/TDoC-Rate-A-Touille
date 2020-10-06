/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;
import rat.java.stringconsts;
import java.sql.*;
/**
 *
 * @author pakhe
 */
public class dbhandler {
    public boolean connection()
    {
         
        boolean status= false;
        try (
              
            Connection conn =DriverManager.getConnection(stringconsts.DB_URL,stringconsts.USER,stringconsts.PASS);
            Statement stmt=conn.createStatement();
                )
            
        
        {
            status=true;
        }
        catch(SQLException ex){
                ex.printStackTrace();
                
        }
        return status;
    }
    
}
