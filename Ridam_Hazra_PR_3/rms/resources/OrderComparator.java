package rms.resources;

import rms.models.Order;
import java.util.Comparator;

public class OrderComparator {
    
     @Override
    public int compare(Order o1,Order o2) {
        // TODO code application logic here
        if(o1.getPriority()<o2.getPriority()){
            return 1;
        }
        else if(o1.getPriority()>o2.getPriority()){
            return -1;
        }
        return 0;
    }


}
