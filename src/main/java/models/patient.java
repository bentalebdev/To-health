package models;

public class Patient {
    String nom;
    String prenom;
    String cin;
    String date_naissance;
    String genre;
    String derniere_visite;
    String acte_medicale;
    int telephone;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDerniere_visite() {
        return derniere_visite;
    }

    public void setDerniere_visite(String derniere_visite) {
        this.derniere_visite = derniere_visite;
    }

    public String getActe_medicale() {
        return acte_medicale;
    }

    public void setActe_medicale(String acte_medicale) {
        this.acte_medicale = acte_medicale;
    }

    public Patient() {
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Patient(String nom, String prenom, String cin, String date_naissance, String genre, String derniere_visite, String acte_medicale, int telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.date_naissance = date_naissance;
        this.genre = genre;
        this.derniere_visite = derniere_visite;
        this.acte_medicale = acte_medicale;
        this.telephone = telephone;
    }



}
