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
import rat.models.Menuitem;

/**
 *
 * @author user
 */
public class MenuDbHandler {
    
    
    public Menuitem FindInMenu(int id,int qty){
        Menuitem item = null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL, StringConstants.USER, StringConstants.PASS);
            Statement stmt = conn.createStatement();  
            )
        {
            String sqlSelect = "SELECT name,price,tpp,nppt from menu WHERE id ="+ id;
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            
            rSet.next();
            item = new Menuitem(rSet.getString("name"), rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id, qty); 

        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return item;
        
    }
    
    public void addToMenu(String name, double price, int qty, int nppt, int tpp) { 
         try (
                 Connection conn = DriverManager.getConnection(StringConstants.DB_URL, StringConstants.USER,StringConstants.PASS); 
                 Statement stmt = conn.createStatement();
              ) 
         { 
             String insertCommand = "INSERT INTO menu (name,price,tpp,nppt) VALUES ('" + name + "'," + price + "," + tpp + ", " + nppt + " )"; 
             int insert = stmt.executeUpdate(insertCommand); 
             if (insert != 0) 
                 System.out.println("Item added"); 
             else 
                 System.out.println("Failed"); 
 
         } 
         catch (SQLException e) 
         { 
             e.printStackTrace(); 
             System.out.println("Adding item Failed"); 
         } 
    } 
 
 

    
    
}
