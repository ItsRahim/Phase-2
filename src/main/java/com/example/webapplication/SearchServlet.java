package com.example.webapplication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet Request Made");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost Request Made");
        PrintWriter out = new PrintWriter(response.getWriter());

        // When a post method is called, the response back to web server is HTML.
        response.setContentType("text/html");

        // basic html sent back to web page
        out.println("<h1>POST Method!</h1>");
        out.println("<p>Post Method Requested</p>");
    }
}
