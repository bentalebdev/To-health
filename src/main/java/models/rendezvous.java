package models;

public class rendezvous {
    public String nom ;
    public String prenom ;
    public String cin ;
    public int telephone ;
    public String date ;
    public String date_heure ;

    public rendezvous(){ }

    public rendezvous(String nom , String prenom , String cin , int telephone , String date , String date_heure)
    {
        this.nom = nom;
        this.prenom = prenom ;
        this.cin = cin ;
        this.telephone = telephone ;
        this.date = date ;
        this.date_heure = date_heure;
    }

    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getCin() {return cin;}
    public int getTelephone() {return telephone;}
    public String getDate() {return date;}
    public String getDate_heure() {return date_heure;}


    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setCin(String cin) {this.cin = cin;}
    public void setTelephone(int telephone) {this.telephone = telephone;}
    public void setDate(String date) {this.date = date;}
    public void setDate_heure(String date_heure) {this.date_heure = date_heure;}

    @Override
    public String toString() {return super.toString();}

    }

