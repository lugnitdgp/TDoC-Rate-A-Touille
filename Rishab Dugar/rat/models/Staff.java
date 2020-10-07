/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RAT.models;

/**
 *
 * @author kingr
 */
public class Staff {
    private int id;
    private String name;
    private int age;
    private double salary;
    
    public Staff(String name,int age,double salary)
    {

        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public double getSalary(double salary){
        return salary;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }

    public void DisplayDetails(){
        System.out.println(name+" "+age+" "+salary);
    }
}
