package rat.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import rms.StringConstants;
import RAT.models.MenuItem;

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
            item=new MenuItem(rSet.getString("name"),rSet.getDouble("price"),rSet.getInt("nppt"),rSet.getInt("tpp"),id,qty);
            
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
        return item;
    }
}
