package controllers;

import dao.DaoFactory;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "EditProfileServlet", urlPatterns = "/profile/edit")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        String email = request.getParameter("email");

        HashMap<String, String> errors = new HashMap<>();

        if (!email.contains("@") || !email.contains(".")) {
            errors.put("improper", "Invalid email address.");
        }
        if (email.isEmpty()) {
            errors.put("empty", "\nEmail address has not been changed. \nPlease try again.");
        }

        request.setAttribute("errors", errors);

        if (!email.contains("@") || !email.contains(".") || email.isEmpty()) {
            request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
        }

        user.setEmail(email);
        DaoFactory.getUsersDao().update(user);
        response.sendRedirect("/profile");
    }

}
