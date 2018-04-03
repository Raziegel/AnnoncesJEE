package fr.projet.ProjetLBC.servlets;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.beans.Utilisateur;
import fr.projet.ProjetLBC.dao.IAnnonceDao;
import fr.projet.ProjetLBC.dao.IUtilisateurDao;
import fr.projet.ProjetLBC.dao.hsqlImpl.AnnonceDao;
import fr.projet.ProjetLBC.dao.hsqlImpl.UtilisateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("Username");
        String password = request.getParameter("Password");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(login);
        utilisateur.setPassword(password);
        IUtilisateurDao userDao = new UtilisateurDao();
        if (userDao.checkLogin(utilisateur)) {
            IAnnonceDao annonceDao = new AnnonceDao();
            List<Annonce> myAnnonces = annonceDao.getListOfAnnoncesWithID(login);
            request.setAttribute("ANNONCES", myAnnonces);
            request.getRequestDispatcher("annonces.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
