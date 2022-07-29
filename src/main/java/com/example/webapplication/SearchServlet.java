package com.example.webapplication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String date = request.getParameter("date");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        int people = Integer.parseInt(request.getParameter("people"));

        PrintWriter out = new PrintWriter(response.getWriter());
        response.setContentType("text/plain");
        out.println(destination);
    }

    // GET Request is to retrieve data from server
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Connect to Hibernate JPA and call method to find flight details based on information above
         */
    }

    // POST Request is to send data to server
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        When a post method is called, the response sent back to web server is  in HTML
         */
        PrintWriter out = new PrintWriter(response.getWriter());
        response.setContentType("text/html");
        out.println("<h1>POST Method!</h1>");
        out.println("<p>Post Method Requested</p>");
    }
}
