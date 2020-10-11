/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author Kshounish
 */
public class Staff {
    private int id;
    private String name;
    private int age;
    private double salary;
    public Staff(String name,int age,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.salary=salary;
        
    }
    //if we do obj.salary -> error as salary is private method so we have to call the setsalary method
    public void setSalary(double salary){
        this.salary=salary;     
    }
    public void setAge(int age){
        this.age=age;     
    }
    public void setName(String name){
        this.name=name;     
    }
    public double getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public  void displayDetails(){
        System.out.println(id+" "+name+" "+salary+" "+age);
    }
    
}
