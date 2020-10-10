package rat.resources;

import java.util.*;
import RAT.models.Order;
import RAT.models.*;

public class OrderComparator implements Comparator<Order>{
    @Override
    public int compare(Order o1,Order o2)
    {
        if(o1.getPriority() < o2.getPriority())
            return 1;
        else if(o1.getPriority() > o2.getPriority())
            return -1;
        return 0;
    }
}