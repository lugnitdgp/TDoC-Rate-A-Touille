package rat;
import RAT.models.Staff;
import RAT.models.MenuItem;
import RAT.models.Order;
import java.util.ArrayList;
public class RAT {
    public static void main(String args[]) {
        Staff s1= new Staff(1,"Manager",35,75000.0);
        s1.setSalary(100000.0);
        s1.DisplayDetails();

        MenuItem m1 = new MenuItem(1,"Chicken Biryani",300.0);
        m1.DisplayDetails();

        MenuItem m2 = new MenuItem(1,"Pulao",200.0);
        m2.DisplayDetails();

        ArrayList<MenuItem> temp = new ArrayList<MenuItem>();
        temp.add(m1);
        temp.add(m2);

        Order o1=new Order(1,"11:00",temp);
        o1.DisplayDetails();

    }
}