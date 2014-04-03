package com.personalcrm.entity;

import java.sql.Date;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Fournisseur {

    private int idFournisseur;
    private String nom_fournisseur;
    private String num_siret;
    private Date date_enregistrement;

    public Fournisseur() {}

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNom_fournisseur() {
        return nom_fournisseur;
    }

    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }

    public String getNum_siret() {
        return num_siret;
    }

    public void setNum_siret(String num_siret) {
        this.num_siret = num_siret;
    }

    public Date getDate_enregistrement() {
        return date_enregistrement;
    }

    public void setDate_enregistrement(Date date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "idFournisseur=" + idFournisseur +
                ", nom_fournisseur='" + nom_fournisseur + '\'' +
                ", num_siret='" + num_siret + '\'' +
                ", date_enregistrement=" + date_enregistrement +
                '}';
    }
}
