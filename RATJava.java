/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.java;
import rat.models.Staff;
import rat.models.MenuItem;
import rat.models.order;
import java.util.ArrayList;
import rat.resources.dbhandler;
/**
 *
 * @author pakhe
 */
public class RATJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Staff s1=new Staff(1,"Manager",35,75000);
        s1.setSalary(100000.0);
        s1.DisplayDetails();
        MenuItem m1=new MenuItem(1,"Butter Chicken",300.0);
        m1.DisplayDetails();
        MenuItem m2=new MenuItem(1,"Dal Makhani",175.0);
       m2.DisplayDetails();
       ArrayList<MenuItem> temp=new ArrayList<>();
       temp.add(m1);
       temp.add(m2);
        order o1=new order(1,"11:00",temp);
        o1.DisplayDetails();
        dbhandler ob= new dbhandler();
        boolean value = ob.connection();
        System.out.println(value);
    }
    
}
