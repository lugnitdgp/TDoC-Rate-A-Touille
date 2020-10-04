package resources;

import rat.StringConst;

import java.sql.*;

public class DbHandler {

    public boolean isConnected() {
        boolean isConnect = false;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {
            isConnect = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isConnect;
    }
}
