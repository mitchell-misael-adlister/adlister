package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet(name = "EditAdServlet", urlPatterns = "/ads/edit/*")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adId = request.getPathInfo().substring(1);

        Ad grabId = DaoFactory.getAdsDao().findUniqueAdId(parseLong(adId));

        request.getSession().setAttribute("ad", grabId);

        System.out.println("grabId.getDescription() = " + grabId.getDescription());
        System.out.println("grabId.getDescription() = " + grabId.getTitle());


        request.setAttribute("existingTitle", grabId.getTitle());
        request.setAttribute("existingDescription", grabId.getDescription());

        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Ad adObject = (Ad) request.getSession().getAttribute("ad");

        System.out.println("singleAd = " + adObject);

        request.setAttribute("existingTitle", adObject.getTitle());
        request.setAttribute("existingDescription", adObject.getDescription());

        System.out.println("adObject.getTitle() = " + adObject.getTitle());
        request.setAttribute("adObject", adObject);
        request.setAttribute("existingTitle", adObject.getTitle());
        request.setAttribute("existingDescription", adObject.getDescription());

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        DaoFactory.getAdsDao().edit(adObject, title, description);
        response.sendRedirect("/profile");

    }
}
