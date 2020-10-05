package RAT.models;
import java.util.ArrayList;
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;

    public Order(int id,String timePlaced,ArrayList<MenuItem>items){
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
    }

    public void DisplayDetails(){
        System.out.println(id+" "+timePlaced);

        for(MenuItem m1 : items){
            m1.DisplayDetails();
        }
    }
}