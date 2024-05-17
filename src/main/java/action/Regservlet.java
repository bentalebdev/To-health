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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

@WebServlet(value = {"/accueil","/rendezvous","/rendezvous/jour", "/rendezvous/formulaire", "/login","/dashboard","/reservation" ,"/patient" ,"/reserver", "/formpatient" , "/reservation/delete" })
public class Regservlet extends HttpServlet {

    private final String index ="WEB-INF/html/index.html";
    private final String create ="WEB-INF/html/jour.jsp";
    private final String login = "WEB-INF/html/formulaire.jsp";
    private final String dashboard = "WEB-INF/html/dashbord.jsp";
    private final String assistantrendezvous = "WEB-INF/html/appointments.html";
    private final String patients = "WEB-INF/html/patients.html";
    private final String reservations = "WEB-INF/html/rdnauj.jsp";
    private final String formpatient = "WEB-INF/html/formPatient.jsp";
    private  final String formulaire = "/WEB-INF/html/formulaire.jsp";
    private final String Confirmer = "WEB-INF/html/success.jsp";
    private IntRendezvous dao;



    public void init() throws ServletException
    {
        super.init();
        dao = new rendezvousIMP();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cin ;
        String date ;
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
                    String jour = request.getParameter("indice");

                    try {
                        List<rendezvous> allrendezvous = dao.getall(jour);
                        request.setAttribute("list", allrendezvous);
                        request.getRequestDispatcher(reservations).forward(request, response);
                    }catch (Exception e){System.out.print(e);}
                    break;
                    case "/patient":
                case "/reserver":
                    HttpSession session = request.getSession(false);
                    if(session != null && session.getAttribute("username") != null)
                    {
                        if(action.equals("/reservation"))
                        {
                           /* String jour = request.getParameter("indice");
                            try {
                                List<rendezvous> allrendezvous = dao.getall(jour);
                                request.setAttribute("list",allrendezvous);
                                request.getRequestDispatcher(reservations).forward(request,response);

                            }catch (Exception e){System.out.print(e);}
*/
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
                    int rdntoday = dao.getrdntoday();
                    request.setAttribute("rdncount" , rdntoday);

                    request.getRequestDispatcher(dashboard).forward(request,response);
                    break;
                case "/reservation/delete":
                     cin = request.getParameter("cin");
                     jour=request.getParameter("indice");
                     dao.delete(cin);
                     response.sendRedirect(request.getContextPath() + "/reservation?indice =" + jour);
                     break;
                case "/rendezvous/formulaire":
                    String day = request.getParameter("date");
                    request.setAttribute("jour",day);
                    try {
                        List<String> heurs = dao.getheur(day);

                        request.setAttribute("list",heurs);
                        request.getRequestDispatcher(formulaire).forward(request,response);

                    }catch (Exception e){System.out.print(e);}


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
                case "/rendezvous/formulaire":
                    String nom = request.getParameter("nom");
                    String prenom = request.getParameter("prenom");
                    String cin = request.getParameter("cin");
                    int telephone = Integer.parseInt(request.getParameter("telephone"));
                    String date = request.getParameter("jour");
                    String heure = request.getParameter("heure");

                    rendezvous rendezvous = new rendezvous(nom , prenom , cin , telephone , date ,heure);
                    dao.prendre(rendezvous);
                    break;


                case "/reserver":
                    String nom1 = request.getParameter("nom");
                    String prenom1 = request.getParameter("prenom ");
                    String cin1 = request.getParameter("cin");
                    int telephone1 = Integer.parseInt(request.getParameter("telephone"));
                    String date1 = request.getParameter("date");
                    String date_heure1 = request.getParameter("heure");

                    rendezvous rendezvousA = new rendezvous();
                    rendezvousA.setNom(nom1);
                    rendezvousA.setPrenom(prenom1);
                    rendezvousA.setCin(cin1);
                    rendezvousA.setTelephone(telephone1);
                    rendezvousA.setDate(date1);
                    rendezvousA.setDate_heure(date_heure1);

                    dao.prendre(rendezvousA);

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