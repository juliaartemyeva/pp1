package org.user.service;

import org.user.model.User;

import java.util.List;

public interface Service {
    void insertUser(User user);

    User selectUser(int id);

    List <User> selectAllUsers();

    boolean deleteUser(int id);

    boolean updateUser(User user);

}
