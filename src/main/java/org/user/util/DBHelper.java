package org.user.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("pp1?").                 //db name
                    append("user=root&").           //login
                    append("password=root").       //password
                    append("&serverTimezone=UTC");  //setup server time
            connection = DriverManager.getConnection(url.toString());
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
