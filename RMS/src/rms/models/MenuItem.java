/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.models;

/**
 *
 * @author rammy
 */
public class MenuItem {
    private int id,tpp,nppt,qty;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price,int tpp,int nppt,int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tpp=tpp;
        this.nppt=nppt;
        this.qty=qty;
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

    public int getTpp() {
        return tpp;
    }

    public void setTpp(int tpp) {
        this.tpp = tpp;
    }

    public int getNppt() {
        return nppt;
    }

    public void setNppt(int nppt) {
        this.nppt = nppt;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public void displayDetails(){
        System.out.println(this.id+") "+this.name+" "+this.price+" "+this.qty);
    }
}
