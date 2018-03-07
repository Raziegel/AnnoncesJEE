package fr.projet.ProjetLBC.dao;

import fr.projet.ProjetLBC.beans.Annonce;

import java.util.List;

public interface IAnnonceDao {


    List<Annonce> getAnnonces(String loginID);

}
