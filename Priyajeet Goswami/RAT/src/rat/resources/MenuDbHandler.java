/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;
import java.util.ArrayList;
import rat.StringConstants;
import rat.models.MenuItem;
import java.sql.*;
/**
 *
 * @author P-G
 */
public class MenuDbHandler {
    //func to find a menuitem and if found return it 
    public MenuItem FindInMenu(int id,int qty){
        MenuItem item=null;
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
            )
        {
            String sqlselect="SELECT name,price,tpp,nppt FROM menu WHERE id="+id;
            ResultSet rSet=stmt.executeQuery(sqlselect);
            rSet.next();
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);
            
            
        }
       catch(SQLException ex){
        ex.printStackTrace();
    
        }
        return item;
            
    }
    //function to add menuitem
    public boolean addToMenu(String name,double price,int nppt,int tpp){
        boolean status=false;
          try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            )
          {
              String sqlinsert="INSERT INTO menu(name,price,tpp,nppt) VALUES('"+name+"',"+price+","+nppt+","+tpp+")";
              int count=stmt.executeUpdate(sqlinsert);
              if(count!=0) 
                  System.out.println("item successfully added");
                 status =true;
              
          }
          catch(SQLException ex){
              ex.printStackTrace();
              
          }
          return status;
        
    }
    //query by name and qty
    public MenuItem findByName(String name,int qty){
        MenuItem item=null;
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
            )
        {
            String sqlselect="SELECT name,price,tpp,nppt FROM menu WHERE name='"+name+"'";
            ResultSet rSet=stmt.executeQuery(sqlselect);
            rSet.next();
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),rSet.getInt("id"),qty);
            
            
        }
       catch(SQLException ex){
        ex.printStackTrace();
    
        }
        return item;
        
    }
}
