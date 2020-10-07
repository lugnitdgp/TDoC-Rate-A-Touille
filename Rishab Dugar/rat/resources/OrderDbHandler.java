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
}