package RAT.models;
public class Staff {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Staff(int id,String name,int age,double salary)
    {
        this.id=id;
        this.name=name;
        this.age= age;
        this.salary = salary;
    }

    public void setSalary(double salary){
        this.salary= salary;
    }
    
    public void setId(int id){
        this.id= id;
    }
    
    public void setage(int age){
        this.age= age;
    }
    
    public void setname(String name){
        this.name= name;
    }
    
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getage(){
        return age;
    }
    public double getSalary(){
        return salary;
    }

    public void DisplayDetails(){
        System.out.println(id+" "+name+" "+age+" "+salary);
    }
}