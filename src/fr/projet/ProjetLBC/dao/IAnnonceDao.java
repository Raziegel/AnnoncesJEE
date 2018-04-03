package fr.projet.ProjetLBC.dao;

import fr.projet.ProjetLBC.beans.Annonce;
import fr.projet.ProjetLBC.beans.Utilisateur;

import java.util.List;

public interface IAnnonceDao {

    List<Annonce> getListOfAnnonces(Utilisateur utilisateur);
    List<Annonce> getListOfAnnonces();
    Annonce getAnnonce(String loginID);
    void addAnnonce(Annonce annonce);
    void updateAnnonceStatus(Annonce annonce, int status);
    void deleteAnnonce(Annonce annonce);

}
