package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.rendezvous;
import dao.rendezvousIMP;
import dao.IntRendezvous;

import java.io.IOException;

@WebServlet(value = {"/reg", "/accueil", "/rendezvous", "/login" })
public class Regservlet extends HttpServlet {

private final String index ="WEB-INF/html/index.html";
private final String create = "WEB-INF/html/form.jsp";
private final String login = "WEB-INF/html/logindoc.html";

private rendezvousIMP intRendezvous;
public void init() throws ServletException
{
    super.init();
    intRendezvous = new rendezvousIMP();
}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getServletPath();
        switch (action) {
            case "/rendezvous":


                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String cin = request.getParameter("cin");
                int telephone = Integer.parseInt(request.getParameter("telephone"));
                String date = request.getParameter("date");
                String date_heure = request.getParameter("heure");

                rendezvous rendezvous1 = new rendezvous();
                rendezvous1.setNom(nom);
                rendezvous1.setPrenom(prenom);
                rendezvous1.setCin(cin);
                rendezvous1.setTelephone(telephone);
                rendezvous1.setDate(date);
                rendezvous1.setDate_heure(date_heure);

                intRendezvous.prendre(rendezvous1);
                break;

        }


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
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found.");
                    break;

            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
        }





