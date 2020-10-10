package RAT.models;
import java.util.ArrayList;
import java.util.Date;
import rms.*;
import java.text.*;
import java.text.ParseException;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import rat.resources.MenuDbHandler;
import java.util.*;
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;

    public Order(int id,String timePlaced,ArrayList<MenuItem>items){
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
    }
    
    public Order(int id,String timePlaced,String details){
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
        processOrder(details);
    }
    
    private void processOrder(String details){
        MenuDbHandler menu = new MenuDbHandler();
        StringTokenizer st1=new StringTokenizer(details,",");
        while (st1.hasMoreTokens()){
            String token = st1.nextToken().trim();
            int itemID=Integer.parseInt(token.substring(0,token.lastIndexOf(":")));
            int itemQty = Integer.parseInt(token.substring(token.lastIndexOf(":")+1));
            MenuItem item = menu.FindInMenu(itemID,itemQty);
            this.items.add(item);
        }
    }

    public void DisplayDetails(){
        System.out.println(id+" "+timePlaced);

        for(MenuItem m1 : items){
            m1.displayDetails();
        }
    }
    
    public long getPriority(){
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy HH:mm");
        int totalTime=0;
        for(MenuItem menuItem:items){
            int qty=menuItem.getqty();
            int tpp=menuItem.gettpp();
            int nppt=menuItem.getnppt();
            int a=(int)Math.ceil((double)qty/nppt);
            totalTime+=(a*tpp);
        }
        Date d1=null,d2=null;
        try{
            d1=df.parse(df.format(timePlaced));
            d1=df.parse(df.format(new Date()));
        }
        catch(Exception e){
            e.printStackTrace();;
        }
        long timeDiff=d2.getTime()-d1.getTime();
        long timeDiffInMinutes = TimeUnit.MILLISECONDS.toMinutes(timeDiff);
        long priority=timeDiffInMinutes+totalTime;
        return priority;
    }
}