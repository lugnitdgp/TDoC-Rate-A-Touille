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
public class OrdersDbHandler {
    //function to convert an order in required form
    public void addOrder(String timePlaced,ArrayList<MenuItem> menus){
        //order is stored like this
        //1:3,2:34,4:5
        String items="";
        for(MenuItem item:menus){
            String id=Integer.toString(item.getId());
            String qty=Integer.toString(item.getQty());
            items+=id+":"+qty+",";
        }
        items=items.substring(0,items.length()-1);
        addOrder2(timePlaced,items);
    }
    //add order in database
    public void addOrder2(String timePlaced,String items){
         try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
           String Sqlinsert="INSERT INTO orders(timePlaced,items) VALUES('"+timePlaced+"','"+items+"')";
           int count=stmt.executeUpdate(Sqlinsert);
           if(count!=0){
               System.out.println("order successfully added");
           }        
        }
        catch(SQLException ex){
        ex.printStackTrace();
    
        }
    }
  
}
