package controllers;

import dao.DaoFactory;
import models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdServlet", urlPatterns = "/ad/delete")
public class DeleteAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {


        if (request.getSession().getAttribute("user") != null) {
            long id = Long.parseLong(request.getParameter("id"));
            Ad ad = DaoFactory.getAdsDao().getAdById(id);
            DaoFactory.getAdsDao().deleteAd(ad);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/");

    }
}
