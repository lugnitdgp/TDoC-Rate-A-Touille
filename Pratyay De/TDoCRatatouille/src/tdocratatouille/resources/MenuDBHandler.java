/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.resources;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tdocratatouille.StringConstants;
import tdocratatouille.models.MenuItem;
/**
 *
 * @author Divyo
 */
public class MenuDBHandler {
    
    public MenuItem FindInMenu(int id, int qty){
        MenuItem item = null;
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
            String sqlSelect = "SELECT  name,price,tpp,nppt FROM menu WHERE id ="+id;
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            
            rSet.next();
            item = new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return item;
    }
    
    //Task -- Add function to search in menu by name
    public MenuItem FindInMenuByName(String name, int qty){
        MenuItem item = null;
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
            String sqlSelect = "SELECT id,price,tpp,nppt FROM menu WHERE name = '"+name+"'";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            
            rSet.next();
            item = new MenuItem(name,rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),rSet.getInt("id"),qty);
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return item;
    }
    
    public void AddToMenu(String name,double price,int tpp,int nppt){
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
            
            String SqlInsert = "INSERT INTO menu (name,price,tpp,nppt) VALUES ('" + name + "', " + price + "," + tpp + "," + nppt + ")";
            int countInserted = stmt.executeUpdate(SqlInsert);
            if(countInserted !=0) System.out.println("Successful Insertion");
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public ArrayList getMenu(){
        ArrayList<MenuItem> menu = new ArrayList();
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                ){
            String strSelect = "SELECT id,name,price,tpp,nppt FROM menu";
            ResultSet rSet = stmt.executeQuery(strSelect);
            
            while(rSet.next()){
                int id = rSet.getInt("id");
                String name = rSet.getString("name");
                double price = rSet.getDouble("price");
                int tpp = rSet.getInt("tpp");
                int nppt = rSet.getInt("nppt");
                menu.add(new MenuItem(name,price,nppt,tpp,id,0));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return menu;
    }
    
    
    
}
