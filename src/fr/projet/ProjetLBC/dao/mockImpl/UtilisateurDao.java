package fr.projet.ProjetLBC.dao.mockImpl;

import fr.projet.ProjetLBC.beans.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurDao implements fr.projet.ProjetLBC.dao.IUtilisateurDao {
    private static List<Utilisateur> listOfUsers;

    public UtilisateurDao() {
        listOfUsers = new ArrayList<>();
        Utilisateur u = new Utilisateur();
        u.setId("ADMIN");
        u.setPassword("ADMIN");
        listOfUsers.add(u);
        u = new Utilisateur();
        u.setId("TOTO");
        u.setPassword("TOTO");
        listOfUsers.add(u);
    }

    @Override
    public boolean checkLogin(Utilisateur utilisateur) {
        boolean accesOk = false;
        Utilisateur existingUser = null;
        for (Utilisateur u: listOfUsers) {
            if (u.getId().equals(utilisateur.getId())) {
                existingUser = u;
                break;
            }
        }
        if (existingUser != null) {
            accesOk = (utilisateur.getId().equals(existingUser.getId())
                    && utilisateur.getPassword().equals(existingUser.getPassword()));
        }
        return accesOk;
    }

}
