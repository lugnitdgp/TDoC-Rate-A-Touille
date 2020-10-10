/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.resources;
import tdocratatouille.models.Order;
import java.util.Comparator;
/**
 *
 * @author Divyo
 */
public class OrderComparator implements Comparator<Order>{
    @Override
    public int compare(Order o1, Order o2){
        
        if(o1.getPriority()<o2.getPriority())
            return 1;//Pushes down in Priority Queue
        else if(o1.getPriority()>o2.getPriority())
            return -1;//Pushes up in Priority Queue
        
        return 0;
    }
   
}
