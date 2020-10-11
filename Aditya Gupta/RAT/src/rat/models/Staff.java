/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author Aditya
 */
public class Staff {
    private int staffId;
    private String name;
    private int age;
    private double salary;
    
    public Staff(String name, int age, double salary){
        this.staffId = staffId;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
}
