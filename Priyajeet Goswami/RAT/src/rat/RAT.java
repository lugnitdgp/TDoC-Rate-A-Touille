/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat;
import java.util.ArrayList;
import rat.models.Staff;
import rat.models.MenuItem;
import rat.models.Order;
import rat.resources.MenuDbHandler;
import rat.resources.OrdersDbHandler;
import rat.resources.UserDbHandler;
/**
 *
 * @author P-G
 */
public class RAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Staff a = new Staff(1,"Arun",20,5000.0);
        a.setSalary(750.0);
        a.DisplayDetails();
        
        MenuItem m1=new MenuItem("Fried rice", 120.0, 1, 1, 1, 3);
        m1.DisplayDetails();
        MenuItem m2=new MenuItem("Pizza", 200.0, 1, 1, 2, 2);
        m2.DisplayDetails();

        ArrayList<MenuItem> temp = new ArrayList<MenuItem>();
        temp.add(m1);
        temp.add(m2);
        Order o1=new Order(1,"11:00",temp);
        o1.DisplayDetails();
        
        UserDbHandler ob1=new UserDbHandler();
       ob1.registerStaff("PriyajeetGoswami","333", 20, 1000000.0);
    }
    
}
