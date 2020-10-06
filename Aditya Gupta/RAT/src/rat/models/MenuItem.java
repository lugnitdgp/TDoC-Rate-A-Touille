/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author Aditya
 */
public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;
    private int nppt;
    
    public MenuItem(int id, String name, double price, int nppt, int tpp, int qty){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setQty(int qty){
        this.qty = qty;
    }
    
    public int getQty(){
        return qty;
    } 
}
