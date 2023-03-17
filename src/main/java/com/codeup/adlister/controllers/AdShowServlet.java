package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdShowServlet", urlPatterns = "/ads/show")
public class AdShowServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getParameter("id");

        if (adId != null) {
            Ad ad = DaoFactory.getAdsDao().findById(Long.parseLong(adId));
            if (ad != null) {
                request.setAttribute("ad", ad);
                request.getRequestDispatcher("/WEB-INF/ads/show.jsp").forward(request, response);
            } else {
                response.sendRedirect("/ads");
            }
        } else {
            response.sendRedirect("/ads");
        }
    }
}





