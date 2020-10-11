
package rat.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rat.StringConstants;
import java.util.ArrayList;
import rat.models.*;

/**
 *
 * @author RUP <your.name at your.org>
 */
public class MenuDbHandler 
{
    public MenuItems FindInMenu(int id,int qty)
            
    {
           MenuItems item=null;
            try(
               Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
               Statement stmt=conn.createStatement();  
                )
        {
            String sqlSelect="SELECT name,price,tpp,nppt from menu WHERE id="+id;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            rSet.next();
            
            item=new MenuItems(id,rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),qty);
            
        }
        catch(SQLException ex)
        {
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
    
    public MenuItems FindByName(String name,int qty) 
    {
        // TODO code application logic here
        MenuItems item=null;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlSelect="SELECT name,price,tpp,nppt,id FROM menu WHERE name="+name;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            rSet.next();
            item=new MenuItems(rSet.getInt("id"),rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),qty);
            //item=new MenuItems(id,rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),qty);
        }
        catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;
        
    }
    public ArrayList getMenu()
    {
        ArrayList <MenuItems> item=new ArrayList();
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
           )
        {
            String sqlSelect="SELECT name,price,tpp,nppt,id FROM menu";
            ResultSet rSet=stmt.executeQuery(sqlSelect);
           while(rSet.next())
           {
               int id =rSet.getInt("id");
               String name=rSet.getString("name");
               double price =rSet.getDouble("price");
               int tpp=rSet.getInt("tpp");
               int nppt=rSet.getInt("nppt");
               item.add(new MenuItems(id,name,price,nppt,tpp,0));
           }
        }
        catch(SQLException ex)
                {
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;
        
    }
    public MenuItems QueryByName(String name,int qty) 
    {
        // TODO code application logic here
        MenuItems item=null;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlSelect="SELECT name,price,tpp,nppt,id FROM menu WHERE name="+name;
            ResultSet rSet=stmt.executeQuery(sqlSelect);
            rSet.next();
            item=new MenuItems(rSet.getInt("id"),rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),qty);
        }
        catch(SQLException ex){
                ex.printStackTrace();
                System.out.println(ex);
                }
        return item;

    }
}

