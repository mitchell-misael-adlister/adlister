package controllers;

import dao.DaoFactory;
import models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SiteIndexServlet", urlPatterns = "/home")
public class SiteIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> newestAds = DaoFactory.getAdsDao().getNewestAds(3);
        request.setAttribute("newestAds", newestAds);
        request.setAttribute("hello", "hello");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}