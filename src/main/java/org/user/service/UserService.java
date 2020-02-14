package org.user.service;

import org.user.dao.UserDAO;
import org.user.model.User;
import org.user.util.DBHelper;

import java.sql.Connection;
import java.util.List;

public class UserService implements Service {
    private static Service service;
    private static Connection connection;

    private UserService(Connection connection) {
        this.connection = connection;
    }

    public static Service getConnection() {
        if (service == null) {
            service = new UserService(DBHelper.getConnection());
        }
        return service;
    }

    public void insertUser(User user) {
        new UserDAO(connection).insertUser(user);
    }

    public User selectUser(int id) {
        return new UserDAO(connection).selectUser(id);
    }

    public List <User> selectAllUsers() {
        return new UserDAO(connection).selectAllUsers();
    }

    public boolean deleteUser(int id) {
        return new UserDAO(connection).deleteUser(id);
    }

    public boolean updateUser(User user) {
        return new UserDAO(connection).updateUser(user);
    }

}