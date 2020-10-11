/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SOUMITRI CHATTERJEE
 */
public class Orders {
   private int id;
    private String time;
    private ArrayList<MenuItem> itemList; // MenuItem and its count

    public Orders() {
    }

    public Orders(int id, String time, ArrayList<MenuItem> itemList) {
        this.id = id;
        this.time = time;
        this.itemList = itemList;
    }
    
    public int getId() {
        return this.id;
    }
    
    public ArrayList<MenuItem> getOrderList() {
        return this.itemList;
    }
    
    public double getTotalValue() {
        double tot=0.0;
        for(MenuItem item:this.itemList)
        {
            tot+=item.getPrice()*item.getQty();
        }
        return tot;
    }
    
    public void displayOrder() {
        System.out.println("Order with ID: " + this.id);
        System.out.println("Time of order: " + this.time);
        for (MenuItem item : itemList) {
            item.displayItem();
        }
    }

    // to get priority value of an order 
    
    public long getPriority() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        int reqTime = 0;
        // iterate through order list and finding total time reqd to prepare order
        for (MenuItem item : itemList) {
            int qty = item.getQty();
            int tpp = item.getTpp();
            int nppt = item.getNppt();
            int cnt = (int) Math.ceil((double) qty / nppt);
            reqTime += cnt * tpp; // total time ; innovate - convert to double
        }
        // when was order placed
        Date date = null, curr = null;

        try {
            date = format.parse(time);
            curr = format.parse(format.format(new Date())); // current time
        } catch (Exception e) {
            e.printStackTrace();
        }

        long diffTime = curr.getTime() - date.getTime(); // in miliseconds
        long diff_in_mins = (diffTime / 1000) / 60;

        long priority = 3 * diff_in_mins + 2 * reqTime; // ratio keeping 3:2

        return priority;
    }
}
