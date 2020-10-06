
package rat.models;

//change to be made!!
public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;
    private int nppt;
    
    public MenuItem(String name,double price,int nppt,int tpp,int id,int qty){
        this.id=id;
        this.name=name;
        this.price=price;
        this.nppt=nppt;
        this.tpp=tpp;
        this.qty=qty;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getId(){
        return id;
    }
    public int getQty(){
        return qty;
    }
 
    public void displayDetails(){
        System.out.println(id+" "+name+" "+price);
    }
    
    
    
}
