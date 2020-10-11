/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rar.resources;

import java.sql.*;
import rat.StringConstants;
import java.util.ArrayList;
import rat.models.MenuItem;
import rat.models.Order;


/**
 *
 * @author Rishabh
 */
public class OrderDbHandler {
    public void addOrder(String timePlaced, ArrayList<MenuItem> menus){
        String items= "";
        
        for(MenuItem item : menus){
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQty());
            
            items += id + ":" + qty + ",";
        }
//        items = items.substring(0, items.length()-1);
        
        addOrder2(timePlaced, items);
    }
        
    public void addOrder2(String timePlaced, String items){
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            )
        {
            String sqlInsert = "INSERT INTO orders (timePlaced,items) VALUES ('" + timePlaced + "','" + items + "')";
            int countInsert = stat.executeUpdate(sqlInsert);
            if(countInsert != 0)
                System.out.println("Order added successfully");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    public ArrayList getOrder(){
        ArrayList<Order> order = new ArrayList();
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            ){
            String sqlSelect = "SELECT id,timeplaced,items FROM orders";
            ResultSet rSet = stat.executeQuery(sqlSelect);
            
            while(rSet.next()){
                int OrderNo = rSet.getInt("id");
                String timePlaced = rSet.getString("timeplaced");
                String items = rSet.getString("items");
                System.out.println(OrderNo+timePlaced+items);
                order.add(new Order(OrderNo, timePlaced, items));
            }
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return order;
    }

    public void removeOrder(int id){
        
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            ){
            String sqlDelete = "DELETE FROM orders WHERE id = " + id;
            int countDeleted = stat.executeUpdate(sqlDelete);
            if(countDeleted != 0) System.out.println("Order removed");
        }
        catch(SQLException ex){
            ex.getMessage();
        }
    }
}
