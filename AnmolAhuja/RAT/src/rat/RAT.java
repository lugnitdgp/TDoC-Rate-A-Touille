/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat;

import rat.models.Menuitem;
import java.util.ArrayList;
import rat.resources.OrdersDbHandler;

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
        Menuitem obj1 = new Menuitem("Chole Bhature",250.0,1,1,1,2);
        Menuitem obj2 = new Menuitem("Idli",300.0,1,1,2,3);
        
        ArrayList items = new ArrayList<Menuitem>();
        items.add(obj1);
        items.add(obj2);
        
        OrdersDbHandler obj3 = new OrdersDbHandler();
        obj3.addOrder("20:40",items);
    }   
}
