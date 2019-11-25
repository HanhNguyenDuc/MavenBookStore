/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenbookstore.utils;

/**
 *
 * @author ADMIN
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnUtils {
    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "bookstore";
        String userName = "root";
        String password = "admin";

        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
            throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;

    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Connection conn = MySQLConnUtils.getMySQLConnection();

        Statement sta = conn.createStatement();

        String sqlQuery = "Select * From books";
        
        ResultSet rs = sta.executeQuery(sqlQuery);
        while (rs.next()){
            System.out.println(rs.getString(2));
        }
    }
}
