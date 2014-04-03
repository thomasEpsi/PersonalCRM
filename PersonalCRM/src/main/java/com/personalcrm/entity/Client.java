package com.personalcrm.entity;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Client {

    private int idClient;
    private String prenom;
    private String nom;
    private String tel_mob;
    private String tel_fixe;
    private String email;

    public Client() { }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel_mob() {
        return tel_mob;
    }

    public void setTel_mob(String tel_mob) {
        this.tel_mob = tel_mob;
    }

    public String getTel_fixe() {
        return tel_fixe;
    }

    public void setTel_fixe(String tel_fixe) {
        this.tel_fixe = tel_fixe;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", tel_mob='" + tel_mob + '\'' +
                ", tel_fixe='" + tel_fixe + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
