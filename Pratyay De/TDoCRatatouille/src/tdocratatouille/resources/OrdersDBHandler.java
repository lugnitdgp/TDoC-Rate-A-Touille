/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.resources;
import java.sql.*;
import java.util.*;
import tdocratatouille.models.Order;
import tdocratatouille.models.MenuItem;
import tdocratatouille.StringConstants;
/**
 *
 * @author Divyo
 */
public class OrdersDBHandler {
    
    public void addOrder(String timePlaced, ArrayList<MenuItem> menus){
        
        String items = "";
        
        for(MenuItem item : menus){
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQty());
            items += id + ":" + qty + ",";
        }
        items = items.substring(0,items.length()-1);//Task -- Remove last comma when adding menu items to order
        addOrder2(timePlaced,items);
    }
    
    public void addOrder2(String timePlaced, String items){
        
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
            ){
            
            String SqlInsert = "INSERT INTO orders (timePlaced,items) VALUES ('" + timePlaced + "', '" + items + "')";
            int countInsert = stmt.executeUpdate(SqlInsert);
            if(countInsert != 0) System.out.println("Order added successfully");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public ArrayList getOrders(){
        
        ArrayList<Order> orders = new ArrayList<>();
        try(
               Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement(); 
        ){
          String SqlSelect = "SELECT id,timePlaced,items FROM orders";
          ResultSet rSet = stmt.executeQuery(SqlSelect);
          
          while(rSet.next()){
              
              int id = rSet.getInt("id");
              String timePlaced = rSet.getString("timePlaced");
              String items = rSet.getString("items");
              orders.add(new Order(id, timePlaced, items));
          } 
        
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return orders;    
    }
  
    
    // Task - Remove order function 
    public void removeOrder(int id){
        try(
               Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement(); 
        ){
            String SqlDelete = "DELETE FROM orders WHERE id ="+id;
            int countDeleted = stmt.executeUpdate(SqlDelete);
            
            if(countDeleted != 0) System.out.println("Order deleted successfully");    
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    // Task - Append order function(s)
    public void appendOrder(int id, ArrayList<MenuItem> menus){
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                ){
            String SqlQuery = "SELECT items FROM orders WHERE id ="+id;
            ResultSet rSet = stmt.executeQuery(SqlQuery);
            rSet.next();
            String order = rSet.getString("items");
            order = order + ","+appendOrder2(menus);
            String sqlUpdate = "UPDATE orders SET items = '"+order+"' WHERE id = "+id;
            int countAppend = stmt.executeUpdate(sqlUpdate);
            if(countAppend != 0) System.out.println("Order successfuly appended");
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public String appendOrder2(ArrayList<MenuItem> menus){
        
        String items = "";
        
        for(MenuItem item : menus){
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQty());
            items += id + ":" + qty + ",";
        }
        items = items.substring(0,items.lastIndexOf(","));//Task -- Remove last comma when adding menu items to order
        return items;
        
    }
    
    
    
}
