package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.rendezvous;
import dao.rendezvousIMP;
import dao.IntRendezvous;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

@WebServlet(value = {"/reg", "/accueil", "/rendezvous", "/login","/reservation" , "/patient" ,"/tousrendezvous" })
public class Regservlet extends HttpServlet {

private final String index ="WEB-INF/html/index.html";
private final String create ="WEB-INF/html/form.jsp";
private final String login = "WEB-INF/html/logindoc.html";
private final String dashbord = "WEB-INF/html/dashbord.html";
private final String rendezvous = "WEB-INF/html/appointments.html";
private final String patients = "WEB-INF/html/patients.html";
private final String reservation = "WEB-INF/html/rdnauj.html";

private rendezvousIMP intRendezvous;
public void init() throws ServletException
{
    super.init();
    intRendezvous = new rendezvousIMP();
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

                       request.getRequestDispatcher(dashbord).forward(request, response);



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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getServletPath();
            switch (action) {
                case "/accueil ":
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
                case "/tousrendezvous":
                    HttpSession session = request.getSession(false);
                    if(session != null && session.getAttribute("username") != null)
                    {
                        if(action.equals("/reservation"))
                        {request.getRequestDispatcher(rendezvous).forward(request,response);}
                        else if (action.equals("/patient"))
                        {request.getRequestDispatcher(patients).forward(request,response);}
                        else if(action.equals("/tousrendezvous"))
                        {
                            List<rendezvous> allrendezvous =intRendezvous.getall();
                            request.setAttribute("list",allrendezvous);

                            request.getRequestDispatcher(reservation).forward(request,response);
                        }
                    }
                    else
                    {request.getRequestDispatcher(login).forward(request,response); }



                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found.");
                    break;

            }
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
        }





