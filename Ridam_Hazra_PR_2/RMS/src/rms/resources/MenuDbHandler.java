package rms.resources;

import rms.StringConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rms.models.MenuItem;

public class MenuDbHandler {
    
    public MenuItem findInMenu(int id, int qty){
        MenuItem item = null;
        
        try{
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
           }
            {
            String sqlSelect="SELECT name,price,tpp,nppt FROM menu WHERE id= '"+ id +"'";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            rSet.next();
            item = new MenuItem(id,rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),qty);
            }
        
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return item;

    }

    public boolean AddToMenu(String name,double price,int nppt,int tpp) {
        boolean status=false;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlinsert="INSERT INTO menu (name,price,nppt,tpp) VALUES ('"+name+"',"+ price + ", " + nppt + ", " + tpp + " )";
            int countInserted=stmt.executeUpdate(sqlinsert);
            if(countInserted != 0)
            System.out.println("Item added successfully!");
        }
        catch(SQLException ex){
                System.out.println(ex);
                }
        return status;
    }

    public MenuItem FindByName(String name,int qty) {
        MenuItem item = null;
        try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
            )
        {
            String sqlSelect="SELECT name,price,tpp,nppt,id FROM menu WHERE name="+name;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            rSet.next();
            item = new MenuItem(rSet.getInt("id"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),name,qty);
        }
        catch(SQLException e){
                System.out.println(e);
                }
        return item;    
    }
    }
