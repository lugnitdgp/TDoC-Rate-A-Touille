//order is stored like this
//1:3,2:34,4:5
package rat.models;

import java.util.ArrayList;

/**
 *
 * @author Kshounish
 */
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    public Order(int id,String timePlaced,ArrayList<MenuItem>items){
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=items;    
    }
    public void displayDetails(){
        System.out.println(id+" "+timePlaced);
        for(MenuItem m: items){
            m.displayDetails();
}
        
}
}
