package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

    private static String drivename;
    private static String url;
    private static String username;
    private static String password;

    static {

        ResourceBundle rb = ResourceBundle.getBundle("dbdetails");

        drivename = rb.getString("db.drivename");

        url = rb.getString("db.url");

        username = rb.getString("db.username");

        password = rb.getString("db.password");

    }


    public static Connection provideConnection() {

        Connection con = null;

        // load the driver

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        }

        // create the connection


        try {

           con =  DriverManager.getConnection(url,username,password);

//            System.out.println(con);

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        return con;

    }
}
