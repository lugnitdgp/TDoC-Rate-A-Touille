package rat.models;
/**
 *
 * @author Rup
 */
public class Staff 
{
    private int id;
    private String name;
    private int age;
    private double salary;
    
    public Staff(int id,String name,int age, double salary)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    //Getdata method Setdata methods
    public void setSalary(double salary)
    {
        this.salary=salary;
    }
    public String getName()
    {
        return name;
    }
    public void displayDetails()
    {
        System.out.println(id+" "+name+" "+age+" "+salary);
    }
}
