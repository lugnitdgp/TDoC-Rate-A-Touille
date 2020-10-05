/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.models;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Order {

    /**
     * @param args the command line arguments
     */
    private int id;
    private String timePlaced;
    private ArrayList<String> items;
    public Order(int id,String timePlaced,ArrayList<String> items) {
        // TODO code application logic here
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=items;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getTimeplaced(){
        return timePlaced;
    }
    
    public void setTimeplaced(String timePlaced){
        this.timePlaced=timePlaced;
    }
    
    public ArrayList<String> getItems(){
        return items;
    }
    
    public void setItems(ArrayList<String> items){
        this.items=items;
    }
    
    public void display(){
        System.out.println(id+" "+timePlaced+" "+items);
        
    }
    
}
