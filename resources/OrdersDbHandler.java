/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

/**
 * addOrder(timePlaced,List of MenuItems) - converts order to a string like
 * id:qty, id:qty , etc
 * 
 * addOrder2(timePlaced, String order) - connects with DB and adds order to the
 * table - ensure that at the last entry there is no comma - also ensure if more
 * appended there is a comma placed (place comma in front instead).
 * 
 * getOrders() - add or remove orders manually (string tokenizer)
 * 
 */

import rms.StringConst;
import rms.models.MenuItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import rms.models.Orders;

public class OrdersDbHandler {
    
     // adding an order

    public void addOrder(String timeOfOrder, ArrayList<MenuItem> itemList) {
        String order = "";

        for (MenuItem item : itemList) {
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQty());

            order += "," + id + ":" + qty;// convert to desired format
        }

        order = (order.length()==1)? "" : order.substring(1); // omitting out the first comma

        addOrder2(timeOfOrder, order);
    }

    public void addOrder2(String timeOfOrder, String order) {
        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {
            String insertCommand = "INSERT INTO orders (timeofOrder,items) VALUES ('" + timeOfOrder + "','" + order
                    + "')";

            int flag = statement.executeUpdate(insertCommand);

            if (flag != 0)
                System.out.println("Order added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add order !");
        }
    }
    
    // delete an order by its id
    
    public void deleteOrder(int id)
    {
        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();)
        {
            String deleteCommand = "DELETE FROM orders WHERE id="+id;
            int flag = statement.executeUpdate(deleteCommand);
            if(flag!=0)
                System.out.println("Order Removed Successfully !");
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Some error occured while deleting order !");
        }
    }
    
    // returns the list of orders
    public ArrayList getOrders() {
        ArrayList<Orders> order = new ArrayList<>();
        try (
                 Connection conn = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER, StringConst.PASS);  
                Statement statement = conn.createStatement();) {
            String selectCommand = "SELECT id,timeofOrder,items from orders";
            ResultSet rSet = statement.executeQuery(selectCommand);
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
                    item.add(menu.findByID(itemID, itemQty));
                   
                }
                
                order.add(new Orders(id,timePlaced,item));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(order.toString());
        return order;
    }
    
}
