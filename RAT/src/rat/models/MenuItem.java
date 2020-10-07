package RAT.models;
public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;
    private int nppt;

    public MenuItem(String name,double price,int nppt,int tpp,int id,int qty){
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty=qty;
        this.nppt=nppt;
        this.tpp=tpp;
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
    public int gettpp(){
        return tpp;
    }
    public int getnppt(){
        return nppt;
    }
    public void DisplayDetails(){
        System.out.println(id+" "+name+" "+price);
    }
}