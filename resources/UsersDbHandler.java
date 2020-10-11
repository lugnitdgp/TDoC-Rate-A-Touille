/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

import rms.StringConst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import rms.models.Staff;

// for registering and adding Staff to the DB
// logging in for staff by authenticating password and salt
// if authentication incorrect print "No such User exist"

public class UsersDbHandler {
    
     // registering a new Staff
    public void registerStaff(String name, String pass, int age, double salary) {
        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {
            String salt = Utils.genRandomSalt();
            System.out.println(salt); // debug
            String encryptedPass = Utils.encryptSHA(pass, salt);

            // SQL command for insertion of data
            String insertCommand = "INSERT INTO staff (name,salt,password,age,salary) VALUES ( '" + name + "', '" + salt
                    + "', '" + encryptedPass + "', " + age + ", " + salary + " )";

            int flag = statement.executeUpdate(insertCommand);

            if (flag != 0)
                System.out.println("Staff successfully registered !");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // logging in an existing staff; returns false if authentication does not occur
    public boolean loginStaff(String name, String pass) {
        boolean auth = false;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            // SQL command to retrieve row
            String selectCommand = "SELECT salt, password from staff WHERE name = '" + name + "'";
            ResultSet rSet = statement.executeQuery(selectCommand);
            rSet.next();

            // getting saved DB data
            String dbSalt = rSet.getString("salt"), dbPass = Utils.encryptSHA(pass, dbSalt);

            auth = dbPass.equals(pass);

        } catch (Exception e) {
            System.out.println("No such user exists!");
        }
        if (!auth)
            System.out.println("No such user exists!");

        return auth;
    }

    // to fetch list of currently employed staff
    public ArrayList<Staff> getStaffList() {
        ArrayList<Staff> staffList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {
            String selectCommand = "SELECT name,age,salary FROM staff";
            ResultSet rSet = statement.executeQuery(selectCommand);

            while (rSet.next()) {
                // fetching name , age and salary of each staff
                String name = rSet.getString("name");
                int age = rSet.getInt("age");
                double salary = rSet.getDouble("salary");
                staffList.add(new Staff(name, age, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }
}
