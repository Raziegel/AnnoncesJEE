package fr.projet.ProjetLBC.servlets;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.dao.IAnnonceDao;
import fr.projet.ProjetLBC.dao.hsqlImpl.AnnonceDao;
//import fr.projet.ProjetLBC.dao.mockImpl.AnnonceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getAnnonceServlet")
public class getAllAnnoncesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("LOGIN");
        IAnnonceDao annonceDao = new AnnonceDao();
        List<Annonce> myAnnonces = annonceDao.getListOfAnnoncesWithID(login);
        for (Annonce annonce : myAnnonces) {
            System.out.println("Annonce=" + annonce.getTitre());
        }
        request.setAttribute("ANNONCES", myAnnonces);
        request.getRequestDispatcher("annonces.jsp").forward(request, response);
    }
}
