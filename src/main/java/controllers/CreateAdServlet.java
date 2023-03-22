package controllers;

import dao.DaoFactory;
import models.Ad;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if user is not logged in, redirect to login page
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        // else, forward to the create-ad.jsp
        request.getRequestDispatcher("/WEB-INF/create-ad.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // if user is not logged in, redirect to login page
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // create a user object using current user object (set in login servlet)
        User user = (User) request.getSession().getAttribute("user");

        // create a new ad using current user id
//        Ad ad = new Ad (
//                user.getId(),
//                title,
//                description
//        );

        HashMap<String, String> adErrors = new HashMap<>();

        if (title.isEmpty()) {
            adErrors.put("title","Title cannot be left blank");
        } else {
            request.setAttribute("title", title);
        }

        if (description.isEmpty()) {
            adErrors.put("description", "Description cannot be left blank");
        } else {
            request.setAttribute("description", description);
        }
        request.setAttribute("adErrors", adErrors);

        if (title.isEmpty() || description.isEmpty()) {
            request.getRequestDispatcher("/WEB-INF/create-ad.jsp").forward(request, response);
            return;
        } else {

            // create a new ad using current user id
            Ad ad = new Ad (
                    user.getId(),
                    title,
                    description
            );

            // insert ad into database
            Long newid = DaoFactory.getAdsDao().insertAd(ad);
            request.setAttribute("newid", newid);

            response.sendRedirect("/profile");
        }

    }
}
