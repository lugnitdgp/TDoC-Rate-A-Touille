/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RAT.models;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Order {
   private int id;
   private String timePlaced;
   private ArrayList<MenuItem> items;
   
   public Order(int id,String timePlaced,ArrayList<MenuItem>items){
       this.id = id;
       this.timePlaced = timePlaced;
       //items=new ArrayList<MenuItem>();
       this.items = items;
   }
   
   public void DisplayDetails(){
       System.out.println(id+" "+timePlaced);
       
       for(MenuItem m1 : items){
           m1.DisplayDetails();
       }
   }
}
