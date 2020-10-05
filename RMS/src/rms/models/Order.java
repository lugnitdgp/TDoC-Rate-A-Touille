/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.models;

import java.util.ArrayList;
import rms.models.MenuItem;

/**
 *
 * @author rammy
 */
public class Order {
    private int id;
    private String timePlaced;
    ArrayList<MenuItem> items;

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
    public void displayDetails(){
        System.out.print(this.id+") "+this.timePlaced+" ");
        for(MenuItem i:this.items){
            System.out.print(i.getName()+" ");
            
        }
        System.out.println();
    }
}
