package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Constantine on 2017/2/28.
 */
public class GetConnection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/graduate?useUnicode=true&characterEncoding=utf8";
        Connection con=null;
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,"root","mjh123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
