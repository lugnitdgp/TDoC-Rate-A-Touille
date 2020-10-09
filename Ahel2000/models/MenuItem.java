/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.models;

/**
 *
 * @author User
 */
public class MenuItem {

    /**
     * @param args the command line arguments
     */
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int tpp;
    private int nppt;
    
    public MenuItem(String name,double price,int tpp,int ntpp,int id,int quantity) {
        // TODO code application logic here
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.tpp=tpp;
        this.nppt=ntpp;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public double getPrice(){
        return price;
    } 
    
    public void setPrice(double price){
        this.price=price;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    } 
    
    public void display(){
        System.out.println(id+" "+name+" "+price+" "+quantity);
    }
    
    public int getTpp(){
        return tpp;
    }
    
    public void setTpp(int tpp){
        this.tpp=tpp;
    }
    
    public int getNppt(){
        return nppt;
    }
    
    public void setNppt(int ntpp){
        this.nppt=ntpp;
    }
    
    
    
}
