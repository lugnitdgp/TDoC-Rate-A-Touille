/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.resources;

import rms.StringConst;
import java.sql.*;

/**
 *
 * @author SOUMITRI CHATTERJEE
 */
public class DbHandler {
    public boolean isConnected() {
        boolean isConnect = false;

        try (Connection connection = DriverManager.getConnection(StringConst.DB_URL, StringConst.USER,
                StringConst.PASS); Statement statement = connection.createStatement();) {
            isConnect = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isConnect;
    }
}
