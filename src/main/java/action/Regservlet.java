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

@WebServlet({"/reg", "/form",})
public class Regservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
    String name = request.getParameter("name");
    String addresse = request.getParameter("addresse");
    try {
        String sql = "INSERT INTO entreprise (nome, adresse) VALUES (?, ?)";
        Connection connection = DB.getCon();
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2,addresse);
        preparedStatement.executeUpdate();
        PrintWriter printWriter = response.getWriter();
        printWriter.println("ajouter avec succes");



    } catch (Exception ex) {


    }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // Forward the request to the JSP file for the form
        try {
            request.getRequestDispatcher("/WEB-INF/html/index.html").forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
