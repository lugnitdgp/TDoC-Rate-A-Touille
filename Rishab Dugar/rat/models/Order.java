/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RAT.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import rat.resources.MenuDbHandler;


/**
 *
 * @author kingr
 */
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    
    public Order(int id, String timePlaced,ArrayList<MenuItem> items)
    {
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=items;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }
    public String getTimeplaced(){
        return timePlaced;
    }

    public void setTimeplaced(String timePlaced){
        this.timePlaced=timePlaced;
    }

    public ArrayList<MenuItem> getItems(){
        return items;
    }

    public void setItems(ArrayList<MenuItem> items){
        this.items=items;
    }

    private void processOrder(String details)
    {
        MenuDbHandler menu = new MenuDbHandler();
        StringTokenizer st1=new StringTokenizer(details,",");
        
        while(st1.hasMoreTokens()){
            
            String token =st1.nextToken().trim();
            int itemID=Integer.parseInt(token.substring(0,token.lastIndexOf(":")));
            int itemQty=Integer.parseInt(token.substring(token.lastIndexOf(":")+1));
            MenuItem item =menu.FindInMenu(itemID,itemQty);
            this.items.add(item);
        }
    }
    public void DisplayDetails()
    {
        System.out.println(id+" "+timePlaced);
        
        for(MenuItem mi:items)
        {
            mi.DisplayDetails();
        }
    }

    public long getPriority() {
    SimpleDateFormat df =new SimpleDateFormat("dd-MM-yyyy HH:mm"); //Data Type Object

    int totalTime=0;
    //total time for preparation
    for(MenuItem menuItem :items)
    {
        int qty =menuItem.getQty();
        int tpp=menuItem.getTpp();
        int nppt =menuItem.getNppt();
        double a=qty/nppt;
        totalTime+=(a*tpp);
    }
    //Date of Order
    Date d1 =null,d2=null;
    
    try
    {
        d1=df.parse(timePlaced);//timePlaced to a date object
        d2=df.parse(df.format(new Date()));//Current Time
        
    }
    catch(ParseException ex)
    {
        ex.printStackTrace();
    }
    long timeDiff=d2.getTime()-d1.getTime();
    long timeDiffInMins = TimeUnit.MILLISECONDS.toMinutes(timeDiff);
    long priority=timeDiffInMins+totalTime;
    
    return priority;
    }

    public double getTotal() {
        double total=0.0;
        for (MenuItem item:items)
        {
            total+=item.getPrice()*item.getQty();
        }
        return total;
    }
    
}
