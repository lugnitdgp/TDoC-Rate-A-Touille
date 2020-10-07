package resources;

/**
 * addOrder(timePlaced,List of MenuItems) - converts order to a string like
 * id:qty, id:qty , etc
 * 
 * addOrder2(timePlaced, String order) - connects with DB and adds order to the
 * table - ensure that at the last entry there is no comma - also ensure if more
 * appended there is a comma placed (place comma in front instead).
 * 
 * getOrders() - add or remove orders manually (string tokenizer)
 * 
 */

import rat.StringConst;
import models.MenuItem;
import models.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrdersDbHandler {

    // adding an order

    public void addOrder(String timeOfOrder, ArrayList<MenuItem> itemList) {
        String order = "";

        for (MenuItem item : itemList) {
            String id = Integer.toString(item.getId());
            String qty = Integer.toString(item.getQty());

            order += "," + id + ":" + qty;// convert to desired format
        }

        order = order.substring(1); // omitting out the first comma

        addOrder2(timeOfOrder, order);
    }

    public void addOrder2(String timeOfOrder, String order) {
        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {
            String insertCommand = "INSERT INTO orders (timeofOrder,items) VALUES ('" + timeOfOrder + "','" + order
                    + "')";

            int flag = statement.executeUpdate(insertCommand);

            if (flag != 0)
                System.out.println("Order added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to add order !");
        }
    }
}
