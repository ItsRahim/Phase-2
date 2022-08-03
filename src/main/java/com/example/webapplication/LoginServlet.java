package com.example.webapplication;

import database.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("searchFlight.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Getting username and password entered by user and validating login
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        if(HibernateUtil.checkLogin(username, password)) {

            //TODO Implement Cookies and Sessions
            HttpSession session = request.getSession(true);
            session.setAttribute("uName", username);
            session.setAttribute("uPass", password);

            doGet(request, response);
        }else {
            request.setAttribute("error", "invalid login");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
