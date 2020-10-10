package rat.models;
/**
 *
 * @author Rup
 */
public class Staff 
{
    public int id;
    public String name;
    public int age;
    public double salary;
    
    public Staff(int id,String name,int age, double salary)
    {
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    //Getdata method Setdata methods
    public double getSalary(double salary)
    {
        return salary;
    }
    public void setSalary(double salary)
    {
        this.salary=salary;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public int getId()
    {
        return id;
    }
    public void displayDetails()
    {
        System.out.println(id+" "+name+" "+age+" "+salary);
    }
}
