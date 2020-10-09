/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javaapplication1.Utils;
import javaapplication1.models.MenuItem;
import javaapplication1.StringConstants;
import javaapplication1.models.Order;
import javaapplication1.resources.MenuDbHandler;
import java.util.*;
import java.sql.*;

/**
 *
 * @author User
 */
public class OrderDbHandler {

    /**
     * @param args the command line arguments
     */
    public void addOrder(String timePlaced,ArrayList<MenuItem> menus){
           String items = "";
        for (MenuItem item : menus) {
            //String sqlInsert="INSERT INTO orders (timePlaced,items) VALUES ('"+ timePlaced+ "','"+ items+"')";
            //int countInserted=stmt.executeUpdate(sqlInsert);
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQuantity());
            items += id + ":" + qty + ",";
            //if(countInserted!=0)System.out.println("Order added successfully!");
        }
        items = items.substring(0, items.length() - 1);
            addOrder2(timePlaced,items);
        }
        
    public void addOrder2(String timePlaced,String items){
        try(
 Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
 Statement stmt = conn.createStatement();
 ){
            String sqlInsert="INSERT INTO orders (timePlaced,items) VALUES ('"+ timePlaced+ "','"+ items+"')";
            int countInserted=stmt.executeUpdate(sqlInsert);
            if(countInserted!=0)System.out.println("Order added successfully!");
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public ArrayList getOrders() {
        ArrayList<Order> order = new ArrayList<>();
        try (
                 Connection conn = DriverManager.getConnection(StringConstants.DB_URL, StringConstants.USER, StringConstants.PASS);  Statement stmt = conn.createStatement();) {
            String strSelect = "SELECT id,timePlaced,items from orders";
            ResultSet rSet = stmt.executeQuery(strSelect);
            ArrayList<MenuItem> item=new ArrayList();
            while (rSet.next()) {
                int id = rSet.getInt("id");
                String timePlaced = rSet.getString("timePlaced");
                String items = rSet.getString("items");
                MenuDbHandler menu=new MenuDbHandler();
                
                StringTokenizer st1=new StringTokenizer(items,",");
                while(st1.hasMoreTokens()){
                    String token=st1.nextToken().trim();
                    int itemID=Integer.parseInt(token.substring(0,token.indexOf(":")));
                    int itemQty=Integer.parseInt(token.substring(token.indexOf(":")+1));
                    item.add(menu.FindInMenu(itemID, itemQty));
                   
                }
                
                order.add(new Order(id,timePlaced,item));
                
                

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(order);
        return (order);
    }
    
    public void removeOrder(int id){
        try (
                 Connection conn = DriverManager.getConnection(StringConstants.DB_URL, StringConstants.USER, StringConstants.PASS);  Statement stmt = conn.createStatement();) {
            String strSelect = "DELETE FROM orders WHERE id="+id;
            int countDeleted=stmt.executeUpdate(strSelect);
            if(countDeleted!=0)System.out.println("Order Removed!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
