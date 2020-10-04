package models;

import java.util.HashMap;

public class Order {
    private int id;
    private String time;
    private HashMap<MenuItem, Integer> itemList; // MenuItem and its count

    public Order() {
    }

    public Order(int id, String time, HashMap<MenuItem, Integer> itemList) {
        this.id = id;
        this.time = time;
        this.itemList = itemList;
    }

    public void displayOrder() {
        System.out.println("Order with ID: " + this.id);
        System.out.println("Time of order: " + this.time);
        for (MenuItem item : itemList.keySet()) {
            System.out.println(item.getItem() + " : " + itemList.get(item));
        }
    }
}
