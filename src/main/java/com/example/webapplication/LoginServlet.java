package com.example.webapplication;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("searchFlight.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("rahim") && password.equals("password1")) {
            HttpSession  session = request.getSession(true);
            session.setAttribute("uName", username);
            session.setAttribute("uPass", password);
            doGet(request,response);
        }else {
            response.sendRedirect("index.jsp");
            HttpSession  session = request.getSession(true);
            session.setAttribute("errorMessage", "Login Failed ");
        }
    }
}
