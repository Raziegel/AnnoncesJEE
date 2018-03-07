package fr.projet.ProjetLBC.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.dao.IAnnonceDao;
import fr.projet.ProjetLBC.dao.mockImpl.AnnonceDao;

@WebServlet(name = "/getAnnoncesServlet")
public class getAnnoncesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAnnoncesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("LOGIN");
        IAnnonceDao annonceDao = new AnnonceDao();
        List<Annonce> myAnnonces = annonceDao.getAnnonces(login);
        for (Annonce annonce : myAnnonces) {
            System.out.println("Annonce=" + annonce.getTitre());
        }
        request.setAttribute("ANNONCES", myAnnonces);
        request.getRequestDispatcher("annonces.jsp").forward(request, response);
    }
}
