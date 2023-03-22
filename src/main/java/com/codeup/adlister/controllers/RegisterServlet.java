package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        request.setAttribute("errors", false);

        // validation
        boolean inputHasErrors = username.isEmpty() || email.isEmpty() || password.isEmpty() || (!password.equals(passwordConfirmation));

        if (username.isEmpty()) {
            request.setAttribute("errors", true);
            request.setAttribute("username_error", true);
        }
        if (email.isEmpty()) {
            request.setAttribute("errors", true);
            request.setAttribute("email_error", true);
        }
        if (password.isEmpty()) {
            request.setAttribute("errors", true);
            request.setAttribute("password_error", true);
        }
        if (!password.equals(passwordConfirmation)) {
            request.setAttribute("errors", true);
            request.setAttribute("passwordConfirmation_error", true);
        }

        if ((Boolean) request.getAttribute("errors")) {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        } else if (!inputHasErrors) {
            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insertUser(user);
            response.sendRedirect("/login");
        }
    }
}
