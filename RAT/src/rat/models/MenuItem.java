package RAT.models;
public class MenuItem {
    private int id;
    private String name;
    private double price;
    private int qty;
    private int tpp;
    private int nppt;

    public MenuItem(int id, String name,double price,int qty,int tpp,int nppt){
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
    
    public String getName(){
        return name;
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
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setQuantity(int qty)
    {
        this.qty=qty;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public void setNppt(int nppt)
    {
        this.nppt=nppt;
    }
    public void setTpp(int tpp)
    {
        this.tpp=tpp;
    }
    public void displayDetails()
    {
        System.out.println(id+" "+name+" "+qty+" "+price+" "+nppt+" "+tpp);
    }
}