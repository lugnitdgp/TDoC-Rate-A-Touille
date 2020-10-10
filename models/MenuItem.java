/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.models;

/**
 *
 * @author SOUMITRI CHATTERJEE
 */
public class MenuItem {
    private int id;
    private double price;
    private String item;
    private int qty;
    private int tpp; // unit time tpp
    private int nppt; // nos of plates that can be processed in unit time tpp

    public MenuItem() {
        id = qty = tpp = nppt = 0;
        price = 0.0;
        item = "";
    }

    public MenuItem(int id, double price, String item, int qty, int tpp, int nppt) {
        this.id = id;
        this.price = price;
        this.item = item;
        this.qty = qty;
        this.tpp = tpp;
        this.nppt = nppt;
    }

    public String getName() {
        return this.item;
    }

    public int getTpp() {
        return this.tpp;
    }

    public int getNppt() {
        return this.nppt;
    }

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQty() {
        return this.qty;
    }

    public void displayItem() {
        System.out.println(id + "\t" + item + "\t" + price);
    }
}
