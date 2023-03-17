package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Extract the title and description from the request
        String adTitle = request.getParameter("title");
        String adDescription = request.getParameter("description");

        // Check if title or description is empty
        if (adTitle.isEmpty() || adDescription.isEmpty()) {
            // If either field is empty, set the attributes in the request
            request.setAttribute("adTitle", adTitle);
            request.setAttribute("adDescription", adDescription);
            // Forward the request back to the create.jsp page with the populated fields
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp").forward(request, response);
            return;
        }

        // Create and save the ad if both fields
        Ad ad = new Ad(
                1, //  the user id
                adTitle,
                adDescription
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}
