/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import rat.resources.MenuDbHandler;

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
    
    public Order(int id,String timePlaced,String details){
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = new ArrayList<>();
        processOrder(details);
    }
    
    private void processOrder(String details){
        MenuDbHandler menu = new MenuDbHandler();
        StringTokenizer st1 = new StringTokenizer(details,",");
        
        while(st1.hasMoreTokens()){
            String token = st1.nextToken().trim();
            int itemID = Integer.parseInt(token.substring(token.lastIndexOf(":" + 1)));
            int itemqty = Integer.parseInt(token.substring(token.lastIndexOf(":") + 1));
            Menuitem item = menu.FindInMenu(itemID,itemqty);
            this.items.add(item);
        }
    }
    public void DisplayDetails(){
        System.out.println(id+" "+timePlaced);
        
        for(Menuitem m1 : items){
            m1.DisplayDetails();
        }
    }
    
}


