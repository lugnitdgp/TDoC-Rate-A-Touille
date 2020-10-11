/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.resources;
import rat.models.Order;
import java.util.Comparator;


/**
 *
 * @author RUP <your.name at your.org>
 */
public class OrderComparator implements Comparator<Order>
{
    @Override
    public int compare(Order o1,Order o2)
    {
        if(o1.getPriority() < o2.getPriority())
            return 1;//pushes it down in pq
        else if(o1.getPriority()>o2.getPriority())
            return -1;//pushes it up in pq
        
        
        return 0;
    }
}

