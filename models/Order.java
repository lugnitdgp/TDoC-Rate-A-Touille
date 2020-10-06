package models;

import java.util.ArrayList;

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
}
