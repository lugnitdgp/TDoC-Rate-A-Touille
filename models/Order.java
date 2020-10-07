package models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int id;
    private String time;
    private ArrayList<MenuItem> itemList; // MenuItem and its count

    public Order() {
    }

    public Order(int id, String time, ArrayList<MenuItem> itemList) {
        this.id = id;
        this.time = time;
        this.itemList = itemList;
    }

    public void displayOrder() {
        System.out.println("Order with ID: " + this.id);
        System.out.println("Time of order: " + this.time);
        for (MenuItem item : itemList) {
            item.displayItem();
        }
    }

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

        long priority = 2 * diff_in_mins + reqTime; // ratio keeping 2:1

        return priority;
    }
}
