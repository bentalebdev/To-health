package action;

import db.DB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet({"/reg", "/accueil", "/rendezvous" })
public class Regservlet extends HttpServlet {

private final String index ="/web-inf/html/index.html";
private final String create = "/web-inf/html/form.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // Forward the request to the JSP file for the form

        String action = request.getServletPath();
        try{
            switch (action)
            {
                case "/accueil":
                   request.getRequestDispatcher(index).forward(request,response);

                case  "/rendezvous":
                    request.getRequestDispatcher(create).forward(request,response);
            }
        }

         catch (IOException e) {
            throw new RuntimeException(e);
        }
        }
    }



