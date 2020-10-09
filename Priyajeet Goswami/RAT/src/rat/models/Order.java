/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import rat.resources.MenuDbHandler;
/**
 *
 * @author P-G
 */
public class Order {
    private int id;
    private String timePlaced;
    private ArrayList<MenuItem> items;
    
    //------------------------------------------------------------
    // constructor
    //------------------------------------------------------------
    public Order(int id, String timePlaced, ArrayList<MenuItem> items) {
        this.id = id;
        this.timePlaced = timePlaced;
        this.items = items;
    }

    //------------------------------------------------------------
    // setter
    //------------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setTimePlaced(String timePlaced) {
        this.timePlaced = timePlaced;
    }
    public void setItems(ArrayList<MenuItem> items) {
        this.items = items;
    }
    //------------------------------------------------------------
    // getter
    //------------------------------------------------------------
    public int getId() {
        return id;
    }
    public String getTimePlaced() {
        return timePlaced;
    }    
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public Order(int id,String timePlaced,String details){
        this.id=id;
        this.timePlaced=timePlaced;
        this.items=new ArrayList<>();
        processOrder(details);
        
    }
    
    public void DisplayDetails() {
        System.out.println(id + " " + timePlaced);
        for(MenuItem m: items){
            m.DisplayDetails();
        }
    }
    public void processOrder(String details){
        MenuDbHandler menu=new MenuDbHandler();
        StringTokenizer st1=new StringTokenizer(details,",");
        while(st1.hasMoreTokens()){
            String token=st1.nextToken().trim();
            int itemID=Integer.parseInt(token.substring(0,token.indexOf(":")));
            int itemQty=Integer.parseInt(token.substring(token.indexOf(":")+1));
            MenuItem item=menu.FindInMenu(itemID, itemQty);
            this.items.add(item);   
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
        d1=(Date) df.parse(timePlaced);//timePlaced to a date object
        d2=df.parse(df.format(new Date())) ;//Current Time //error!!

    }
    catch(ParseException ex)
    {
        ex.printStackTrace();
    }
    long timeDiff=d2.getTime()-d1.getTime();
    long timeDiffInMins = TimeUnit.MILLISECONDS.toMinutes(timeDiff);//convert the diff to minutes default milisecs
    long priority=timeDiffInMins+totalTime;//our priority

    return priority;
    }
    
}
