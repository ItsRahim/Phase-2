package com.example.webapplication;

import database.dbConnector;
import entity.Users;
import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirecting user to searchFlight page
        response.sendRedirect("searchFlight.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Connecting to database
        dbConnector.connect();

        /*
        Getting username and password entered by user and validating login
         */
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        if(checkLogin(username, password)) {
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

    protected boolean checkLogin(String email, String password) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        TypedQuery<Users> getLoginDetails;
        try {
            transaction.begin();
            getLoginDetails = entityManager.createNamedQuery("Users.byEmailPassword", Users.class);
            getLoginDetails.setParameter(email, password);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return !getLoginDetails.getResultList().isEmpty();
    }
}
