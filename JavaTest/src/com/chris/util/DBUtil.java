package com.chris.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Chris on 2017/3/18.
 */
public class DBUtil {

    public static void main(String[] args) {
        DBUtil util = new DBUtil();
//        Connection conn = util.getConnection();
        Connection conn = util.openConnection();
        System.out.println(conn);
    }

    public Connection openConnection() {
        Properties prop = new Properties();
        String driver = null;
        String url = null;
        String username = null;
        String password = null;

        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream
                    ("DBConfig.properties"));
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Connection getConnection(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/yto", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
