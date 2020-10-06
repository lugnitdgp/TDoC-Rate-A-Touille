/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author P-G
 */
public class Staff {
    private int id;
    private String name;
    private int age;
    private double salary;
    
    //------------------------------------------------------------
    // constructor
    //------------------------------------------------------------
    
    public Staff(int id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    //------------------------------------------------------------
    // setter
    //------------------------------------------------------------
    
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;     
    }
    public void setAge(int age){
        this.age = age;     
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    //------------------------------------------------------------
    // getter
    //------------------------------------------------------------
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    
    public double getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }
    

    public void DisplayDetails() {
        System.out.println(id + " " + name + " " + age + " " + salary);
    }
    
    
}
