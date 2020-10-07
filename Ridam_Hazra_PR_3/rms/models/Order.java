package rms.models;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.*;
import rms.models.MenuItem;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

    public void DisplayDetails() {
        System.out.println(id + " " + timePlaced + " " + items);
    }
    
   public long getPriority(){
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy HH:mm");
        int totalTime=0;
        for(MenuItem menuItem : items){
            int qty=menuItem.getQty();
            int tpp=menuItem.getTpp();
            int nppt=menuItem.getNppt();
            int a=(int)Math.ceil((double)qty/nppt);
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
