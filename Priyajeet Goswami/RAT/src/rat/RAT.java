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
        
        MenuItem m1=new MenuItem(1,"Fried rice",120.0,3);
        m1.DisplayDetails();
        MenuItem m2=new MenuItem(2,"Pizza",200.0,2);
        m2.DisplayDetails();

        ArrayList<MenuItem> temp = new ArrayList<MenuItem>();
        temp.add(m1);
        temp.add(m2);
        Order o1=new Order(1,"11:00",temp);
        o1.DisplayDetails();
        
    }
    
}
