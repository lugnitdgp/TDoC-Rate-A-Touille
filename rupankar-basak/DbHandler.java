/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;
import rat.StringConstants;
import java.sql.*;
/**
 *
 * @author RUP <your.name at your.org>
 */
public class DbHandler 
{
    public boolean connection()
    {
        boolean status=false;
        
        try(
              Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
               Statement stmt=conn.createStatement();
                )
        {
           status=true; 
        }
        catch(SQLException ex)
        {
             ex.printStackTrace();
        }
        return status;
    }
    public boolean insert(String name)
    {
        boolean status=false;
        try(
              Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
               Statement stmt=conn.createStatement();
                )
        {
           String sqlinsert ="ÏNSERT INTO test_table (name) VALUES(''+name+'')";
           int countInserted=stmt.executeUpdate(sqlinsert);
           
           if(countInserted!=0)status=true;
        }
        catch(SQLException ex)
        {
             ex.printStackTrace();
        }
        return status;
    }
}
