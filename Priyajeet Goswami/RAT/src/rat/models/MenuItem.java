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
    private int qty;
    private int tpp;//unit time
    private int nppt;//no of plates that can be processed in time tpp


    //------------------------------------------------------------
    // constructor
    //------------------------------------------------------------
    public MenuItem(String name,double price,int nppt,int tpp,int id,int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nppt=nppt;
        this.tpp=tpp;
        this.qty = qty;

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
    public void setQty(int qty) {
        this.qty = qty;
    }public void setTpp(){
        this.tpp = tpp;
    }
    public void setNppt(){
        this.nppt = nppt;
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
     public int getQty(){
        return qty;
    }
    public int getTpp(){
        return tpp;
    }
    public int getNppt(){
        return nppt;
    }
    
    public void DisplayDetails() {
        System.out.println(id + " " + name + " " + price + " " + qty);
    }
    
}
