package org.user.servlets;

import org.user.dao.UserDAO;
import org.user.model.User;
import org.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/update")
public class UpdateUserServlet extends HttpServlet {
    private UserService userService = UserService.getConnection();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User book = new User(id, name, email, country);
        userService.updateUser(book);
        resp.sendRedirect("list");
    }
}
