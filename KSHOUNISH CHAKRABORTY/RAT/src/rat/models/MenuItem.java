
package rat.models;

//change to be made!!
public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;//unit time
    private int nppt;//no of plates that can be processed in time tpp
    
    public MenuItem(String name,double price,int nppt,int tpp,int id,int qty){
        this.id=id;
        this.name=name;
        this.price=price;
        this.nppt=nppt;
        this.tpp=tpp;
        this.qty=qty;
    }
    public void setName(String name){//
        this.name=name;
    }
    public void setPrice(double price){//
        this.price=price;
    }
    public String getName(){//
        return name;
    }
    public void setId(int id){//
        this.id=id;
    }
    public double getPrice(){//
        return price;
    }
    public int getId(){//
        return id;
    }
    
    public void setQty(int qty){
        this.qty=qty;
    } 
    public int getQty(){
        return qty;
    }
    public int getTpp(){//
        return this.tpp;
    }
    public int getNppt(){//
        return nppt;
    }
    public void setTpp(int tpp){//
        this.tpp=tpp;
    }
    public void setNppt(int ntpp){//
        this.nppt=ntpp;
    }
 
    public void displayDetails(){
        System.out.println(id+" "+name+" "+price);
    }
    
    
    
}
