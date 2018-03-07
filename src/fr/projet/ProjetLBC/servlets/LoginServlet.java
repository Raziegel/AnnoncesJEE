package fr.projet.ProjetLBC.servlets;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.beans.Utilisateur;
import fr.projet.ProjetLBC.dao.IAnnonceDao;
import fr.projet.ProjetLBC.dao.IUtilisateurDao;
import fr.projet.ProjetLBC.dao.mockImpl.AnnonceDao;
import fr.projet.ProjetLBC.dao.mockImpl.UtilisateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("LOGIN");
        String password = request.getParameter("PWD");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(login);
        utilisateur.setPassword(password);
        IUtilisateurDao userDao = new UtilisateurDao();
        if (userDao.checkLogin(utilisateur)) {
            IAnnonceDao annonceDao = new AnnonceDao();
            List<Annonce> myAnnonces = annonceDao.getAnnonces(login);
            request.setAttribute("ANNONCES", myAnnonces);
            request.getRequestDispatcher("annonces.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }

}
