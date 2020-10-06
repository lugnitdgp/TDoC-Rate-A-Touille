package rms.resources;

import rms.models.Order;
import rms.models.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rms.StringConstants;
import java.util.ArrayList;
/**
 *
 * @author rdmhz
 */
public class OrdersDbHandler {
    
    public void addOrder(String timePlaced, ArrayList<MenuItem> menu){

        String items = "";

        for(MenuItem item : menu){
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQty());
            items += id + ":" + qty + ",";
        }
        items = items.substring(0,items.lastIndexOf(","));
        addOrder2(timePlaced,items);
    }

    public void addOrder2(String timePlaced, String items){

        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
            ){

            String sqlInsert = "INSERT INTO orders (timePlaced,items) VALUES ('" + timePlaced + "', '" + items + "')";
            int countInsert = stmt.executeUpdate(sqlInsert);
            if(countInsert != 0) System.out.println("Order added Successfully!");
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public ArrayList getOrders(){

        ArrayList<Order> orders = new ArrayList<>();
        try(
               Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement(); 
        ){
          String strSelect = "SELECT id,timePlaced,items FROM orders";
          ResultSet rSet = stmt.executeQuery(strSelect);

          while(rSet.next()){

              int id = rSet.getInt("id");
              String timePlaced = rSet.getString("timePlaced");
              String items = rSet.getString("items");
              orders.add(new Order(id, timePlaced, items));
          } 

        }
        catch(SQLException ex){
        System.out.println(ex);
        }

        return orders;    
    }

}
