/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;

import java.util.Comparator;
import rat.models.Order;

/**
 *
 * @author Kshounish
 */
//here the ordercomparator class implements the inteface predefined Comparator
public class OrderComparator implements Comparator<Order>{
    @Override//since the class implements an interface then it is necessary to write override so that whenevr this class is called the following method is 
    public int compare(Order o1,Order o2){//executed and the default method in the interface is not executed
        if(o1.getPriority()<o2.getPriority()) return 1;
        else if(o1.getPriority()>o2.getPriority())return -1;//returning  pushes an item down in pq and -1 ...
        return 0;
        //topmost elemnt is max and then order could be anything
    }
    
    
    
}
