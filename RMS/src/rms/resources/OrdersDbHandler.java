/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rms.StringConstants;
import rms.models.MenuItem;
import rms.models.Order;

/**
 *
 * @author rammy
 */
public class OrdersDbHandler {
    public void addOrder(String timePlaced,ArrayList<MenuItem> menus){
        String items=format(menus);
        addOrder2(timePlaced,items);
    }
    public void appendOrder(int id,ArrayList<MenuItem> menus){
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String SqlQuery="SELECT items FROM orders WHERE id="+id;
            ResultSet rSet=stmt.executeQuery(SqlQuery);
            rSet.next();
            String order=rSet.getString("items");
            order=order+","+format(menus);
            String sqlUpdate="UPDATE orders SET items = '"+order+"' WHERE id = "+id;
            int countAppend = stmt.executeUpdate(sqlUpdate);
            if(countAppend != 0) System.out.println("Order successfully appended.");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public String format(ArrayList<MenuItem> menus){
        String items="";
        
        for(MenuItem item:menus){
            String id=Integer.toString(item.getId());
            String qty=Integer.toString(item.getQty());
            items+=id+":"+qty+',';
        }
        items=items.substring(0, items.length()-1);
        return items;
    }
    public void addOrder2(String timePlaced,String items){
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String sqlInsert = "INSERT INTO orders (timePlaced,items) VALUES ( '" + timePlaced + "','" + items + "')";
            int countAdded = stmt.executeUpdate(sqlInsert);
            if(countAdded != 0) System.out.println("Order successfully added.");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList getOrders(){
        ArrayList<Order> orders=new ArrayList<>();
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String SqlSearch = "SELECT id,timePlaced,items FROM orders";
            ResultSet rSet=stmt.executeQuery(SqlSearch);
            while(rSet.next()){
                int id=rSet.getInt("id");
                String timePlaced=rSet.getString("timePlaced");
                String items=rSet.getString("items");
                orders.add(new Order(id,timePlaced,items));
            }
        }
        catch(SQLException ex){
                ex.printStackTrace();
        }
        return orders;
    }
}
