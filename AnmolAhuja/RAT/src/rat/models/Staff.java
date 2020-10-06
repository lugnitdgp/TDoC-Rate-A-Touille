/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rat.models;

/**
 *
 * @author user
 */
public class Staff {
    private int id;
    private String name;
    private int age;
    private double salary;
    
    public Staff(int id, String name, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public String getName(){
        return name;
    }
    
    public void DisplayDetails(){
        System.out.println(id+ " "+ name +" "+age+" "+salary);
    }
}
