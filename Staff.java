/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author pakhe
 */
public class Staff {
    private int id;
    private String name;
    private int age;
    private double salary;
    public Staff(int a, String b,int c,double d)
    {
        id=a;
        name=b;
        age=c;
        salary=d;
    }
    //Getdata method and setData method
    //obj1.salary = 100 will give an error
    //obj1.setsalary=100 is the correct procedure
    public void setSalary(double salary)
    {
        this.salary=salary;
    }
    public String getName()
    {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public double getSalary() {
        return salary;
    }
    public void DisplayDetails()
    {
        System.out.println(id+" "+name+" "+age+" "+salary);
    }
    
}
