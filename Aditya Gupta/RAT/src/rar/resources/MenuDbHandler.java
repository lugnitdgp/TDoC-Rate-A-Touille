/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rar.resources;

import java.sql.*;
import rat.StringConstants;
import rat.models.MenuItem;

/**
 *
 * @author Rishabh
 */
public class MenuDbHandler {
    public MenuItem FindInMenu(int id, int qty){
        MenuItem item = null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            )
        {
            String sqlSelect = "SELECT name,price,tpp,nppt FROM menu WHERE id " + id;
            ResultSet rSet = stat.executeQuery(sqlSelect);
            
            rSet.next();
            item = new MenuItem(id, rSet.getString("name"), rSet.getDouble("price"),rSet.getInt("nppt"), rSet.getInt("tpp"), qty);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return item;
    }
    
    public void AddToMenu(String name, double price, int tpp, int nppt){
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            ){
            String sqlInsert = "INSERT INTO menu (name, price, tpp, nppt) VALUES ('" + name + "'," + price + "," + tpp + "," + nppt + ")";
            int countInsert = stat.executeUpdate(sqlInsert);
            if(countInsert != 0)
                System.out.println("Item added to menu successfully");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void findInMenuByName(String name, int qty){
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            ){
            String sqlSelect = " SELECT name FROM menu WHERE name = '" + name + "' AND  qty = " + qty;
            ResultSet rSet = stat.executeQuery(sqlSelect);
            
            rSet.next();
            System.out.println(rSet.getString("name"));
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
