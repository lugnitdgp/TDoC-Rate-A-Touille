package resources;

// function to add menu based on MenuItem parameters
// findInMenu(id,qty) and addToMenu(MenuItem)
// add a function to query by name: params= name and qty

import models.MenuItem;
import rat.StringConst;

import java.sql.*;

public class MenuDbHandler {

    // adding items to menu

    public void addToMenu(String name, double price, int qty, int nppt, int tpp) {
        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            String insertCommand = "INSERT INTO menu (name,price,tpp,nppt) VALUES ('" + name + "'," + price + ", " + tpp
                    + ", " + nppt + " )";

            int flag = statement.executeUpdate(insertCommand);

            if (flag != 0)
                System.out.println("Menu item added Successfully !");
            else
                System.out.println("Failed to add item to Menu");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item to Menu");
        }
    }

    // find an item in menu and return the same

    public MenuItem findMenuItem(String name, int qty) {
        MenuItem item = null;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            String selectCommand = "SELECT name,price,tpp,nppt,id FROM menu WHERE name=" + name;

            ResultSet rSet = statement.executeQuery(selectCommand);
            rSet.next();

            item = new MenuItem(rSet.getInt("id"), rSet.getDouble("price"), rSet.getString("name"), qty,
                    rSet.getInt("tpp"), rSet.getInt("nppt"));

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item to Menu");
        }
        return item;
    }

    // finding by ID of item

    public MenuItem findByID(int id, int qty) {
        MenuItem item = null;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {

            String selectCommand = "SELECT name,price,tpp,nppt,id FROM menu WHERE id=" + id;

            ResultSet rSet = statement.executeQuery(selectCommand);
            rSet.next();

            item = new MenuItem(id, rSet.getDouble("price"), rSet.getString("name"), qty, rSet.getInt("tpp"),
                    rSet.getInt("nppt"));

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add item to Menu");
        }
        return item;
    }

}
