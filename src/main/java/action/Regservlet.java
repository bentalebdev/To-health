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

@WebServlet(value = {"/reg", "/accueil", "/rendezvous", "/login" })
public class Regservlet extends HttpServlet {

private final String index ="WEB-INF/html/index.html";
private final String create = "WEB-INF/html/form.jsp";
private final String login = "WEB-INF/html/logindoc.html";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            switch (action) {
                case "/accueil":
                    request.getRequestDispatcher(index).forward(request, response);
                    break;

                case "/rendezvous":
                    request.getRequestDispatcher(create).forward(request, response);
                    break;
                case "/login":
                    request.getRequestDispatcher(login).forward(request,response);

                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found.");
                    break;

            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
        }





