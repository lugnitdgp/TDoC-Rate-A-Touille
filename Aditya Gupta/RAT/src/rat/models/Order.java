/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.util.ArrayList;

/**
 *
 * @author Aditya
 */
public class Order {
    private int OrderNo;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    
    public Order(int OrderNo, String timePlaced, ArrayList<MenuItem> items){
       this.OrderNo =OrderNo;
       this.timePlaced = timePlaced;
       this.items = items;
    }
}
