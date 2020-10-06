/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat;
import rat.models.Staff;
import rat.models.Menuitem;
import rat.models.Order;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class RAT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Staff s1 = new Staff(1, "Manager",35,75000.0);
        //s1.setSalary(100000.0);
        s1.DisplayDetails();
        
        Menuitem m1 = new Menuitem(1," Chole Bhature",200.0);
        //m1.setName("Idli");
        m1.DisplayDetails();
        
         Menuitem m2 = new Menuitem(2," Noodles",300.0);
        //m2.setName("Idli");
        m2.DisplayDetails();
        
        ArrayList<Menuitem> temp = new ArrayList<Menuitem>();
        temp.add(m1);
        temp.add(m2);
        
        Order o1 = new Order(1,"12:00",temp );
        o1.DisplayDetails();
        
    }   
}
