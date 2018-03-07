package fr.projet.ProjetLBC.dao.hsqlImpl;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.dao.IAnnonceDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class AnnonceDao implements IAnnonceDao{


    @Override
    public List<Annonce> getAnnonces(String loginID) {
        List<Annonce> annonces = new ArrayList<>();
        String url = "127.0.0.1:9003";
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://" + url, "SA", "");
            Statement stmt = con.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM ANNONCES");
            while (results.next()) {
                // Parcours des annonces
                Annonce annonce = new Annonce();
                annonce.setId(results.getInt(0));
                // ...
                annonces.add(annonce);
            }
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return annonces;
    }
}
