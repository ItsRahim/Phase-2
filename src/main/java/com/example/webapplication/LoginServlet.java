package com.example.webapplication;

import database.HibernateUtil;
import database.dbConnector;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //Getting username and password entered by user and validating login
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        if(HibernateUtil.checkLogin(username, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("uName", username);
            session.setAttribute("uPass", password);

            // once login is valid, a request is sent to change pages
            response.sendRedirect("searchFlight.jsp");
        }else {
            request.setAttribute("error", "invalid login");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
