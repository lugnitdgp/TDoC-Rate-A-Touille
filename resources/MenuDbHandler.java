/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

// function to add menu based on MenuItem parameters
// findInMenu(id,qty) and addToMenu(MenuItem)
// add a function to query by name: params= name and qty

import rms.models.MenuItem;
import rms.StringConst;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author SOUMITRI CHATTERJEE
 */
public class MenuDbHandler {
    
    // adding items to menu

    public void addToMenu(String name, double price, int qty, int nppt, int tpp) {
        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            String insertCommand = "INSERT INTO menu (name,price,tpp,nppt) VALUES ('" + name + "'," + price + ", " + tpp
                    + ", " + nppt + " )";

            int flag = statement.executeUpdate(insertCommand);

            if (flag != 0)
                System.out.println("Menu item added Successfully !");
            else
                System.out.println("Failed to add item to Menu");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item to Menu");
        }
    }

    // find an item in menu and return the same

    public MenuItem findMenuItem(String name, int qty) {
        MenuItem item = null;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            String selectCommand = "SELECT name,price,tpp,nppt,id FROM menu WHERE name= '" + name+ "'";

            ResultSet rSet = statement.executeQuery(selectCommand);
            rSet.next();

            item = new MenuItem(rSet.getInt("id"), rSet.getDouble("price"), rSet.getString("name"), qty,
                    rSet.getInt("tpp"), rSet.getInt("nppt"));

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item to Menu");
        }
        return item;
    }

    // finding by ID of item

    public MenuItem findByID(int id, int qty) {
        MenuItem item = null;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            String selectCommand = "SELECT id,price,name,tpp,nppt FROM menu WHERE id=" + id;

            ResultSet rSet = statement.executeQuery(selectCommand);
            rSet.next();

            item = new MenuItem(id, rSet.getDouble("price"), rSet.getString("name"), qty, rSet.getInt("tpp"),
                    rSet.getInt("nppt"));

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item to Menu");
        }
        return item;
    }
    
    public ArrayList<MenuItem> getMenu() {
        
        ArrayList<MenuItem> menu=new ArrayList<>();
        
        try (
                 Connection conn = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER, StringConst.PASS);  
                Statement statement = conn.createStatement();) 
        {
            String selectCommand = "SELECT id,name,price,tpp,nppt FROM menu";
            ResultSet rSet=statement.executeQuery(selectCommand);
            
            while(rSet.next())
            {
                int id=rSet.getInt("id");
                String name=rSet.getString("name");
                double price=rSet.getDouble("price");
                int tpp=rSet.getInt("tpp");
                int nppt=rSet.getInt("nppt");
                menu.add(new MenuItem(id,price,name,0,tpp,nppt));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return menu;
    }
    
}
