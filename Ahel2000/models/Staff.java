/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.models;

/**
 *
 * @author User
 */
public class Staff {

    /**
     * @param args the command line arguments
     */
    private String name;
    private int age;
    private double salary;
    public Staff(String username,int age,double salary){
        // TODO code application logic here
        this.name=username;
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
    
    public void display(){
        System.out.println(name+" "+age+" "+salary);
    }
    
}
