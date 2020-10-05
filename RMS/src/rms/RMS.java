/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;
import java.util.ArrayList;
import rms.models.MenuItem;
import rms.models.Order;
import rms.models.Staff;
/**
 *
 * @author rammy
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Staff s1=new Staff(1,43,"Manager",75000.00);
        s1.setSalary(100000.0);
        s1.displayDetails();

        MenuItem m1=new MenuItem(1,"Pizza",300.00);
        MenuItem m2=new MenuItem(2,"Thums up",42.00);
        m1.displayDetails();
        m2.displayDetails();
        ArrayList<MenuItem> temp=new ArrayList<MenuItem>();
        temp.add(m1);
        temp.add(m2);
        Order o1=new Order(1,"12:30",temp);
        o1.displayDetails();
    }
    
}
