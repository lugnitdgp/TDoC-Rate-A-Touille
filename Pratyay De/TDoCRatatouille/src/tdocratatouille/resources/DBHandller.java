/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.resources;
import tdocratatouille.StringConstants;
import java.sql.*;
/**
 *
 * @author Divyo
 */
public class DBHandller {
    public boolean connection(){
        boolean status = false;
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();    
            )
        {
            status = true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return status;
    }
    
    public boolean insert(String name){
      boolean status = false;
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();    
            )
        {
            String sqlinsert = "INSERT INTO test (name) VALUES ('"+name+"')";
            int countInserted = stmt.executeUpdate(sqlinsert);
            
            if(countInserted != 0)status=true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return status;  
    }
    
        public boolean query(){
      boolean status = false;
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();    
            )
        {
            String sqlquery = "SELECT * FROM test";
            ResultSet rSet = stmt.executeQuery(sqlquery);
            
            while(rSet.next())
            {
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                
                System.out.println(id+" "+name);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return status;  
    }
    
}
