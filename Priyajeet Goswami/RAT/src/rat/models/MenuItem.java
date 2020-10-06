/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author P-G
 */
public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int quantity;


    //------------------------------------------------------------
    // constructor
    //------------------------------------------------------------
    public MenuItem(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    //------------------------------------------------------------
    // setter
    //------------------------------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //------------------------------------------------------------
    // getter
    //------------------------------------------------------------
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    
    public void DisplayDetails() {
        System.out.println(id + " " + name + " " + price + " " + quantity + " " + (price * quantity));
    }
    
}
