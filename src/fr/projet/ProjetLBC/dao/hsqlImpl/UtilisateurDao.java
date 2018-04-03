package fr.projet.ProjetLBC.dao.hsqlImpl;

import fr.projet.ProjetLBC.beans.Utilisateur;
import fr.projet.ProjetLBC.dao.IUtilisateurDao;

import java.sql.*;
import java.util.List;

public class UtilisateurDao implements IUtilisateurDao {

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

    @Override
    public List<Utilisateur> getListOfUtilisateurs() {
        return null;
    }

    @Override
    public Utilisateur getUtilisateurById(String id) {
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
            ps.setString(1, id);
            Statement stmt = con.createStatement();
            resultats = ps.executeQuery();
            while (resultats.next()) {
                return new Utilisateur(resultats.getString(1),
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
    public void addUtilisateur(Utilisateur utilisateur) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        Connection con;
        ResultSet resultats = null;

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?)");
            ps.setString(1, utilisateur.getId());
            ps.setString(2, utilisateur.getPassword());
            ps.setBoolean(3, utilisateur.isAdministrateur());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        Connection con;
        ResultSet resultats = null;

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
            PreparedStatement ps = con.prepareStatement("UPDATE users SET password = ?, isadministrator = ? WHERE id = ?");
            ps.setString(1, utilisateur.getPassword());
            ps.setBoolean(2, utilisateur.isAdministrateur());
            ps.setString(3, utilisateur.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        Connection con;

        try {
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003");
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setString(1, utilisateur.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
