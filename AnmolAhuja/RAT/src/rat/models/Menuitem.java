/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author user
 */
public class Menuitem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;
    private int nppt;
    
    public Menuitem(String name, double price,int nppt, int tpp, int id, int qty){
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.nppt = nppt;
        this.tpp = tpp;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getId(){
        return id;
    }
    
    public int getqty(){
        return qty;
    }
    
    public void DisplayDetails(){
        System.out.println(id+" "+name +" "+price);
    }
    
}
