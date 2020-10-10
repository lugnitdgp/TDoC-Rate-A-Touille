/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import RAT.models.MenuItem;
import RAT.models.Order;
import rat.StringConstants;
import java.util.*;
import java.sql.*;

/**
 *
 * @author kingr
 */
public class OrderDbHandler {

    public void addOrder(String timePlaced,ArrayList<MenuItem> menus){
            String items="";
            for(MenuItem item : menus)
            {
               String id=Integer.toString(item.getId());
               String qty=Integer.toString(item.getQty());
               items+=id+":"+qty+",";
            }
            addOrder2(timePlaced,(items.substring(0,items.length()-1)));
        }

    public void addOrder2(String timePlaced,String items){
        try
            (
 Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
 Statement stmt = conn.createStatement();
            )      
        {
            String sqlInsert="INSERT INTO orders (timePlaced,items) VALUES ('"+ timePlaced+ "','"+ items+"')";
            int countInserted=stmt.executeUpdate(sqlInsert);
            if(countInserted!=0)System.out.println("Order added successfully!");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public ArrayList getOrders() {
        ArrayList<Order> order = new ArrayList<>();
        try (
                 Connection conn = DriverManager.getConnection(StringConstants.DB_URL, StringConstants.USER, StringConstants.PASS); 
                Statement stmt = conn.createStatement();
                )
        {
            String strSelect = "SELECT id,timePlaced,items from orders";
            ResultSet rSet = stmt.executeQuery(strSelect);
            ArrayList<MenuItem> item=new ArrayList();
            while (rSet.next()) {
                int id = rSet.getInt("id");
                String timePlaced = rSet.getString("timePlaced");
                String items = rSet.getString("items");
                MenuDbHandler menu=new MenuDbHandler();

                StringTokenizer st=new StringTokenizer(items,",");
                while(st.hasMoreTokens()){
                    String token=st.nextToken().trim();
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