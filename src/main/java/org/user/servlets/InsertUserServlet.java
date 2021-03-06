package org.user.servlets;

import org.user.dao.UserDAO;
import org.user.model.User;
import org.user.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class InsertUserServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User newUser = new User(name, email, country);
        userService.insertUser(newUser);
        try {
            resp.sendRedirect("list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
