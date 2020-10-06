/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.util.ArrayList;
/**
 *
 * @author P-G
 */
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    
    //------------------------------------------------------------
    // constructor
    //------------------------------------------------------------
    public Order(int id, String timePlaced, ArrayList<MenuItem> items) {
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
    }

    //------------------------------------------------------------
    // setter
    //------------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }
    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
    //------------------------------------------------------------
    // getter
    //------------------------------------------------------------
    public int getId() {
        return id;
    }
    public String getTimePlaced() {
        return timePlaced;
    }    
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void DisplayDetails() {
        System.out.println(id + " " + timePlaced);
        for(MenuItem m: items){
            m.DisplayDetails();
        }
    }
}
