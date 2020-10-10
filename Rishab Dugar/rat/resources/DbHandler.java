package rat.resources;
import rat.StringConstants;
/**
 *
 * @author kingr
 */
import java.sql.*;
public class DbHandler {

    public boolean connection() {
        boolean status=false;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            status=true;
        }
        catch(SQLException ex){
                ex.printStackTrace();
                }
        return status;
    }

    public boolean insert(String name) {
        boolean status=false;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
                )
        {
            String sqlinsert="INSERT INTO test_table (name) VALUES ('"+name+"')";
            int countInserted=stmt.executeUpdate(sqlinsert);

            if(countInserted!=0)status=true;
        }
        catch(SQLException ex){
                ex.printStackTrace();
                }
        return status;
    }

    public boolean query()
    {
        boolean status=false;
        try(
            Connection conn=DriverManager.getConnection(StringConstants.DB_URL,StringConstants.USER,StringConstants.PASS);
            Statement stmt=conn.createStatement();
           )
        {
            String sqlQuery="SELECT * FROM test_table";
            ResultSet rSet=stmt.executeQuery(sqlQuery);
            while(rSet.next()){
                int id=rSet.getInt("id");
                String name=rSet.getString("name");
                status=true;
                System.out.println(id+" "+name);
            }

        }
        catch(SQLException ex){
                ex.printStackTrace();
                }
        return status;
    }
}