package rat.resources;
import java.util.ArrayList;
import rat.StringConstants;
import rat.models.MenuItem;
import java.sql.*;
import rat.models.Order;

/**
 *
 * @author Kshounish
 */
public class OrdersDbHandler {
    //function to convert an order in required form
    public void addOrder(String timePlaced,ArrayList<MenuItem> menus){
        //order is stored like this
        //1:3,2:34,4:5
        String items="";
        for(MenuItem item:menus){
            String id=Integer.toString(item.getId());
            String qty=Integer.toString(item.getQty());
            items+=id+":"+qty+",";
        }
        items=items.substring(0,items.length()-1);
        addOrder2(timePlaced,items);
    }
    public String convert(ArrayList<MenuItem> menus){
        String items="";
        for(MenuItem item:menus){
            String id=Integer.toString(item.getId());
            String qty=Integer.toString(item.getQty());
            items+=id+":"+qty+",";
        }
        items=items.substring(0,items.length()-1);
        return items;
    }
    public void appendOrder(int id,ArrayList<MenuItem> menus){
           try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
           {
               String sqlquery="SELECT items FROM orders WHERE id="+id;
               ResultSet rset=stmt.executeQuery(sqlquery);
               rset.next();
               String order=rset.getString("items");
               order+=","+convert(menus);
               String sqlup="UPDATE orders SET items='"+order+"' WHERE id="+id;
               int count=stmt.executeUpdate(sqlup);
               if(count!=0) System.out.println("appended");
               
           }
           catch(SQLException ex){
        ex.printStackTrace();
    
        }
        
        
        
        
        
    }
    //add order in database
    public void addOrder2(String timePlaced,String items){
         try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
           String Sqlinsert="INSERT INTO orders(timePlaced,items) VALUES('"+timePlaced+"','"+items+"')";
           int count=stmt.executeUpdate(Sqlinsert);
           if(count!=0){
               System.out.println("order successfully added");
           }        
        }
        catch(SQLException ex){
        ex.printStackTrace();
    
        }
    }
    //function to get order
    public ArrayList getOrders(){
        //order means arraylist of menu items
        ArrayList<Order> orders=new ArrayList();
        
         try(
        Connection conn = DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
        Statement stmt = conn.createStatement();
       )
        {
            String sqlorder="SELECT id,timePlaced,items FROM orders";
            ResultSet rset=stmt.executeQuery(sqlorder);
            while(rset.next()){
                int id=rset.getInt("id");
                String tp=rset.getString("timePlaced");
                String items=rset.getString("items");
                orders.add(new Order(id,tp,items));
                
            }
           
            
        }
        catch(SQLException ex){
        ex.printStackTrace();
    
        }
         return orders;
    }


    
}
