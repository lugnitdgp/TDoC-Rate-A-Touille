/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.models;
import java.util.ArrayList;

/**
 *
 * @author Divyo
 */
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;

    public Order(int id, String timePlaced, ArrayList<MenuItem> items) {
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
    
    
    
    public void DisplayDetails(){
        System.out.println(id+" "+ timePlaced);
        for(MenuItem mi : items){
            mi.DisplayDetails();
        }
    }
    
}
