package org.user.service;

import org.user.dao.UserUserDAOJDBC;
import org.user.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserService userService;
    private UserUserDAOJDBC daoJDBC = UserUserDAOJDBC.getInstance();

    private UserServiceImpl() {}

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public void insertUser(User user) {
        daoJDBC.insertUser(user);
    }

    public User selectUser(int id) {
        return daoJDBC.selectUser(id);
    }

    public List <User> selectAllUsers() {
        return daoJDBC.selectAllUsers();
    }

    public boolean deleteUser(int id) {
        return daoJDBC.deleteUser(id);
    }

    public boolean updateUser(User user) {
        return daoJDBC.updateUser(user);
    }
}
