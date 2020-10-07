/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import rms.models.MenuItem;
import rms.resources.MenuDbHandler;

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
    public Order(int id,String timePlaced,String details){
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=new ArrayList<>();
        processOrder(details);
    }
    public void processOrder(String details){
        MenuDbHandler menu=new MenuDbHandler();
        StringTokenizer st1=new StringTokenizer(details,",");
        while(st1.hasMoreTokens()){
            String token=st1.nextToken().trim();
            int itemID=Integer.parseInt(token.substring(0,token.indexOf(":")));
            int itemQty=Integer.parseInt(token.substring(token.indexOf(":")+1));
            MenuItem item=menu.FindInMenuById(itemID, itemQty);
            this.items.add(item);   
        }
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
    public long getPriority(){
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy HH:mm");
        int totalTime=0;
        for(MenuItem menuItem:items){
            int qty=menuItem.getQty();
            int nppt=menuItem.getNppt();
            int tpp=menuItem.getTpp();
            int a =(int)Math.ceil((double)qty/nppt);
            totalTime+=(a*tpp);
        }
        Date d1=null,d2=null;
        try{
            d1=df.parse(timePlaced);
            d2=df.parse(df.format(new Date()));
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        long timeDiff=d2.getTime()-d1.getTime();
        long timeDiffInMins=TimeUnit.MILLISECONDS.toMinutes(timeDiff);
        long priority=timeDiffInMins+totalTime;
        return priority;
    }
}
