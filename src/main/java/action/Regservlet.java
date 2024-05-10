package action;

import dao.IntRendezvous;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.rendezvous;
import dao.rendezvousIMP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@WebServlet(value = {"/accueil", "/rendezvous", "/login","/reservation" , "/patient" ,"/reserver", "/formpatient" , "/dashboard" })
public class Regservlet extends HttpServlet {

private final String index ="WEB-INF/html/index.html";
private final String create ="WEB-INF/html/form.jsp";
private final String login = "WEB-INF/html/logindoc.html";
private final String dashboard = "WEB-INF/html/dashbord.html";
private final String assistantrendezvous = "WEB-INF/html/appointments.html";
private final String patients = "WEB-INF/html/patients.html";
private final String reservations = "WEB-INF/html/rdnauj.jsp";
private final String formpatient = "WEB-INF/html/formPatient.jsp";
private final String Confirmer = "WEB-INF/html/success.jsp";
private IntRendezvous dao = new rendezvousIMP();


private rendezvousIMP intRendezvous;
public void init() throws ServletException
{
    super.init();
    intRendezvous = new rendezvousIMP();
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

                case "/reservation":
                case "/patient":
                case "/reserver":
                    HttpSession session = request.getSession(false);
                    if(session != null && session.getAttribute("username") != null)
                    {
                        if(action.equals("/reservation"))
                        {
                            List<rendezvous> allrendezvous = dao.getall();
                            request.setAttribute("list",allrendezvous);
                            request.getRequestDispatcher(reservations).forward(request,response);

                        }
                        else if (action.equals("/patient"))
                        {request.getRequestDispatcher(patients).forward(request,response);}
                        else if(action.equals("/reserver"))
                        {
                            request.getRequestDispatcher(assistantrendezvous).forward(request,response);
                        }
                    }
                    else
                    {request.getRequestDispatcher(login).forward(request,response); }

                case "/formpatient":
                    request.getRequestDispatcher(formpatient).forward(request,response);
                    break;
                case "/dashboard":
                    request.getRequestDispatcher(dashboard).forward(request,response);
                break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found.");
                    break;
            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
       try {
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

               case "/login":
                   String log = request.getParameter("username");
                   String pass = request.getParameter("password");

                   if (log.equals("assistant") || pass.equals("assistant")) {
                       HttpSession session = request.getSession(true);
                       session.setAttribute("username",log);

                       request.getRequestDispatcher(dashboard).forward(request, response);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Le login ou le mot de passe est incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
                   }
                   break;

           }
       }catch (ServletException | IOException e) {
            throw new RuntimeException(e);}



    }

        }





