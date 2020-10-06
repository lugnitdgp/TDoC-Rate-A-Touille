/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<Menuitem> items;
    
    public Order(int id,String timePlaced, ArrayList<Menuitem> items){
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
    }
    
    public void DisplayDetails(){
        System.out.println(id+" "+timePlaced);
        
        for(Menuitem m1 : items){
            m1.DisplayDetails();
        }
    }
    
}
