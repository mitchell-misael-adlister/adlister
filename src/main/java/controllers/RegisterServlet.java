package controllers;

//import dao.DaoFactory;


import dao.DaoFactory;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm-password");
        String hash = Password.hash(password);
        User existingUser = DaoFactory.getUsersDao().getUserByUsername(username);

        if (DaoFactory.getUsersDao().getUserByUsername(username) != null) {
            request.setAttribute("error", "This username is already taken.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        HashMap<String, String> errors = new HashMap<>();

        if (username.isEmpty()) {
            errors.put("username", "Username cannot be left blank");
        } else {
            request.setAttribute("username", username);
        }

        if (email.isEmpty()) {
            errors.put("email", "Email cannot be left blank");
        } else {
            request.setAttribute("email", email);
        }

        if (password.isEmpty()) {
            errors.put("password", "Password cannot be left blank");
        }

        if (!password.equals(confirm)) {
            errors.put("confirm", "Passwords do not match");
        }

        request.setAttribute("errors", errors);

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || !password.equals(confirm)) {
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
            return;
        }


            User user = new User(username, email, hash);

            DaoFactory.getUsersDao().insertUser(user);

            response.sendRedirect("/login");

    }
}
