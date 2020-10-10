/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public int getId() {
        return id;
    }

    public String getTimePlaced() {
        return timePlaced;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
    

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
    
    public double getTotal(){
        double total = 0.0;
        for(MenuItem item : items){
            total+=item.getPrice()*item.getQty();
        }
        return total;
    }
    
    public long getPriority(){
        
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        int totalTime = 0;
        
        for(MenuItem menuItem : items) {
            int qty = menuItem.getQty();
            int tpp = menuItem.getTpp();
            int nppt = menuItem.getNppt();
            int a = (int)Math.ceil((double)qty/nppt);
            totalTime += (a*tpp);
        }
        
        Date d1=null,d2=null;
        try{
            d1 = df.parse(timePlaced);
            d2 = df.parse(df.format(new Date()));
        } catch(ParseException ex){
            ex.printStackTrace();
        }
        
        long timeDiff = d2.getTime() - d1.getTime();
        long timeDiffInMins = TimeUnit.MILLISECONDS.toMinutes(timeDiff);
        long priority = timeDiffInMins + totalTime;
        
        return priority;
    }
    
}
