package rat.resources;
import java.sql.*;
import java.util.*;
import rms.StringConstants;
import RAT.models.Order;
import RAT.models.MenuItem;
public class OrdersDbHandler {

    public void addOrder(String timePlaced,ArrayList<MenuItem> menus){
        String items ="";

        for (MenuItem item : menus){
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getqty());
            items += id + ":" + qty + ",";
    }
    addOrder2(timePlaced,items);
}

    public void addOrder2(String timePlaced,String items){

        try(
              Connection conn =DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
              Statement stmt = conn.createStatement();
                )
        {
            String sqlInsert = "INSERT INTO orders (timePlaced,items) VALUES('" + timePlaced +"','"+items+"' )";
            int countInsert = stmt.executeUpdate(sqlInsert);
            if(countInsert !=0) System.out.println("Order added successfully");
        }
       catch(SQLException ex){
       ex.printStackTrace();
    } 
    }
    public ArrayList getOrders()
    {
        ArrayList<Order> orders = new ArrayList<>();
        try(
                Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
                Statement stmt=conn.createStatement();
                )
        {
            String select = "SELECT id,timePlaced,items FROM orders";
            ResultSet rSet=stmt.executeQuery(select);
            while(rSet.next())
            {
                int id = rSet.getInt("id");
                String timePlaced = rSet.getString("timePlaced");
                String items = rSet.getString("items");
                orders.add(new Order(id,timePlaced,items));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return orders;
    }
    
}