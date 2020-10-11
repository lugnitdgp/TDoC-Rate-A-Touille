/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author RUP <your.name at your.org>
 */
public class MenuItems
{
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;//Unit time
    private int nppt;//No of plates that can be processed in unit time
    
    public MenuItems(int id,String name,double price,int qty,int nppt,int tpp)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.qty=qty;
        this.nppt=nppt;
        this.tpp=tpp;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getQty()
    {
        return qty;
    }
    public void setQty(int qty)
    {
        this.qty=qty;
    }
    
    public int getTpp()
    {
        return tpp;
    }
    public void setTpp(int tpp)
    {
        this.tpp=tpp;
    }
    public int getNppt()
    {
        return nppt;
    }
    public void setNppt(int ntpp)
    {
        this.nppt=ntpp;
    }
    
    
    public void displayDetails()
    {
        System.out.println(id+" "+name+" "+price);
    }
}
