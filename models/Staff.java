package models;

public class Staff {
    private String name, pass;
    private double salary;
    private int id, age;
    private String salt;

    public Staff() {

    }

    public Staff(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Staff(String name, int id, String pass, int age, double salary, String salt) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.pass = pass;
        this.salt = salt;
        this.age = age;
    }

    // Getters and Setters

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getPass() {
        return this.pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Password: " + this.pass);
        System.out.println("Age: " + this.age);
        System.out.println("Salary: Rs." + this.salary);
        System.out.println("Salt: " + this.salt);
    }

}
