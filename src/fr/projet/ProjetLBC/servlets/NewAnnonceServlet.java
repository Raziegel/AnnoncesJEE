package fr.projet.ProjetLBC.servlets;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.beans.Utilisateur;
import fr.projet.ProjetLBC.dao.IUtilisateurDao;
import fr.projet.ProjetLBC.dao.hsqlImpl.UtilisateurDao;
import sun.util.calendar.BaseCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@WebServlet("/NewAnnonceServlet")
public class NewAnnonceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAnnonceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String descriptionAnnonce = request.getParameter("description");
        String prix = request.getParameter("prix");
        String login = request.getParameter("LOGIN");

            Annonce newAnnonce = new Annonce();
            newAnnonce.setPrix(Double.parseDouble(prix));
            newAnnonce.setTitre(titre);
            newAnnonce.setContent(descriptionAnnonce);
            newAnnonce.setStatut(1);
            java.util.Date now = new java.util.Date();
            newAnnonce.setModification(now);
            newAnnonce.setCreation(now);
            newAnnonce.setVendeur(UtilisateurDao.getUtilisateur(login));
            request.getRequestDispatcher("index2.html").forward(request, response);

    }

}

