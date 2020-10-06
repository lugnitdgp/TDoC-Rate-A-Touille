/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.models;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;

import tdocratatouille.resources.MenuDBHandler;

import java.util.ArrayList;

import java.util.StringTokenizer;

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

    public Order(int id, String timePlaced, String details){
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = new ArrayList<>();
        processOrder(details);
    }
    
    private void processOrder(String details){
     
        MenuDBHandler menu = new MenuDBHandler();
        StringTokenizer st1 = new StringTokenizer(details,",");
        
        while(st1.hasMoreTokens()){
            
            String token = st1.nextToken().trim();
            int itemID = Integer.parseInt(token.substring(0,token.lastIndexOf(":")));
            int itemQty = Integer.parseInt(token.substring(token.lastIndexOf(":") + 1));
            MenuItem item = menu.FindInMenu(itemID,itemQty);
            this.items.add(item);
        }
    }
    
    public void DisplayDetails(){
        System.out.println(id+" "+ timePlaced);
        for(MenuItem mi : items){
            mi.DisplayDetails();
        }
    }
    
}
