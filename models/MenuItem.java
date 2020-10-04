package models;

public class MenuItem {

    private int id;
    private double price;
    private String item;

    public MenuItem() {
        id = 0;
        price = 0.0;
        item = "";
    }

    public MenuItem(int id, double price, String item) {
        this.id = id;
        this.price = price;
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

    public double getPrice() {
        return this.price;
    }

    public void displayItem() {
        System.out.println(id + "\t" + item + "\t" + price);
    }

}