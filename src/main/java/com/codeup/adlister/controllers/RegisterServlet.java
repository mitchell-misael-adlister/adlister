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

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // check if the username is unique
        if (!DaoFactory.getUsersDao().isUsernameUnique(username)) { // <-- Added this line
            request.setAttribute("usernameNotUnique", true); // <-- Added this line
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response); // <-- Added this line
            return; // <-- Added this line
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}



//    I added a new condition to check if the username is unique using the isUsernameUnique method. If the username is not unique, an attribute called "usernameNotUnique" is set to true on the request, and the registration page is displayed again with an error message. I will need to update the register.jsp file to display the error message when the "usernameNotUnique" attribute is set to true.