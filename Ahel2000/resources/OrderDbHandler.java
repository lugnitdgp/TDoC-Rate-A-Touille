/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javaapplication1.models.MenuItem;
import javaapplication1.StringConstants;
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
            String items="";
            for(MenuItem item : menus){
               //String sqlInsert="INSERT INTO orders (timePlaced,items) VALUES ('"+ timePlaced+ "','"+ items+"')";
               //int countInserted=stmt.executeUpdate(sqlInsert);
               String id=Integer.toString(item.getId());
               String qty=Integer.toString(item.getQuantity());
               items+=id+":"+qty+",";
            //if(countInserted!=0)System.out.println("Order added successfully!");
            }
            items=items.substring(0,items.length()-1);
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
    
    
}
