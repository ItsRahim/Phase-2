package com.example.webapplication;

import database.HibernateUtil;
import database.dbConnector;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // redirecting user to searchFlight page
        response.sendRedirect("searchFlight.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Connecting to database
        dbConnector.connect();

        //Getting username and password entered by user and validating login
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        if(HibernateUtil.checkLogin(username, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("uName", username);
            session.setAttribute("uPass", password);

            // once login is valid, a GET request is sent to change pages
            doGet(request,response);
        }else {
            response.sendRedirect("index.jsp");
            HttpSession session = request.getSession(true);
            session.setAttribute("errorMessage", "Login Failed ");
        }
    }
}
