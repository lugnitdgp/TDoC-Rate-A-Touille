/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import rms.StringConstants;
import rms.models.MenuItem;

/**
 *
 * @author rammy
 */
public class MenuDbHandler {
    public void addMenu(String name,double price,int tpp,int nppt,int qty){
        boolean status=false;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String sqlInsert = "INSERT INTO menu (name,price,tpp,nppt,qty) VALUES ( '" + name + "'," + price + ", " + tpp + ", " +nppt +", "+qty+" )";
            int countAdded = stmt.executeUpdate(sqlInsert);
            if(countAdded != 0) System.out.println("Menu Item successfully added.");
            status=true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public MenuItem FindInMenuById(int id,int qty){
        MenuItem item=null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String SqlSearch = "SELECT name,price,tpp,nppt FROM menu WHERE id="+id;
            ResultSet rSet=stmt.executeQuery(SqlSearch);
            rSet.next();
            item=new MenuItem(id,rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("tpp"),rSet.getInt("nppt"),qty);
        }
        catch(SQLException ex){
            String temp=ex.getMessage();
            if(temp.equals("Illegal operation on empty result set."))
                System.out.println("No such menu item exists.");
            else
                ex.printStackTrace();
        }
        return item;
    }
    public MenuItem FindInMenuByName(String name,int qty){
        MenuItem item=null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String SqlSearch = "SELECT id,price,tpp,nppt FROM menu WHERE name='"+name+"'";
            ResultSet rSet=stmt.executeQuery(SqlSearch);
            rSet.next();
            item=new MenuItem(rSet.getInt("id"),name,rSet.getDouble("price"),rSet.getInt("tpp"),rSet.getInt("nppt"),qty);
        }
        catch(SQLException ex){
            String temp=ex.getMessage();
            if(temp.equals("Illegal operation on empty result set."))
                System.out.println("No such menu item exists.");
            else
                ex.printStackTrace();
        }
        return item;
    }
    
    public ArrayList getMenu(){
        ArrayList<MenuItem> menu=new ArrayList();
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
        )
        {
            String sqlSelect = "SELECT id,name,price,tpp,nppt FROM menu";
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            while(rSet.next()){
                int id=rSet.getInt("id");
                String name=rSet.getString("name");
                double price=rSet.getDouble("price");
                int tpp=rSet.getInt("tpp");
                int nppt=rSet.getInt("nppt");
                menu.add(new MenuItem(id,name,price,tpp,nppt,0));
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return menu;
    }
}
