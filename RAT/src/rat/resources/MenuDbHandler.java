package rat.resources;

import java.sql.*;
import rms.StringConstants;
import RAT.models.MenuItem;
import RAT.models.*;

public class MenuDbHandler {
    public MenuItem FindInMenu(int id,int qty){
        MenuItem item=null;
        try(
                Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
            String sqlSelect = "SELECT name.price.tpp.nppt from menu WHERE id ="+id;
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            
            rSet.next();
            item = new MenuItem(id,rSet.getString("name"),rSet.getDouble("price"),qty,rSet.getInt("tpp"),rSet.getInt("nppt"));
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return item;
    }
    public MenuItem FindInMenuByName(String name,int qty){
        MenuItem item=null;
        try(
                Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt = conn.createStatement();
                )
        {
            String sqlSelect = "SELECT * from menu WHERE name = '"+name+"';";
            ResultSet rSet = stmt.executeQuery(sqlSelect);
            
            rSet.next();
            item = new MenuItem(rSet.getInt("id"),name,rSet.getDouble("price"),qty,rSet.getInt("tpp"),rSet.getInt("nppt"));
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return item;
    }
    
    public void AddToMenu(String name, double price, int tpp, int nppt)
    {
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt=conn.createStatement();
                )
        {
            String sqlstring = "INSERT INTO menu (name,price,tpp,nppt) VALUES('"+name+"',"+price+","+tpp+","+nppt+");";
            int countInserted=stmt.executeUpdate(sqlstring);
            if(countInserted  != 0)
            System.out.println("Adding is successful");
        }
        catch(SQLException e)
        {
            System.out.println(e);
            
        }
    }
}
