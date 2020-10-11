/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rar.resources;

import java.sql.*;
import java.util.ArrayList;
import rat.StringConstants;
import rat.models.MenuItem;

/**
 *
 * @author Aditya
 */
public class MenuDbHandler {
    public MenuItem FindInMenu(int id, int qty){
        MenuItem item = null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            )
        {
            String sqlSelect = "SELECT name,price,tpp,nppt FROM menu WHERE id = " + id;
            ResultSet rSet = stat.executeQuery(sqlSelect);
            
            rSet.next();
            item = new MenuItem(id, rSet.getString("name"), rSet.getDouble("price"),rSet.getInt("tpp"), rSet.getInt("nppt"), qty);
            
        }
        catch(SQLException ex){
            ex.getMessage();
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
            ex.getMessage();
        }
    }
    
    public MenuItem getMenuItem(String name, int qty){
        MenuItem mi = null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            ){
            String sqlSelect = "SELECT id,price,tpp,nppt FROM menu WHERE name = '" + name + "'";
            ResultSet rSet = stat.executeQuery(sqlSelect);
            
            rSet.next();
            mi = (new MenuItem(rSet.getInt("id"),name,rSet.getInt("price"),rSet.getInt("tpp"),rSet.getInt("nppt"),qty));
            
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return mi;
    }
    
    public ArrayList getMenu(){
        ArrayList<MenuItem> menu = new ArrayList();
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stat = conn.createStatement();
            ){
            String sqlSelect = "SELECT * FROM menu";
            ResultSet rSet = stat.executeQuery(sqlSelect);
            
            while(rSet.next()){
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                double price = rSet.getDouble("price");
                int tpp = rSet.getInt("tpp");
                int nppt = rSet.getInt("nppt");
                menu.add(new MenuItem(id,name,price,tpp,nppt,0));
            }
        }
        catch(SQLException ex){
            ex.getMessage();
        }
        return menu;
    }
}
