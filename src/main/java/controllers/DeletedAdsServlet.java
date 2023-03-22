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

@WebServlet(name = "DeletedAdsServlet", urlPatterns = "/ads/deleted")
public class DeletedAdsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ad> deletedAds = DaoFactory.getAdsDao().getDeletedAds();
        request.setAttribute("deletedAds", deletedAds);
        request.getRequestDispatcher("/WEB-INF/deletedAds.jsp").forward(request, response);
    }
}
