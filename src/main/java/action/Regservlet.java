package action;

import dao.IntRendezvous;
import dao.PatientDao;
import dao.PatientImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Patient;
import models.rendezvous;
import dao.rendezvousIMP;

import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

@WebServlet(value = {"/accueil","/rendezvous","/rendezvous/jour", "/rendezvous/formulaire", "/login","/dashboard","/reservation" ,"/patient" , "/patient/delete","/reserver", "/formpatient" , "/reservation/delete" })
public class Regservlet extends HttpServlet {

    private final String index ="WEB-INF/html/index.html";
    private final String create ="WEB-INF/html/jour.jsp";
    private final String login = "WEB-INF/html/logindoc.html";
    private final String dashboard = "WEB-INF/html/dashbord.jsp";
    private final String assistantrendezvous = "WEB-INF/html/appointments.html";
    private final String patients = "WEB-INF/html/patients.jsp";
    private final String reservations = "WEB-INF/html/rdnauj.jsp";
    private final String formpatient = "WEB-INF/html/formPatient.jsp";
    private  final String formulaire = "/WEB-INF/html/formulaire.jsp";
    private final String Confirmer = "WEB-INF/html/success.jsp";
    private IntRendezvous dao;
    private PatientDao dao1 ;



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
            int id;
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
                    dao1 = new PatientImp();

                    List<Patient> patients1 = dao1.getallPatients();
                    request.setAttribute("patients", patients1); // Set patients as request attribute
                    request.getRequestDispatcher(patients).forward(request,response);


                    break;

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
                    break;

                case "/formpatient":
                    request.getRequestDispatcher(formpatient).forward(request, response);
                    break;
                case "/patient/delete":
                     id = Integer.parseInt(request.getParameter("id"));
                    dao1.delete(id);
                    response.sendRedirect(request.getContextPath() + "/patient");
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
                case "/formpatient":
                    String nom2 = request.getParameter("nom");
                    String prenom2 = request.getParameter("prenom");
                    String cin2 = request.getParameter("cin");
                    String genre = request.getParameter("genre");
                    String date_naissance = request.getParameter("date_naissance");
                    String derniere_visite = request.getParameter("derniere_visite");
                    int telephone2 = Integer.parseInt(request.getParameter("telephone"));
                    String acte_medicale = request.getParameter("acte_medicale");

                    Patient patient = new Patient();
                    patient.setNom(nom2);
                    patient.setPrenom(prenom2);
                    patient.setCin(cin2);
                    String genre1 = request.getParameter("genre");
                    if (genre != null && (genre.equals("homme") || genre.equals("femme"))) {
                        patient.setGenre(genre);
                    } else {
                        // Handle invalid genre value (e.g., log an error, set a default value, or display a message)
                        // For simplicity, let's set a default value
                        patient.setGenre("Undefined");
                    }
                    patient.setDate_naissance(date_naissance);
                    patient.setDerniere_visite(derniere_visite);
                    patient.setTelephone(telephone2);
                    patient.setActe_medicale(acte_medicale);

                    dao1.Ajouter(patient);
                    response.sendRedirect(request.getContextPath() + "/patient");

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