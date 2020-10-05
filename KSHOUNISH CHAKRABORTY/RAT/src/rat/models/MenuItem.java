
package rat.models;

//change to be made!!
public class MenuItem {
    private int id;
    private String name;
    private double price;
    
    public MenuItem(int id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
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
    public void displayDetails(){
        System.out.println(id+" "+name+" "+price);
    }
    
    
    
}
