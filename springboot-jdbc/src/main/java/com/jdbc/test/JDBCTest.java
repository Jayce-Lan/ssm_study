package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            String username = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/ssm?useSSL=false&serverTimezone=UTC";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println(connection.toString());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行完毕");
        }
    }
}
