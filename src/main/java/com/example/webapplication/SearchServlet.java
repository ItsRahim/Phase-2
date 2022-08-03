package com.example.webapplication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name="SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    // GET Request is to retrieve data from server
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Connect to Hibernate JPA and call method to find flight details based on information above
         */
        String date = request.getParameter("date");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String people = request.getParameter("people");

        List<String> formInfo = new ArrayList<>(Arrays.asList(date, source, destination, people));

        if(checkFormValidity(formInfo)) {
            System.out.println("Valid Form");
            getServletContext().getRequestDispatcher("/SearchFlight.jsp").forward(request, response);
        } else {
            response.sendRedirect("searchFlight.jsp");
        }
    }

    // POST Request is to send data to server
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean checkFormValidity(List<String> formInfo) {
        return formInfo.size() == 4;
    }
}
