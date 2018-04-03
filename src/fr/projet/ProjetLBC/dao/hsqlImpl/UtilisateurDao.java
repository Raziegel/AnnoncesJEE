package fr.projet.ProjetLBC.dao.hsqlImpl;

import fr.projet.ProjetLBC.beans.Utilisateur;

import java.sql.*;

public class UtilisateurDao implements fr.projet.ProjetLBC.dao.IUtilisateurDao{

    public static Utilisateur getUtilisateur(String userId) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }

        Connection con;
        ResultSet resultats = null;

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, userId);
            Statement stmt = con.createStatement();
            resultats = ps.executeQuery();
            while (resultats.next()) {
                return new Utilisateur( resultats.getString(1),
                                        resultats.getString(2),
                                        resultats.getString(3),
                                        resultats.getString(4),
                                        resultats.getBoolean(5));
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean checkLogin(Utilisateur utilisateur) {
        return false;
    }
}
