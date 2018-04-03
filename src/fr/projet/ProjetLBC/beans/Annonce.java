package fr.projet.ProjetLBC.beans;

import java.util.Date;

public class Annonce {
    private  int id;
    private  String titre;
    private String content;
    private Utilisateur vendeur;
    private  Date creation;
    private Date modification;
    private Double prix;
    private int statut;
    private Utilisateur acheteur;
    private Date achat;
    private long nbVues;

    public Annonce(){
        statut = Statuts.TEMPORAIRE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Utilisateur vendeur) {
        this.vendeur = vendeur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public long getNbVues() {
        return nbVues;
    }

    public void setNbVues(long nbVues) {
        this.nbVues = nbVues;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getModification() {
        return modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
    }

    public Utilisateur getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Utilisateur acheteur) {
        this.acheteur = acheteur;
    }

    public Date getAchat() {
        return achat;
    }

    public void setAchat(Date achat) {
        this.achat = achat;
    }
}
