/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.resources;

/**
 *
 * @author User
 */
import javaapplication1.models.MenuItem;
import javaapplication1.StringConstants;
import java.sql.*;
public class MenuDbHandler {

    /**
     * @param args the command line arguments
     */
    public MenuItem FindInMenu(int id,int qty) {
        // TODO code application logic here
        MenuItem item=null;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlSelect="SELECT name,price,tpp,nppt FROM menu WHERE id="+id;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            rSet.next();
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);
        }
        catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;
        
    }
    
    public boolean addToMenu(String name,double price,int nppt,int tpp,int qty) {
        // TODO code application logic here
        boolean status=false;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlinsert="INSERT INTO menu (name,price,nppt,tpp) VALUES ('"+name+"',"+ price + ", " + nppt + ", " + tpp + " )";
            int countInserted=stmt.executeUpdate(sqlinsert);
            
            if(countInserted!=0)System.out.println("Menu Item added successfully!");
        }
        catch(SQLException ex){
                ex.printStackTrace();
                }
        return status;
    }
    
    public MenuItem FindByName(String name,int qty) {
        // TODO code application logic here
        MenuItem item=null;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlSelect="SELECT name,price,tpp,nppt,id FROM menu WHERE name="+name;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            rSet.next();
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),rSet.getInt("id"),qty);
        }
        catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;
        
    }
    
}
