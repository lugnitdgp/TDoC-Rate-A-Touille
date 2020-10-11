/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import rat.StringConstants;
import rat.models.MenuItem;

/**
 *
 * @author Kshounish
 */
public class MenuDbHandler {
    //func to find a menuitem and if found eturn it //query ny id and qty
    public MenuItem FindInMenu(int id,int qty){
        MenuItem item=null;
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
            )
        {
            String sqlselect="SELECT name,price,tpp,nppt FROM menu WHERE id="+id;
            ResultSet rSet=stmt.executeQuery(sqlselect);
            if(rSet.next())
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);
            
            
        }
       catch(SQLException ex){
        ex.printStackTrace();
           System.out.println("err in menudbhandler finmenu");
    
        }
        return item;
            
    }
    //function to add menuitem
    public boolean addToMenu(String name,double price,int nppt,int tpp){
        boolean status=false;
          try(
            Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt = conn.createStatement();
            )
          {
              String sqlinsert="INSERT INTO menu(name,price,tpp,nppt) VALUES('"+name+"',"+price+","+nppt+","+tpp+")";
              int count=stmt.executeUpdate(sqlinsert);
              if(count!=0) 
                  System.out.println("item successfully added");
                 status =true;
              
          }
          catch(SQLException ex){
              ex.printStackTrace();
              System.out.println("err in menudbhandler addtomenu");
              
          }
          return status;
        
    }
    //query by name and qty
    public MenuItem findByName(String name,int qty){
        MenuItem item=null;
        try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
            )
        {
            String sqlselect="SELECT id,price,tpp,nppt FROM menu WHERE name='"+name+"'";
            ResultSet rSet=stmt.executeQuery(sqlselect);
            rSet.next();
            item=new MenuItem(name,rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),rSet.getInt("id"),qty);
            
            
        }
       catch(SQLException ex){
        ex.printStackTrace();
        System.out.println("err in menudbhandler findbyname");
    
        }
        return item;
        
    }
    public ArrayList getMenu(){ //gets the entire menu
        ArrayList<MenuItem> menu=new ArrayList<>();
            try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
            {
             String sql="SELECT * FROM menu";
             ResultSet rset=stmt.executeQuery(sql);
             while(rset.next()){
                 int id=rset.getInt("id");
                 String name=rset.getString("name");
                 double price =rset.getDouble("price");
                 int tpp=rset.getInt("tpp");
                 int nppt=rset.getInt("nppt");
                 menu.add(new MenuItem(name, price, nppt, tpp, id, 0));
             }
             
         }
        catch(SQLException ex){
        ex.printStackTrace();
        System.out.println("err in menudbhandler getmenu");
    
        }
         return menu;
    }
        
                
        
    }
    
