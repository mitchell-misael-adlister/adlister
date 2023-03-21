package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        //code for error messages
        request.setAttribute("errors", false);

        boolean hasErrors = request.getParameter("title").isEmpty()
                || request.getParameter("description").isEmpty();

        String currentTitle = request.getParameter("title");
        request.setAttribute("title", currentTitle);

        String currentDesc = request.getParameter("description");
        request.setAttribute("description", currentDesc);

        String select[] = request.getParameterValues("check");


        if (!hasErrors) {
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );


            Long adId = DaoFactory.getAdsDao().insert(ad);
            ad.setId(adId);
            response.sendRedirect("/ads");
        } else {
            request.setAttribute("errors", true);
            request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                    .forward(request, response);
        }


    }
}
