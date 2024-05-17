package models;

public class patient {
    String nom;
    String prenom;
    String cin;
    String date_naissance;
    String genre;
    String derniere_visite;
    String acte_medicale;
    int telephone;

    public patient() {}
    public patient(String nom , String prenom , String cin , String date_naissance , String genre , String derniere_visite , int telephone, String acte_medicale)
    {
        this.nom = nom;
        this.prenom=prenom ;
        this.cin =cin ;
        this.date_naissance = date_naissance;
        this.genre = genre;
        this.derniere_visite = derniere_visite;
        this.telephone = telephone ;
        this.acte_medicale = acte_medicale;
    }
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getCin() {return cin;}
    public String getGenre() {return genre;}
    public String getdate_naissance() {return date_naissance;}
    public String getDerniere_visite() {return derniere_visite;}
    public String getActe_medicale() {return acte_medicale;}
    public int getTelephone(){return telephone;}


    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setNom(String nom) {this.nom = nom;}
    public void setCin(String cin) {this.cin = cin;}
    public void setdate_naissance(String date_naissance) {this.date_naissance = date_naissance;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setDerniere_visite(String derniere_visite) {this.derniere_visite = derniere_visite;}
    public void setActe_medicale(String acte_medicale) {this.acte_medicale = acte_medicale;}
    public void setTelephone(int telephone){this.telephone=telephone;}


}