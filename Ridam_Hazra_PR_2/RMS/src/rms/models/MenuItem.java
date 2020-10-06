package rms.models;

public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp, nppt;


    public MenuItem(int id, String name, double price, int qty, int tpp, int nppt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
 
    public void DisplayDetails() {
        System.out.println(id + " " + name + " " + price + " " + qty);
    }
    
}
