package rat;
import RAT.models.Staff;
import RAT.models.MenuItem;
import RAT.models.Order;
import java.util.ArrayList;
import rat.resources.dbHandler;
public class RAT {
    public static void main(String args[]) {
        Staff s1= new Staff(1,"Manager",35,75000.0);
        s1.setSalary(100000.0);
        s1.DisplayDetails();

        dbHandler ob = new dbHandler();
        boolean value=ob.connection();
        System.out.println(value);
        
       boolean status = ob.insert("Vipul");
       
       ob.query();

    }
}