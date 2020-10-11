package rat.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import rat.resources.*;
//import rat.resources.OrderDbHandler;
import rat.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author RUP <your.name at your.org>
 */
public class Order
{
    private int id;
     private String timePlaced;
    public ArrayList<MenuItems> items;
    
   /* public Order(int id,String timePlaced,ArrayList<MenuItems> items)
    {
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=new ArrayList<>();
        processOrder(details);
    }*/
    public Order(int id,String timePlaced,ArrayList<MenuItems> items)
    {
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=items;
        //processOrder(details);
    }
    /*private void processOrder(String details)
    {
        MenuDbHandler menu=new MenuDbHandler();
        StringTokenizer st1=new StringTokenizer(details,",");
        
        
        while(st1.hasMoreTokens())
        {
            String token=st1.nextToken().trim();
            int itemID=Integer.parseInt(token.substring(0,token.lastIndexOf(":")));
            int itemQty=Integer.parseInt(token.substring(token.lastIndexOf(":")+1));
            MenuItems item;
            item = menu.FindInMenu(itemID,itemQty);
            this.items.add(item);
                    
            
        }
    }*/
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id=id;
    }
    
    public String getTimeplaced()
    {
        return timePlaced;
    }
    
    public void setTimeplaced(String timePlaced)
    {
        this.timePlaced=timePlaced;
    }
    
    public ArrayList<MenuItems> getItems()
    {
        return items;
    }
    
    public void setItems(ArrayList<MenuItems> items)
    {
        this.items=items;
    }
    
    /*public void display(){
        System.out.println(id+" "+timePlaced+" "+items);
        
    }*/
    public void DisplayDetails()
    {
        System.out.println(id+" "+timePlaced);
        for(MenuItems mi: items)
        {
            mi.displayDetails();
        }
    }
    public long getPriority()
    {
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy HH:mm");//Java reads it in form of a clock
        int totalTime=0;
        for(MenuItems menuItem:items)
        {
            int qty=menuItem.getQty();
            int tpp=menuItem.getTpp();
            int nppt=menuItem.getNppt();
            int a=(int)Math.ceil((double)qty/nppt);
            totalTime+=(a*tpp);           
        }
        //order placed time
        Date d1=null,d2=null;
        try
        {
            d1=df.parse(timePlaced);//converts the time placed into date obj
            d2=df.parse(df.format(new Date()));//stores the current time 
        }
        catch(ParseException ex)
        {
            ex.printStackTrace();
        
        }
        long timeDiff= d2.getTime()-d1.getTime();
        long timeDiffMins=TimeUnit.MILLISECONDS.toMinutes(timeDiff);
        long priority=timeDiffMins+totalTime;
        return priority;
       }
     public double getTotal()
     {
        double total = 0.00;
        for(MenuItems item : items)
        {
            total+=item.getPrice()*item.getQty();
        }
        return total;
    }
}

