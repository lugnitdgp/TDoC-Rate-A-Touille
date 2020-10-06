package rms.models;

public class Staff {
    private int id;
    private String name, pass, salt;
    private int age;
    private double salary;
    
    public Staff(int id, String name, String pass, String salt, int age, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.pass = pass;
        this.salt = salt;
        
    }

    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public void DisplayDetails() {
        System.out.println(id + " " + name + " " + pass + " " + salt + " " + age + " " + salary);
    }
}