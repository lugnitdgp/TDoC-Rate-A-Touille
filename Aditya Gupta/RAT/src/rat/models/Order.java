/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import rat.models.*;
import rar.resources.*;

/**
 *
 * @author Aditya
 */
public class Order {
    private int OrderNo;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    
    public Order(int OrderNo, String timePlaced, ArrayList<MenuItem> items){
       this.OrderNo = OrderNo;
       this.timePlaced = timePlaced;
       this.items = items;
    }
    
    public Order(int OrderNo, String timePlaced, String details){
        this.OrderNo = OrderNo;
        this.timePlaced = timePlaced;
        this.items = new ArrayList<>();
        processOrder(details);
    }
    
    private void processOrder(String details){
        MenuDbHandler mdbh = new MenuDbHandler();
        StringTokenizer st = new StringTokenizer(details,",");
        
        while(st.hasMoreTokens()){
            String token = st.nextToken().trim();
            int itemId = Integer.parseInt(token.substring(0, token.lastIndexOf(":")));
            int itemQty = Integer.parseInt(token.substring(token.lastIndexOf(":") + 1));
            MenuItem item = mdbh.FindInMenu(itemId,itemQty);
            this.items.add(item);
        }
    }
    
    public void DisplayDetails(){
        System.out.println(OrderNo + " " + timePlaced);
        
        for(MenuItem mi : items){
            mi.DisplayDetails();
        }
    }
    
    public long getpriority(){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm ");
        
        int totalTime = 0;
        
        for(MenuItem mi : items){
            int qty = mi.getQty();
            int tpp = mi.getTpp();
            int nppt = mi.getNppt();
            int a = (int)Math.ceil((double)qty/nppt);
            totalTime = (a*tpp);
        }
        
        Date d1 = null, d2=null;
        
        try{
            d1 = df.parse(timePlaced);
            d2 = df.parse(df.format(new Date()));
        }
        catch(ParseException ex){
            System.out.println(ex);
        }
        long timeDiff = d2.getTime() - d1.getTime();
        long timeDiffInMins;
        timeDiffInMins = TimeUnit.MILLISECONDS.toMinutes(timeDiff);
        long priority = timeDiffInMins + totalTime;
        
        return priority;
    }
            
}
