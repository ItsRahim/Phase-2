package com.example.webapplication;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name="SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    // GET Request is to retrieve data from server
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Connect to Hibernate JPA and call method to find flight details based on information above
         */
    }

    // POST Request is to send data to server
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String people = request.getParameter("people");

        if(checkFormValidity(date, source, destination, people)) {
            //TODO Query to find flights and output them onto another page
            System.out.println("Valid Form");
        } else {
            System.out.println("Invalid Form");
            response.sendRedirect("searchFlight.jsp");
        }
    }

    private boolean checkFormValidity(String date, String source, String destination, String people) {
        return date.length() != 0 && source.length() != 0 && destination.length() != 0 && people.length() != 0;
    }

    //TODO Implement Cookies
    /*
    Useru=new User();
    HttpSession session=request.getSession(false);
    if(session!=null){
        Useru=(User)session.getAttribute("user");
        u.setEmail(request.getParameter("email"));
        u.setAge(Integer.parseInt(request.getParameter("age")));
        session.setAttribute("user",u);
        session.invalidate() --logout
        response.sendRedirect("three.html");
    }
     */

}
